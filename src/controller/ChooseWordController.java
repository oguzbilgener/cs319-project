package controller;

import ui.ChooseWordPanel;
import ui.GameStatePanel;
import ui.GameWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author oguzb
 */
public class ChooseWordController extends GameStateController {

	public ChooseWordController(GameWindow window) {
		super(window);
	}

	@Override
	GameStatePanel initializePanel() {
		ChooseWordPanel panel = new ChooseWordPanel(GameController.game().getWindow().getContentSize());
        ActionListener listener = e -> {
            JButton source = (JButton) e.getSource();
            GameController.game().getSession().setChosenWord(source.getText());
        };
		panel.word1Button.addActionListener(listener);
		panel.word2Button.addActionListener(listener);
		panel.word3Button.addActionListener(listener);
		return panel;
	}
}
