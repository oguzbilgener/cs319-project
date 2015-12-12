package ui.play;

import javax.swing.*;
import java.awt.*;

/**
 * @author oguzb
 */
public class BrushButton extends JPanel {

	protected int brushSize;
	private Dimension size;

	private BrushButton(Dimension size, int brushSize) {
		this.brushSize = brushSize;
		this.size = size;
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}

	public int getBrushSize() {
		return brushSize;
	}

	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, size.width, size.height);
		g.setColor(Color.gray);
		g.fillOval(size.width/2 - brushSize, size.width/2 - brushSize, brushSize*2, brushSize*2);
	}

	/**
	 * Creates a predefined brush instance with given index
	 * @param index the brush index, currently between 0 and 5.
	 * @return a new BrushButton instance with brushSize
	 */
	public static BrushButton create(int index, Dimension panelSize) {
		// TODO: find the optimal brush sizes.
		switch (index) {
			case 0:
				return new BrushButton(panelSize, 2);
			case 1:
				return new BrushButton(panelSize, 4);
			case 2:
				return new BrushButton(panelSize, 8);
			case 3:
				return new BrushButton(panelSize, 10);
			case 4:
				return new BrushButton(panelSize, 12);
			case 5:
				return new BrushButton(panelSize, 16);
			default:
				return new BrushButton(panelSize, 2);
		}
	}
}
