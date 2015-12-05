

package ui;

import controller.ChooseWordController;
import controller.GameController;
import model.GameSession;
import ui.GameStatePanel;

import java.awt.*;


/*
 *
 * @author Görkem Çamlı
 */


public class ChooseWordPanel extends GameStatePanel {

    // Variables declaration
    private javax.swing.JLabel chooseWordLabel;
    public javax.swing.JButton word1Button;
    public javax.swing.JButton word2Button;
    public javax.swing.JButton word3Button;



/*
     * Creates new form ChooseWordPanel
 */

    public ChooseWordPanel(Dimension size) {
        super(size);
        initComponents();
    }


    @SuppressWarnings("unchecked")
    private void initComponents() {

        chooseWordLabel = new javax.swing.JLabel();
        word1Button = new javax.swing.JButton();
        word2Button = new javax.swing.JButton();
        word3Button = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(480, 576));

        chooseWordLabel.setFont(new java.awt.Font("Tahoma", 0, 24));
        chooseWordLabel.setText("Choose a word to draw:");


        word1Button.setText(GameController.game().getSession().getWordList()[0]);

        word2Button.setText(GameController.game().getSession().getWordList()[1]);

        word3Button.setText(GameController.game().getSession().getWordList()[2]);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(110, 110, 110)
                                                .addComponent(chooseWordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(172, 172, 172)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(word2Button, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(word1Button, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(word3Button, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(chooseWordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(word1Button, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(word2Button, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(word3Button, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(218, Short.MAX_VALUE))
        );
    }

}

