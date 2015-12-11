package controller;

import ui.GameStatePanel;
import ui.GameWindow;

/**
 * @author oguzb
 */
public class WaitController extends GameStateController {

	public WaitController(GameWindow window) {
		super(window);
	}

	@Override
	GameStatePanel initializePanel() {

		return null;
	}
}
