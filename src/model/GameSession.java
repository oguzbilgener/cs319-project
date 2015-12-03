package model;

import java.util.Observable;

/**
 * @author oguzb
 */
public class GameSession extends Observable {

	public enum RoundState {
		DRAW, WATCH, GUESS, WAIT, STATS
	}

	protected Player myPlayer;
	protected Player otherPlayer;
	protected boolean myPlayerIsActive;
	protected int roundNumber;
	protected RoundState roundState;

	public GameSession(Player myPlayer, Player otherPlayer, boolean isMyPlayerActive) {
		this.myPlayer = myPlayer;
		this.otherPlayer = otherPlayer;
		this.myPlayerIsActive = isMyPlayerActive;
		this.roundNumber = 1;
		this.roundState = isMyPlayerActive ? RoundState.DRAW : RoundState.WATCH;
	}

	public Player getMyPlayer() {
		return myPlayer;
	}

	public void setMyPlayer(Player myPlayer) {
		this.myPlayer = myPlayer;
		setChanged();
		notifyObservers(myPlayer);
	}

	public Player getOtherPlayer() {
		return otherPlayer;
	}

	public void setOtherPlayer(Player otherPlayer) {
		this.otherPlayer = otherPlayer;
		setChanged();
		notifyObservers(otherPlayer);
	}

	public boolean isMyPlayerIsActive() {
		return myPlayerIsActive;
	}

	public void setMyPlayerIsActive(boolean myPlayerIsActive) {
		this.myPlayerIsActive = myPlayerIsActive;
		setChanged();
		notifyObservers(myPlayerIsActive);
	}

	public int getRoundNumber() {
		return roundNumber;
	}

	public void setRoundNumber(int roundNumber) {
		this.roundNumber = roundNumber;
		setChanged();
		notifyObservers(roundNumber);
	}

	public RoundState getRoundState() {
		return roundState;
	}

	public void setRoundState(RoundState roundState) {
		this.roundState = roundState;
		setChanged();
		notifyObservers(roundState);
	}

	public Player getActivePlayer() {
		if(myPlayerIsActive) {
			return myPlayer;
		}
		return otherPlayer;
	}
}
