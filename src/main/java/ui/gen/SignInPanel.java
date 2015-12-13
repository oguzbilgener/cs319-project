
package ui.gen;

import controller.GameController;
import network.GameClient;
import ui.GameStatePanel;

import java.awt.*;

/**
 *
 * @author Görkem Çamlı
 */
public class SignInPanel extends GameStatePanel {

     // Variables declaration 
    private javax.swing.JLabel SignInLabel;
    private javax.swing.JLabel passLabel;
    private javax.swing.JTextField passText;
    private javax.swing.JButton signInButton;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JTextField usernameText;
    
    /**
     * Creates new form SignInPanel
     */
    public SignInPanel(Dimension size) {
        super(size);
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    private void initComponents() {

        SignInLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        usernameText = new javax.swing.JTextField();
        passLabel = new javax.swing.JLabel();
        passText = new javax.swing.JTextField();
        signInButton = new javax.swing.JButton();

        SignInLabel.setFont(new java.awt.Font("Tahoma", 1, 36)); 
        SignInLabel.setText("Sign In");

        usernameLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        usernameLabel.setText("username:");

        usernameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameTextActionPerformed(evt);
            }
        });

        passLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        passLabel.setText("password:");

        passText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passTextActionPerformed(evt);
            }
        });

        signInButton.setText("Sign In");
        signInButton.addActionListener(this::signInButtonActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(signInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(passText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                            .addComponent(passLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usernameLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usernameText, javax.swing.GroupLayout.Alignment.LEADING))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(SignInLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(186, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(SignInLabel)
                .addGap(41, 41, 41)
                .addComponent(usernameLabel)
                .addGap(18, 18, 18)
                .addComponent(usernameText, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(passLabel)
                .addGap(28, 28, 28)
                .addComponent(passText, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(signInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(102, Short.MAX_VALUE))
        );
    }

    private void usernameTextActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void passTextActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void signInButtonActionPerformed(java.awt.event.ActionEvent evt) {
        GameController.game().getGameClient().login(usernameText.getText(), passText.getText());
    }

}
