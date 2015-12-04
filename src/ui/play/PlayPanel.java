package ui.play;

import ui.GameStatePanel;

/**
 * @author oguzb
 */
public abstract class PlayPanel extends GameStatePanel {

	public PlayPanel() {
		Canvas canvas = initializeCanvas();
	}

	protected abstract Canvas initializeCanvas();
}
