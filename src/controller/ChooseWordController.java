package controller;

import ui.ChooseWordPanel;
import ui.GameStatePanel;
import ui.GameWindow;

/**
 * @author oguzb
 */
public class ChooseWordController extends GameStateController {

	public ChooseWordController(GameWindow window) {
		super(window);
	}

	@Override
	GameStatePanel initializePanel() {
		return new ChooseWordPanel(GameController.game().getWindow().getContentSize());
	}
}
