package ui.play;

import ui.play.Canvas;
import ui.play.PlayPanel;

import java.awt.*;

/**
 * @author oguzb
 */
public class WordDrawPanel extends PlayPanel {


	public WordDrawPanel(Dimension size) {
		super(size);
	}

	@Override
	protected Canvas initializeCanvas() {
		return new DrawingCanvas();
	}
}
