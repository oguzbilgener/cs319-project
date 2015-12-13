
package ui.gen;

import controller.GameController;
import ui.GameStatePanel;

import java.awt.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author Görkem Çamlı
 */
public class HostPanel extends GameStatePanel {

    // Variables declaration 
    private javax.swing.JLabel conLabel;
    private javax.swing.JLabel hostLabel;
    private javax.swing.JTextField userText;
    private javax.swing.JLabel usernameLabel;


    /**
     * Creates new form DrawingScreenPanel
     */
    public HostPanel(Dimension size) {
        super(size);
        initComponents();
    }


    @SuppressWarnings("unchecked")
    private void initComponents() {

        hostLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        userText = new javax.swing.JTextField();
        conLabel = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(480, 576));

        hostLabel.setFont(new java.awt.Font("Tahoma", 0, 36));
        hostLabel.setText("Host Game");

        usernameLabel.setFont(new java.awt.Font("Tahoma", 0, 18));
        usernameLabel.setText("Your username is:");

        userText.setEditable(false);
        userText.setText(GameController.game().getP2pManager().getOwnPlayer().getUsername());
        userText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userTextActionPerformed(evt);
            }
        });

        conLabel.setFont(new java.awt.Font("Tahoma", 0, 18));
        conLabel.setText("Waiting for a connection...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(143, 143, 143)
                                .addComponent(hostLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                                .addGap(132, 132, 132))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(159, 159, 159)
                                .addComponent(usernameLabel)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(userText, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(16, 16, 16)
                                                .addComponent(conLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(121, 121, 121))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(hostLabel)
                                .addGap(47, 47, 47)
                                .addComponent(usernameLabel)
                                .addGap(65, 65, 65)
                                .addComponent(userText, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(81, 81, 81)
                                .addComponent(conLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(151, Short.MAX_VALUE))
        );
    }

    private void userTextActionPerformed(java.awt.event.ActionEvent evt) {
    }

}


