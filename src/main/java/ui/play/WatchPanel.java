package ui.play;

import model.Piece;

import javax.swing.*;
import java.awt.*;

/**
 * @author oguzb
 */
public class WatchPanel extends PlayPanel {

	private Canvas canvas;

	public WatchPanel(Dimension size) {
		super(size);
		//setBackground(Color.yellow);


	/*	setTimeLabel(new JLabel());
		getTimeLabel().setBounds(canvas.getX(),canvas.getY()+canvas.getHeight()+50, 25,25);//size.height-55,size.width-150,25,25);
		add(getTimeLabel());*/

	}

	public void addPiece(Piece piece) {
		canvas.addPiece(piece);
	}

	@Override
	protected Canvas initializeCanvas() {
		canvas = new ViewingCanvas();
		return canvas;


	}

	@Override
	protected ColorPanel initializeColorPanel(Dimension size) {
		return new DisabledColorPanel(size);
	}

	@Override
	protected BrushPanel initializeBrushPanel(Dimension size) {
		return new BrushPanel(size);
	}

	@Override
	protected WordPanel initializeWordPanel(Dimension size) {
		return null;
	}

	@Override
	protected ActionToolbar initializeActionToolbar(Dimension size) {
		return null;
	}

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
