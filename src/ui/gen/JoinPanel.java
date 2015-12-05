
package ui.gen;

/**
 *
 * @author Görkem Çamlı
 */
public class JoinPanel extends GameStatePanel {

    
    // Variables declaration 
    private javax.swing.JButton connectButton;
    private javax.swing.JLabel enterNameLabel;
    private javax.swing.JTextField enterNameText;
    private javax.swing.JLabel joinLabel;
 

    /**
     * Creates new form GuessBoxPanel
     */
    public JoinPanel() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    private void initComponents() {

        joinLabel = new javax.swing.JLabel();
        enterNameLabel = new javax.swing.JLabel();
        enterNameText = new javax.swing.JTextField();
        connectButton = new javax.swing.JButton();

        joinLabel.setFont(new java.awt.Font("Tahoma", 0, 36)); 
        joinLabel.setText("Join Game");

        enterNameLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        enterNameLabel.setText("Enter your buddy's username:");

        enterNameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterNameTextActionPerformed(evt);
            }
        });

        connectButton.setText("Connect");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(146, 146, 146)
                            .addComponent(connectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(99, 99, 99)
                            .addComponent(enterNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(enterNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(joinLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(107, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(joinLabel)
                .addGap(27, 27, 27)
                .addComponent(enterNameLabel)
                .addGap(50, 50, 50)
                .addComponent(enterNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(connectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(176, Short.MAX_VALUE))
        );
    }
    private void enterNameTextActionPerformed(java.awt.event.ActionEvent evt) {/
    }/

}
