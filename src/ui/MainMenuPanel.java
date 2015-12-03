
package ui;

import ui.event.MenuEvent;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Görkem Çamlı
 */
public class MainMenuPanel extends JPanel {

    

       // Variables declaration
    private JButton hostGameButton;
    private JButton joinGameButton;
    private JButton logoutButton;
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
        add(menuWrapper, BorderLayout.CENTER);
    }

    private void addBottomPanel() {
        JPanel bottomWrapper = new JPanel();
        JLabel accountStatusLabel = new JLabel();
        logoutButton = new JButton();

        accountStatusLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        accountStatusLabel.setText("signed in as XXX");

        logoutButton.setText("LOG OUT");
        logoutButton.setBackground(Color.white);

        bottomWrapper.add(accountStatusLabel);
        bottomWrapper.add(logoutButton);
        add(bottomWrapper, BorderLayout.SOUTH);
    }

    public void setMenuEventListeners(MenuEvent.Listener listener) {
        hostGameButton.addActionListener(event -> listener.onMenuEvent(MenuEvent.ItemType.host));

        joinGameButton.addActionListener(event -> listener.onMenuEvent(MenuEvent.ItemType.join));

        creditsButton.addActionListener(event -> listener.onMenuEvent(MenuEvent.ItemType.credits));

        logoutButton.addActionListener(event -> listener.onMenuEvent(MenuEvent.ItemType.logout));

    }

 

}
