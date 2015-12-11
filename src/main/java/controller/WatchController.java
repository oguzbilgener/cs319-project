package controller;

import model.Piece;
import ui.GameStatePanel;
import ui.GameWindow;
import ui.play.WatchPanel;
import ui.play.WordDrawPanel;
import util.TimerListener;
import util.TurnTimer;

import java.awt.event.ActionListener;

/**
 * Created by oguzb on 03/12/15.
 */
public class WatchController extends GameStateController implements TimerListener {

	public WatchController(GameWindow window) {
		super(window);
	}

    private WatchPanel panel;
	private TurnTimer turnTimer;

	public void addPiece(Piece piece) {
	    if(panel != null) {
            panel.addPiece(piece);
        }
	}

	@Override
	GameStatePanel initializePanel() {

		ActionListener giveUpListener = (event) -> {};
		ActionListener closeListener = (event) -> {};
		panel = new WatchPanel(GameController.game().getWindow().getContentSize(), giveUpListener, closeListener);
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
	public void onTick(int elapsedTime) {}

}
