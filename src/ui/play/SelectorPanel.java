package ui.play;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author oguzb
 */
public abstract class SelectorPanel extends JPanel implements MouseListener {

	private JPanel[] panels;

	public SelectorPanel(Dimension panelSize) {
		// TODO: create a table with predefined matrix dimensions, place each item into cells.
		// TODO: also listen for clicks and delegate to onItemClicked
	}

	protected abstract Dimension getMatrixDimensions();

	protected abstract JPanel getItem(int position);

	// We don't need the following events:

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
}
