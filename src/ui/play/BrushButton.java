package ui.play;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.swing.*;
import java.awt.*;

/**
 * @author oguzb
 */
public class BrushButton extends JPanel {

	protected int size;

	private BrushButton(int size) {
		this.size = size;
	}

	public int getBrushSize() {
		return size;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.gray);
		// TODO: draw a circle with a radius proportional to the parameter `size`
	}

	/**
	 * Creates a predefined brush instance with given index
	 * @param index the brush index, currently between 0 and 5.
	 * @return a new BrushButton instance with size
	 */
	public static BrushButton create(int index) {
		// TODO: find the optimal brush sizes.
		switch (index) {
			case 0:
				return new BrushButton(2);
			case 1:
				return new BrushButton(4);
			case 2:
				return new BrushButton(8);
			case 3:
				return new BrushButton(12);
			case 4:
				return new BrushButton(16);
			case 5:
				return new BrushButton(20);
			default:
				return new BrushButton(20);
		}
	}
}
