package model;

import java.awt.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author oguzb
 */
public class Piece {

	protected List<Point> points;
	protected int radius;
	protected Color color;

	public Piece(Color color, int radius) {
		points = new CopyOnWriteArrayList<>();
		this.radius = radius;
		this.color = color;
	}

	public void addPoint(Point point) {
		points.add(point);
	}

	public void reset() {
		points = new CopyOnWriteArrayList<>();
	}

	public List<Point> getPoints() {
		return points;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}
