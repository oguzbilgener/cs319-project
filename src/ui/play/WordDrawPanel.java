package ui.play;

import java.awt.*;

/**
 * @author oguzb
 */
public class WordDrawPanel extends PlayPanel {


	public WordDrawPanel(Dimension size) {
		super(size);
		setBackground(Color.cyan);
	}

	@Override
	protected Canvas initializeCanvas() {
		return new DrawingCanvas();
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
