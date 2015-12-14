package ui.play;

import controller.GuessWordController;

import javax.swing.*;
import java.awt.*;

/**
 * Created by asusss on 12.12.2015.
 */
public class GuessBoxPanel extends WordPanel {

    private LetterButton[] buttons;
    private LetterSlot[] slots;
    private String correctWord;
    private LetterButton.LetterButtonClickListener listener;

    public GuessBoxPanel(Dimension size, String word) {
        setSize(size);
        setBackground(Color.WHITE);
        setLayout(null);

        correctWord = word;

        placeLetterSlots();
        placeDeleteButton();
    }

    public void placeLetterButtons(char[] availableLetters, LetterButton.LetterButtonClickListener listener) {
        this.listener = listener;
        buttons = new LetterButton[GuessWordController.MAX_LENGTH];
        int leftX = 10;
        for(int i=0; i<GuessWordController.MAX_LENGTH;i++) {
            LetterButton button = new LetterButton(new Dimension(29, 30), availableLetters[i], i);
            button.setListener(listener);
            add(button);
            button.setBounds(leftX + i*34, 60, button.getSize().width, button.getSize().height);
            buttons[i] = button;
        }
    }

    private void placeLetterSlots() {
        slots = new LetterSlot[correctWord.length()];
        int x = (getSize().width - (34 * correctWord.length() - 5)) / 2;
        for(int i=0; i<correctWord.length();i++) {
            LetterSlot slot = new LetterSlot(new Dimension(29, 30));
            add(slot);
            slot.setBounds(x, 5, slot.getSize().width, slot.getSize().height);
            slots[i] = slot;

            x += 34;
        }
    }

    private void placeDeleteButton() {
        JButton delete = new JButton();
        delete.setText("\u2612");
        add(delete);
        delete.setBounds(330,10,20,20);
        delete.addActionListener(e -> {
            if(listener != null) {
                listener.onClear();
            }
        });
    }

    public void setLetterSlot(int index, char letter) {
        System.out.println("set "+index+" "+letter);
        slots[index].setLetter(letter);
    }

    public void clearLetterSlot(int index) {
        slots[index].clear();
    }

    public void disableLetterButton(int index) {
        buttons[index].disableButton();
    }

    public void enableAllLetterButtons() {
        for(int i=0;i<GuessWordController.MAX_LENGTH;i++) {
            buttons[i].enableButton();
        }
    }
}
