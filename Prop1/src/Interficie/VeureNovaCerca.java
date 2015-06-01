/*
 * Panell que mostra el resultat d'una cerca de comunitats encara no guardat
 */
package Interficie;

import static Interficie.InterficieWiki.capsalera;
import static Interficie.InterficieWiki.comunaEliminar;
import static Interficie.InterficieWiki.cercaactual;
import static Interficie.InterficieWiki.vista;
import static Interficie.InterficieWiki.auxguard;
import static Interficie.InterficieWiki.macro;
import java.util.Collections;
import java.util.PriorityQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.OK_OPTION;
import static javax.swing.JOptionPane.PLAIN_MESSAGE;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
/**
 *
 * @author cristina.fontanet
 */
public class VeureNovaCerca extends javax.swing.JPanel {
	
    private Integer numcerca;
    private InterficieWiki pare;
    private Boolean modificacio;
    
    /**
     * Creates new form VisualitzaNovaCerca
     */
    public VeureNovaCerca(JFrame par, Integer cerca) {
        initComponents();
        pare = (InterficieWiki)par;
        numcerca = cerca;
        modificacio = false;
    }

    /**
     * By Netbeans
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ButAfegirComunitat = new javax.swing.JButton();
        ButAfegirArbre = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        Resultat = new javax.swing.JTree();
        ButGuardar = new javax.swing.JButton();
        modelos = new DefaultListModel();
        Penjades = new javax.swing.JList();
        ButTreureArbre = new javax.swing.JButton();
        ButModificarCriteris = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        CriterisNovaCerca = new javax.swing.JTextArea();
        ButTancar = new javax.swing.JToggleButton();
        jButton1 = new javax.swing.JButton();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        ButAfegirComunitat.setText("Afegir Comunitat");
        ButAfegirComunitat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButAfegirComunitatActionPerformed(evt);
            }
        });

        ButAfegirArbre.setText("<<<<");
        ButAfegirArbre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButAfegirArbreActionPerformed(evt);
            }
        });

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("carregant.....");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("tingues paciencia siusplau");
        treeNode1.add(treeNode2);
        Resultat.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        Resultat.setAutoscrolls(true);
        Resultat.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Resultat.setLargeModel(true);
        jScrollPane9.setViewportView(Resultat);

        ButGuardar.setText("Guardar");
        ButGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButGuardarActionPerformed(evt);
            }
        });

        Penjades.setModel(modelos);
        Penjades.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        Penjades.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Penjades.setDragEnabled(true);
        Penjades.setDropMode(javax.swing.DropMode.INSERT);
        Penjades.setFocusable(false);
        Penjades.setValueIsAdjusting(true);

        ButTreureArbre.setText(">>>>");
        ButTreureArbre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButTreureArbreActionPerformed(evt);
            }
        });

        ButModificarCriteris.setText("Modificar Criteris");
        ButModificarCriteris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButModificarCriterisActionPerformed(evt);
            }
        });

        CriterisNovaCerca.setBackground(new java.awt.Color(240, 240, 240));
        CriterisNovaCerca.setColumns(20);
        CriterisNovaCerca.setRows(5);
        CriterisNovaCerca.setText("S'està carregant, \nel procés pot tardar una estoneta");
        jScrollPane11.setViewportView(CriterisNovaCerca);

        ButTancar.setText("Tanca sense guardar");
        ButTancar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButTancarActionPerformed(evt);
            }
        });

        jButton1.setText("Visualitzar Categoria");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ButModificarCriteris)
                        .addGap(18, 18, 18)
                        .addComponent(ButGuardar)
                        .addGap(18, 18, 18)
                        .addComponent(ButTancar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ButAfegirArbre)
                            .addComponent(ButTreureArbre)
                            .addComponent(ButAfegirComunitat)
                            .addComponent(jButton1))))
                .addGap(31, 31, 31)
                .addComponent(Penjades, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ButModificarCriteris)
                    .addComponent(ButGuardar)
                    .addComponent(ButTancar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(ButAfegirArbre)
                        .addGap(18, 18, 18)
                        .addComponent(ButTreureArbre)
                        .addGap(18, 18, 18)
                        .addComponent(ButAfegirComunitat)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))))
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(Penjades, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    /*
    * Afegeix una nova comunitat sense categories 
    */
    private void ButAfegirComunitatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButAfegirComunitatActionPerformed
        Integer quina = macro.getContUser().addComunitatCerca(macro.getUserActual(), numcerca)+1;
        DefaultTreeModel arb = (DefaultTreeModel)Resultat.getModel();

        DefaultMutableTreeNode act = (DefaultMutableTreeNode)arb.getRoot();

        arb.insertNodeInto(new DefaultMutableTreeNode("Comunitat "+quina), act, act.getChildCount());
        comunaEliminar.add(quina-1);
    }//GEN-LAST:event_ButAfegirComunitatActionPerformed
    
    /*
    * Afegeix la categoria seleccionada de la llista a la comunitat de l'arbre seleccionada
    */
    private void ButAfegirArbreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButAfegirArbreActionPerformed
        vista.afegeixCatComun(Resultat,modelos, Penjades, numcerca);
    }//GEN-LAST:event_ButAfegirArbreActionPerformed
   
    /*
    * En clicar al boto de Guardar, demana les dades necessaries per a poder guardar la cerca de comunitats i la guarda, permetent que se'n pugui realitzar una altra
    */
    private void ButGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButGuardarActionPerformed
        GuardaCerca auxi = new GuardaCerca();
        int result = JOptionPane.showConfirmDialog(this, auxi,"Entra les dades requerides", PLAIN_MESSAGE);
        if(result == OK_OPTION) {
            if(auxi.getNameCerca().length()<=0) JOptionPane.showMessageDialog(this, "Has d'introduir un nom.", capsalera, WARNING_MESSAGE);
            else if(auxi.getNameCerca().contains("|")||auxi.getNameCerca().contains("*")||auxi.getNameCerca().contains("+")) JOptionPane.showMessageDialog(this, "El nom conte algun caràcter prohibit", capsalera, ERROR_MESSAGE);
            else if (auxi.getComentari().length() >0 && (auxi.getComentari().contains("|")||auxi.getComentari().contains("*")||auxi.getComentari().contains("+"))) JOptionPane.showMessageDialog(this, "El comentari conté algun caracter prohibit", capsalera, ERROR_MESSAGE);
            else {
                macro.getContUser().addNomCerca(macro.getUserActual(),numcerca,auxi.getNameCerca());
                macro.getContUser().addComentariCerca(macro.getUserActual(),numcerca,auxi.getComentari());
                vista.netejaArbreCerca(numcerca);
                if(modificacio)macro.getContUser().ordenaCerca(macro.getUserActual(), numcerca);
                pare.canviarACercaGuardada();
            } 
        }
    }//GEN-LAST:event_ButGuardarActionPerformed
    
    /*
    * Treu la categoria seleccionada de l'arbre de resultats i l'afegeix a la llista
    */
    private void ButTreureArbreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButTreureArbreActionPerformed
        vista.treuCatComun(Resultat,modelos, numcerca);
        modificacio = true;
    }//GEN-LAST:event_ButTreureArbreActionPerformed
    
    /*
    * En clicar el boto de modificar criteris, es mostra la pantalla de creació de cerques
    */
    private void ButModificarCriterisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButModificarCriterisActionPerformed
        cercaactual=numcerca;
        pare.modificaCercaGuardada();
    }//GEN-LAST:event_ButModificarCriterisActionPerformed
    
    /*
    * En mostrar-se el panell, s'omplen les dades de la cerca
    */
    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        cercaactual = numcerca;
        vista.visualitzaCerca(false, Resultat, CriterisNovaCerca, numcerca);
        comunaEliminar = new PriorityQueue<>(1, Collections.reverseOrder());
    }//GEN-LAST:event_formComponentShown
    
    /*
    * En desapareixer el panell, s'actualitzen els canvis de l'arbre
    */
    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
      if(modificacio)macro.getContUser().ordenaCerca(macro.getUserActual(), numcerca);
    }//GEN-LAST:event_formComponentHidden
    
    /*
    * Descarta la cerca de comunitats actual
    */
    private void ButTancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButTancarActionPerformed
      macro.getContUser().removeCerca(macro.getUserActual(),numcerca);
      auxguard = 0;
      pare.activaCerca();
      pare.eliminaTab(this);
    }//GEN-LAST:event_ButTancarActionPerformed
    
    /*
    * En clicar el boto de visualitzar una categoria, es mostres les caracteristiques d'aquesta
    */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        vista.visualitzarCategoriaCerca(pare,Resultat);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButAfegirArbre;
    private javax.swing.JButton ButAfegirComunitat;
    private javax.swing.JButton ButGuardar;
    private javax.swing.JButton ButModificarCriteris;
    private javax.swing.JToggleButton ButTancar;
    private javax.swing.JButton ButTreureArbre;
    private javax.swing.JTextArea CriterisNovaCerca;
    private javax.swing.JList Penjades;
    private DefaultListModel modelos;
    private javax.swing.JTree Resultat;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane9;
    // End of variables declaration//GEN-END:variables
}
