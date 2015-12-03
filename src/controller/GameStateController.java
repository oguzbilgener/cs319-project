package controller;

import ui.GameWindow;

/**
 * @author oguzb
 */
public abstract class GameStateController {

	public GameStateController(GameWindow window) {
		initializePanel(window);
	}

	abstract void initializePanel(GameWindow window);
}
