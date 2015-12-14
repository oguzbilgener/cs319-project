package controller;

import model.GameSession;
import model.Piece;
import model.Player;
import network.AccountStore;
import network.GameClient;
import network.P2PManager;
import ui.GameWindow;
import ui.event.MenuEvent;
import util.TimerListener;

import javax.swing.*;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * @author oguzb
 */
public class GameController implements Observer, P2PManager.P2PConnectionListener,
    GameClient.GameClientListener, TimerListener {

	protected GameWindow window;
	// Used by static game() method. See below for the purpose
	private static GameController staticGameInstance;

	private GameSession session;
	private GameStateController activeController;

	private P2PManager p2pManager;
	private GameClient gameClient;

    private MenuEvent.Listener menuListener;

    private List<Piece> finishedDrawing;

    public void createAndShowGUI() {
		//Create and set up the window.
		window = new GameWindow();
		staticGameInstance = this;
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		window.setTitle("Draw It!");

		window.getContentPane();
		//Display the window.
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);

		menuListener = itemType -> {
			switch (itemType) {
				case host:
					showHostScreen();
					break;
				case join:
					showJoinScreen();
					break;
				case credits:
					showCreditsScreen();
					break;
				case login:
					showLoginScreen();
                    break;
                case signup:
                    showSignupScreen();
                    break;
				case logout:
					logout();
                    break;
			}
		};

		window.showMainMenu(menuListener);

        gameClient = new GameClient();
        gameClient.addListener(this);
        Player storedPlayer = AccountStore.retrieve();
        if(storedPlayer != null) {
            gameClient.login(storedPlayer.getUsername(), storedPlayer.getPassword());
        }
	}

	private void showHostScreen() {
		window.showHostPanel();
        p2pManager.host();
	}

	private void showJoinScreen() {
		window.showJoinPanel();
	}

	private void showCreditsScreen() {
		window.showCreditsPanel();
	}

    private void showLoginScreen() {
        window.showLoginPanel();
    }

    private void showSignupScreen() {
        window.showSignupPanel();
    }

    private void logout() {
        AccountStore.logout();
        p2pManager = null;
        // recreate the menu
        window.showMainMenu(menuListener);
    }

	private void chooseWord() {
		session.setRoundState(GameSession.RoundState.CHOOSE_WORD);
	}

    public void joinPlayer(String username) {
        gameClient.lookup(username);
    }

	private void setupNewGame() {
		session = new GameSession(p2pManager.getOwnPlayer(), p2pManager.getOtherPlayer(), p2pManager.isSelfHost());
		session.addObserver(this);
        session.addObserver(p2pManager);
	}

	private void beginDrawOrWatch() {
		if(session.isMyPlayerIsActive()) {
			session.setRoundState(GameSession.RoundState.DRAW);
		}
		else {
			session.setRoundState(GameSession.RoundState.WATCH);
		}
	}

    public void finishDrawing() {
        finishedDrawing = ((WordDrawController)activeController).getCanvas().getPieces();
        p2pManager.finishDrawing();
        session.setRoundState(GameSession.RoundState.WAIT);
    }

    public void failGuessing() {
        p2pManager.failGuessing();
        session.setRoundState(GameSession.RoundState.STATS);
    }

    public void accomplishGuessing() {
        p2pManager.accomplishGuessing();
    }

	@Override
	public void update(Observable observable, Object data) {
		if(observable instanceof GameSession) {
			if(data != null && data instanceof GameSession.Field) {
				GameSession.Field field = (GameSession.Field) data;
				if(field.name == GameSession.Field.Name.ROUND_STATE) {
                    if(activeController != null) {
                        activeController.onRemove();
                    }
					// Begin new state, replace active controller
					switch (session.getRoundState()) {
						case DRAW:
							activeController = new WordDrawController(window);
							break;
						case WATCH:
							activeController = new WatchController(window);
							break;
						case GUESS:
							activeController = new GuessWordController(window, finishedDrawing);
							break;
						case WAIT:
							activeController = new WaitController(window, finishedDrawing);
							break;
						case STATS:
							activeController = new StatsController(window);
							break;
						case CHOOSE_WORD:
							activeController = new ChooseWordController(window);
							break;
					}
                    activeController.getTurnTimer().addListener(this);
				}
				else if(field.name == GameSession.Field.Name.CHOSEN_WORD) {
					beginDrawOrWatch();
				}
			}
		}
	}

	/**
	 * Allows this game instance to be accessed from anywhere of the code
	 * Useful when you want to access the window or session object from any method of
	 * child controllers but you don't want to keep a reference to GameController.
	 * Similar to how the window object can be accessed from any context
	 * in iOS development (Swift):
	 * `UIApplication.sharedApplication().delegate.window`
	 * @return the main controller object of the application
	 */
	public static GameController game() {
		return staticGameInstance;
	}

	public GameWindow getWindow() {
		return window;
	}

    public GameStateController getActiveController() {
        return activeController;
    }

    public GameSession getSession() {
		return session;
	}

    public P2PManager getP2pManager() {
        return p2pManager;
    }

    public GameClient getGameClient() {
        return gameClient;
    }

    public boolean isLoggedIn() {
        return p2pManager != null;
    }

    public Player getLoggedInPlayer() {
        if(p2pManager != null) {
            return p2pManager.getOwnPlayer();
        }
        return null;
    }

    /**
     * P2PManager Events
     */

    @Override
	public void onConnected() {
        System.out.println("Socket connected");
	}

	@Override
	public void onGuestIdentified(Player guest) {
        System.out.println("Socket player identified");
        if(session == null) {
            setupNewGame();
        }
        chooseWord();
	}

    @Override
    public void onWordChosen(String word) {
        System.out.println("GC word chosen by active player");
        if(session == null) {
            setupNewGame();
        }
		session.setChosenWord(word);
    }

    @Override
    public void onDraw(Piece piece) {
        if(activeController instanceof WatchController) {
            ((WatchController)activeController).addPiece(piece);
        }
    }

    @Override
	public void onHostConnectionRefused() {
        System.out.println("Socket refused");
	}

	@Override
	public void onDisconnected() {
        System.out.println("Socket disconnected");
        window.showMainMenu(menuListener);
	}

	@Override
	public void onError(Exception exception) {
        System.out.println("Socket error");
	}

	@Override
	public void onDrawFinished() {
        finishedDrawing = ((WatchController) activeController).getCanvas().getPieces();
        session.setRoundState(GameSession.RoundState.GUESS);
	}

    @Override
    public void onGuessingFinished() {
        session.setRoundState(GameSession.RoundState.STATS);
    }

    @Override
    public void onNextRoundRequested() {
        // TODO
        System.out.println("next round requested, switch roles!!");
    }

    /**
     * GameClient Events
     */

    @Override
    public void onLoginFailure(GameClient.ErrorType type) {
        if(activeController == null) {
            SwingUtilities.invokeLater(() -> window.showMainMenu(menuListener));
        }
    }

    @Override
    public void onSignupFailure(GameClient.ErrorType type) {
        SwingUtilities.invokeLater(() -> window.showMainMenu(menuListener));
    }

    @Override
    public void onLookupFailure(GameClient.ErrorType type) {
        System.out.println("lookup error "+type);
    }

    @Override
    public void onLoadWordsFailure(GameClient.ErrorType type) {
        System.out.println("load words error "+type);
    }

    @Override
    public void onLoginSuccess(Player player) {
        p2pManager = new P2PManager(player, this);
        AccountStore.store(player);
        SwingUtilities.invokeLater(() -> window.showMainMenu(menuListener));
    }

    @Override
    public void onSignupSuccess(Player player) {
        p2pManager = new P2PManager(player, this);
        SwingUtilities.invokeLater(() -> window.showMainMenu(menuListener));
        AccountStore.store(player);
    }

    @Override
    public void onLookupSuccess(Player player) {
        p2pManager.join(player);
    }

    @Override
    public void onLoadWordsSuccess(String[] words) {
        session.setWordList(words);
    }

    @Override
    public void onTimeOut() {
        System.out.println("GC timeout");
        if(session.getRoundState() == GameSession.RoundState.DRAW) {
            finishDrawing();
        }
        else if(session.getRoundState() == GameSession.RoundState.GUESS) {
            failGuessing();
        }
        else if(session.getRoundState() == GameSession.RoundState.STATS && p2pManager.isSelfHost()) {

        }
    }

    @Override
    public void onTick(int elapsedTime) {
        System.out.println("GC tick "+session.getRoundState());
    }
}
