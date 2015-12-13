package controller;

import ui.GameStatePanel;
import ui.GameWindow;

/**
 * @author oguzb
 */
public abstract class GameStateController {

	public GameStateController(GameWindow window) {
		recreatePanel();
	}

	protected void recreatePanel() {
        GameStatePanel panel = initializePanel();
        GameController.game().getWindow().replacePanel(panel);
    }

	abstract GameStatePanel initializePanel();
}
