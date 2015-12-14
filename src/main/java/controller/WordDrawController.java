package controller;

import ui.GameStatePanel;
import ui.GameWindow;
import ui.play.Canvas;
import ui.play.WordDrawPanel;

import java.awt.event.ActionListener;

/**
 * Created by oguzb on 03/12/15.
 */
public class WordDrawController extends GameStateController {

	private WordDrawPanel panel;

	public WordDrawController(GameWindow window) {
		super(window);
	}

	@Override
	GameStatePanel initializePanel() {
		ActionListener checkListener = (event) -> {};
		ActionListener closeListener = (event) -> {};
		panel = new WordDrawPanel(GameController.game().getWindow().getContentSize(), checkListener, closeListener);
		turnTimer.schedule();
		turnTimer.addListener(panel);
		return panel;
	}

    public Canvas getCanvas() {
        return panel.getCanvas();
    }
}
