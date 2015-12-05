package controller;

import ui.GameStatePanel;
import ui.GameWindow;

/**
 * Created by oguzb on 03/12/15.
 */
public class GuessWordController extends GameStateController {

	public GuessWordController(GameWindow window) {
		super(window);
	}

	@Override
	GameStatePanel initializePanel() {
		return null;
	}
}
