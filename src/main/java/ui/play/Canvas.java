package ui.play;

import controller.GameController;
import model.Piece;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.awt.event.MouseMotionListener;
import java.util.List;
import java.util.TimerTask;
import java.util.Timer;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author oguzb
 */
public abstract class Canvas extends JPanel implements MouseListener, MouseMotionListener {


	protected abstract boolean isInteractionAllowed();

	protected List<Piece> pieces;
	private Piece currentPiece;
	private int currentPiecePosition;

	public Canvas() {
		pieces = new CopyOnWriteArrayList<>();
		addMouseListener(this);
		addMouseMotionListener(this);
		setBackground(Color.white);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		for(Piece piece : pieces) {
			drawPiece(piece, g);
		}
		if(currentPiece != null) {
            if(currentPiecePosition == -1) {
                drawPiece(currentPiece, g);
            }
            else if(currentPiecePosition > -1) {
                drawPartialPiece(currentPiece, g);
            }
		}
	}

	public void drawPiece(Piece piece, Graphics g) {
		g.setColor(piece.getColor());
		if(piece.getPoints() == null) {
			return;
		}
		for(Point point : piece.getPoints()) {
			g.fillOval((int)point.getX()-piece.getRadius(), (int)point.getY()-piece.getRadius(), piece.getRadius()*2, piece.getRadius()*2);
		}
	}

    public void drawPartialPiece(Piece piece, Graphics g) {
        g.setColor(piece.getColor());
        if(piece.getPoints() == null) {
            return;
        }
        for(int i=0;i<=currentPiecePosition;i++) {
            Point point = piece.getPoints().get(i);
            g.fillOval((int)point.getX()-piece.getRadius(), (int)point.getY()-piece.getRadius(), piece.getRadius()*2, piece.getRadius()*2);
        }
    }

	public void addPiece(Piece piece) {
		pieces.add(piece);
		repaint();
	}

    public void receivePiece(Piece piece) {
        currentPiece = piece;
        currentPiecePosition = 0;
        startCurrentPieceAnimation();
    }

	public void clear() {
		pieces = new CopyOnWriteArrayList<>();
		currentPiece = null;
		currentPiecePosition = -1;
		repaint();
	}

	public void addPoint(MouseEvent e) {
		if(isInteractionAllowed()) {
			if(currentPiece == null) {
                currentPiecePosition = -1;
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

	protected void commitCurrentPieceDrawing() {
		if(currentPiece != null && isInteractionAllowed()) {
			currentPiece.setEndTime(System.currentTimeMillis());
			addPiece(currentPiece);
			currentPiece = null;
			currentPiecePosition = -1;
		}
	}

    protected void startCurrentPieceAnimation() {
        currentPiecePosition = 0;
        final Timer timer = new Timer();
        TimerTask animTask = new TimerTask() {
            @Override
            public void run() {
                repaint();
                if(currentPiecePosition < currentPiece.getPoints().size() -1) {
                    currentPiecePosition++;
                }
                else {
                    timer.cancel();
                    onCurrentPieceAnimationEnd();
                }
            }
        };
        long rate = Math.abs((currentPiece.getEndTime()-currentPiece.getStartTime())/(currentPiece.getPoints().size()));
        timer.scheduleAtFixedRate(animTask, 0, rate);
    }

    protected void onCurrentPieceAnimationEnd() {
        currentPiecePosition = -1;
        addPiece(currentPiece);

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
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mouseDragged(MouseEvent e) {
		addPoint(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {}
}
