package ui.play;

import ui.GameStatePanel;

import java.awt.*;

/**
 * @author oguzb
 */
public abstract class PlayPanel extends GameStatePanel {

	public PlayPanel(Dimension size) {
		super(size);
		// Doing it in absolute way
		setLayout(null);

		System.out.println(getSize());
		System.out.println(getInsets());

		Canvas canvas = initializeCanvas();
		add(canvas);


	}

	protected abstract Canvas initializeCanvas();
}
