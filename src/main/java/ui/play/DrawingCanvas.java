package ui.play;

import controller.GameController;
import model.Piece;

/**
 * @author oguzb
 */
public class DrawingCanvas extends Canvas {
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
