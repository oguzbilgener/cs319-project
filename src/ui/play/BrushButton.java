package ui.play;

import javax.swing.*;
import java.awt.*;

/**
 * @author oguzb
 */
public class BrushButton extends JPanel {

	protected int brushSize;

	private BrushButton(Dimension size, int brushSize) {
		this.brushSize = brushSize;
	}

	public int getBrushSize() {
		return brushSize;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.gray);
		// TODO: draw a circle with a radius proportional to the parameter `brushSize`
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
				return new BrushButton(panelSize, 12);
			case 4:
				return new BrushButton(panelSize, 16);
			case 5:
				return new BrushButton(panelSize, 20);
			default:
				return new BrushButton(panelSize, 20);
		}
	}
}
