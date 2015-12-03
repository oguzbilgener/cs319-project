
package ui;

/**
 *
 * @author Görkem Çamlı
 */
public class HostPanel extends javax.swing.JPanel {

    
    // Variables declaration 
    private javax.swing.JLabel conLabel;
    private javax.swing.JLabel hostLabel;
    private javax.swing.JTextField userText;
    private javax.swing.JLabel usernameLabel;

    /**
     * Creates new form HostPanel
     */
    public HostPanel() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    private void initComponents() {

        hostLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        userText = new javax.swing.JTextField();
        conLabel = new javax.swing.JLabel();

        hostLabel.setFont(new java.awt.Font("Tahoma", 0, 36)); 
        hostLabel.setText("Host Game");

        usernameLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        usernameLabel.setText("Your username is:");

        userText.setEditable(false);
        userText.setText("            XXXX");
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
                .addGap(176, 176, 176)
                .addComponent(hostLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                .addGap(99, 99, 99))
            .addGroup(layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(userText, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(usernameLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(conLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(hostLabel)
                .addGap(47, 47, 47)
                .addComponent(usernameLabel)
                .addGap(27, 27, 27)
                .addComponent(userText, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(conLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(128, Short.MAX_VALUE))
        );
    }

    private void userTextActionPerformed(java.awt.event.ActionEvent evt) {
       
    }


}
