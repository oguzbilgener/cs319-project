package model;

import java.util.Observable;

/**
 * @author oguzb
 */
public class GameSession extends Observable {

	public enum RoundState {
		READY, DRAW_OR_WATCH, GUESS, STATS
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
		this.roundState = RoundState.READY;
	}

	public Player getMyPlayer() {
		return myPlayer;
	}

	public void setMyPlayer(Player myPlayer) {
		this.myPlayer = myPlayer;
		notifyObservers(myPlayer);
	}

	public Player getOtherPlayer() {
		return otherPlayer;
	}

	public void setOtherPlayer(Player otherPlayer) {
		this.otherPlayer = otherPlayer;
		notifyObservers(otherPlayer);
	}

	public boolean isMyPlayerIsActive() {
		return myPlayerIsActive;
	}

	public void setMyPlayerIsActive(boolean myPlayerIsActive) {
		this.myPlayerIsActive = myPlayerIsActive;
		notifyObservers(myPlayerIsActive);
	}

	public int getRoundNumber() {
		return roundNumber;
	}

	public void setRoundNumber(int roundNumber) {
		this.roundNumber = roundNumber;
		notifyObservers(roundNumber);
	}

	public RoundState getRoundState() {
		return roundState;
	}

	public void setRoundState(RoundState roundState) {
		this.roundState = roundState;
		notifyObservers(roundState);
	}

	public Player getActivePlayer() {
		if(myPlayerIsActive) {
			return myPlayer;
		}
		return otherPlayer;
	}
}
