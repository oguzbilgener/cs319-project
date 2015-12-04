package ui.play;

import javax.swing.*;
import java.awt.*;

/**
 * @author oguzb
 */
public class BrushButton extends JPanel {

	protected int size;

	public BrushButton(int size) {
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
}
