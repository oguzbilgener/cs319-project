package controller;

import ui.GameStatePanel;
import ui.GameWindow;

/**
 * @author oguzb
 */
public abstract class GameStateController {

	public GameStateController(GameWindow window) {
		GameStatePanel panel = initializePanel();
		window.replacePanel(panel);
	}

	abstract GameStatePanel initializePanel();
}
