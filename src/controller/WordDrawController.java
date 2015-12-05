package controller;

import ui.GameStatePanel;
import ui.GameWindow;
import ui.play.WordDrawPanel;

/**
 * Created by oguzb on 03/12/15.
 */
public class WordDrawController extends GameStateController {

	public WordDrawController(GameWindow window) {
		super(window);
	}

	@Override
	GameStatePanel initializePanel() {
		return new WordDrawPanel(GameController.game().getWindow().getContentSize());
	}

}
