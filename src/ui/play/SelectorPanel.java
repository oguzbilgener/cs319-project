package ui.play;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author oguzb
 */
public abstract class SelectorPanel extends JPanel implements MouseListener {

	private Dimension panelSize;

	public SelectorPanel(Dimension panelSize) {
		this.panelSize = panelSize;
	}

	protected void placeItems() {
		setLayout(null);
		// TODO: iterate over all items over 2 dimension,
		// - use getMatrixDimensions()
		// - use getItem()
		// - use getSize()
	}

	protected boolean isInteractionAllowed() {
		return true;
	}

	protected abstract Dimension getMatrixDimensions();

	protected abstract JPanel getItem(int position);

	protected Dimension getItemSize() {
		return new Dimension(panelSize.width / getMatrixDimensions().width,
				panelSize.height / getMatrixDimensions().height);
	}

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
