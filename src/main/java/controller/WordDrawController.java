package controller;

import ui.GameStatePanel;
import ui.GameWindow;
import ui.play.WordDrawPanel;
import util.TimerListener;
import util.TurnTimer;

import java.awt.event.ActionListener;

/**
 * Created by oguzb on 03/12/15.
 */
public class WordDrawController extends GameStateController implements TimerListener {

	private TurnTimer turnTimer;

	public WordDrawController(GameWindow window) {
		super(window);
	}

	@Override
	GameStatePanel initializePanel() {
		ActionListener checkListener = (event) -> {};
		ActionListener closeListener = (event) -> {};
		WordDrawPanel panel = new WordDrawPanel(GameController.game().getWindow().getContentSize(), checkListener, closeListener);
		turnTimer = new TurnTimer();
		turnTimer.schedule();
		turnTimer.addListener(panel);
		turnTimer.addListener(this);
		return panel;
	}

	@Override
	public void onTimeOut() {
		System.out.println("45 SEC OUT!!!!!!");
	}

	@Override
	public void onTick(int timeElapsed) {}
}
