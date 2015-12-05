package ui.play;

import ui.GameStatePanel;

import java.awt.*;

/**
 * @author oguzb
 */
public abstract class PlayPanel extends GameStatePanel {

	private Canvas canvas;

	public PlayPanel(Dimension size) {
		super(size);
		// Doing it in absolute way
		setLayout(null);

		canvas = initializeCanvas();
		add(canvas);
		canvas.setBounds(16, 39, 360, 360);


	}

	public Canvas getCanvas() {
		return canvas;
	}

	protected abstract Canvas initializeCanvas();

	protected abstract ColorPanel initializeColorPanel();

	protected abstract BrushPanel initializeBrushPanel();

	protected abstract WordPanel initializeWordPanel();

	protected abstract ActionToolbar initializeActionToolbar();
}
