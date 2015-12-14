package ui.play;

import ui.GameStatePanel;
import util.TimerListener;

import javax.swing.*;
import java.awt.*;

/**
 * @author oguzb
 */
public abstract class PlayPanel extends GameStatePanel implements TimerListener {

	private Canvas canvas;
	protected JLabel timeLabel;
    protected WordPanel wordBox;
    protected ActionToolbar actionToolbar;

	public PlayPanel(Dimension size) {
		super(size);
		// Doing it in absolute way
		setLayout(null);

		canvas = initializeCanvas();
		add(canvas);
		canvas.setBounds(16, 16, 360, 360);
		ColorPanel colorPanel = initializeColorPanel(new Dimension(64, 320));
		add(colorPanel);
		colorPanel.setBounds(396, 16, colorPanel.getSize().width, colorPanel.getSize().height);

		BrushPanel brushPanel = initializeBrushPanel(new Dimension(64, 96));
		add(brushPanel);

		brushPanel.setBounds(396, 360, brushPanel.getSize().width, brushPanel.getSize().height);
		wordBox = initializeWordPanel(new Dimension(360,100));
        add(wordBox);
		wordBox.setBounds(canvas.getX(),canvas.getY()+canvas.getHeight()+10, wordBox.getWidth(), wordBox.getHeight() );
        timeLabel = new JLabel();
        add(timeLabel);
        timeLabel.setBounds(canvas.getX(), wordBox.getY()+wordBox.getHeight()+5, 25,25);
        timeLabel.setText("45");

		actionToolbar = initializeActionToolbar(new Dimension(64,100));
		add(actionToolbar);
        actionToolbar.setBounds(396,470, actionToolbar.getSize().width, actionToolbar.getSize().height);


	}

	public Canvas getCanvas() {
		return canvas;
	}

	protected abstract Canvas initializeCanvas();

	protected abstract ColorPanel initializeColorPanel(Dimension size);

	protected abstract BrushPanel initializeBrushPanel(Dimension size);

	protected abstract WordPanel initializeWordPanel(Dimension size);

	protected abstract ActionToolbar initializeActionToolbar(Dimension size);

    public void onTimeOut()
    {

    }

    public void onTick (int elapsedTime)
    {

        timeLabel.setText(Integer.toString(elapsedTime));

    }
}


