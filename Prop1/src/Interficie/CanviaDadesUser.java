/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interficie;

/**
 *
 * @author Cristina
 */
public class CanviaDadesUser extends javax.swing.JPanel {

    /**
     * Creates new form CanviaDadesUser
     */
    public CanviaDadesUser() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel29 = new javax.swing.JLabel();
        NovaPassword1 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        Enrere13 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        NouUsername1 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();

        jLabel29.setText("Username");

        jLabel28.setText("Password");

        jButton7.setText("Comproba Disponibilitat");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        Enrere13.setText("Enrere");
        Enrere13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Enrere13ActionPerformed(evt);
            }
        });

        jButton6.setText("Canvia");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel27.setText("Si us plau, introdueixi les noves dades d'usuari desitjades:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel27))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(116, 116, 116)
                                .addComponent(jButton6))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addGap(38, 38, 38)
                                .addComponent(NouUsername1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(31, 31, 31)
                        .addComponent(jButton7))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addGap(40, 40, 40)
                        .addComponent(NovaPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(133, 133, 133)
                        .addComponent(Enrere13)))
                .addGap(0, 20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NouUsername1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29)
                    .addComponent(jButton7))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(NovaPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Enrere13)
                            .addComponent(jLabel28))
                        .addGap(26, 26, 26)))
                .addComponent(jButton6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        vista.comprovaUsername(NouUsername1);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void Enrere13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Enrere13ActionPerformed
        A_CanviaDadesUser.setVisible(false);
        if(macro.getContUser().isAdmin(macro.getUserActual())) A_OpcionsAdmin.setVisible(true);
        else A_OpcionsClient.setVisible(true);
    }//GEN-LAST:event_Enrere13ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        vista.canviaDadesUser(NouUsername1, NovaPassword1);
    }//GEN-LAST:event_jButton6ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Enrere13;
    private javax.swing.JTextField NouUsername1;
    private javax.swing.JTextField NovaPassword1;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    // End of variables declaration//GEN-END:variables
}