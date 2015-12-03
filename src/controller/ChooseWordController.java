package controller;

import ui.ChooseWordPanel;
import ui.DrawingScreenPanel;
import ui.GameWindow;

/**
 * @author oguzb
 */
public class ChooseWordController extends GameStateController {

	public ChooseWordController(GameWindow window) {
		super(window);
	}

	@Override
	void initializePanel(GameWindow window) {
		window.replacePanel(new ChooseWordPanel());
	}
}
