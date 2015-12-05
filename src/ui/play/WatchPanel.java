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
	protected ColorPanel initializeColorPanel() {
		return null;
	}

	@Override
	protected BrushPanel initializeBrushPanel() {
		return null;
	}

	@Override
	protected WordPanel initializeWordPanel() {
		return null;
	}

	@Override
	protected ActionToolbar initializeActionToolbar() {
		return null;
	}
}
