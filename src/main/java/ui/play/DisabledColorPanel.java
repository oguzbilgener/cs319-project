package ui.play;

import java.awt.*;

/**
 * @author oguzb
 */
public class DisabledColorPanel extends ColorPanel {
	public DisabledColorPanel(Dimension panelSize) {
		super(panelSize);
	}

	@Override
	protected boolean isInteractionAllowed() {
		return false;
	}
}
