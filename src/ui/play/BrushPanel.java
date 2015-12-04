package ui.play;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * @author oguzb
 */
public class BrushPanel extends SelectorPanel {

	private BrushPanel[] brushes;

	public BrushPanel() {
		brushes = new BrushPanel[6];

		// TODO: initialize each brush, give values

		for (BrushPanel brush: brushes) {
			brush.addMouseListener(this);
		}
	}

	@Override
	protected Dimension getMatrixDimensions() {
		return new Dimension(2, 3);
	}

	@Override
	protected JPanel getItem(int position) {
		return brushes[position];
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		BrushButton brush = (BrushButton) e.getSource();
		int size = brush.getBrushSize();
		// TODO: delegate this event to the active controller
	}
}
