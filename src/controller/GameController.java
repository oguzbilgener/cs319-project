package controller;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import model.GameSession;
import model.Player;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import ui.GameWindow;
import ui.event.MenuEvent;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

/**
 * @author oguzb
 */
public class GameController implements Observer {

	protected GameWindow window;
	// Used by static mainWindow() method. See below for the purpose
	@NotNull private static GameWindow staticWindowInstance;

	@Nullable private GameSession session;
	@Nullable private GameStateController activeController;

	public void createAndShowGUI() {
		//Create and set up the window.
		window = new GameWindow();
		staticWindowInstance = window;
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
//					showHostScreen();
					startNewGame();
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
	}

	private void showHostScreen() {
		window.showHostPanel();
	}

	private void showJoinScreen() {
		window.showJoinPanel();
	}

	private void showCreditsScreen() {
		window.showCreditsPanel();
	}

	private void startNewGame() {
		session = new GameSession(new Player(), new Player(), true);
		session.addObserver(this);
		session.setRoundState(GameSession.RoundState.DRAW);
	}

	@Override
	public void update(Observable observable, Object data) {
		if(observable instanceof GameSession) {
			if(data != null && data instanceof GameSession.RoundState) {
				// Begin new state, replace active controller
				switch(session.getRoundState()) {
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
				}

			}
		}
	}

	/**
	 * Allows the window instance to be accessed from anywhere of the code
	 * Useful when you want to access the window object from any method of
	 * child controllers but you don't want to keep a reference to GameWindow.
	 * Similar to how the window object can be accessed from any context
	 * in iOS development (Swift):
	 * `UIApplication.sharedApplication().delegate.window`
	 * @return the main window object of the application
	 */
	@NotNull
	public static GameWindow mainWindow() {
		return staticWindowInstance;
	}
}
