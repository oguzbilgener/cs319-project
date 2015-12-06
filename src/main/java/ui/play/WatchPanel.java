package ui.play;

import model.Piece;

import java.awt.*;

/**
 * @author oguzb
 */
public class WatchPanel extends PlayPanel {

	private Canvas canvas;

	public WatchPanel(Dimension size) {
		super(size);
		setBackground(Color.yellow);
	}

	public void addPiece(Piece piece) {
		canvas.addPiece(piece);
	}

	@Override
	protected Canvas initializeCanvas() {
		canvas = new ViewingCanvas();
		return canvas;
	}

	@Override
	protected ColorPanel initializeColorPanel(Dimension size) {
		return new DisabledColorPanel(size);
	}

	@Override
	protected BrushPanel initializeBrushPanel(Dimension size) {
		return new BrushPanel(size);
	}

	@Override
	protected WordPanel initializeWordPanel(Dimension size) {
		return null;
	}

	@Override
	protected ActionToolbar initializeActionToolbar(Dimension size) {
		return null;
	}
}
