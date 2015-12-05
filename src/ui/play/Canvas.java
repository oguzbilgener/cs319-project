package ui.play;

import com.sun.istack.internal.Nullable;
import controller.GameController;
import model.Piece;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.awt.event.MouseMotionListener;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author oguzb
 */
public abstract class Canvas extends JPanel implements MouseListener, MouseMotionListener {


	protected abstract boolean isInteractionAllowed();

	private List<Piece> pieces;
	@Nullable private Piece currentPiece;

	public Canvas() {
		pieces = new CopyOnWriteArrayList<>();
		addMouseListener(this);
		addMouseMotionListener(this);
		setBackground(Color.white);
		setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		for(Piece piece : pieces) {
			drawPiece(piece, g);
		}
		if(currentPiece != null) {
			drawPiece(currentPiece, g);
		}
	}

	public void drawPiece(Piece piece, Graphics g) {
		g.setColor(piece.getColor());
		for(Point point : piece.getPoints()) {
			g.fillOval((int)point.getX(), (int)point.getY(), piece.getRadius()*2, piece.getRadius()*2);
		}
	}

	public void addPiece(Piece piece) {
		pieces.add(piece);
		repaint();
	}

	public void clear() {
		pieces = new CopyOnWriteArrayList<>();
		currentPiece = null;
		repaint();
	}

	public void addPoint(MouseEvent e) {
		if(isInteractionAllowed()) {
			if(currentPiece == null) {
				Color color = GameController.game().getSession().getColor();
				int   size  = GameController.game().getSession().getBrushSize();
				currentPiece = new Piece(color, size);
				currentPiece.setStartTime(System.currentTimeMillis());
			}
			Point point = new Point(e.getX(), e.getY());
			currentPiece.addPoint(point);
		}
		repaint();
	}

	public void commitCurrentPieceDrawing() {
		if(currentPiece != null && isInteractionAllowed()) {
			currentPiece.setEndTime(System.currentTimeMillis());
			addPiece(currentPiece);
			currentPiece = null;
			// TODO: trigger new piece creation event at `DrawingCanvas`
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		addPoint(e);
		commitCurrentPieceDrawing();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		addPoint(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		commitCurrentPieceDrawing();
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		addPoint(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}
}
