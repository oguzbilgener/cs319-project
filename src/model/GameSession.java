package model;

import ui.play.BrushButton;
import ui.play.ColorSwatch;

import java.awt.*;
import java.util.Observable;

/**
 * @author oguzb
 */
public class GameSession extends Observable {

	public enum RoundState {
		CHOOSE_WORD, DRAW, WATCH, GUESS, WAIT, STATS
	}

	protected Player myPlayer;
	protected Player otherPlayer;
	protected boolean myPlayerIsActive;
	protected int roundNumber;
	protected RoundState roundState;
	protected Color color;
	protected int brushSize;

	public GameSession(Player myPlayer, Player otherPlayer, boolean isMyPlayerActive) {
		this.myPlayer = myPlayer;
		this.otherPlayer = otherPlayer;
		this.myPlayerIsActive = isMyPlayerActive;
		this.roundNumber = 1;
		this.roundState = isMyPlayerActive ? RoundState.DRAW : RoundState.WATCH;
		this.color = ColorSwatch.create(1).getColor(); // Default color is black
		this.brushSize = BrushButton.create(0).getBrushSize(); // Default brush is the smallest.
	}

	public Player getMyPlayer() {
		return myPlayer;
	}

	public void setMyPlayer(Player myPlayer) {
		this.myPlayer = myPlayer;
		setChanged();
		notifyObservers(new Field(Field.Name.MY_PLAYER, myPlayer));
	}

	public Player getOtherPlayer() {
		return otherPlayer;
	}

	public void setOtherPlayer(Player otherPlayer) {
		this.otherPlayer = otherPlayer;
		setChanged();
		notifyObservers(new Field(Field.Name.OTHER_PLAYER, otherPlayer));
	}

	public boolean isMyPlayerIsActive() {
		return myPlayerIsActive;
	}

	public void setMyPlayerIsActive(boolean myPlayerIsActive) {
		this.myPlayerIsActive = myPlayerIsActive;
		setChanged();
		notifyObservers(new Field(Field.Name.MY_PLAYER_IS_ACTIVE, myPlayerIsActive));
	}

	public int getRoundNumber() {
		return roundNumber;
	}

	public void setRoundNumber(int roundNumber) {
		this.roundNumber = roundNumber;
		setChanged();
		notifyObservers(new Field(Field.Name.ROUND_NUMBER, roundNumber));
	}

	public RoundState getRoundState() {
		return roundState;
	}

	public void setRoundState(RoundState roundState) {
		this.roundState = roundState;
		setChanged();
		notifyObservers(new Field(Field.Name.ROUND_STATE, roundState));
	}

	public Player getActivePlayer() {
		if(myPlayerIsActive) {
			return myPlayer;
		}
		return otherPlayer;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
		setChanged();
		notifyObservers(new Field(Field.Name.COLOR, color));
	}

	public int getBrushSize() {
		return brushSize;
	}

	public void setBrushSize(Integer brushSize) {
		this.brushSize = brushSize;
		setChanged();
		notifyObservers(new Field(Field.Name.BRUSH_SIZE, brushSize));
	}

	public static class Field {
		public Name name;
		public Object object;

		public enum Name {
			MY_PLAYER, OTHER_PLAYER, MY_PLAYER_IS_ACTIVE, ROUND_NUMBER, ROUND_STATE, COLOR, BRUSH_SIZE
		}

		public Field(Name name, Object object) {
			this.name = name;
			this.object = object;
		}
	}
}
