package controller;

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

	private GameWindow window;

	@Nullable private GameSession session;
	@Nullable private BaseController activeController;

	public void createAndShowGUI() {
		//Create and set up the window.
		window = new GameWindow();
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		window.setTitle("Draw It!");

		window.getContentPane();
		//Display the window.
		window.pack();
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
					case WATCH:
						activeController = new WatchController(window);
					case GUESS:
						activeController = new GuessWordController(window);
					case WAIT:
						activeController = new WaitController(window);
					case STATS:
						activeController = new StatsController(window);
				}

			}
		}
	}
}
