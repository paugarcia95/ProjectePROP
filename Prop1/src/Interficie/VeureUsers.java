/*
 * Panell que mostra els noms dels usuaris existents, si son administradors o no. S'hi poden crear nous administradors
 */
package Interficie;

import static Interficie.InterficieWiki.vista;
import static Interficie.InterficieWiki.macro;
import static Interficie.InterficieWiki.capsalera;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
/**
 *
 * @author cristina.fontanet
 */
public class VeureUsers extends javax.swing.JPanel {

    private InterficieWiki pare;
    
    /**
     * Creates new form VeureUsers
     */
    public VeureUsers(JFrame par) {
        initComponents();
        pare = (InterficieWiki)par;
    }

    /**
     * By Netbeans
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ferAdmin = new javax.swing.JButton();
        modusers = new DefaultListModel();
        UsersAct = new javax.swing.JList();
        Elimina = new javax.swing.JButton();
        creaNou = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();

        addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                formComponentAdded(evt);
            }
        });

        ferAdmin.setText("Fer Admin");
        ferAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ferAdminActionPerformed(evt);
            }
        });

        UsersAct.setModel(modusers);
        UsersAct.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        UsersAct.setDragEnabled(true);
        UsersAct.setDropMode(javax.swing.DropMode.INSERT);
        UsersAct.setFocusable(false);
        UsersAct.setValueIsAdjusting(true);

        Elimina.setText("Elimina");
        Elimina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminaActionPerformed(evt);
            }
        });

        creaNou.setText("Crea un nou usuari Administrador");
        creaNou.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creaNouActionPerformed(evt);
            }
        });

        jLabel17.setText("Aquests són els usuaris actuals:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(UsersAct, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(creaNou)
                            .addComponent(ferAdmin)
                            .addComponent(Elimina))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UsersAct, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Elimina)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ferAdmin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(creaNou)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    /*
    * En clicar el boto Fer Admin, es fa administrador al usuari seleccionat
    */
    private void ferAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ferAdminActionPerformed
        if(UsersAct.getSelectedIndices().length>0) {
            macro.getContUser().addAdmin(UsersAct.getSelectedValue().toString());
            vista.carregaUsers(modusers);
        }
        else JOptionPane.showMessageDialog(this, "Has de seleccionar quin usuari vols fer admninistrador!", capsalera, WARNING_MESSAGE);
    }//GEN-LAST:event_ferAdminActionPerformed
    /*
    * En clicar el boto Elimina, s'elimina si es pot, a l'usuari seleccionat
    */
    private void EliminaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminaActionPerformed
        if(UsersAct.getSelectedIndices().length>0) {
            if(UsersAct.getSelectedValue().toString().equals(macro.getUserActual())||(UsersAct.getSelectedValue().toString().contains("[ad]")&&(UsersAct.getSelectedValue().toString().substring(0, UsersAct.getSelectedValue().toString().length()-5)).equals(macro.getUserActual()))) {
                    int resposta = JOptionPane.showConfirmDialog(this, "Segur que vols eliminar-te a tu mateix?", capsalera, YES_NO_OPTION);
                    if(resposta==YES_OPTION) {
                        macro.getContUser().removeUser(macro.getUserActual());
                        pare.logout();
                    }
            }
            else {
                if(vista.espoteliminar(UsersAct.getSelectedValue().toString())) {
                    macro.getContUser().removeUser(UsersAct.getSelectedValue().toString());
                    modusers.removeElement(UsersAct.getSelectedValue().toString());
                    vista.carregaUsers(modusers);
                }
                else JOptionPane.showMessageDialog(this, "No pots eliminar a altres administradors", capsalera, ERROR_MESSAGE);
            }
        }
        else JOptionPane.showMessageDialog(this, "Has de seleccionar quin usuari vols eliminar!", capsalera, WARNING_MESSAGE);
    }//GEN-LAST:event_EliminaActionPerformed
    /*
    * En clicar Crea un nou usuari Administrador, es crea un nou usuari amb poders d'administrador
    */
    private void creaNouActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creaNouActionPerformed
       pare.creaAdminNou();
        vista.carregaUsers(modusers);
    }//GEN-LAST:event_creaNouActionPerformed
     /*
    * En iniciar sessio, es carreguen els usuaris existents
    */
    private void formComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_formComponentAdded
        vista.carregaUsers(modusers);
    }//GEN-LAST:event_formComponentAdded


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Elimina;
    private javax.swing.JList UsersAct;
    private DefaultListModel modusers;
    private javax.swing.JButton creaNou;
    private javax.swing.JButton ferAdmin;
    private javax.swing.JLabel jLabel17;
    // End of variables declaration//GEN-END:variables
}
