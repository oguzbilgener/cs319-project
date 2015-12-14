package ui.play;

import controller.GameController;

import java.awt.*;

/**
 * Created by asusss on 12.12.2015.
 */
public class GuessPanel extends PlayPanel {

    public GuessPanel(Dimension size, char[] availableLetters, LetterButton.LetterButtonClickListener letterClickListener) {
        super(size);
        ((GuessBoxPanel) wordBox).placeLetterButtons(availableLetters, letterClickListener);
    }

    protected Canvas initializeCanvas() {
        return new ViewingCanvas();
    }

    protected ColorPanel initializeColorPanel(Dimension size) {
        return new DisabledColorPanel(size);
    }

    protected BrushPanel initializeBrushPanel(Dimension size) {
        return new BrushPanel(size);
    }

    protected WordPanel initializeWordPanel(Dimension size) {
        return new GuessBoxPanel(size, GameController.game().getSession().getChosenWord());
    }

    protected ActionToolbar initializeActionToolbar(Dimension size) {
        ActionButton button1 = ActionButton.createCheckButton(new Dimension(size.width/2, size.height));
        ActionButton button2 = ActionButton.createCloseButton(new Dimension(size.width/2, size.height));
        ActionToolbar guessBar = new ActionToolbar(size, button1, button2);
        return guessBar;
    }

    public void setLetterSlot(int index, char letter) {
        ((GuessBoxPanel) wordBox).setLetterSlot(index, letter);
    }

    public void clearLetterSlot(int index) {
        ((GuessBoxPanel) wordBox).clearLetterSlot(index);
    }

    public void disableLetterButton(int index) {
        ((GuessBoxPanel) wordBox).disableLetterButton(index);
    }

    public void enableAllLetterButtons() {
        ((GuessBoxPanel) wordBox).enableAllLetterButtons();
    }

    public void setGuessBoxBackgroundColorPositive() {
        wordBox.setBackground(Color.decode("#C3FA00"));
    }

    public void setGuessBoxBackgroundColorNegative() {
        wordBox.setBackground(Color.decode("#FFC0CC"));
    }

    public void setGuessBoxBackgroundColorNeutral() {
        wordBox.setBackground(Color.white);
    }
}
