/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interficie;

import static Interficie.InterficiaProva1.capsalera;
import static Interficie.InterficiaProva1.comunaEliminar;
import static Interficie.InterficiaProva1.cercaactual;
import static Interficie.InterficiaProva1.vista;
import static Interficie.InterficiaProva1.guardada;
import static Interficie.InterficiaProva1.auxguard;
import static Interficie.InterficiaProva1.macro;
import java.util.Collections;
import java.util.Enumeration;
import java.util.PriorityQueue;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.OK_CANCEL_OPTION;
import static javax.swing.JOptionPane.OK_OPTION;
import static javax.swing.JOptionPane.PLAIN_MESSAGE;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
/**
 *
 * @author Cristina
 */
public class VeureNovaCerca extends javax.swing.JPanel {
    private Integer numcerca;
    private InterficiaProva1 pare;
    
    /**
     * Creates new form VisualitzaCerca
     */
    public VeureNovaCerca(JFrame par, Integer cerca) {
        initComponents();
        pare = (InterficiaProva1)par;
        numcerca = cerca;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton20 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        Resultat = new javax.swing.JTree();
        jButton13 = new javax.swing.JButton();
        modelos = new DefaultListModel();
        Penjades = new javax.swing.JList();
        jButton12 = new javax.swing.JButton();
        ModificarCriterisBut = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        CriterisNovaCerca = new javax.swing.JTextArea();
        jToggleButton1 = new javax.swing.JToggleButton();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton20.setText("Afegir Comunitat");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jButton10.setText("<<<<");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        Resultat.setAutoscrolls(true);
        Resultat.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Resultat.setLargeModel(true);
        jScrollPane9.setViewportView(Resultat);

        jButton13.setText("Guardar");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        Penjades.setModel(modelos);
        Penjades.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        Penjades.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Penjades.setDragEnabled(true);
        Penjades.setDropMode(javax.swing.DropMode.INSERT);
        Penjades.setFocusable(false);
        Penjades.setValueIsAdjusting(true);

        jButton12.setText(">>>>");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        ModificarCriterisBut.setText("Modificar Criteris");
        ModificarCriterisBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarCriterisButActionPerformed(evt);
            }
        });

        CriterisNovaCerca.setBackground(new java.awt.Color(240, 240, 240));
        CriterisNovaCerca.setColumns(20);
        CriterisNovaCerca.setRows(5);
        jScrollPane11.setViewportView(CriterisNovaCerca);

        jToggleButton1.setText("Tanca sense guardar");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ModificarCriterisBut)
                        .addGap(18, 18, 18)
                        .addComponent(jButton13)
                        .addGap(18, 18, 18)
                        .addComponent(jToggleButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton10)
                            .addComponent(jButton12)
                            .addComponent(jButton20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Penjades, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane11)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ModificarCriterisBut)
                            .addComponent(jButton13)
                            .addComponent(jToggleButton1))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(105, 105, 105)
                                .addComponent(jButton10)
                                .addGap(18, 18, 18)
                                .addComponent(jButton12)
                                .addGap(18, 18, 18)
                                .addComponent(jButton20))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Penjades, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        Integer quina = macro.getContUser().addComunitatCerca(macro.getUserActual(), numcerca)+1;
        System.out.println("Afegeico la comunitat: "+quina);
        DefaultTreeModel arb = (DefaultTreeModel)Resultat.getModel();

        DefaultMutableTreeNode act = (DefaultMutableTreeNode)arb.getRoot();

        arb.insertNodeInto(new DefaultMutableTreeNode("Comunitat "+quina), act, act.getChildCount());
        comunaEliminar.add(quina-1);
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        vista.afegeixCatComun(Resultat,modelos, Penjades, numcerca);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        GuardaCerca auxi = new GuardaCerca(pare);
        int result = JOptionPane.showConfirmDialog(this, auxi,"Entra les dades requerides", PLAIN_MESSAGE);
        if(result == OK_OPTION) {
            if(auxi.getName().length()>0) {
                macro.getContUser().addNomCerca(macro.getUserActual(),numcerca,auxi.getName());
                macro.getContUser().addComentariCerca(macro.getUserActual(),numcerca,auxi.getComentari());
                pare.canviarACercaGuardada();
            }
            else JOptionPane.showMessageDialog(this, "Has d'introduir un nom.", capsalera, WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        vista.treuCatComun(Resultat,modelos, numcerca);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void ModificarCriterisButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarCriterisButActionPerformed
        cercaactual=numcerca;
        pare.modificaCercaGuardada();
    }//GEN-LAST:event_ModificarCriterisButActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        cercaactual = numcerca;
        System.out.println("Mostro la nova cerca");
        vista.visualitzaCerca(false, Resultat, CriterisNovaCerca, numcerca);
        guardada=1;
        comunaEliminar = new PriorityQueue<>(1, Collections.reverseOrder());
    }//GEN-LAST:event_formComponentShown

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
       System.out.print("Elimino les comunitats:");
        while(!comunaEliminar.isEmpty()) {
            System.out.print(" "+comunaEliminar.peek());
            macro.getContUser().removeComunitatCerca(macro.getUserActual(),numcerca,comunaEliminar.poll());
        }
        System.out.println();
    }//GEN-LAST:event_formComponentHidden

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
      macro.getContUser().removeCerca(macro.getUserActual(),numcerca);
      auxguard = 0;
      pare.eliminaTab(this);
    }//GEN-LAST:event_jToggleButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea CriterisNovaCerca;
    private javax.swing.JButton ModificarCriterisBut;
    private javax.swing.JList Penjades;
    private DefaultListModel modelos;
    private javax.swing.JTree Resultat;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton20;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
