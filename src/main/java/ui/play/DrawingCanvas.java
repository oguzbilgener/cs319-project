package ui.play;

import controller.GameController;
import model.Piece;

import java.awt.*;

/**
 * @author oguzb
 */
public class DrawingCanvas extends Canvas {

	public DrawingCanvas() {
		super();
		setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
	}

	@Override
	protected boolean isInteractionAllowed() {
		return true;
	}

	@Override
	public void commitCurrentPieceDrawing() {
		super.commitCurrentPieceDrawing();

        Piece lastPiece = pieces.get(pieces.size()-1);

        GameController.game().getP2pManager().sendPiece(lastPiece);
	}
}
