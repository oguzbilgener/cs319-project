package ui.play;

import controller.GameController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * @author oguzb
 */
public class ColorPanel extends SelectorPanel {

	private ColorSwatch[] colors;

	public ColorPanel(Dimension panelSize) {
		super(panelSize);
		setBackground(Color.white);
		colors = new ColorSwatch[20];

		for(int i = 0; i < colors.length; i++) {
			colors[i] = ColorSwatch.create(i, getItemSize());
			if (isInteractionAllowed()) {
				colors[i].addMouseListener(this);
			}
            else {
                colors[i].setDisabled(true);
            }
		}
		super.placeItems();
	}

	@Override
	protected Dimension getMatrixDimensions() {
		return new Dimension(2, 10);
	}

	@Override
	protected JPanel getItem(int position) {
		return colors[position];
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		ColorSwatch swatch = (ColorSwatch) e.getSource();
		Color color = swatch.getColor();
		// Delegate this event to the session
		GameController.game().getSession().setColor(color);
	}
}
