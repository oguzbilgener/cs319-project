package controller;

import model.Piece;
import ui.GameStatePanel;
import ui.GameWindow;
import ui.play.GuessPanel;
import ui.play.PlayPanel;

import java.util.List;

/**
 * Created by oguzb on 03/12/15.
 */
public class GuessWordController extends GameStateController {

	public GuessWordController(GameWindow window, List<Piece> finishedDrawing) {
		super(window);
		((PlayPanel) getPanel()).getCanvas().setPieces(finishedDrawing);
	}

	@Override
	GameStatePanel initializePanel() {
        GuessPanel panel = new GuessPanel((GameController.game().getWindow().getContentSize()));
        turnTimer.schedule();
        turnTimer.addListener(panel);
		return panel;
	}
}
