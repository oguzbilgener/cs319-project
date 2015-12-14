package controller;

import ui.GameStatePanel;
import ui.GameWindow;
import util.TurnTimer;

/**
 * @author oguzb
 */
public abstract class GameStateController {

	protected TurnTimer turnTimer;
    private GameStatePanel panel;

	public GameStateController(GameWindow window) {
		turnTimer = new TurnTimer();
		recreatePanel();
	}

	protected void recreatePanel() {
        panel = initializePanel();
        GameController.game().getWindow().replacePanel(panel);
    }

    protected GameStatePanel getPanel() {
        return panel;
    }

	abstract GameStatePanel initializePanel();

    void onRemove() {
        turnTimer.cancel();
    }

	public TurnTimer getTurnTimer() {
		return turnTimer;
	}
}
