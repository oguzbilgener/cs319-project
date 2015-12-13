package ui.play;

import model.Piece;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author oguzb
 */
public class WatchPanel extends PlayPanel {

	private ActionListener giveUpListener, closeListener;
	private Canvas canvas;


	public WatchPanel(Dimension size, ActionListener  giveUpListener, ActionListener closeListener) {
		super(size);

		this.giveUpListener = giveUpListener;
		this.closeListener = closeListener;
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
		return new WatchInfoPanel(size);
	}

	@Override
	protected ActionToolbar initializeActionToolbar(Dimension size) {
		ActionButton button1 = ActionButton.createGiveUpButton(new Dimension(size.width/2, size.height));
		ActionButton button2 = ActionButton.createCloseButton(new Dimension(size.width/2, size.height));
		ActionToolbar watchBar = new ActionToolbar(size, button1, this.giveUpListener, button2, this.closeListener);

		return watchBar;
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
