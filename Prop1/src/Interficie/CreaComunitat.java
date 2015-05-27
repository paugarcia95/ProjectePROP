/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interficie;

import static Interficie.InterficiaProva1.vista;
import static Interficie.InterficiaProva1.guardada;
import static Interficie.InterficiaProva1.capsalera;
import static Interficie.InterficiaProva1.comp;
import static Interficie.InterficiaProva1.cercaactual;
import static Interficie.InterficiaProva1.macro;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;
import static javax.swing.JOptionPane.YES_NO_CANCEL_OPTION;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;
import static javax.swing.JOptionPane.OK_CANCEL_OPTION;
import static javax.swing.JOptionPane.OK_OPTION;
import static javax.swing.JOptionPane.PLAIN_MESSAGE;
import javax.swing.JTabbedPane;
/**
 *
 * @author Cristina
 */
public class CreaComunitat extends javax.swing.JPanel {

    private InterficiaProva1 pare;
    private JTabbedPane taula;
   private Thread hilo;
   private Timer timer;
   
   class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            if (/*progressMonitor.isCanceled() ||*/ !hilo.isAlive()) {
                //progressMonitor.close();
                //hilo.interrupt();
                Toolkit.getDefaultToolkit().beep();
                timer.stop();
            
           } /* else {
                progressMonitor.setNote(iterador.toString());
                progressMonitor.setProgress(iterador);
                //taskOutput.append(task.getMessage() + newline);
               // taskOutput.setCaretPosition(taskOutput.getDocument().getLength());
            }*/
        }
    }
   
   
    /**
     * Creates new form CreaComunitat
     */
    public CreaComunitat(JFrame par, JTabbedPane dequi) {
        initComponents();
        pare = (InterficiaProva1)par;
        taula = dequi;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        Cpc = new javax.swing.JTextField();
        Crelacio = new javax.swing.JSlider();
        Cbusca = new javax.swing.JTextField();
        Cafegeix1 = new javax.swing.JButton();
        CbuscaCat = new javax.swing.JButton();
        Csembla = new javax.swing.JSlider();
        CpcImp = new javax.swing.JSlider();
        EliminaCsub = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        LCTotes = new javax.swing.JList();
        jScrollPane6 = new javax.swing.JScrollPane();
        modelo = new DefaultListModel();
        Lsub = new javax.swing.JList();
        jScrollPane7 = new javax.swing.JScrollPane();
        LPTotes = new javax.swing.JList();
        Cbusca1 = new javax.swing.JTextField();
        Cafegeix2 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        Cbusca2 = new javax.swing.JTextField();
        CbuscaPag = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        Cafegeix3 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        Cafegeix4 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        modelo1 = new DefaultListModel();
        Lsub1 = new javax.swing.JList();
        modelo2 = new DefaultListModel();
        Lsub2 = new javax.swing.JList();
        CercaB = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        Algorismes = new javax.swing.JTree();
        Cdada = new javax.swing.JSpinner();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLabel5.setText("Benvingut a la creaci� d'una nova Cerca de Comunitats!");

        jLabel6.setText("Si us plau, omple totes les dades amb un * i tingues en compte les restriccions de les altres");

        jLabel10.setText("Indica amb un numero del 0 al 10 la import�ncia que li vols dnar a la relaci� entre categopries.");

        jLabel11.setText("0 nom�s premia a les relacions amb les p�gines, un 5 premia igual les relacions cat-cat que les cat-pag i un 10 nom�s premia les relacions cat-cat");

        jLabel12.setText("Indica amb un n�mero del 0 al 10 la import�ncia que li vols donar  a la semblan�a entre els noms de les categories");

        jLabel13.setText("Indica una paraula clau que vols que es tingui en compte i la seva import�ncia:");

        jLabel14.setText("Un 0 si no en vols cap, un 5 per tal de que les categories que es tinguin en compte tinguin com a m�nim la meitat d'aquesta paraula o 10 si l'han de contenir en la seva totalitat");

        jLabel15.setText("Selecciona unes quantes categories entre les quals vols que es faci la cerca");

        jLabel16.setText("Selecciona la categoria pare a partir de la qual es tenen en compte tots els seus fills");

        jLabel18.setText("Selecciona unes quantes categories i/o p�gines les quals vols ignorar");

        Crelacio.setForeground(new java.awt.Color(0, 0, 153));
        Crelacio.setMajorTickSpacing(1);
        Crelacio.setMaximum(10);
        Crelacio.setMinorTickSpacing(1);
        Crelacio.setPaintLabels(true);
        Crelacio.setPaintTicks(true);
        Crelacio.setSnapToTicks(true);
        Crelacio.setValue(5);
        Crelacio.setAutoscrolls(true);
        Crelacio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Crelacio.setInheritsPopupMenu(true);
        Crelacio.setValueIsAdjusting(true);

        Cafegeix1.setText("Afegeix");
        Cafegeix1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cafegeix1ActionPerformed(evt);
            }
        });

        CbuscaCat.setText("Busca");
        CbuscaCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbuscaCatActionPerformed(evt);
            }
        });

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

        EliminaCsub.setText("Elimina");
        EliminaCsub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminaCsubActionPerformed(evt);
            }
        });

        LCTotes.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane5.setViewportView(LCTotes);

        Lsub.setModel(modelo);
        Lsub.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        Lsub.setDragEnabled(true);
        Lsub.setDropMode(javax.swing.DropMode.INSERT);
        Lsub.setFocusable(false);
        Lsub.setValueIsAdjusting(true);
        jScrollPane6.setViewportView(Lsub);

        LPTotes.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane7.setViewportView(LPTotes);

        Cafegeix2.setText("Afegeix");
        Cafegeix2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cafegeix2ActionPerformed(evt);
            }
        });

        jLabel19.setText("Categories");

        CbuscaPag.setText("Busca");
        CbuscaPag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbuscaPagActionPerformed(evt);
            }
        });

        jLabel20.setText("Pagines");

        Cafegeix3.setText("Afegeix");
        Cafegeix3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cafegeix3ActionPerformed(evt);
            }
        });

        jButton9.setText("Elimina");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel21.setText("Categories");

        jLabel22.setText("Pagines");

        Cafegeix4.setText("Afegeix");
        Cafegeix4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cafegeix4ActionPerformed(evt);
            }
        });

        jButton11.setText("Elimina");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        Lsub1.setModel(modelo1);
        Lsub1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        Lsub1.setDragEnabled(true);
        Lsub1.setDropMode(javax.swing.DropMode.INSERT);
        Lsub1.setFocusable(false);
        Lsub1.setValueIsAdjusting(true);

        Lsub2.setModel(modelo2);
        Lsub2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        Lsub2.setDragEnabled(true);
        Lsub2.setDropMode(javax.swing.DropMode.INSERT);
        Lsub2.setFocusable(false);
        Lsub2.setValueIsAdjusting(true);

        CercaB.setText("Fer Cerca!");
        CercaB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CercaBActionPerformed(evt);
            }
        });

        jLabel23.setText("Algorisme:");

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
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Cliqu�");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Dispersio");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        Algorismes.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        Algorismes.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                AlgorismesValueChanged(evt);
            }
        });
        jScrollPane8.setViewportView(Algorismes);

        Cdada.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(383, 383, 383)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(CercaB)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CpcImp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Cpc, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Cdada, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Crelacio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel10)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addGap(18, 18, 18)
                                        .addComponent(Cbusca1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Cafegeix2))
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel14))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(Csembla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Cafegeix1)
                            .addComponent(EliminaCsub)))
                    .addComponent(jLabel15)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Cbusca, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CbuscaCat))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(68, 68, 68)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane7)
                            .addComponent(Cbusca2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CbuscaPag)))
                .addGap(22, 22, 22))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Lsub1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Cafegeix3)
                    .addComponent(jButton9))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel22))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(Lsub2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Cafegeix4)
                            .addComponent(jButton11))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel6)
                                            .addComponent(CercaB))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel11)
                                            .addComponent(Crelacio, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(23, 23, 23)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12)
                                            .addComponent(Csembla, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(Cpc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(7, 7, 7)
                                        .addComponent(CpcImp, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel16)
                                            .addComponent(Cbusca1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Cafegeix2)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(152, 152, 152)
                                        .addComponent(jLabel23)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Cdada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel18))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel20)
                                            .addComponent(jLabel19)))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Cafegeix1)
                                        .addGap(31, 31, 31)
                                        .addComponent(EliminaCsub))
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(Cbusca2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(CbuscaPag))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(Cbusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(CbuscaCat, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cafegeix3)
                    .addComponent(Lsub1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Lsub2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cafegeix4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton9)
                        .addComponent(jLabel21))
                    .addComponent(jButton11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22)
                .addContainerGap(65, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void Cafegeix1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cafegeix1ActionPerformed
        if(LCTotes.getSelectedIndex()>=0) {
            if(!modelo.contains(LCTotes.getSelectedValue())) modelo.addElement(LCTotes.getSelectedValue());
            LCTotes.clearSelection();
        }
        else {
            JOptionPane.showMessageDialog(this, "Has de seleccionar algun element de la llista de categories!", capsalera, WARNING_MESSAGE);
        }
    }//GEN-LAST:event_Cafegeix1ActionPerformed

    private void CbuscaCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbuscaCatActionPerformed
        vista.ompleCategoriesExistentsConcret(LCTotes,Cbusca);
    }//GEN-LAST:event_CbuscaCatActionPerformed

    private void EliminaCsubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminaCsubActionPerformed
        if(modelo.getSize()>0){
            int n = Lsub.getSelectedIndex();
            modelo.removeElementAt(n);
        }
        Lsub.clearSelection();
    }//GEN-LAST:event_EliminaCsubActionPerformed

    private void Cafegeix2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cafegeix2ActionPerformed
        Cbusca1.setText(LCTotes.getSelectedValue().toString());
    }//GEN-LAST:event_Cafegeix2ActionPerformed

    private void CbuscaPagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbuscaPagActionPerformed
        vista.omplePaginesExistentsConcret(LPTotes,Cbusca2);
    }//GEN-LAST:event_CbuscaPagActionPerformed

    private void Cafegeix3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cafegeix3ActionPerformed
        if(!modelo1.contains(LCTotes.getSelectedValue())) modelo1.addElement(LCTotes.getSelectedValue());
        LCTotes.clearSelection();
    }//GEN-LAST:event_Cafegeix3ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if(modelo1.getSize()>0){
            int n = Lsub1.getSelectedIndex();
            modelo1.removeElementAt(n);
        }
        Lsub1.clearSelection();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void Cafegeix4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cafegeix4ActionPerformed
        if(!modelo2.contains(LPTotes.getSelectedValue()))modelo2.addElement(LPTotes.getSelectedValue());
        LPTotes.clearSelection();
    }//GEN-LAST:event_Cafegeix4ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        if(modelo2.getSize()>0){
            int n = Lsub2.getSelectedIndex();
            modelo2.removeElementAt(n);
        }
        Lsub2.clearSelection();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void CercaBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CercaBActionPerformed
        Runnable cerca = new Runnable() {
            public void run() {
                try {
                    if(vista.ferCerca(Algorismes, Cdada, Lsub, Lsub2, Lsub1, CpcImp, Cpc, Csembla, Crelacio, Cbusca1)) {
                        Crelacio.setEnabled(true);
                        Csembla.setEnabled(true);
                        Cpc.setEnabled(true);
                        CpcImp.setEnabled(true);
                        Cafegeix1.setEnabled(true);
                        Cafegeix2.setEnabled(true);
                        Cafegeix3.setEnabled(true);
                        Cafegeix4.setEnabled(true);
                        CercaB.setEnabled(true);
                        
                        if(taula.getSelectedIndex()==4) {
                            pare.visualitzaCercaNova();
                        }
                        else {
                            int resposta = JOptionPane.showConfirmDialog(comp, "La cerca ja ha acabat. vols visualitzar-la ara?", capsalera, YES_NO_OPTION);
                            if(YES_OPTION ==resposta) {
                                guardada=1;
                                pare.visualitzaCercaNova();
                            }
                            else {
                                String nouComen =JOptionPane.showInputDialog(comp,"Escriu el nom de la nova cerca",QUESTION_MESSAGE);
                                guardada=2;
                                macro.getContUser().addNomCerca(macro.getUserActual(), cercaactual, nouComen);
                            }
                        }
                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        };
        hilo = new Thread(cerca);
        hilo.start();
        timer = new Timer(1000, new TimerListener());
        //progressMonitor = new ProgressMonitor(this,"Estem realitzant la cerca de comunitats, si us plau, tingues paci�ncia","",0,arestes);
        timer.start();
        //progressMonitor.setProgress(0);
        //progressMonitor.setMillisToDecideToPopup(2*1000);
        CercaB.setEnabled(false);
        Crelacio.setEnabled(false);
        Csembla.setEnabled(false);
        Cpc.setEnabled(false);
        CpcImp.setEnabled(false);
        Cafegeix1.setEnabled(false);
        Cafegeix2.setEnabled(false);
        Cafegeix3.setEnabled(false);
        Cafegeix4.setEnabled(false);
        /* Espera sp = new Espera();
        sp.setVisible(true);*/
    }//GEN-LAST:event_CercaBActionPerformed

    private void AlgorismesValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_AlgorismesValueChanged

    }//GEN-LAST:event_AlgorismesValueChanged

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        vista.preaparaCreacioNovaCerca(false, LCTotes, LPTotes, Algorismes, Lsub, Lsub2, Lsub1, Cbusca1, Cpc, CpcImp, Csembla, Crelacio, Cdada);
        
        
    }//GEN-LAST:event_formComponentShown


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree Algorismes;
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
    private javax.swing.JSlider Crelacio;
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
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    // End of variables declaration//GEN-END:variables
}
