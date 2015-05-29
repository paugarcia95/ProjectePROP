/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interficie;


import static Interficie.InterficiaProva1.capsalera;
import static Interficie.InterficiaProva1.guardada;
import static Interficie.InterficiaProva1.macro;
import static Interficie.InterficiaProva1.vista;
import static Interficie.InterficiaProva1.comunaEliminar;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;
import static javax.swing.JOptionPane.YES_NO_CANCEL_OPTION;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
/**
 *
 * @author Cristina
 */
public class VeureCercaAntiga extends javax.swing.JPanel {

    private InterficiaProva1 pare;
    private Integer numcerca;
    
    /**
     * Creates new form VeureCercaAntiga
     */
    public VeureCercaAntiga(JFrame par, Integer num) {
        initComponents();
        pare = (InterficiaProva1)par;
        numcerca = num;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        modelos1 = new DefaultListModel();
        Penjades1 = new javax.swing.JList();
        jButton21 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jScrollPane13 = new javax.swing.JScrollPane();
        CriterisNovaCerca1 = new javax.swing.JTextArea();
        jButton15 = new javax.swing.JButton();
        ModificaCriterisB = new javax.swing.JButton();
        jScrollPane14 = new javax.swing.JScrollPane();
        Resultat1 = new javax.swing.JTree();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton3.setText("Modificar Comentari");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        Penjades1.setModel(modelos1);
        Penjades1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        Penjades1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Penjades1.setDragEnabled(true);
        Penjades1.setDropMode(javax.swing.DropMode.INSERT);
        Penjades1.setFocusable(false);
        Penjades1.setValueIsAdjusting(true);

        jButton21.setText("Afegir Comunitat");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jButton23.setText(">>>>");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        jButton22.setText("<<<<");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        CriterisNovaCerca1.setBackground(new java.awt.Color(240, 240, 240));
        CriterisNovaCerca1.setColumns(20);
        CriterisNovaCerca1.setRows(5);
        jScrollPane13.setViewportView(CriterisNovaCerca1);

        jButton15.setText("Modificar Nom");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        ModificaCriterisB.setText("Modificar Criteris");
        ModificaCriterisB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificaCriterisBActionPerformed(evt);
            }
        });

        Resultat1.setAutoscrolls(true);
        Resultat1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Resultat1.setLargeModel(true);
        jScrollPane14.setViewportView(Resultat1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ModificaCriterisB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton22)
                            .addComponent(jButton23)
                            .addComponent(jButton21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Penjades1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ModificaCriterisB)
                            .addComponent(jButton15)
                            .addComponent(jButton3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane13)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(87, 87, 87)
                                        .addComponent(jButton22)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton23)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton21))
                                    .addComponent(Penjades1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String nouComen =JOptionPane.showInputDialog(this,"Escriu el nou nom",QUESTION_MESSAGE);
        macro.getContUser().addComentariCerca(macro.getUserActual(), numcerca, nouComen);
        vista.visualitzaCerca(true,Resultat1,CriterisNovaCerca1, numcerca);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        Integer quina = macro.getContUser().addComunitatCerca(macro.getUserActual(), numcerca)+1;
        System.out.println("Afegeico la comunitat: "+quina);
        DefaultTreeModel arb = (DefaultTreeModel)Resultat1.getModel();

        DefaultMutableTreeNode act = (DefaultMutableTreeNode)arb.getRoot();

        arb.insertNodeInto(new DefaultMutableTreeNode("Comunitat "+quina), act, act.getChildCount());
        comunaEliminar.add(quina-1);
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        vista.treuCatComun(Resultat1,modelos1, numcerca);
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        vista.afegeixCatComun(Resultat1,modelos1, Penjades1, numcerca);
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        String nouNom =JOptionPane.showInputDialog(this,"Escriu el nou nom",QUESTION_MESSAGE);
        macro.getContUser().addNomCerca(macro.getUserActual(), numcerca, nouNom);
        vista.visualitzaCerca(true,Resultat1,CriterisNovaCerca1, numcerca);
    }//GEN-LAST:event_jButton15ActionPerformed

    private void ModificaCriterisBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificaCriterisBActionPerformed
        int resposta = JOptionPane.showOptionDialog(this,"Vols crear una nova cerca o sobreescriure aquesta?", capsalera,YES_NO_CANCEL_OPTION,QUESTION_MESSAGE,null,new Object[]{"Conserva aquesta","Modifica aquesta","Cancelar"},"i tu?");
        if(resposta==0) {
            guardada=0;
           // vista.preaparaCreacioNovaCerca(true, LCTotes, LPTotes, Algorismes, Lsub, Lsub2, Lsub1, Cbusca1, Cpc, CpcImp, Csembla, Crelacio, Cdada);
            /*A_VisualitzacioCercaAntiga.setVisible(false);
            A_CreaComunitat.setVisible(true);*/
        }
        else if (resposta==1){
            System.out.println("Es marca la 2");
            guardada=3;
          //  vista.preaparaCreacioNovaCerca(true, LCTotes, LPTotes, Algorismes, Lsub, Lsub2, Lsub1, Cbusca1, Cpc, CpcImp, Csembla, Crelacio, Cdada);
           /* A_VisualitzacioCercaAntiga.setVisible(false);
            A_CreaComunitat.setVisible(true);*/
        }
    }//GEN-LAST:event_ModificaCriterisBActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
       vista.visualitzaCerca(true, Resultat1, CriterisNovaCerca1, numcerca);
    }//GEN-LAST:event_formComponentShown


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea CriterisNovaCerca1;
    private javax.swing.JButton ModificaCriterisB;
    private javax.swing.JList Penjades1;
    private DefaultListModel modelos1;
    private javax.swing.JTree Resultat1;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    // End of variables declaration//GEN-END:variables
}
