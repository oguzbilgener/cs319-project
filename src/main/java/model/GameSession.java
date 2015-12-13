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
	protected String chosenWord;
	protected String[] wordList;

	public GameSession(Player myPlayer, Player otherPlayer, boolean isMyPlayerActive) {
		this.myPlayer = myPlayer;
		this.otherPlayer = otherPlayer;
		this.myPlayerIsActive = isMyPlayerActive;
		this.roundNumber = 1;
		this.roundState = isMyPlayerActive ? RoundState.DRAW : RoundState.WATCH;
		this.color = ColorSwatch.create(1, new Dimension(0,0)).getColor(); // Default color is black
		this.brushSize = BrushButton.create(0, new Dimension(0,0)).getBrushSize(); // Default brush is the smallest.
        this.wordList = new String[3];
        this.chosenWord = null;

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

	public String getChosenWord() {
		return chosenWord;
	}

	public void setChosenWord(String chosenWord) {
		this.chosenWord = chosenWord;
		setChanged();
		notifyObservers(new Field(Field.Name.CHOSEN_WORD,chosenWord));
	}

	public String[] getWordList() {
		return wordList;
	}

	public void setWordList(String[] wordList) {
		this.wordList = wordList;
		setChanged();
		notifyObservers(new Field(Field.Name.WORD_LIST, wordList));
	}

	public static class Field {
		public Name name;
		public Object object;

		public enum Name {
			MY_PLAYER, OTHER_PLAYER, MY_PLAYER_IS_ACTIVE, ROUND_NUMBER, ROUND_STATE, COLOR, BRUSH_SIZE,
			CHOSEN_WORD, WORD_LIST;
		}

		public Field(Name name, Object object) {
			this.name = name;
			this.object = object;
		}
	}
}
