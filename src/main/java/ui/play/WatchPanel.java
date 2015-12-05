package ui.play;

import java.awt.*;

/**
 * @author oguzb
 */
public class WatchPanel extends PlayPanel {

	public WatchPanel(Dimension size) {
		super(size);
		setBackground(Color.yellow);
	}

	@Override
	protected Canvas initializeCanvas() {
		return new ViewingCanvas();
	}

	@Override
	protected ColorPanel initializeColorPanel(Dimension size) {
		return null;
	}

	@Override
	protected BrushPanel initializeBrushPanel(Dimension size) {
		return null;
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
