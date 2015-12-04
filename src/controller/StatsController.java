package controller;

import ui.GameStatePanel;
import ui.GameWindow;

/**
 * @author oguzb
 */
public class StatsController extends GameStateController {

	public StatsController(GameWindow window) {
		super(window);
	}

	@Override
	GameStatePanel initializePanel() {
		return null;
	}
}
