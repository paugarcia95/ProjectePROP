/*
 * Panell que mostra el resultat d'una cerca de comunitats ja guardada
 */
package Interficie;

import static Interficie.InterficiaProva1.auxguard;
import static Interficie.InterficiaProva1.capsalera;
import static Interficie.InterficiaProva1.cercaactual;
import static Interficie.InterficiaProva1.macro;
import static Interficie.InterficiaProva1.vista;
import static Interficie.InterficiaProva1.comunaEliminar;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;
import static javax.swing.JOptionPane.YES_NO_CANCEL_OPTION;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
/**
 *
 * @author cristina.fontanet
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
     * By Netbeans
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ButModComentari = new javax.swing.JButton();
        modelos1 = new DefaultListModel();
        Penjades1 = new javax.swing.JList();
        butAfegeixComuni = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jScrollPane13 = new javax.swing.JScrollPane();
        CriterisNovaCerca1 = new javax.swing.JTextArea();
        butModNom = new javax.swing.JButton();
        ModificaCriterisB = new javax.swing.JButton();
        jScrollPane14 = new javax.swing.JScrollPane();
        Resultat1 = new javax.swing.JTree();
        ButTanca = new javax.swing.JButton();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        ButModComentari.setText("Modificar Comentari");
        ButModComentari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButModComentariActionPerformed(evt);
            }
        });

        Penjades1.setModel(modelos1);
        Penjades1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        Penjades1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Penjades1.setDragEnabled(true);
        Penjades1.setDropMode(javax.swing.DropMode.INSERT);
        Penjades1.setFocusable(false);
        Penjades1.setValueIsAdjusting(true);

        butAfegeixComuni.setText("Afegir Comunitat");
        butAfegeixComuni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butAfegeixComuniActionPerformed(evt);
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
        CriterisNovaCerca1.setText("S'està carregant, \nel procés pot tardar una estoneta");
        jScrollPane13.setViewportView(CriterisNovaCerca1);

        butModNom.setText("Modificar Nom");
        butModNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butModNomActionPerformed(evt);
            }
        });

        ModificaCriterisB.setText("Modificar Criteris");
        ModificaCriterisB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificaCriterisBActionPerformed(evt);
            }
        });

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("carregant.....");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("tingues paciencia siusplau");
        treeNode1.add(treeNode2);
        Resultat1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        Resultat1.setAutoscrolls(true);
        Resultat1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Resultat1.setLargeModel(true);
        jScrollPane14.setViewportView(Resultat1);

        ButTanca.setText("Tanca");
        ButTanca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButTancaActionPerformed(evt);
            }
        });

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
                        .addComponent(butModNom)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ButModComentari)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ButTanca))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton22)
                            .addComponent(jButton23)
                            .addComponent(butAfegeixComuni))
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
                            .addComponent(butModNom)
                            .addComponent(ButModComentari)
                            .addComponent(ButTanca))
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
                                        .addComponent(butAfegeixComuni))
                                    .addComponent(Penjades1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    /*
    * Apareix un missatge demanant el nou comentari de la cerca
    */
    private void ButModComentariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButModComentariActionPerformed
        String nouComen =JOptionPane.showInputDialog(this,"Escriu el nou comentari",QUESTION_MESSAGE);
        macro.getContUser().addComentariCerca(macro.getUserActual(), numcerca, nouComen);
        vista.visualitzaCerca(true,Resultat1,CriterisNovaCerca1, numcerca);
    }//GEN-LAST:event_ButModComentariActionPerformed
    /*
    * Afegeix una nova comunitat sense categories 
    */
    private void butAfegeixComuniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butAfegeixComuniActionPerformed
        Integer quina = macro.getContUser().addComunitatCerca(macro.getUserActual(), numcerca)+1;
        System.out.println("Afegeico la comunitat: "+quina);
        DefaultTreeModel arb = (DefaultTreeModel)Resultat1.getModel();

        DefaultMutableTreeNode act = (DefaultMutableTreeNode)arb.getRoot();

        arb.insertNodeInto(new DefaultMutableTreeNode("Comunitat "+quina), act, act.getChildCount());
        comunaEliminar.add(quina-1);
    }//GEN-LAST:event_butAfegeixComuniActionPerformed
    /*
    * Treu la categoria seleccionada de l'arbre de resultats i l'afegeix a la llista
    */
    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        vista.treuCatComun(Resultat1,modelos1, numcerca);
    }//GEN-LAST:event_jButton23ActionPerformed
    /*
    * Afegeix la categoria seleccionada de la llista a la comunitat de l'arbre seleccionada
    */
    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        vista.afegeixCatComun(Resultat1,modelos1, Penjades1, numcerca);
    }//GEN-LAST:event_jButton22ActionPerformed
    /*
    * Apareix un missatge demanant el nou nom de la cerca
    */
    private void butModNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butModNomActionPerformed
        String nouNom =JOptionPane.showInputDialog(this,"Escriu el nou nom",QUESTION_MESSAGE);
        macro.getContUser().addNomCerca(macro.getUserActual(), numcerca, nouNom);
        pare.canviaNomTaula(nouNom);
        vista.visualitzaCerca(true,Resultat1,CriterisNovaCerca1, numcerca);
    }//GEN-LAST:event_butModNomActionPerformed
    /*
    * En clicar el boto de modificar criteris, es pregunta a l'usuari si vol fer la nova cerca tot modificant l'actual o creant-ne una de nova
    */
    private void ModificaCriterisBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificaCriterisBActionPerformed
        if(auxguard ==2) JOptionPane.showMessageDialog(this, "No es pot fer una nova cerca mentres n'hi hagi una sense guardar, si us plau, guarda-la o descarta-la", capsalera, ERROR_MESSAGE);
        else {
        int resposta = JOptionPane.showOptionDialog(this,"Vols crear una nova cerca o sobreescriure aquesta?", capsalera,YES_NO_CANCEL_OPTION,QUESTION_MESSAGE,null,new Object[]{"Conserva aquesta","Modifica aquesta","Cancelar"},"i tu?");
        if(resposta==0)pare.novaCerca();
        else if (resposta==1){
            cercaactual = numcerca;
            pare.modificaCercaGuardada();
        }
        }
    }//GEN-LAST:event_ModificaCriterisBActionPerformed
    /*
    * En visualitzar-se el panell, es preparen els detalls de la cerca
    */
    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
       vista.visualitzaCerca(true, Resultat1, CriterisNovaCerca1, numcerca);
    }//GEN-LAST:event_formComponentShown
    /*
    * Es tanca la visualitzacio actual de la cerca
    */
    private void ButTancaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButTancaActionPerformed
        vista.netejaArbreCerca(numcerca);
        pare.eliminaTab(this);
    }//GEN-LAST:event_ButTancaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButModComentari;
    private javax.swing.JButton ButTanca;
    private javax.swing.JTextArea CriterisNovaCerca1;
    private javax.swing.JButton ModificaCriterisB;
    private javax.swing.JList Penjades1;
    private DefaultListModel modelos1;
    private javax.swing.JTree Resultat1;
    private javax.swing.JButton butAfegeixComuni;
    private javax.swing.JButton butModNom;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    // End of variables declaration//GEN-END:variables
}
