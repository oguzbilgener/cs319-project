
package ui.gen;

import controller.GameController;
import ui.GameStatePanel;

import java.awt.*;

/**
 *
 * @author Görkem Çamlı
 */
public class SignUpPanel extends GameStatePanel {

      // Variables declaration
    private javax.swing.JLabel createAccLabel;
    private javax.swing.JLabel passLabel;
    private javax.swing.JTextField passText;
    private javax.swing.JButton signUpButton;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JTextField usernameText;

    /**
     * Creates new form StatusPanel
     */
    public SignUpPanel(Dimension size) {
        super(size);
        initComponents();
    }

  
    @SuppressWarnings("unchecked")
    private void initComponents() {

        createAccLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        usernameText = new javax.swing.JTextField();
        passLabel = new javax.swing.JLabel();
        passText = new javax.swing.JTextField();
        signUpButton = new javax.swing.JButton();

        createAccLabel.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        createAccLabel.setText("Create Account");

        usernameLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
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

        signUpButton.setText("Sign Up");
        signUpButton.addActionListener(this::signUpButtonActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(createAccLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(112, 112, 112))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(passText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                            .addComponent(passLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usernameLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usernameText, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(179, 179, 179)
                .addComponent(signUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(createAccLabel)
                .addGap(50, 50, 50)
                .addComponent(usernameLabel)
                .addGap(18, 18, 18)
                .addComponent(usernameText, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(passLabel)
                .addGap(28, 28, 28)
                .addComponent(passText, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(signUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(102, Short.MAX_VALUE))
        );
    }

    private void usernameTextActionPerformed(java.awt.event.ActionEvent evt) {
    }
    private void passTextActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void signUpButtonActionPerformed(java.awt.event.ActionEvent evt) {
        GameController.game().getGameClient().signup(usernameText.getText().trim(), passText.getText().trim());
    }
    
}
