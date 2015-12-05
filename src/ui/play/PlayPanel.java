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
		ColorPanel colorPanel = initializeColorPanel(new Dimension(64, 320));
		add(colorPanel);
		colorPanel.setBounds(396, 39, colorPanel.getSize().width, colorPanel.getSize().height);

		BrushPanel brushPanel = initializeBrushPanel(new Dimension(64, 96));
		add(brushPanel);
		brushPanel.setBounds(396, 360, brushPanel.getSize().width, brushPanel.getSize().height);
	}

	public Canvas getCanvas() {
		return canvas;
	}

	protected abstract Canvas initializeCanvas();

	protected abstract ColorPanel initializeColorPanel(Dimension size);

	protected abstract BrushPanel initializeBrushPanel(Dimension size);

	protected abstract WordPanel initializeWordPanel(Dimension size);

	protected abstract ActionToolbar initializeActionToolbar(Dimension size);
}
