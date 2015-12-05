package ui.play;

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
		colors = new ColorSwatch[20];

		for(int i = 0; i < colors.length; i++) {
			colors[i] = ColorSwatch.create(i);
			colors[i].addMouseListener(this);

			// TODO: place this swatch into the panel
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
