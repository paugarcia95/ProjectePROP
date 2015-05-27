/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interficie;

import java.util.Collection;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;
import static cercaComunitats.AlgorismeNewmanGirvan.arestes;
import static cercaComunitats.AlgorismeNewmanGirvan.iterador;
import domini.Categoria;
import domini.GrafDades;
import domini.MacroControlador;
import domini.Pagina;
import java.awt.Component;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.PriorityQueue;
import java.util.Set;
import javax.swing.JList;
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
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.ProgressMonitor;
import javax.swing.Timer;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

/**
 *
 * @author Cristina
 */
public class InterficiaProva1 extends javax.swing.JFrame {
    static domini.MacroControlador macro;
    static Integer cercaactual;
    String algorisme;
    static Integer guardada;
    static String capsalera = "Wiki";
    //guardada=0 -> nova cerca sense guardar, crearla
    //guardada=1  -> cerca no guardada, preguntar si la volen guardar
    //guardada=2 -> cerca guardada
    //guardada=3 -> volem sobreescriue una cerca ja guardada
    Boolean primera; //variable per evitar excepcions en els pannels que tenen accions en amagar
    static ControladorVistes1 vista;
    static Frame comp;
    //int pos;
    //private ProgressMonitor progressMonitor;
   public static Boolean userAdmin;
   public static PriorityQueue<Integer> comunaEliminar;
   
   public void guardaCerca(Component quin, int num){
       guardada = 2;
       A_GuardaCerca = new GuardaCerca(this);
       AP_Cerques.setComponentAt(AP_Cerques.getSelectedIndex(), quin);
       //AP_Cerques.remove(quin);
   } 
   public void visualitzaCercaAntiga() {
       A_VisualitzacioCercaAntiga = new VeureCercaAntiga(this);
       AP_Cerques.add(A_VisualitzacioCercaAntiga, macro.getContUser().getNomCerca(macro.getUserActual(), cercaactual));
   }   
    
   public void visualitzaCercaNova() {
       NovaCerca = new VeureNovaCerca(this);
       //AP_Client.add(A_VisualitzaNovaCerca, 5);
       AP_Cerques.add(NovaCerca, "Sense guardar");
       //AP_Client.setComponentAt(5, A_VisualitzaNovaCerca);
       //AP_Client.revalidate();
       AP_Client.setSelectedIndex(5);
       AP_Cerques.setSelectedIndex(AP_Cerques.getComponentCount()-1);
   }
   private void provisional(){
        Username.setText("admin");
        Password.setText("admin");
       
        macro.getContUser().addUser("admin", "admin");
	macro.getContUser().addUser("client", "client");
	macro.getContUser().addAdmin("admin");
        vista.jocProves1();
   }
   
   public final void obreOpcions(){
       if(macro.getContUser().isAdmin(macro.getUserActual())) A_OpcionsAdmin.setVisible(true);
       else A_OpcionsClient.setVisible(true);
   }
   public void login(){
        String user, pass;
        user= Username.getText();
        pass= Password.getText();
        if(!macro.getContUser().existsUser(user)) {
            JOptionPane.showMessageDialog(this, "L'username no existeix, torna'l a introduir o crea una nova conta.", capsalera, WARNING_MESSAGE);
        }
        else if(macro.getContUser().login(user, pass)){
            //A_PantallaPrincipal.setVisible(false);
            AP_Principal.setVisible(false);
            //AP_Principal.setEnabled(false);
            macro.setUserActual(user);
            AP_Client.setVisible(true);
            
            A_VisualitzaCerques = new VeureCerques(this);
        AP_Cerques.add(A_VisualitzaCerques, "Totes");
        AP_Client.add(AP_Cerques, "Cerques guardades");
        A_CanviaDadesUser = new CanviaDadesUser();
        AP_Client.add(A_CanviaDadesUser, "Dades d'usuari");
            
            
            if(macro.getContUser().isAdmin(user)) {
                jPanel1 = new Afegeix();
                AP_Client.add(jPanel1, "Afegeix");
                A_VeureUsers = new VeureUsers(this);
                AP_Client.add(A_VeureUsers, "Usuaris existents");
                AP_Client.add(A_CreaUsuari, "Nou admin");
            }
            
        }
        else {
            JOptionPane.showMessageDialog(this, "La contrassenya es incorrecta.", capsalera, ERROR_MESSAGE);
        }
    }
   public final void logout(){
       AP_Principal.setVisible(true);
       AP_Client.setVisible(false);
   }
   /**
     * Creates new form InterficiaProva
     */

    public InterficiaProva1() {
        //macro = new domini.MacroControlador();
        primera=true;
        comunaEliminar = new PriorityQueue<>();
        macro = new MacroControlador();
        vista = new ControladorVistes1();
        comp = this;
        userAdmin=false;
        initComponents();
        this.setVisible(false);
        A_Inici = new Inici(this);
        AP_Client.add(A_Inici, "Inici");
        A_BuscaCat = new BuscaCat(this);
        AP_Client.add(A_BuscaCat, "Categories");
        A_BuscaPag = new BuscaPag(this);
        AP_Client.add(A_BuscaPag, "Pàgines");
        A_BuscaCatPag = new Cat_Pag(this);
        AP_Client.add(A_BuscaCatPag, "Categories i pagines");
        A_CreaComunitat = new CreaComunitat(this,AP_Client);
        AP_Client.add(A_CreaComunitat, "Fer Cerca");
        //A_VisualitzaCerques = new VeureNovaCerca(this);
        
        //jPanel1.setVisible(false);
        provisional();
        
    }
    
    private void addAfegeix(){
        
    }
            
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AP_Principal = new javax.swing.JTabbedPane();
        A_PantallaPrincipal = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        Exit = new javax.swing.JButton();
        Login = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Username = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Password = new javax.swing.JTextField();
        A_CreaUsuari = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        NouUsername = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        NovaPassword = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        AP_Client = new javax.swing.JTabbedPane();
        A_Inici = new javax.swing.JPanel();
        AP_Cerques = new javax.swing.JTabbedPane();
        A_BuscaCat = new javax.swing.JPanel();
        A_BuscaPag = new javax.swing.JPanel();
        A_BuscaCatPag = new javax.swing.JPanel();
        A_CreaComunitat = new javax.swing.JPanel();
        A_VisualitzaCerques = new javax.swing.JPanel();
        A_CanviaDadesUser = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        A_VeureUsers = new javax.swing.JPanel();
        Enrere8 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        modusers = new DefaultListModel();
        UsersAct = new javax.swing.JList();
        jButton19 = new javax.swing.JButton();
        A_VisualitzaNovaCerca = new javax.swing.JPanel();
        A_GuardaCerca = new javax.swing.JPanel();
        A_VisualitzacioCercaAntiga = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("WIKIPEDIA");
        setLocationByPlatform(true);
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.TOOLKIT_EXCLUDE);
        getContentPane().setLayout(new java.awt.CardLayout());

        jLabel3.setText("Benvingut al programa de la wikipedia");

        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });

        Login.setText("Login");
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });

        jLabel1.setText("Si us plau, entra les teves dades. Si encara no tens cap usuari assignat, pots Crear-ne un de nou :)");

        jLabel2.setText("Username:");

        jLabel4.setText("Password:");

        javax.swing.GroupLayout A_PantallaPrincipalLayout = new javax.swing.GroupLayout(A_PantallaPrincipal);
        A_PantallaPrincipal.setLayout(A_PantallaPrincipalLayout);
        A_PantallaPrincipalLayout.setHorizontalGroup(
            A_PantallaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(A_PantallaPrincipalLayout.createSequentialGroup()
                .addGroup(A_PantallaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(A_PantallaPrincipalLayout.createSequentialGroup()
                        .addGap(255, 255, 255)
                        .addComponent(jLabel3))
                    .addGroup(A_PantallaPrincipalLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(A_PantallaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(A_PantallaPrincipalLayout.createSequentialGroup()
                                .addGroup(A_PantallaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(A_PantallaPrincipalLayout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(Username, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(A_PantallaPrincipalLayout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(35, 35, 35)
                                .addGroup(A_PantallaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Login)
                                    .addComponent(Exit))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        A_PantallaPrincipalLayout.setVerticalGroup(
            A_PantallaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(A_PantallaPrincipalLayout.createSequentialGroup()
                .addGroup(A_PantallaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(A_PantallaPrincipalLayout.createSequentialGroup()
                        .addGap(226, 226, 226)
                        .addGroup(A_PantallaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(Login))
                        .addGap(20, 20, 20)
                        .addGroup(A_PantallaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Exit)))
                    .addGroup(A_PantallaPrincipalLayout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jLabel3)
                        .addGap(70, 70, 70)
                        .addComponent(jLabel1)))
                .addContainerGap(102, Short.MAX_VALUE))
        );

        Username.getAccessibleContext().setAccessibleName("Username");

        AP_Principal.addTab("Iniciar Sessió", A_PantallaPrincipal);

        jLabel7.setText("Creació d'un nou usuari");

        NouUsername.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                NouUsernameComponentShown(evt);
            }
        });

        jLabel8.setText("Username");

        jButton1.setText("Comproba Disponibilitat");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel9.setText("Password");

        jButton2.setText("Crea");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout A_CreaUsuariLayout = new javax.swing.GroupLayout(A_CreaUsuari);
        A_CreaUsuari.setLayout(A_CreaUsuariLayout);
        A_CreaUsuariLayout.setHorizontalGroup(
            A_CreaUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(A_CreaUsuariLayout.createSequentialGroup()
                .addGroup(A_CreaUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(A_CreaUsuariLayout.createSequentialGroup()
                        .addGap(272, 272, 272)
                        .addComponent(jLabel7))
                    .addGroup(A_CreaUsuariLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(A_CreaUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(A_CreaUsuariLayout.createSequentialGroup()
                                .addGroup(A_CreaUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(A_CreaUsuariLayout.createSequentialGroup()
                                        .addGap(116, 116, 116)
                                        .addComponent(jButton2))
                                    .addGroup(A_CreaUsuariLayout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(38, 38, 38)
                                        .addComponent(NouUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(31, 31, 31)
                                .addComponent(jButton1))
                            .addGroup(A_CreaUsuariLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(40, 40, 40)
                                .addComponent(NovaPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(1078, Short.MAX_VALUE))
        );
        A_CreaUsuariLayout.setVerticalGroup(
            A_CreaUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(A_CreaUsuariLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel7)
                .addGap(40, 40, 40)
                .addGroup(A_CreaUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NouUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jButton1))
                .addGroup(A_CreaUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, A_CreaUsuariLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(NovaPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(A_CreaUsuariLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel9)
                        .addGap(35, 35, 35)))
                .addComponent(jButton2)
                .addContainerGap(322, Short.MAX_VALUE))
        );

        AP_Principal.addTab("Crea nou usuari", A_CreaUsuari);

        getContentPane().add(AP_Principal, "card17");

        AP_Client.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                AP_ClientComponentShown(evt);
            }
        });
        getContentPane().add(AP_Client, "card16");

        javax.swing.GroupLayout A_IniciLayout = new javax.swing.GroupLayout(A_Inici);
        A_Inici.setLayout(A_IniciLayout);
        A_IniciLayout.setHorizontalGroup(
            A_IniciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1532, Short.MAX_VALUE)
        );
        A_IniciLayout.setVerticalGroup(
            A_IniciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
        );

        getContentPane().add(A_Inici, "card18");
        getContentPane().add(AP_Cerques, "card16");

        A_BuscaCat.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                A_BuscaCatComponentShown(evt);
            }
        });

        javax.swing.GroupLayout A_BuscaCatLayout = new javax.swing.GroupLayout(A_BuscaCat);
        A_BuscaCat.setLayout(A_BuscaCatLayout);
        A_BuscaCatLayout.setHorizontalGroup(
            A_BuscaCatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1532, Short.MAX_VALUE)
        );
        A_BuscaCatLayout.setVerticalGroup(
            A_BuscaCatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
        );

        getContentPane().add(A_BuscaCat, "card7");

        A_BuscaPag.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                A_BuscaPagComponentShown(evt);
            }
        });

        javax.swing.GroupLayout A_BuscaPagLayout = new javax.swing.GroupLayout(A_BuscaPag);
        A_BuscaPag.setLayout(A_BuscaPagLayout);
        A_BuscaPagLayout.setHorizontalGroup(
            A_BuscaPagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1532, Short.MAX_VALUE)
        );
        A_BuscaPagLayout.setVerticalGroup(
            A_BuscaPagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
        );

        getContentPane().add(A_BuscaPag, "card8");

        A_BuscaCatPag.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                A_BuscaCatPagformComponentShown(evt);
            }
        });

        javax.swing.GroupLayout A_BuscaCatPagLayout = new javax.swing.GroupLayout(A_BuscaCatPag);
        A_BuscaCatPag.setLayout(A_BuscaCatPagLayout);
        A_BuscaCatPagLayout.setHorizontalGroup(
            A_BuscaCatPagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1532, Short.MAX_VALUE)
        );
        A_BuscaCatPagLayout.setVerticalGroup(
            A_BuscaCatPagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
        );

        getContentPane().add(A_BuscaCatPag, "card13");

        A_CreaComunitat.setAlignmentX(A_PantallaPrincipal.getAlignmentX());
        A_CreaComunitat.setAlignmentY(A_PantallaPrincipal.getAlignmentY());

        javax.swing.GroupLayout A_CreaComunitatLayout = new javax.swing.GroupLayout(A_CreaComunitat);
        A_CreaComunitat.setLayout(A_CreaComunitatLayout);
        A_CreaComunitatLayout.setHorizontalGroup(
            A_CreaComunitatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1532, Short.MAX_VALUE)
        );
        A_CreaComunitatLayout.setVerticalGroup(
            A_CreaComunitatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
        );

        getContentPane().add(A_CreaComunitat, "card3");

        A_VisualitzaCerques.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                A_VisualitzaCerquesComponentHidden(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                A_VisualitzaCerquesComponentShown(evt);
            }
        });

        javax.swing.GroupLayout A_VisualitzaCerquesLayout = new javax.swing.GroupLayout(A_VisualitzaCerques);
        A_VisualitzaCerques.setLayout(A_VisualitzaCerquesLayout);
        A_VisualitzaCerquesLayout.setHorizontalGroup(
            A_VisualitzaCerquesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1532, Short.MAX_VALUE)
        );
        A_VisualitzaCerquesLayout.setVerticalGroup(
            A_VisualitzaCerquesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
        );

        getContentPane().add(A_VisualitzaCerques, "card13");

        A_CanviaDadesUser.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                A_CanviaDadesUserComponentShown(evt);
            }
        });

        javax.swing.GroupLayout A_CanviaDadesUserLayout = new javax.swing.GroupLayout(A_CanviaDadesUser);
        A_CanviaDadesUser.setLayout(A_CanviaDadesUserLayout);
        A_CanviaDadesUserLayout.setHorizontalGroup(
            A_CanviaDadesUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1532, Short.MAX_VALUE)
        );
        A_CanviaDadesUserLayout.setVerticalGroup(
            A_CanviaDadesUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
        );

        getContentPane().add(A_CanviaDadesUser, "card15");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1532, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, "card10");

        A_VeureUsers.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                A_VeureUsersComponentHidden(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                A_VeureUsersComponentShown(evt);
            }
        });

        Enrere8.setText("Enrere");
        Enrere8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Enrere8ActionPerformed(evt);
            }
        });

        jLabel17.setText("Aquests són els usuaris actuals:");

        jButton17.setText("Elimina");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setText("Fer Admin");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        UsersAct.setModel(modusers);
        UsersAct.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        UsersAct.setDragEnabled(true);
        UsersAct.setDropMode(javax.swing.DropMode.INSERT);
        UsersAct.setFocusable(false);
        UsersAct.setValueIsAdjusting(true);

        jButton19.setText("Crea un nou usuari Administrador");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout A_VeureUsersLayout = new javax.swing.GroupLayout(A_VeureUsers);
        A_VeureUsers.setLayout(A_VeureUsersLayout);
        A_VeureUsersLayout.setHorizontalGroup(
            A_VeureUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(A_VeureUsersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(A_VeureUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(A_VeureUsersLayout.createSequentialGroup()
                        .addComponent(UsersAct, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(A_VeureUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(A_VeureUsersLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jButton17))
                            .addGroup(A_VeureUsersLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(A_VeureUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton19)
                                    .addComponent(Enrere8)
                                    .addComponent(jButton18))))
                        .addGap(0, 1080, Short.MAX_VALUE))
                    .addGroup(A_VeureUsersLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(93, 93, 93))))
        );
        A_VeureUsersLayout.setVerticalGroup(
            A_VeureUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(A_VeureUsersLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addGroup(A_VeureUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(A_VeureUsersLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(UsersAct, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(A_VeureUsersLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jButton17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Enrere8)
                        .addContainerGap(386, Short.MAX_VALUE))))
        );

        getContentPane().add(A_VeureUsers, "card10");

        A_VisualitzaNovaCerca.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                A_VisualitzaNovaCercaComponentHidden(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                A_VisualitzaNovaCercaComponentShown(evt);
            }
        });

        javax.swing.GroupLayout A_VisualitzaNovaCercaLayout = new javax.swing.GroupLayout(A_VisualitzaNovaCerca);
        A_VisualitzaNovaCerca.setLayout(A_VisualitzaNovaCercaLayout);
        A_VisualitzaNovaCercaLayout.setHorizontalGroup(
            A_VisualitzaNovaCercaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1532, Short.MAX_VALUE)
        );
        A_VisualitzaNovaCercaLayout.setVerticalGroup(
            A_VisualitzaNovaCercaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
        );

        getContentPane().add(A_VisualitzaNovaCerca, "card11");

        A_GuardaCerca.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                A_GuardaCercaComponentShown(evt);
            }
        });

        javax.swing.GroupLayout A_GuardaCercaLayout = new javax.swing.GroupLayout(A_GuardaCerca);
        A_GuardaCerca.setLayout(A_GuardaCercaLayout);
        A_GuardaCercaLayout.setHorizontalGroup(
            A_GuardaCercaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1532, Short.MAX_VALUE)
        );
        A_GuardaCercaLayout.setVerticalGroup(
            A_GuardaCercaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
        );

        getContentPane().add(A_GuardaCerca, "card12");

        A_VisualitzacioCercaAntiga.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                A_VisualitzacioCercaAntigaComponentHidden(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                A_VisualitzacioCercaAntigaComponentShown(evt);
            }
        });

        javax.swing.GroupLayout A_VisualitzacioCercaAntigaLayout = new javax.swing.GroupLayout(A_VisualitzacioCercaAntiga);
        A_VisualitzacioCercaAntiga.setLayout(A_VisualitzacioCercaAntigaLayout);
        A_VisualitzacioCercaAntigaLayout.setHorizontalGroup(
            A_VisualitzacioCercaAntigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1532, Short.MAX_VALUE)
        );
        A_VisualitzacioCercaAntigaLayout.setVerticalGroup(
            A_VisualitzacioCercaAntigaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
        );

        getContentPane().add(A_VisualitzacioCercaAntiga, "card14");

        getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
        login();
    }//GEN-LAST:event_LoginActionPerformed
    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_ExitActionPerformed
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        vista.comprovaUsername(NouUsername);
    }//GEN-LAST:event_jButton1ActionPerformed
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        vista.creaUserNou(NouUsername, NovaPassword);
        if(userAdmin) {
                userAdmin=false;
                AP_Principal.setVisible(false);
                AP_Client.setVisible(true);
                //A_OpcionsAdmin.setVisible(true);
        }
        else {
            AP_Principal.setSelectedIndex(0);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void Enrere8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Enrere8ActionPerformed
        A_VeureUsers.setVisible(false);
        A_OpcionsAdmin.setVisible(true);
    }//GEN-LAST:event_Enrere8ActionPerformed
    private void A_GuardaCercaComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_A_GuardaCercaComponentShown
       jTextField5.setText("");
       jTextField6.setText("");
    }//GEN-LAST:event_A_GuardaCercaComponentShown
    private void NouUsernameComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_NouUsernameComponentShown
        NouUsername.setText("");
        NovaPassword.setText("");
    }//GEN-LAST:event_NouUsernameComponentShown
    private void A_VeureUsersComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_A_VeureUsersComponentShown
        vista.carregaUsers(modusers);
        
    }//GEN-LAST:event_A_VeureUsersComponentShown

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        if(UsersAct.getSelectedIndices().length>0) {
            Boolean segueix = true;
            if(UsersAct.getSelectedValue().toString().equals("admin")) JOptionPane.showMessageDialog(this, "Aquest usuari no es pot eliminar", capsalera, WARNING_MESSAGE);
            else {
            if(UsersAct.getSelectedValue().toString().equals(macro.getUserActual())) {
                int resposta = JOptionPane.showConfirmDialog(this, "Segur que vols eliminar-te a tu mateix?", capsalera, YES_NO_OPTION);
                if(resposta==YES_OPTION) {
                    A_PantallaPrincipal.setVisible(true);
                    A_VeureUsers.setVisible(false);
                }
                else  segueix = false;
            }
            if(segueix) {
            macro.getContUser().removeUser(UsersAct.getSelectedValue().toString());
            modusers.removeElement(UsersAct.getSelectedValue().toString());
            }
            }
        }
        else JOptionPane.showMessageDialog(this, "Has de seleccionar quin usuari vols eliminar!", capsalera, WARNING_MESSAGE);

    }//GEN-LAST:event_jButton17ActionPerformed
    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        if(UsersAct.getSelectedIndices().length>0) {
            macro.getContUser().addAdmin(UsersAct.getSelectedValue().toString());
            JOptionPane.showMessageDialog(this, "Felicitats, aquest usuari ja és admin!", capsalera, WARNING_MESSAGE);
        }
        else JOptionPane.showMessageDialog(this, "Has de seleccionar quin usuari vols fer admninistrador!", capsalera, WARNING_MESSAGE);

    }//GEN-LAST:event_jButton18ActionPerformed
    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        userAdmin = true;
        A_CreaUsuari.setVisible(true);
        A_VeureUsers.setVisible(false);
    }//GEN-LAST:event_jButton19ActionPerformed

    private void A_VeureUsersComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_A_VeureUsersComponentHidden
        modusers.removeAllElements();
    }//GEN-LAST:event_A_VeureUsersComponentHidden

    private void A_VisualitzaNovaCercaComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_A_VisualitzaNovaCercaComponentShown
        comunaEliminar = new PriorityQueue<>(1, Collections.reverseOrder());
    }//GEN-LAST:event_A_VisualitzaNovaCercaComponentShown

    private void A_VisualitzaNovaCercaComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_A_VisualitzaNovaCercaComponentHidden
       System.out.print("Elimino les comunitats:");
        while(!comunaEliminar.isEmpty()) {
            System.out.print(" "+comunaEliminar.peek());
            macro.getContUser().removeComunitatCerca(macro.getUserActual(),cercaactual,comunaEliminar.poll());
        }
        System.out.println();
    }//GEN-LAST:event_A_VisualitzaNovaCercaComponentHidden

    private void A_VisualitzacioCercaAntigaComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_A_VisualitzacioCercaAntigaComponentShown
        comunaEliminar = new PriorityQueue<>(1, Collections.reverseOrder());
    }//GEN-LAST:event_A_VisualitzacioCercaAntigaComponentShown

    private void A_VisualitzacioCercaAntigaComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_A_VisualitzacioCercaAntigaComponentHidden
        System.out.print("Elimino les comunitats:");
        while(!comunaEliminar.isEmpty()) {
            System.out.print(" "+comunaEliminar.peek());
            macro.getContUser().removeComunitatCerca(macro.getUserActual(),cercaactual,comunaEliminar.poll());
        }
        System.out.println();
    }//GEN-LAST:event_A_VisualitzacioCercaAntigaComponentHidden

    private void A_CanviaDadesUserComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_A_CanviaDadesUserComponentShown
        NouUsername1.setText(macro.getUserActual());
        NovaPassword1.setText("");
    }//GEN-LAST:event_A_CanviaDadesUserComponentShown

    private void A_VisualitzaCerquesComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_A_VisualitzaCerquesComponentShown
        vista.carregaCerquesFetes(jTextField7, LlistaCerques);
    }//GEN-LAST:event_A_VisualitzaCerquesComponentShown

    private void A_VisualitzaCerquesComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_A_VisualitzaCerquesComponentHidden
        try {
            cercaactual= macro.getContUser().getNumCerca(macro.getUserActual(), LlistaCerques.getSelectedValue().toString());
        }
        catch(Exception prime){

        }
    }//GEN-LAST:event_A_VisualitzaCerquesComponentHidden

    private void A_BuscaCatPagformComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_A_BuscaCatPagformComponentShown
        vista.omplePaginesExistents(LlistaPag1);
        vista.ompleCategoriesExistents(LlistaCateg1);
    }//GEN-LAST:event_A_BuscaCatPagformComponentShown

    private void A_BuscaPagComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_A_BuscaPagComponentShown
        vista.omplePaginesExistents(LlistaPag);
    }//GEN-LAST:event_A_BuscaPagComponentShown

    private void A_BuscaCatComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_A_BuscaCatComponentShown
        vista.ompleCategoriesExistents(LlistaCateg);
    }//GEN-LAST:event_A_BuscaCatComponentShown

    private void AP_ClientComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_AP_ClientComponentShown
        
    }//GEN-LAST:event_AP_ClientComponentShown

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
            java.util.logging.Logger.getLogger(InterficiaProva1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterficiaProva1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterficiaProva1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterficiaProva1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterficiaProva1()/*.setVisible(true)*/;
            }
        });
    }

    private javax.swing.JPanel NovaCerca;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane AP_Cerques;
    private javax.swing.JTabbedPane AP_Client;
    private javax.swing.JTabbedPane AP_Principal;
    private javax.swing.JPanel A_BuscaCat;
    private javax.swing.JPanel A_BuscaCatPag;
    private javax.swing.JPanel A_BuscaPag;
    private javax.swing.JPanel A_CanviaDadesUser;
    private javax.swing.JPanel A_CreaComunitat;
    private javax.swing.JPanel A_CreaUsuari;
    private javax.swing.JPanel A_GuardaCerca;
    private javax.swing.JPanel A_Inici;
    private javax.swing.JPanel A_PantallaPrincipal;
    private javax.swing.JPanel A_VeureUsers;
    private javax.swing.JPanel A_VisualitzaCerques;
    private javax.swing.JPanel A_VisualitzaNovaCerca;
    private javax.swing.JPanel A_VisualitzacioCercaAntiga;
    private javax.swing.JButton Enrere8;
    private javax.swing.JButton Exit;
    private javax.swing.JButton Login;
    private javax.swing.JTextField NouUsername;
    private javax.swing.JTextField NovaPassword;
    private javax.swing.JTextField Password;
    private javax.swing.JTextField Username;
    private javax.swing.JList UsersAct;
    private DefaultListModel modusers;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}