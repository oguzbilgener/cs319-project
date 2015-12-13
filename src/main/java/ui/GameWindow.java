
package ui;

import ui.event.MenuEvent;
import ui.gen.*;

import java.awt.*;
import javax.swing.*;

/**
 * @author Görkem Çamlı
 */
public class GameWindow extends JFrame {

	final int WIDTH = 480;
	final int HEIGHT = 576;

	/**
	 * Creates new form GameWindow
	 */
	public GameWindow() {
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(WIDTH, HEIGHT));
		Dimension size = new Dimension(WIDTH, HEIGHT);
		setSize(size);
		setMinimumSize(size);
		setMaximumSize(size);

		setVisible(true);
	}

	public void showMainMenu(MenuEvent.Listener listener) {
		MainMenuPanel menuPanel = new MainMenuPanel();
		replacePanel(menuPanel);
		menuPanel.setMenuEventListeners(listener);
	}

	public void showHostPanel() {
		replacePanel(new HostPanel(getContentSize()));
	}

	public void showJoinPanel() {
		replacePanel(new JoinPanel(getContentSize()));
	}

	public void showCreditsPanel() {
		replacePanel(new CreditsPanel(getContentSize()));
	}

	public void showLoginPanel() {
		replacePanel(new SignInPanel(getContentSize()));
	}

    public void showSignupPanel() {
        replacePanel(new SignUpPanel(getContentSize()));
    }

	public void replacePanel(Component component) {
		getContentPane().removeAll();
		getContentPane().add(component);
		revalidate();
	}

	public Dimension getContentSize() {
		return new Dimension(WIDTH, HEIGHT);
	}

}
