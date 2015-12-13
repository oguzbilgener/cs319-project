package controller;

import model.GameSession;
import model.Piece;
import model.Player;
import network.GameClient;
import network.P2PManager;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import ui.GameWindow;
import ui.event.MenuEvent;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

/**
 * @author oguzb
 */
public class GameController implements Observer, P2PManager.P2PConnectionListener,
    GameClient.GameClientListener {

	protected GameWindow window;
	// Used by static game() method. See below for the purpose
	private static GameController staticGameInstance;

	private GameSession session;
	private GameStateController activeController;

	private P2PManager p2pManager;
	private GameClient gameClient;

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

		MenuEvent.Listener menuListener = itemType -> {
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
					throw new NotImplementedException();
				case logout:
					throw new NotImplementedException();
			}
		};

		window.showMainMenu(menuListener);


        // TODO: login from account store
        gameClient = new GameClient();
        gameClient.login("oguz", "opass");
        gameClient.addListener(this);
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

	@Override
	public void update(Observable observable, Object data) {
		if(observable instanceof GameSession) {
			if(data != null && data instanceof GameSession.Field) {
				GameSession.Field field = (GameSession.Field) data;
				if(field.name == GameSession.Field.Name.ROUND_STATE) {
					// Begin new state, replace active controller
					switch (session.getRoundState()) {
						case DRAW:
							activeController = new WordDrawController(window);
							break;
						case WATCH:
							activeController = new WatchController(window);
							break;
						case GUESS:
							activeController = new GuessWordController(window);
							break;
						case WAIT:
							activeController = new WaitController(window);
							break;
						case STATS:
							activeController = new StatsController(window);
							break;
						case CHOOSE_WORD:
							activeController = new ChooseWordController(window);
							break;
					}
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

	public GameSession getSession() {
		return session;
	}

    public P2PManager getP2pManager() {
        return p2pManager;
    }

    public GameClient getGameClient() {
        return gameClient;
    }

    @Override
	public void onConnected() {
        System.out.println("GC connected");
	}

	@Override
	public void onGuestIdentified(Player guest) {
        System.out.println("GC identified");
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
        beginDrawOrWatch();
    }

    @Override
    public void onDraw(Piece piece) {
        if(activeController instanceof WatchController) {
            ((WatchController)activeController).addPiece(piece);
        }
    }

    @Override
	public void onHostConnectionRefused() {
        System.out.println("GC refused");
	}

	@Override
	public void onDisconnected() {
        System.out.println("GC disconnected");
	}

	@Override
	public void onError(Exception exception) {
        System.out.println("GC error");
	}

    @Override
    public void onLoginFailure(GameClient.ErrorType type) {

    }

    @Override
    public void onSignupFailure(GameClient.ErrorType type) {

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
        // TODO: use parameter player
        Player ownPlayer = new Player();
        ownPlayer.setUsername("oguz2");
        ownPlayer.setPreferredAddress("192.168.2.200");
        p2pManager = new P2PManager(ownPlayer, this);
    }

    @Override
    public void onSignupSuccess(Player player) {

    }

    @Override
    public void onLookupSuccess(Player player) {
        p2pManager.join(player);
    }

    @Override
    public void onLoadWordsSuccess(String[] words) {
        for (String word : words) {
            System.out.print(word);
        }
        session.setWordList(words);
    }
}
