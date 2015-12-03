
package ui;

import ui.event.MenuEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Görkem Çamlı
 */
public class MainMenuPanel extends JPanel {

    

       // Variables declaration 
    private JButton creditsBut;
    private JButton hostGameButton;
    private JLabel jLabel3;
    private JPanel jPanel3;
    private JButton joinGameBut;
    private JButton logoutBut;
 
    boolean credFlag;
 
    /**
     * Creates new form MainMenuPanel
     */
    public MainMenuPanel() {
        initComponents();
        setFlags();
    }

    private void setFlags()
    {
        credFlag=false;
    }
   
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel3 = new JPanel();
        hostGameButton = new JButton();
        creditsBut = new JButton();
        joinGameBut = new JButton();
        jLabel3 = new JLabel();
        logoutBut = new JButton();

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        hostGameButton.setText("HOST GAME");
        hostGameButton.setBackground(Color.white);

        joinGameBut.setText("JOIN GAME");
        joinGameBut.setBackground(Color.white);

        creditsBut.setText("CREDITS");
        creditsBut.setBackground(Color.white);


        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("signed in as XXX");

        logoutBut.setText("LOG OUT");
        logoutBut.setBackground(Color.white);


        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(221, 221, 221)
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(logoutBut, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(joinGameBut, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
                        .addComponent(creditsBut, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
                        .addComponent(hostGameButton, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(242, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(123, Short.MAX_VALUE)
                .addComponent(hostGameButton, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(joinGameBut, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(creditsBut, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logoutBut, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }

    public void setMenuEventListeners(MenuEvent.Listener listener) {
        hostGameButton.addActionListener(event -> listener.onMenuEvent(MenuEvent.ItemType.host));

        joinGameBut.addActionListener(event -> listener.onMenuEvent(MenuEvent.ItemType.join));

        creditsBut.addActionListener(event -> listener.onMenuEvent(MenuEvent.ItemType.credits));

        logoutBut.addActionListener(event -> listener.onMenuEvent(MenuEvent.ItemType.logout));

    }

 

}
