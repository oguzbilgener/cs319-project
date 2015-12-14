package controller;

import model.Piece;
import ui.GameStatePanel;
import ui.GameWindow;
import ui.play.Canvas;
import ui.play.WatchPanel;

import java.awt.event.ActionListener;

/**
 * Created by oguzb on 03/12/15.
 */
public class WatchController extends GameStateController {

	public WatchController(GameWindow window) {
		super(window);
	}

    private WatchPanel panel;

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
		turnTimer.schedule();
		turnTimer.addListener(panel);
		return panel;
	}

    public Canvas getCanvas() {
        return panel.getCanvas();
    }

}
