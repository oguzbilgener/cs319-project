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
	protected ColorPanel initializeColorPanel(Dimension size) {
		return new ColorPanel(size);
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
