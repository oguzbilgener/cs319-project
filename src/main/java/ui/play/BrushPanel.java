package ui.play;

import controller.GameController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * @author oguzb
 */
public class BrushPanel extends SelectorPanel {

	private BrushButton[] brushes;

	public BrushPanel(Dimension panelSize) {
		super(panelSize);
		brushes = new BrushButton[6];

		for(int i = 0; i < brushes.length; i++) {
			brushes[i] = BrushButton.create(i, getItemSize());
			if(isInteractionAllowed()) {
				brushes[i].addMouseListener(this);
			}
		}
		super.placeItems();
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
		click(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		click(e);
	}

	protected void click(MouseEvent e) {
		BrushButton brush = (BrushButton) e.getSource();
		int size = brush.getBrushSize();
		GameController.game().getSession().setBrushSize(size);
	}
}
