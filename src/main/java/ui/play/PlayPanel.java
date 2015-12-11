package ui.play;

import ui.GameStatePanel;
import util.TimerListener;
import util.TurnTimer;

import javax.swing.*;
import java.awt.*;
import java.util.TimerTask;
import java.util.Timer;

/**
 * @author oguzb
 */
public abstract class PlayPanel extends GameStatePanel implements TimerListener {

	private Canvas canvas;
	protected JLabel timeLabel;
    private int currentTime;

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


        timeLabel= new JLabel();
        add(timeLabel);
        timeLabel.setBounds(canvas.getX(),canvas.getY()+canvas.getHeight()+50, 25,25);
        timeLabel.setText("45");

		// canvas.getY()+canvas.getHeight()+50, 25,25);
				//canvas.getX()+450, canvas.getY()+450, 25,25);

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
        /*if(currentTime>0)
        {
            currentTime-=1;
            timeLabel.setText(Integer.toString(currentTime));

        }*/

    }
}


