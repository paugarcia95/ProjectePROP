/*
 * Panell que mostra el resultat d'una cerca de comunitats encara no guardat
 */
package Interficie;

import static Interficie.InterficiaProva1.capsalera;
import static Interficie.InterficiaProva1.comunaEliminar;
import static Interficie.InterficiaProva1.cercaactual;
import static Interficie.InterficiaProva1.vista;
import static Interficie.InterficiaProva1.auxguard;
import static Interficie.InterficiaProva1.macro;
import java.util.Collections;
import java.util.PriorityQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
    private InterficiaProva1 pare;
    
    /**
     * Creates new form VisualitzaNovaCerca
     */
    public VeureNovaCerca(JFrame par, Integer cerca) {
        initComponents();
        pare = (InterficiaProva1)par;
        numcerca = cerca;
    }

    /**
     * By Netbeans
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

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

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        setLayout(new java.awt.GridBagLayout());

        ButAfegirComunitat.setText("Afegir Comunitat");
        ButAfegirComunitat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButAfegirComunitatActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 18, 0, 0);
        add(ButAfegirComunitat, gridBagConstraints);

        ButAfegirArbre.setText("<<<<");
        ButAfegirArbre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButAfegirArbreActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(105, 18, 0, 0);
        add(ButAfegirArbre, gridBagConstraints);

        Resultat.setAutoscrolls(true);
        Resultat.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Resultat.setLargeModel(true);
        jScrollPane9.setViewportView(Resultat);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 217;
        gridBagConstraints.ipady = 428;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(18, 18, 11, 0);
        add(jScrollPane9, gridBagConstraints);

        ButGuardar.setText("Guardar");
        ButGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButGuardarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 18, 0, 0);
        add(ButGuardar, gridBagConstraints);

        Penjades.setModel(modelos);
        Penjades.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        Penjades.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Penjades.setDragEnabled(true);
        Penjades.setDropMode(javax.swing.DropMode.INSERT);
        Penjades.setFocusable(false);
        Penjades.setValueIsAdjusting(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.ipadx = 265;
        gridBagConstraints.ipady = 290;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 6, 0, 10);
        add(Penjades, gridBagConstraints);

        ButTreureArbre.setText(">>>>");
        ButTreureArbre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButTreureArbreActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 18, 0, 0);
        add(ButTreureArbre, gridBagConstraints);

        ButModificarCriteris.setText("Modificar Criteris");
        ButModificarCriteris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButModificarCriterisActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 18, 0, 0);
        add(ButModificarCriteris, gridBagConstraints);

        CriterisNovaCerca.setBackground(new java.awt.Color(240, 240, 240));
        CriterisNovaCerca.setColumns(20);
        CriterisNovaCerca.setRows(5);
        jScrollPane11.setViewportView(CriterisNovaCerca);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 322;
        gridBagConstraints.ipady = 469;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(11, 10, 11, 0);
        add(jScrollPane11, gridBagConstraints);

        ButTancar.setText("Tanca sense guardar");
        ButTancar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButTancarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 18, 0, 0);
        add(ButTancar, gridBagConstraints);
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
        GuardaCerca auxi = new GuardaCerca(pare);
        int result = JOptionPane.showConfirmDialog(this, auxi,"Entra les dades requerides", PLAIN_MESSAGE);
        if(result == OK_OPTION) {
            if(auxi.getName().length()>0) {
                macro.getContUser().addNomCerca(macro.getUserActual(),numcerca,auxi.getName());
                macro.getContUser().addComentariCerca(macro.getUserActual(),numcerca,auxi.getComentari());
                vista.netejaArbreCerca(numcerca);
                pare.canviarACercaGuardada();
            }
            else JOptionPane.showMessageDialog(this, "Has d'introduir un nom.", capsalera, WARNING_MESSAGE);
        }
    }//GEN-LAST:event_ButGuardarActionPerformed
    /*
    * Treu la categoria seleccionada de l'arbre de resultats i l'afegeix a la llista
    */
    private void ButTreureArbreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButTreureArbreActionPerformed
        vista.treuCatComun(Resultat,modelos, numcerca);
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
      vista.netejaArbreCerca(numcerca);
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
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane9;
    // End of variables declaration//GEN-END:variables
}
