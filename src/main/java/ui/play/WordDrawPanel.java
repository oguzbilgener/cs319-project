package ui.play;

import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author oguzb
 */
public class WordDrawPanel extends PlayPanel {

	public WordDrawPanel(Dimension size) {
		super(size);
		setBackground(Color.decode("#EDEDED"));

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
		return new ActionToolbar(size, button1, button2);
	}

	public void setActionListeners(ActionListener checkListener, ActionListener closeListener) {
		actionToolbar.setListeners(checkListener, closeListener);
	}
}
