package ui.play;

import ui.GameStatePanel;
import util.TimerListener;
import util.TurnTimer;

import javax.swing.*;
import java.awt.*;

/**
 * @author oguzb
 */
public abstract class PlayPanel extends GameStatePanel implements TimerListener {

	private Canvas canvas;
	protected JLabel timeLabel;
    private int currentTime;
    private GuessBoxPanel guessBox;

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
		//////////////////
        guessBox= new GuessBoxPanel(new Dimension(350,100));
		///guessBox.intializeWordPanel(new Dimension(350,100));
        add(guessBox);
        guessBox.setBounds(canvas.getX(),canvas.getY()+canvas.getHeight()+10, guessBox.getWidth(), guessBox.getHeight() );
		//////////////////
        timeLabel= new JLabel();
        add(timeLabel);
        timeLabel.setBounds(canvas.getX(), guessBox.getY()+guessBox.getHeight()+5, 25,25);
        timeLabel.setText("45");

		ActionToolbar toolbar = initializeActionToolbar(new Dimension(100,100));
		add(toolbar);
		toolbar.setBounds(365,470, toolbar.getSize().width, toolbar.getSize().height);


	}

	public Canvas getCanvas() {
		return canvas;
	}

	protected abstract Canvas initializeCanvas();

	protected abstract ColorPanel initializeColorPanel(Dimension size);

	protected abstract BrushPanel initializeBrushPanel(Dimension size);

	protected abstract WordPanel initializeWordPanel(Dimension size);

	protected abstract ActionToolbar initializeActionToolbar(Dimension size);

	public JLabel getTimeLabel() {
		return timeLabel;
	}

	public void setTimeLabel(JLabel timeLabel) {
		this.timeLabel = timeLabel;
	}

    public void onTimeOut()
    {

    }

    public void onTick (int elapsedTime)
    {

        timeLabel.setText(Integer.toString(elapsedTime));

    }
}


