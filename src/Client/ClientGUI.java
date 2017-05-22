
package Client;

import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class ClientGUI extends javax.swing.JFrame {
    
    public static final int WIDTH = 300;
    private Picture_IO p;
    private Picture source, modified;
    private Sender s;
    private SettingsFrame frame;
    Map<String, String> map;
    String [] tab;

    public ClientGUI() {
        
        p = new Picture_IO();
        s = new Sender();
        frame = new SettingsFrame();
        initComponents();  
        this.Send_jButton1.setEnabled(false);
        this.Save_jButton1.setEnabled(false);  
        this.Open_jButton1.setEnabled(false);
        this.jButton1.setEnabled(false);
        this.jComboBox1.setEnabled(false);
        this.jComboBox2.setEnabled(false);
        map = new HashMap<String, String>();
        tab = new String[6];
        tab[1] = "Sepia"; 
        tab[2] = "Binaryzacja"; 
        tab[3] = "Skala szarości"; 
        tab[4] = "Lustro"; 
        tab[5] = "Negatyw";
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jFileChooser2 = new javax.swing.JFileChooser();
        jPanel3 = new javax.swing.JPanel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        Save_jButton1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        Send_jButton1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        ConnectjButton1 = new javax.swing.JButton();
        Open_jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        Open_imgjLabel1 = new javax.swing.JLabel();
        receiving_jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        jFileChooser2.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Edytor obrazów");

        jComboBox2.setMinimumSize(new java.awt.Dimension(28, 20));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jPanel2.setLayout(new java.awt.GridLayout());

        Save_jButton1.setText("Zapisz na dysku");
        Save_jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Save_jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(Save_jButton1);

        jButton1.setText("Cofnij");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        jPanel1.setLayout(new java.awt.GridLayout());

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sepia", "Binaryzacja", "Skala szarości", "Lustro", "Negatyw" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel5.add(jComboBox1);

        Send_jButton1.setText("Wyślij");
        Send_jButton1.setFocusable(false);
        Send_jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Send_jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Send_jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Send_jButton1ActionPerformed(evt);
            }
        });
        jPanel5.add(Send_jButton1);

        jPanel6.setLayout(new java.awt.GridLayout());

        ConnectjButton1.setText("Połącz");
        ConnectjButton1.setFocusable(false);
        ConnectjButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ConnectjButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ConnectjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConnectjButton1ActionPerformed(evt);
            }
        });
        jPanel6.add(ConnectjButton1);

        Open_jButton1.setText("Otwórz obrazek");
        Open_jButton1.setFocusable(false);
        Open_jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Open_jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Open_jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Open_jButton1ActionPerformed(evt);
            }
        });
        jPanel6.add(Open_jButton1);

        Open_imgjLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 120, 120)));

        receiving_jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 120, 120)));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Open_imgjLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                .addComponent(receiving_jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(receiving_jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Open_imgjLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jMenu1.setText("Menu");

        jMenuItem1.setText("Ustawienia");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(280, 280, 280))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ConnectjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConnectjButton1ActionPerformed
        // TODO add your handling code here:       
        if(s.connectToServer(this.frame.getIP(), Integer.parseInt(this.frame.getPort()))){           
            this.ConnectjButton1.setEnabled(false);
            this.Open_jButton1.setEnabled(true);
        }           
    }//GEN-LAST:event_ConnectjButton1ActionPerformed
    
    private void Save_jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Save_jButton1ActionPerformed
        // TODO add your handling code here:
        p.savePicture(modified);
    }//GEN-LAST:event_Save_jButton1ActionPerformed

    private void Open_jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Open_jButton1ActionPerformed
        // TODO add your handling code here: 
        source = p.openPicture();
        if(source != null){
            Open_imgjLabel1.setIcon(new ImageIcon(source.getImage().getScaledInstance(WIDTH, WIDTH, WIDTH)));  
            source.mod_type = this.jComboBox1.getSelectedIndex() + 1;
            this.Send_jButton1.setEnabled(true);
            //this.jButton1.setEnabled(true);
            this.jComboBox1.setEnabled(true);
            //this.jComboBox2.setEnabled(true);
        }
        else{
            this.Send_jButton1.setEnabled(false);
            this.receiving_jLabel1.setIcon(null);
            this.Open_imgjLabel1.setIcon(null);
            this.Save_jButton1.setEnabled(false);
            this.jButton1.setEnabled(false);
            this.jComboBox1.setEnabled(false);
            this.jComboBox2.setEnabled(false);
        }
        map.clear();
        this.jComboBox2.removeAllItems();
    }//GEN-LAST:event_Open_jButton1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        frame.setVisible(true);
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String t = (String) this.jComboBox2.getSelectedItem();
        for(int i =1; i<6; i++){
            if(t.contains(tab[i])){
                source.mod_type = i;
                break;
            }
        }
        this.Send_jButton1ActionPerformed(evt);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void Send_jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Send_jButton1ActionPerformed
        // TODO add your handling code here:
        modified = s.sendPicture(source);
        receiving_jLabel1.setIcon(new ImageIcon(modified.getImage().getScaledInstance(WIDTH, WIDTH, WIDTH)));
        this.Save_jButton1.setEnabled(true);
        this.jButton1.setEnabled(true);
        this.jComboBox2.setEnabled(true);
        source.id = modified.id;
        //JOptionPane.showMessageDialog(null, modified.date, "data", JOptionPane.INFORMATION_MESSAGE);
        if(!map.containsKey(tab[modified.mod_type])){
            map.put(tab[modified.mod_type], modified.date);
            this.jComboBox2.addItem(tab[modified.mod_type] + "  " + modified.date);
        }

    }//GEN-LAST:event_Send_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        if(source != null) source.mod_type = this.jComboBox1.getSelectedIndex() + 1;
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                 new ClientGUI().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ConnectjButton1;
    private javax.swing.JLabel Open_imgjLabel1;
    private javax.swing.JButton Open_jButton1;
    private javax.swing.JButton Save_jButton1;
    private javax.swing.JButton Send_jButton1;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JFileChooser jFileChooser2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel receiving_jLabel1;
    // End of variables declaration//GEN-END:variables
}
