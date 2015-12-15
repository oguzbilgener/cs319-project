package controller;

import model.Piece;
import ui.GameStatePanel;
import ui.GameWindow;
import ui.play.GuessPanel;
import ui.play.LetterButton;
import ui.play.PlayPanel;

import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by oguzb on 03/12/15.
 */
public class GuessWordController extends GameStateController implements LetterButton.LetterButtonClickListener {

    public static final int MAX_LENGTH = 10;
    private String correctWord;
    private char[] availableLetters;
    private char[] guess;
    private int slotToFill;

	public GuessWordController(GameWindow window, List<Piece> finishedDrawing) {
		super(window);
		((PlayPanel) getPanel()).getCanvas().setPieces(finishedDrawing);
        slotToFill = 0;
	}

	@Override
	GameStatePanel initializePanel() {
        correctWord = GameController.game().getSession().getChosenWord();
        guess = new char[correctWord.length()];
        availableLetters = shuffleCharSpace(fillCharSpaceWithRandomLetters(correctWord));
        ActionListener giveUpListener = (event) -> GameController.game().failGuessing();
        ActionListener closeListener = (event) -> GameController.game().disconnect();
        GuessPanel panel = new GuessPanel(GameController.game().getWindow().getContentSize(), availableLetters, this);
        panel.setActionListeners(giveUpListener, closeListener);
        turnTimer.schedule();
        turnTimer.addListener(panel);
		return panel;
	}

    public static char[] fillCharSpaceWithRandomLetters(String word) {
        char[] chars = new char[MAX_LENGTH];
        final String alphabet = "ABCDEFGHIJKLMNOPRSTUVWYZX";
        final int N = alphabet.length();
        Random r = new Random();

        for(int i=0;i<word.length(); i++) {
            chars[i] = word.charAt(i);
        }

        for (int i = 0; i < MAX_LENGTH - word.length(); i++) {
            chars[word.length() + i] = alphabet.charAt(r.nextInt(N));
        }
        return chars;
    }

    public static char[] shuffleCharSpace(char arr[]) {
        char[] shuffled = Arrays.copyOf(arr, arr.length);
        Random rgen = new Random();

        for (int i=0; i<arr.length; i++) {
            int pos = rgen.nextInt(arr.length);
            char temp = shuffled[i];
            shuffled[i] = shuffled[pos];
            shuffled[pos] = temp;
        }
        return shuffled;
    }

    @Override
    public void onLetterButtonClick(char letter, int index) {
        guess[slotToFill] = letter;
        ((GuessPanel) getPanel()).disableLetterButton(index);
        ((GuessPanel) getPanel()).setLetterSlot(slotToFill, letter);
        slotToFill++;
        if(isGuessComplete()) {
            if(isGuessCorrect()) {
                ((GuessPanel)getPanel()).setGuessBoxBackgroundColorPositive();
                getTurnTimer().cancel();
                GameController.game().accomplishGuessing();
            }
            else {
                ((GuessPanel)getPanel()).setGuessBoxBackgroundColorNegative();
            }
        }
        else {
            ((GuessPanel)getPanel()).setGuessBoxBackgroundColorNeutral();
        }
    }

    @Override
    public void onClear() {
        ((GuessPanel)getPanel()).setGuessBoxBackgroundColorNeutral();
        slotToFill = 0;
        for(int i=0;i<guess.length;i++) {
            ((GuessPanel) getPanel()).clearLetterSlot(i);
        }
        ((GuessPanel) getPanel()).enableAllLetterButtons();
    }

    private boolean isGuessCorrect() {
        if(!isGuessComplete()) {
            return false;
        }
        for(int i=0;i<guess.length;i++) {
            if(guess[i] != correctWord.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean isGuessComplete() {
        return slotToFill == guess.length;
    }
}
