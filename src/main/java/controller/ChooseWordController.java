package controller;

import model.Player;
import network.GameClient;
import ui.ChooseWordPanel;
import ui.GameStatePanel;
import ui.GameWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author oguzb
 */
public class ChooseWordController extends GameStateController implements GameClient.GameClientListener {

    private boolean wordsLoaded = false;

	public ChooseWordController(GameWindow window) {
		super(window);
        GameController.game().getGameClient().addListener(this);
	}

	@Override
	GameStatePanel initializePanel() {
        ChooseWordPanel panel = new ChooseWordPanel(GameController.game().getWindow().getContentSize());
        if(wordsLoaded) {
            ActionListener listener = e -> {
                JButton source = (JButton) e.getSource();
                GameController.game().getSession().setChosenWord(source.getText());
            };
            panel.word1Button.addActionListener(listener);
            panel.word2Button.addActionListener(listener);
            panel.word3Button.addActionListener(listener);
        }
        else {
            JLabel loadingText = new JLabel("Loading words...", SwingConstants.CENTER);
            loadingText.setFont(new Font("Tahoma", 0, 18));
            panel.setLayout(null);
            panel.removeAll();
            panel.revalidate();
            panel.repaint();
            panel.add(loadingText);
            loadingText.setBounds(0, 100, panel.getSize().width, 40);
            GameController.game().getGameClient().loadWords();
        }
        return panel;
	}

    @Override
    public void onLoginFailure(GameClient.ErrorType type) {

    }

    @Override
    public void onSignupFailure(GameClient.ErrorType type) {

    }

    @Override
    public void onLookupFailure(GameClient.ErrorType type) {

    }

    @Override
    public void onLoadWordsFailure(GameClient.ErrorType type) {

    }

    @Override
    public void onLoginSuccess(Player player) {

    }

    @Override
    public void onSignupSuccess(Player player) {

    }

    @Override
    public void onLookupSuccess(Player player) {

    }

    @Override
    public void onLoadWordsSuccess(String[] words) {
        wordsLoaded = true;
        System.out.println("CWC WL");
        recreatePanel();
    }
}
