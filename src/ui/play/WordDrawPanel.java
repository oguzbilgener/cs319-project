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
}
