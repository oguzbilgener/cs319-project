package controller;

import ui.GameStatePanel;
import ui.GameWindow;
import ui.play.StatsPanel;

/**
 * @author oguzb
 */
public class StatsController extends GameStateController {

	public StatsController(GameWindow window) {
		super(window);
	}

	@Override
	GameStatePanel initializePanel() {
		StatsPanel panel = new StatsPanel((GameController.game().getWindow().getContentSize()));
        turnTimer.schedule(15);
        return panel;
	}
}
