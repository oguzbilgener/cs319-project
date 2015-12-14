package model;

import com.google.gson.*;

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
	protected Long startTime;
	protected Long endTime;

	public Piece() {
		this(Color.black, 0);
	}

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

	void setPoints(List<Point> points) {
		this.points = points;
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

	public Long getStartTime() {
		return startTime;
	}

	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}

	public Long getEndTime() {
		return endTime;
	}

	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}

	public static Piece fromJson(String jsonStr) {
        JsonElement msg = new JsonParser().parse(jsonStr);
		Piece piece = new Gson().fromJson(msg.getAsJsonObject().get("content"), Piece.class);
        System.out.println(piece.points);
        return piece;
	}
}
