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
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.PriorityQueue;
import java.util.Set;
import javax.swing.JButton;
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
    static Interficie.ControladorRafa rafa;
    static Integer cercaactual;
    String algorisme;
    static Integer guardada;
    static String capsalera = "Wiki";
    static javax.swing.JTabbedPane AP_Afegeix = new javax.swing.JTabbedPane();
    static javax.swing.JPanel A_Afegeix = new javax.swing.JPanel();
    //guardada=0 -> nova cerca sense guardar, crearla
    //guardada=1  -> cerca no guardada, preguntar si la volen guardar
    //guardada=2 -> cerca guardada
    //guardada=3 -> volem sobreescriue una cerca ja guardada
    //guardada=4 -> volem modificar una cerca sense guardar, no se'n poden fer de noves!
    Boolean primera; //variable per evitar excepcions en els pannels que tenen accions en amagar
    static Integer auxguard;
    //auxguard= 0 -> es pot crear una nova cerca sense problemes
    //auxguard= 1 -> s'ha de sobrescriure la cerca cercaactual
    //auxguard= 2 -> no es pot crear cap nova cerca, ja n'hi ha una sense guardar
    static ControladorVistes1 vista;
    static Frame comp;
    //int pos;
    //private ProgressMonitor progressMonitor;
   public static Boolean userAdmin;
   public static PriorityQueue<Integer> comunaEliminar;
   public static Thread hilo;
   public static Boolean interrumput;
   
   
  //public void guardaCerca(Component quin) {}
   public void activaCerca(){
       AP_Client.setEnabledAt(4, true);
   }
   public void activaEspera() {
       Panell = new PantallaEspera(this);
       AP_Client.setComponentAt(4, Panell);
   }
   public void desactivaEspera() {
       Panell = new CreaComunitat(this,AP_Client);
       AP_Client.setComponentAt(4, Panell);
   }
   public void cancelaCerca(){
       hilo.interrupt();
       interrumput = true;
       //hilo.st
   }
   public void canviarACercaGuardada(){
      AP_Cerques.remove(AP_Cerques.getSelectedIndex());
      System.out.println("Guardem la cerca i auxguard= 0");
      auxguard = 0;
      AP_Client.setEnabledAt(4, true);
      AP_Cerques.setEnabledAt(0, true);
      /* for(int i = 0; i < AP_Cerques.getComponentCount(); ++i) {
         AP_Cerques.setEnabledAt(i, true);
       }*/
      visualitzaCercaAntiga();
   } 
   public void canviaNomTaula(String nouNom){
        AP_Cerques.setTitleAt(AP_Cerques.getSelectedIndex(), nouNom);
    }
   public void creaAdminNou(){
       Panell = new NouUser(this);
       AP_Client.setComponentAt(8, Panell);
   }
   public void eliminaTab(Component quin){
       AP_Cerques.remove(quin);
   }
   public Boolean espotvisualitzar(String nom) {
       for(int i = 1; i < AP_Cerques.getComponentCount(); ++i) {
            if(AP_Cerques.getTitleAt(i).equals(nom)) return false;
       }
       return true;
   }
   public void modificaCercaGuardada(){
       AP_Client.setEnabledAt(4, true);
       System.out.println("Vull modificar una cerca ja existent, auxguard = 1");
       auxguard = 1;
       AP_Client.setSelectedIndex(4);
   }
   public void novaCerca(){
       AP_Client.setEnabledAt(4, true);
       auxguard = 0;
       AP_Client.setSelectedIndex(4);
   }
   public void obreOpcions(){
     //  if(macro.getContUser().isAdmin(macro.getUserActual())) A_OpcionsAdmin.setVisible(true);
     //  else A_OpcionsClient.setVisible(true);
   }{
    System.out.println("Aqui crido a la funcio obreOpcions de InterficiaProva1, s'ha d'implementar");  
    /* guardada = 2;
       Panell = new GuardaCerca(this);
       AP_Cerques.setComponentAt(AP_Cerques.getSelectedIndex(), Panell);
       */
       //AP_Cerques.remove(quin);
   } 
   private void provisional(){
        Username.setText("admin");
        Password.setText("admin");
       
        macro.getContUser().addUser("admin", "admin");
	macro.getContUser().addUser("client", "client");
	macro.getContUser().addAdmin("admin");
        vista.jocProves1();
   }
  /* public void retornaCreacioAdmins(){
   if(userAdmin) {
            userAdmin=false;
            A_VeureUsers = new VeureUsers(this);
            
           /* AP_Principal.setVisible(false);
            AP_Client.setVisible(true);
            //A_OpcionsAdmin.setVisible(true);
        }
        else {
            AP_Principal.setSelectedIndex(0);
        }  
   }*/
   public void revalidaCerques(){
       AP_Cerques.setSelectedIndex(0);
   }
   public void tornaVeureUsers(){
      Panell = new VeureUsers(this);
      AP_Client.setComponentAt(8, Panell);
    }
   public void visualitzaCercaAntiga() {
       javax.swing.JPanel Panells = new VeureCercaAntiga(this, cercaactual);
       AP_Cerques.add(Panells, macro.getContUser().getNomCerca(macro.getUserActual(), cercaactual));
       AP_Cerques.setSelectedComponent(Panells);
   }  
   public void visualitzaCercaNova() {
       System.out.println("Visualitzacio cerac nova, auxguard: "+auxguard);
       if(auxguard!=1) {
           Panell = new VeureNovaCerca(this, cercaactual);
           AP_Cerques.add(Panell, "Sense guardar");
       }
       System.out.println("Visualitzacio cerac nova, posem auxguard a 2 ");
       auxguard = 2;
       AP_Client.setSelectedIndex(5);
       AP_Cerques.setSelectedIndex(AP_Cerques.getComponentCount()-1);
       AP_Client.setEnabledAt(4, false);
   }
   public void login(){
       
        String user, pass;
        user= Username.getText();
        pass= Password.getText();
        userAdmin=true;
        if(!macro.getContUser().existsUser(user)) JOptionPane.showMessageDialog(this, "L'username no existeix, torna'l a introduir o crea una nova conta.", capsalera, WARNING_MESSAGE);
        else if(macro.getContUser().login(user, pass)){
            macro.setUserActual(user);
            auxguard = 0;
            if(primera) {
                A_CerquesGuardades = new VeureCerques(this);
                AP_Cerques.add(A_CerquesGuardades, "Totes");
                AP_Client.add(AP_Cerques, "Cerques guardades");
                Panell = new CanviaDadesUser();
                AP_Client.add(Panell, "Dades d'usuari"); 
                primera = false;
            }
            else {
                // AP_Client.setComponentAt(6, A_CanviaDadesUser);
            }
            if(macro.getContUser().isAdmin(user)) {
                rafa.ini();
                AP_Client.add(AP_Afegeix, "Afegeix");
                A_VeureUsers = new VeureUsers(this);
                AP_Client.add(A_VeureUsers, "Usuaris existents");
              //  AP_Client.add(A_CreaUsuari, "Nou admin");
            }
            AP_Client.setVisible(true);
            AP_Principal.setVisible(false);
            AP_Client.setSelectedIndex(0);
            
        }
        else {
            JOptionPane.showMessageDialog(this, "La contrassenya es incorrecta.", capsalera, ERROR_MESSAGE);
        }
    }
   public void logout(){
       AP_Client.setVisible(false);
       //Panell = new NouUser(this);
       AP_Principal.add(A_CreaUsuari, "Crea nou usuari");
       AP_Principal.setVisible(true);
       if(AP_Client.getComponentCount()>7) {
        AP_Client.remove(8);
        AP_Client.remove(7);
       }
        userAdmin=false;
      // AP_Client.remove(A_CreaUsuari);
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
        rafa = new ControladorRafa();
        comp = this;
        userAdmin= false;
        initComponents();
        this.setVisible(false);
        Panell = new Inici(this);
        AP_Client.add(Panell, "Inici");
        Panell = new BuscaCat(this);
        AP_Client.add(Panell, "Categories");
        Panell = new BuscaPag(this);
        AP_Client.add(Panell, "Pàgines");
        Panell = new BuscaCatPag(this);
        AP_Client.add(Panell, "Categories i pagines");
        Panell = new CreaComunitat(this,AP_Client);
        AP_Client.add(Panell, "Fer Cerca");
       /* A_BuscaCat = new BuscaCat(this);
        AP_Client.add(A_BuscaCat, "Categories");
        A_BuscaPag = new BuscaPag(this);
        AP_Client.add(A_BuscaPag, "Pàgines");
        A_BuscaCatPag = new BuscaCatPag(this);
        AP_Client.add(A_BuscaCatPag, "Categories i pagines");
        A_CreaComunitat = new CreaComunitat(this,AP_Client);
        AP_Client.add(A_CreaComunitat, "Fer Cerca");*/
        //A_VisualitzaCerques = new VeureNovaCerca(this);
        
        //jPanel1.setVisible(false);
        provisional();
        
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
        Panell = new javax.swing.JPanel();
        AP_Cerques = new javax.swing.JTabbedPane();
        A_FerCerca = new javax.swing.JPanel();
        A_CerquesGuardades = new javax.swing.JPanel();
        A_VeureUsers = new javax.swing.JPanel();
        A_NouAdmin = new javax.swing.JPanel();

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
                .addContainerGap(1010, Short.MAX_VALUE))
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
                .addContainerGap(242, Short.MAX_VALUE))
        );

        Username.getAccessibleContext().setAccessibleName("Username");

        AP_Principal.addTab("Iniciar Sessió", A_PantallaPrincipal);

        A_CreaUsuari.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                A_CreaUsuariComponentShown(evt);
            }
        });

        jLabel7.setText("Creació d'un nou usuari");

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
                .addGap(34, 34, 34)
                .addGroup(A_CreaUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
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
                        .addComponent(NovaPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(1078, Short.MAX_VALUE))
        );
        A_CreaUsuariLayout.setVerticalGroup(
            A_CreaUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(A_CreaUsuariLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
        getContentPane().add(AP_Client, "card16");

        javax.swing.GroupLayout PanellLayout = new javax.swing.GroupLayout(Panell);
        Panell.setLayout(PanellLayout);
        PanellLayout.setHorizontalGroup(
            PanellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1532, Short.MAX_VALUE)
        );
        PanellLayout.setVerticalGroup(
            PanellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
        );

        getContentPane().add(Panell, "card18");

        AP_Cerques.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(AP_Cerques, "card16");

        A_FerCerca.setAlignmentX(A_PantallaPrincipal.getAlignmentX());
        A_FerCerca.setAlignmentY(A_PantallaPrincipal.getAlignmentY());

        javax.swing.GroupLayout A_FerCercaLayout = new javax.swing.GroupLayout(A_FerCerca);
        A_FerCerca.setLayout(A_FerCercaLayout);
        A_FerCercaLayout.setHorizontalGroup(
            A_FerCercaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1532, Short.MAX_VALUE)
        );
        A_FerCercaLayout.setVerticalGroup(
            A_FerCercaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
        );

        getContentPane().add(A_FerCerca, "card3");

        javax.swing.GroupLayout A_CerquesGuardadesLayout = new javax.swing.GroupLayout(A_CerquesGuardades);
        A_CerquesGuardades.setLayout(A_CerquesGuardadesLayout);
        A_CerquesGuardadesLayout.setHorizontalGroup(
            A_CerquesGuardadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1532, Short.MAX_VALUE)
        );
        A_CerquesGuardadesLayout.setVerticalGroup(
            A_CerquesGuardadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
        );

        getContentPane().add(A_CerquesGuardades, "card13");

        javax.swing.GroupLayout A_VeureUsersLayout = new javax.swing.GroupLayout(A_VeureUsers);
        A_VeureUsers.setLayout(A_VeureUsersLayout);
        A_VeureUsersLayout.setHorizontalGroup(
            A_VeureUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1532, Short.MAX_VALUE)
        );
        A_VeureUsersLayout.setVerticalGroup(
            A_VeureUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
        );

        getContentPane().add(A_VeureUsers, "card10");

        javax.swing.GroupLayout A_NouAdminLayout = new javax.swing.GroupLayout(A_NouAdmin);
        A_NouAdmin.setLayout(A_NouAdminLayout);
        A_NouAdminLayout.setHorizontalGroup(
            A_NouAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1532, Short.MAX_VALUE)
        );
        A_NouAdminLayout.setVerticalGroup(
            A_NouAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
        );

        getContentPane().add(A_NouAdmin, "card18");

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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        vista.creaUserNou(NouUsername, NovaPassword);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        vista.comprovaUsername(NouUsername.getText());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void A_CreaUsuariComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_A_CreaUsuariComponentShown
        NouUsername.setText("");
        NovaPassword.setText("");
    }//GEN-LAST:event_A_CreaUsuariComponentShown

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
//public javax.swing.JTabbedPane AP_Afegeix;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane AP_Cerques;
    private javax.swing.JTabbedPane AP_Client;
    private javax.swing.JTabbedPane AP_Principal;
    private javax.swing.JPanel A_CerquesGuardades;
    private javax.swing.JPanel A_CreaUsuari;
    private javax.swing.JPanel A_FerCerca;
    private javax.swing.JPanel A_NouAdmin;
    private javax.swing.JPanel A_PantallaPrincipal;
    private javax.swing.JPanel A_VeureUsers;
    private javax.swing.JButton Exit;
    private javax.swing.JButton Login;
    private javax.swing.JTextField NouUsername;
    private javax.swing.JTextField NovaPassword;
    private javax.swing.JPanel Panell;
    private javax.swing.JTextField Password;
    private javax.swing.JTextField Username;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}