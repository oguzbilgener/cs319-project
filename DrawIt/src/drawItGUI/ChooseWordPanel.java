
package drawItGUI;

/**
 *
 * @author Görkem Çamlı
 */
public class ChooseWordPanel extends javax.swing.JPanel {

        // Variables declaration 
    private javax.swing.JLabel chooseWordLabel;
    private javax.swing.JButton word1Button;
    private javax.swing.JButton word2Button;
    private javax.swing.JButton word3Button;

    /**
     * Creates new form ChooseWordPanel
     */
    public ChooseWordPanel() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    private void initComponents() {

        chooseWordLabel = new javax.swing.JLabel();
        word1Button = new javax.swing.JButton();
        word2Button = new javax.swing.JButton();
        word3Button = new javax.swing.JButton();

        chooseWordLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); 
        chooseWordLabel.setText("Choose a word to draw:");

        word1Button.setText("WORD 1");

        word2Button.setText("WORD 2");

        word3Button.setText("WORD 3");

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
                .addContainerGap(148, Short.MAX_VALUE))
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
                .addContainerGap(101, Short.MAX_VALUE))
        );
    }


}
