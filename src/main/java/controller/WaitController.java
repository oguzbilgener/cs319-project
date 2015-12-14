package controller;

import model.Piece;
import ui.GameStatePanel;
import ui.GameWindow;
import ui.play.PlayPanel;
import ui.play.WaitPanel;

import java.util.List;

/**
 * @author oguzb
 */
public class WaitController extends GameStateController {

	public WaitController(GameWindow window, List<Piece> finishedDrawing) {
		super(window);
        ((PlayPanel) getPanel()).getCanvas().setPieces(finishedDrawing);

	}

	@Override
	GameStatePanel initializePanel() {
		WaitPanel panel = new WaitPanel(GameController.game().getWindow().getContentSize());
        turnTimer.schedule();
        turnTimer.addListener(panel);
        return panel;
	}
}
