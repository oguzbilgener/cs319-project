
package ui;

import controller.GameController;
import ui.event.MenuEvent;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Görkem Çamlı
 */
public class MainMenuPanel extends JPanel {

    private JButton hostGameButton;
    private JButton joinGameButton;
    private JButton logoutButton;
    private JButton loginButton;
    private JButton signupButton;
    private JButton creditsButton;

    /**
     * Creates new form MainMenuPanel
     */
    public MainMenuPanel() {
        initComponents();
    }
   
    @SuppressWarnings("unchecked")
    private void initComponents() {
        setLayout(new BorderLayout());
        addMenu();
        addBottomPanel();
    }

    private void addMenu() {
        JPanel menuWrapper = new JPanel();
        menuWrapper.setLayout(new BoxLayout(menuWrapper, BoxLayout.Y_AXIS));
        hostGameButton = new JButton();
        creditsButton = new JButton();
        joinGameButton = new JButton();

        hostGameButton.setText("HOST GAME");
        hostGameButton.setBackground(Color.white);
        hostGameButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        joinGameButton.setText("JOIN GAME");
        joinGameButton.setBackground(Color.white);
        joinGameButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        creditsButton.setText("CREDITS");
        creditsButton.setBackground(Color.white);
        creditsButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        menuWrapper.add(hostGameButton);
        menuWrapper.add(joinGameButton);
        menuWrapper.add(creditsButton);


        if(!GameController.game().isLoggedIn()) {
            hostGameButton.setEnabled(false);
            joinGameButton.setEnabled(false);
        }
        add(menuWrapper, BorderLayout.CENTER);
    }

    private void addBottomPanel() {
        JPanel bottomWrapper = new JPanel();
        JLabel accountStatusLabel = new JLabel();

        String accountStatusText = "Sign in to start playing.";
        if(GameController.game().isLoggedIn()) {
            accountStatusText = "Signed in as "+GameController.game().getLoggedInPlayer().getUsername();

            logoutButton = new JButton();
            logoutButton.setText("Sign out");
            logoutButton.setBackground(Color.white);
            bottomWrapper.add(logoutButton);
        }
        else {
            loginButton = new JButton();
            loginButton.setText("Sign in");
            bottomWrapper.add(loginButton);

            signupButton = new JButton();
            signupButton.setText("Sign up");
            bottomWrapper.add(signupButton);
        }

        accountStatusLabel.setFont(new java.awt.Font("Tahoma", 0, 14));
        accountStatusLabel.setText(accountStatusText);

        bottomWrapper.add(accountStatusLabel);
        add(bottomWrapper, BorderLayout.SOUTH);
    }

    public void setMenuEventListeners(MenuEvent.Listener listener) {
        hostGameButton.addActionListener(event -> listener.onMenuEvent(MenuEvent.ItemType.host));

        joinGameButton.addActionListener(event -> listener.onMenuEvent(MenuEvent.ItemType.join));

        creditsButton.addActionListener(event -> listener.onMenuEvent(MenuEvent.ItemType.credits));

        if(loginButton != null) {
            loginButton.addActionListener(event -> listener.onMenuEvent(MenuEvent.ItemType.login));
        }

        if(signupButton != null) {
            signupButton.addActionListener(event -> listener.onMenuEvent(MenuEvent.ItemType.signup));
        }

        if(logoutButton != null) {
            logoutButton.addActionListener(event -> listener.onMenuEvent(MenuEvent.ItemType.logout));
        }

    }

 

}
