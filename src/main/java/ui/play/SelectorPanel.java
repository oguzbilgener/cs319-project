package ui.play;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author oguzb
 */
public abstract class SelectorPanel extends JPanel implements MouseListener {

	public SelectorPanel(Dimension panelSize) {
		setSize(panelSize);
	}

	protected void placeItems() {
		setLayout(null);
		for(int row=0; row < getMatrixDimensions().height; row++) {
			for(int column=0; column < getMatrixDimensions().width;column++) {
				JPanel item = getItem(column + getMatrixDimensions().width * row);
				add(item);
				item.setBounds(
						column * (getSize().width / getMatrixDimensions().width),
						row * (getSize().height / getMatrixDimensions().height),
						getSize().width / getMatrixDimensions().width,
						getSize().height / getMatrixDimensions().height);
			}
		}
	}

	protected boolean isInteractionAllowed() {
		return true;
	}

	protected abstract Dimension getMatrixDimensions();

	protected abstract JPanel getItem(int position);

	protected Dimension getItemSize() {
		return new Dimension(getSize().width / getMatrixDimensions().width,
				getSize().height / getMatrixDimensions().height);
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
