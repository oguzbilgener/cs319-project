package controller;

import ui.DrawingScreenPanel;
import ui.GameWindow;

/**
 * Created by oguzb on 03/12/15.
 */
public class WordDrawController extends GameStateController {

	public WordDrawController(GameWindow window) {
		super(window);

	}

	@Override
	void initializePanel(GameWindow window) {
		window.replacePanel(new DrawingScreenPanel());
	}

}
