package ui.play;

import java.awt.*;

/**
 * @author oguzb
 */
public class ViewingCanvas extends Canvas {

	public ViewingCanvas() {
		super();
	}

	@Override
	protected boolean isInteractionAllowed() {
		return false;
	}
}
