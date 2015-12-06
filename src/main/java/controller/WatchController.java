package controller;

import model.Piece;
import ui.GameStatePanel;
import ui.GameWindow;
import ui.play.WatchPanel;

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
        panel = new WatchPanel(GameController.game().getWindow().getContentSize());
		return panel;
	}
}
