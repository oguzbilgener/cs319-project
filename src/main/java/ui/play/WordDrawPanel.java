package ui.play;

import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author oguzb
 */
public class WordDrawPanel extends PlayPanel {

	private ActionListener checkListener, closeListener;

	public WordDrawPanel(Dimension size, ActionListener checkListener, ActionListener closeListener) {
		super(size);
		setBackground(Color.decode("#EDEDED"));
		this.checkListener = checkListener;
		this.closeListener = closeListener;
	}

	@Override
	protected Canvas initializeCanvas() {
		return new DrawingCanvas();
	}

	@Override
	protected ColorPanel initializeColorPanel(Dimension size) {
		return new ColorPanel(size);
	}

	@Override
	protected BrushPanel initializeBrushPanel(Dimension size) {
		return new BrushPanel(size);
	}

	@Override
	protected WordPanel initializeWordPanel(Dimension size) {
		return new WordInfoPanel(size);
	}

	@Override

	protected ActionToolbar initializeActionToolbar(Dimension size) {

		ActionButton button1 = ActionButton.createCheckButton(new Dimension(size.width/2, size.height));
		ActionButton button2 = ActionButton.createCloseButton(new Dimension(size.width/2, size.height));
		ActionToolbar drawBar = new ActionToolbar(size, button1, this.checkListener, button2, this.closeListener);
		return drawBar;
	}
}
