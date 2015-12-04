package ui.play;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * @author oguzb
 */
public class ColorPanel extends SelectorPanel {

	private ColorSwatch[] colors;

	public ColorPanel() {
		colors = new ColorSwatch[20];

		// TODO: initialize each color, give values

		for(ColorSwatch color : colors) {
			color.addMouseListener(this);
		}
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
		// TODO: delegate this event to the active controller
	}
}
