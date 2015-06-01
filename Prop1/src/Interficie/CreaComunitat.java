/*
 * Panell de creació d'una cerca de comunitats
 */
package Interficie;

import static Interficie.InterficieWiki.vista;
import static Interficie.InterficieWiki.capsalera;
import static Interficie.InterficieWiki.comp;
import static Interficie.InterficieWiki.cercaactual;
import static Interficie.InterficieWiki.auxguard;
import static Interficie.InterficieWiki.interrumput;
import static Interficie.InterficieWiki.macro;
import static Interficie.InterficieWiki.hilo;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;
/**
 *
 * @author cristina.fontanet
 */
public class CreaComunitat extends javax.swing.JPanel {
    /**
     * Interficie a la qual es coloca el panell, per poder interectuar amb ella
     */
    private final InterficieWiki pare;
    /**
     * Per a saber quin tab hi ha seleccionat en el moment d'acabar la cerca
     */
    private final JTabbedPane taula; 

    /**
     * Creates new form CreaComunitat
     * 
     * @param par Frame principal de la interficie a la qual es coloca el panell
     * @param dequi TabbedPane a on es coloca el panell
     */
    public CreaComunitat(JFrame par, JTabbedPane dequi) {
        initComponents();
        pare = (InterficieWiki)par;
        taula = dequi;
    }

   
    /**
     * By Netbeans
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane9 = new javax.swing.JScrollPane();
        Algorismes1 = new javax.swing.JTree();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        CrelacioSub = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        CrelacioPag = new javax.swing.JSlider();
        CrelacioSup = new javax.swing.JSlider();
        CpcImp = new javax.swing.JSlider();
        Csembla = new javax.swing.JSlider();
        CrelacioCat = new javax.swing.JSlider();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        Cpc = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        Cdada = new javax.swing.JSpinner();
        jScrollPane8 = new javax.swing.JScrollPane();
        Algorismes = new javax.swing.JTree();
        jLabel23 = new javax.swing.JLabel();
        CercaB = new javax.swing.JButton();
        modelo2 = new DefaultListModel();
        Lsub2 = new javax.swing.JList();
        modelo1 = new DefaultListModel();
        Lsub1 = new javax.swing.JList();
        jButton11 = new javax.swing.JButton();
        Cafegeix4 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        Cafegeix3 = new javax.swing.JButton();
        CbuscaPag = new javax.swing.JButton();
        Cbusca2 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        Cafegeix2 = new javax.swing.JButton();
        Cbusca1 = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        LPTotes = new javax.swing.JList();
        jScrollPane6 = new javax.swing.JScrollPane();
        modelo = new DefaultListModel();
        Lsub = new javax.swing.JList();
        jScrollPane5 = new javax.swing.JScrollPane();
        LCTotes = new javax.swing.JList();
        EliminaCsub = new javax.swing.JButton();
        CbuscaCat = new javax.swing.JButton();
        Cafegeix1 = new javax.swing.JButton();
        Cbusca = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Algorismes");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Louvain");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Dispersio");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Newman-Girvan");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Dispersio");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Numero Categories");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Maxima Between");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Cliqué");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Dispersio");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        Algorismes1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane9.setViewportView(Algorismes1);

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLabel2.setText("La paraula clau no pot contenir |, * ni +");

        CrelacioSub.setForeground(new java.awt.Color(0, 0, 153));
        CrelacioSub.setMajorTickSpacing(1);
        CrelacioSub.setMaximum(10);
        CrelacioSub.setMinorTickSpacing(1);
        CrelacioSub.setPaintLabels(true);
        CrelacioSub.setPaintTicks(true);
        CrelacioSub.setSnapToTicks(true);
        CrelacioSub.setValue(5);
        CrelacioSub.setAutoscrolls(true);
        CrelacioSub.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        CrelacioSub.setInheritsPopupMenu(true);
        CrelacioSub.setValueIsAdjusting(true);

        jLabel1.setText("Importancia de la relació existent entre categories");

        CrelacioPag.setForeground(new java.awt.Color(0, 0, 153));
        CrelacioPag.setMajorTickSpacing(1);
        CrelacioPag.setMaximum(10);
        CrelacioPag.setMinorTickSpacing(1);
        CrelacioPag.setPaintLabels(true);
        CrelacioPag.setPaintTicks(true);
        CrelacioPag.setSnapToTicks(true);
        CrelacioPag.setValue(5);
        CrelacioPag.setAutoscrolls(true);
        CrelacioPag.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        CrelacioPag.setInheritsPopupMenu(true);
        CrelacioPag.setValueIsAdjusting(true);

        CrelacioSup.setForeground(new java.awt.Color(0, 0, 153));
        CrelacioSup.setMajorTickSpacing(1);
        CrelacioSup.setMaximum(10);
        CrelacioSup.setMinorTickSpacing(1);
        CrelacioSup.setPaintLabels(true);
        CrelacioSup.setPaintTicks(true);
        CrelacioSup.setSnapToTicks(true);
        CrelacioSup.setValue(5);
        CrelacioSup.setAutoscrolls(true);
        CrelacioSup.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        CrelacioSup.setInheritsPopupMenu(true);
        CrelacioSup.setValueIsAdjusting(true);

        CpcImp.setForeground(new java.awt.Color(0, 0, 153));
        CpcImp.setMajorTickSpacing(5);
        CpcImp.setMaximum(10);
        CpcImp.setMinorTickSpacing(5);
        CpcImp.setPaintLabels(true);
        CpcImp.setPaintTicks(true);
        CpcImp.setSnapToTicks(true);
        CpcImp.setValue(0);
        CpcImp.setAutoscrolls(true);
        CpcImp.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        CpcImp.setInheritsPopupMenu(true);
        CpcImp.setValueIsAdjusting(true);

        Csembla.setForeground(new java.awt.Color(0, 0, 153));
        Csembla.setMajorTickSpacing(1);
        Csembla.setMaximum(10);
        Csembla.setMinorTickSpacing(1);
        Csembla.setPaintLabels(true);
        Csembla.setPaintTicks(true);
        Csembla.setSnapToTicks(true);
        Csembla.setValue(5);
        Csembla.setAutoscrolls(true);
        Csembla.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Csembla.setInheritsPopupMenu(true);
        Csembla.setValueIsAdjusting(true);

        CrelacioCat.setForeground(new java.awt.Color(0, 0, 153));
        CrelacioCat.setMajorTickSpacing(1);
        CrelacioCat.setMaximum(10);
        CrelacioCat.setMinorTickSpacing(1);
        CrelacioCat.setPaintLabels(true);
        CrelacioCat.setPaintTicks(true);
        CrelacioCat.setSnapToTicks(true);
        CrelacioCat.setValue(5);
        CrelacioCat.setAutoscrolls(true);
        CrelacioCat.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        CrelacioCat.setInheritsPopupMenu(true);
        CrelacioCat.setValueIsAdjusting(true);

        jLabel12.setText("Importància de la semblança de noms");

        jLabel11.setText("Importància de compartir Subcategories");

        jLabel5.setText("Benvingut a la creació d'una nova Cerca de Comunitats!");

        jLabel10.setText("Indica amb un numero del 0 al 10 la importància que li vols dnar a la relació entre categopries.");

        jLabel13.setText("Indica una paraula clau que vols que es tingui en compte i la seva importància:");

        jLabel3.setText("Importancia de la relació amb les pàgines");

        jLabel14.setText("Importància de compartir Supercategories");

        jButton1.setText("Seguent");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(Cpc, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel10)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(405, 405, 405)
                            .addComponent(jLabel5)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(CrelacioCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(CrelacioPag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Csembla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel12))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(CrelacioSub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(CrelacioSup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel14))
                            .addComponent(jLabel2)
                            .addComponent(CpcImp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CrelacioCat, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CrelacioPag, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Csembla, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CrelacioSub, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CrelacioSup, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Cpc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(CpcImp, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(319, Short.MAX_VALUE))
        );

        Cdada.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Algorismes");
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Louvain");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Dispersio");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Newman-Girvan");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Dispersio");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Numero Categories");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Maxima Between");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Cliqué");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Dispersio");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        Algorismes.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane8.setViewportView(Algorismes);

        jLabel23.setText("Algorisme:");

        CercaB.setText("Fer Cerca!");
        CercaB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CercaBActionPerformed(evt);
            }
        });

        Lsub2.setModel(modelo2);
        Lsub2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        Lsub2.setDragEnabled(true);
        Lsub2.setDropMode(javax.swing.DropMode.INSERT);
        Lsub2.setFocusable(false);
        Lsub2.setValueIsAdjusting(true);

        Lsub1.setModel(modelo1);
        Lsub1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        Lsub1.setDragEnabled(true);
        Lsub1.setDropMode(javax.swing.DropMode.INSERT);
        Lsub1.setFocusable(false);
        Lsub1.setValueIsAdjusting(true);

        jButton11.setText("Elimina");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        Cafegeix4.setText("Afegeix");
        Cafegeix4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cafegeix4ActionPerformed(evt);
            }
        });

        jLabel22.setText("Pagines");

        jLabel21.setText("Categories");

        jButton9.setText("Elimina");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        Cafegeix3.setText("Afegeix");
        Cafegeix3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cafegeix3ActionPerformed(evt);
            }
        });

        CbuscaPag.setText("Busca");
        CbuscaPag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbuscaPagActionPerformed(evt);
            }
        });

        jLabel19.setText("Categories");

        Cafegeix2.setText("Afegeix");
        Cafegeix2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cafegeix2ActionPerformed(evt);
            }
        });

        LPTotes.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane7.setViewportView(LPTotes);

        Lsub.setModel(modelo);
        Lsub.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        Lsub.setDragEnabled(true);
        Lsub.setDropMode(javax.swing.DropMode.INSERT);
        Lsub.setFocusable(false);
        Lsub.setValueIsAdjusting(true);
        jScrollPane6.setViewportView(Lsub);

        LCTotes.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane5.setViewportView(LCTotes);

        EliminaCsub.setText("Elimina");
        EliminaCsub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminaCsubActionPerformed(evt);
            }
        });

        CbuscaCat.setText("Busca");
        CbuscaCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbuscaCatActionPerformed(evt);
            }
        });

        Cafegeix1.setText("Afegeix");
        Cafegeix1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cafegeix1ActionPerformed(evt);
            }
        });

        jLabel18.setText("Selecciona unes quantes categories i/o pàgines les quals vols ignorar");

        jLabel16.setText("Selecciona la categoria pare a partir de la qual es tenen en compte tots els seus fills");

        jLabel15.setText("Selecciona unes quantes categories entre les quals vols que es faci la cerca");

        jLabel24.setText("Pagines");

        jLabel25.setText("Categories");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(Lsub1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Cafegeix1)
                                    .addComponent(jButton11)))
                            .addComponent(jLabel19))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(Lsub2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Cafegeix3)
                                    .addComponent(jButton9)))
                            .addComponent(jLabel22)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(CercaB))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(EliminaCsub)
                            .addComponent(Cafegeix2)))
                    .addComponent(jLabel21)
                    .addComponent(jLabel18)
                    .addComponent(jLabel16)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Cbusca, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Cafegeix4)))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(Cbusca1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CbuscaPag)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24)
                                    .addComponent(Cbusca2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CbuscaCat)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel23))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Cdada, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(CercaB))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel21)
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(Cafegeix2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(EliminaCsub)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel19)
                                .addGap(15, 15, 15)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(Cafegeix1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton11))
                                    .addComponent(Lsub1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addGap(12, 12, 12)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton9, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Lsub2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Cafegeix3)))))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Cbusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cafegeix4))
                        .addGap(123, 123, 123))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Cdada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CbuscaCat, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cbusca2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CbuscaPag)
                            .addComponent(Cbusca1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(136, 136, 136)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(551, 551, 551)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void Cafegeix1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cafegeix1ActionPerformed
        if(LCTotes.getSelectedIndex()>=0) {
            if(!modelo.contains(LCTotes.getSelectedValue())) modelo.addElement(LCTotes.getSelectedValue());
            LCTotes.clearSelection();
        }
        else JOptionPane.showMessageDialog(this, "Has de seleccionar algun element de la llista de categories!", capsalera, WARNING_MESSAGE);
    }//GEN-LAST:event_Cafegeix1ActionPerformed
    /*
    * Quan es clica al boto busca de les categories, es mostren nomes les categories que contenen el conjunt de lletres
    */
    private void CbuscaCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbuscaCatActionPerformed
        vista.ompleCategoriesExistentsConcret(LCTotes,Cbusca);
    }//GEN-LAST:event_CbuscaCatActionPerformed

    private void EliminaCsubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminaCsubActionPerformed
        if(modelo.getSize()>0){
            int n = Lsub.getSelectedIndex();
            modelo.removeElementAt(n);
        }
        else JOptionPane.showMessageDialog(this, "Has de seleccionar algun element de la llista de categories entre les quals es fa la cerca!", capsalera, WARNING_MESSAGE);
        Lsub.clearSelection();
    }//GEN-LAST:event_EliminaCsubActionPerformed
    /*
    * Determina quina és la comunitat pare a partir de la qual fer la cerca
    */
    private void Cafegeix2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cafegeix2ActionPerformed
        if(LCTotes.getSelectedIndex()<0)JOptionPane.showMessageDialog(this, "Has de seleccionar algun element de la llista de categories!", capsalera, WARNING_MESSAGE);
        else Cbusca1.setText(LCTotes.getSelectedValue().toString());
    }//GEN-LAST:event_Cafegeix2ActionPerformed
    /*
    * Quan es clica al boto busca de les pagines, es mostren nomes les pagines que contenen el conjunt de lletres
    */
    private void CbuscaPagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbuscaPagActionPerformed
        vista.omplePaginesExistentsConcret(LPTotes,Cbusca2);
    }//GEN-LAST:event_CbuscaPagActionPerformed
    /*
    * Afegeix la categoria seleccionada a la llista de categories a ignorar per a fer la cerca
    */
    private void Cafegeix3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cafegeix3ActionPerformed
        if(LCTotes.getSelectedIndex()<0)JOptionPane.showMessageDialog(this, "Has de seleccionar algun element de la llista de categories!", capsalera, WARNING_MESSAGE);
        else if(!modelo1.contains(LCTotes.getSelectedValue())) modelo1.addElement(LCTotes.getSelectedValue());
        LCTotes.clearSelection();
    }//GEN-LAST:event_Cafegeix3ActionPerformed
    /*
    * Elimina de la llista de categories a eliminar la categoria seleccionada
    */
    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if(modelo1.getSize()>0){
            modelo1.removeElementAt(Lsub1.getSelectedIndex());
        }
        else JOptionPane.showMessageDialog(this, "Has de seleccionar algun element de la llista de categories a ignorar!", capsalera, WARNING_MESSAGE);
        Lsub1.clearSelection();
    }//GEN-LAST:event_jButton9ActionPerformed
    /*
    * Afegeix la pagina seleccionada a la llista de pagines a ignorar per a fer la cerca
    */
    private void Cafegeix4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cafegeix4ActionPerformed
        if(LPTotes.getSelectedIndex()<0) JOptionPane.showMessageDialog(this, "Has de seleccionar algun element de la llista de pàgines!", capsalera, WARNING_MESSAGE);
        else if(!modelo2.contains(LPTotes.getSelectedValue()))modelo2.addElement(LPTotes.getSelectedValue());
        LPTotes.clearSelection();
    }//GEN-LAST:event_Cafegeix4ActionPerformed
    /*
    * Elimina de la llista de pagines a eliminar la pagina seleccionada
    */
    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        if(modelo2.getSize()>0){
            modelo2.removeElementAt(Lsub2.getSelectedIndex());
        }
        else JOptionPane.showMessageDialog(this, "Has de seleccionar algun element de la llista de pàgines a ignorar!", capsalera, WARNING_MESSAGE);
        Lsub2.clearSelection();
    }//GEN-LAST:event_jButton11ActionPerformed
    /*
    * En premer el boto Fer Cerca, es recullen i analitzen els valors seleccionats i es procedeix a fer la cerca, tot permetent a l'usuari fer altres consultes menys fer una altra cerca
    */
    private void CercaBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CercaBActionPerformed
    if(auxguard ==2) JOptionPane.showMessageDialog(comp, "Ja tens una cerca sense guardar oberta, si us plau, guarda-la o descarta-la abans de crear-ne una de nova", capsalera, WARNING_MESSAGE);
    else if(Cpc.getText().length()>0 && (Cpc.getText().contains("|")||Cpc.getText().contains("+")||Cpc.getText().contains("*"))) JOptionPane.showMessageDialog(this, "La paraula clau conté algun caràcter prohibit", capsalera, ERROR_MESSAGE);
    else {
        Runnable cerca = new Runnable() {
            @Override 
            public void run() {
                try {
                        interrumput = false;
                       if(vista.ferCerca(Algorismes,(Integer)Cdada.getValue(), Lsub, Lsub2, Lsub1, CpcImp.getValue(), Cpc, Csembla.getValue(), CrelacioCat.getValue(), Cbusca1, CrelacioPag.getValue(), CrelacioSup.getValue(), CrelacioSub.getValue())){
                        pare.desactivaEspera();
                        pare.revalidaCerques();
                            if(taula.getSelectedIndex()==4) {
                                pare.visualitzaCercaNova();
                            }
                            else {
                                int resposta = JOptionPane.showConfirmDialog(comp, "La cerca ja ha acabat. vols visualitzar-la ara?", capsalera, YES_NO_OPTION);
                                if(YES_OPTION ==resposta) {
                                    pare.visualitzaCercaNova();
                                }
                                else {
                                    String nouComen =JOptionPane.showInputDialog(comp,"Escriu el nom de la nova cerca",QUESTION_MESSAGE);
                                    macro.getContUser().addNomCerca(macro.getUserActual(), cercaactual, nouComen);
                                }
                            }
                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        hilo = new Thread(cerca);
        hilo.start();
        pare.activaEspera();
    }
    }//GEN-LAST:event_CercaBActionPerformed
    /*
    * En mostrar-se el panell, es carreguen els valors per defecte en cas de que sigui una cerca nova o els valors originals de cerca a modificar en cas contrari
    */
    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        Boolean nova;
        nova = auxguard != 0;
        vista.preaparaCreacioNovaCerca(nova, LCTotes, LPTotes, Algorismes, Lsub, Lsub2, Lsub1, Cbusca1, Cpc, CpcImp, Csembla, CrelacioCat, Cdada,CrelacioPag,CrelacioSup, CrelacioSub);
    }//GEN-LAST:event_formComponentShown


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree Algorismes;
    private javax.swing.JTree Algorismes1;
    private javax.swing.JButton Cafegeix1;
    private javax.swing.JButton Cafegeix2;
    private javax.swing.JButton Cafegeix3;
    private javax.swing.JButton Cafegeix4;
    private javax.swing.JTextField Cbusca;
    private javax.swing.JTextField Cbusca1;
    private javax.swing.JTextField Cbusca2;
    private javax.swing.JButton CbuscaCat;
    private javax.swing.JButton CbuscaPag;
    private javax.swing.JSpinner Cdada;
    private javax.swing.JButton CercaB;
    private javax.swing.JTextField Cpc;
    private javax.swing.JSlider CpcImp;
    private javax.swing.JSlider CrelacioCat;
    private javax.swing.JSlider CrelacioPag;
    private javax.swing.JSlider CrelacioSub;
    private javax.swing.JSlider CrelacioSup;
    private javax.swing.JSlider Csembla;
    private javax.swing.JButton EliminaCsub;
    private javax.swing.JList LCTotes;
    private javax.swing.JList LPTotes;
    private javax.swing.JList Lsub;
    private DefaultListModel modelo;
    private javax.swing.JList Lsub1;
    private DefaultListModel modelo1;
    private javax.swing.JList Lsub2;
    private DefaultListModel modelo2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    // End of variables declaration//GEN-END:variables
}
