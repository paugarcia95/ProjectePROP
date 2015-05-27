/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interficie;


//jung

//import static Interficie.InterficiaProva.macro;

import static Interficie.InterficiaProva1.macro;
import static Interficie.InterficiaProva1.comp;
import static Interficie.InterficiaProva1.capsalera;
import static Interficie.InterficiaProva1.cercaactual;
import static Interficie.InterficiaProva1.guardada;
import static Interficie.InterficiaProva1.comunaEliminar;
import static Interficie.InterficiaProva1.userAdmin;


/*import static Interficie.Taules.macro;
import static Interficie.Taules.comp;
import static Interficie.Taules.capsalera;
import static Interficie.Taules.cercaactual;
import static Interficie.Taules.guardada;
import static Interficie.Taules.comunaEliminar;*/


import domini.Categoria;
import domini.GrafDades;
import domini.Pagina;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
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
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.ListModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

/**
 *
 * @author Cristina
 */
public class ControladorVistes1 {
    static JList<String> CategList;  
    static JList<String> PagList; 

    public void jocProves1(){
       Categoria aux1 = new Categoria("sexualitat"); // Prova Sexualitat
	Categoria aux2 = new Categoria("asexual");
	GrafDades G = macro.getGraf();
	G.addCC(aux1,aux2);
	Categoria aux3 = new Categoria("heterosexual");
	G.addCC(aux1,aux3);
	Categoria aux4 = new Categoria("homosexual");
	G.addCC(aux1, aux4);
	Categoria aux5 = new Categoria("sexe");
	G.addCC(aux1,aux5);
	Categoria aux6 = new Categoria("embaras");
	G.addCC(aux3,aux6);
	G.addCC(aux5, aux6);
	Categoria aux7 = new Categoria("infertil");
	G.addCC(aux4, aux7);
	G.addCC(aux2, aux7);
	G.addCC(aux3,aux4);
	Pagina aux0 = new Pagina("esteril");
	G.addPagina(aux0);
        G.addCP(aux7, aux0);
        G.addPC(aux0, aux6);
        Pagina aux8 = new Pagina("eril");
        Categoria aux9 = new Categoria("aillat1");
        Categoria aux10 = new Categoria("aillat2");
       // Categoria aux11 = new Categoria("sexu");
        //G.addCategoria(aux11);
        G.addCC(aux9,aux10);
	G.addPagina(aux8);
   } 
   public void jocProves2(){
       GrafDades G = macro.getGraf();
       Categoria aux1 = new Categoria("sanitat"); // PROVA METGES
			Categoria aux2 = new Categoria("metge");
			G.addCC(aux1, aux2);
			Categoria aux4 = new Categoria("metgessa");
			G.addCC(aux1, aux4);
			Categoria aux6 = new Categoria("uroleg");
			G.addCC(aux2, aux6);
			Pagina aux7 = new Pagina("agulla");
			G.addCP(aux2, aux7);
			G.addCP(aux4, aux7);
			Categoria aux8 = new Categoria("ginecoleg");
			G.addCC(aux4, aux8);
			Categoria aux9 = new Categoria("traumatoleg");
			G.addCC(aux4, aux9);
			G.addCC(aux2, aux9);
			Categoria aux10 = new Categoria("metgos");
			G.addCC(aux2, aux10);
			G.addCC(aux2, aux4);
   }
   public void jocProves3() {
       GrafDades G = macro.getGraf();
       Categoria aux1 = new Categoria("familia"); // Prova familia
			Categoria aux2 = new Categoria("pare");
			G.addCC(aux1,aux2);
			Categoria aux3 = new Categoria("mare");
			G.addCC(aux1,aux3);
			Categoria aux4 = new Categoria("fill");
			G.addCC(aux2,aux4);
			G.addCC(aux3,aux4);
   }
    
    public void guardaDades() {
        JFileChooser input = new JFileChooser();
        int result = input.showSaveDialog(comp);
        if (result == JFileChooser.APPROVE_OPTION) {
            File aux =input.getSelectedFile();
            //macro.getContAdUs().guardaDades(aux);
        }
    }
    public void ompleCategoriesExistents(JList quina){         //es pot millorar efici?ncia (que vagi carregant a mida q es va fent scroll)
        Collection<String> auxc = macro.getContAdUs().getCategories();
        Object[] aux2 = new Object[auxc.size()];
        int cont = 0;
        Iterator<String> it = auxc.iterator();
        while(it.hasNext()) {
            aux2[cont] = it.next();
            ++cont;
        }
        quina.setListData(aux2);
    }
    public void ompleCategoriesExistentsConcret(JList quina, JTextField don){
        String busca = don.getText();
        Collection<String> aux = macro.getContAdUs().getCategories();
        Iterator<String> it = aux.iterator();
        Object[] csub= new Object[aux.size()];
        int cont = 0;
        while(it.hasNext()){
            String nom =it.next();
            if(nom.contains(busca)) {
                csub[cont] = nom;
                ++cont;
            }
        }
        quina.setListData(csub);
    }
    public void omplePaginesExistents(JList quina){
        Collection<String> auxc = macro.getContAdUs().getPagines();
        Object[] aux2 = new Object[auxc.size()];
        int cont = 0;
        Iterator<String> it = auxc.iterator();
        while(it.hasNext()) {
            aux2[cont] = it.next();
            ++cont;
        }
        quina.setListData(aux2);
    }
    public void omplePaginesExistentsConcret(JList quina, JTextField don){
        String busca = don.getText();
        Collection<String> aux = macro.getContAdUs().getPagines();
        Iterator<String> it = aux.iterator();
        Object[] csub= new Object[aux.size()];
        int cont = 0;
        while(it.hasNext()){
            String nom =it.next();
            if(nom.contains(busca)) {
                csub[cont] = nom;
                ++cont;
            }
        }
        quina.setListData(csub);
    }
   
    public void visualitzarCategoriaDe(JList quina){
        if(quina.getSelectedIndices().length>0) {
            String hy = quina.getSelectedValue().toString();
            VCategoria aux = new VCategoria(comp,true,macro.getContUser().isAdmin(macro.getUserActual()));
            CategList = quina;
            aux.NomCat(hy);
        }
        else {
            JOptionPane.showMessageDialog(comp, "Has de seleccionar alguna categoria de la llista!", capsalera, WARNING_MESSAGE);
        }
    }
    public void visualitzarPaginaDe(JList quina){
        if(quina.getSelectedIndices().length>0) {
            String hy = quina.getSelectedValue().toString();
            VPagina aux = new VPagina(comp,true, macro.getContUser().isAdmin(macro.getUserActual()));
            PagList = quina;
            aux.NomPag(hy);
        }
        else {
            JOptionPane.showMessageDialog(comp, "Has de seleccionar alguna p?gina de la llista!", capsalera, WARNING_MESSAGE);
        }
    }
    public void comprovaUsername(JTextField NouUser){
        if(macro.getContUser().existsUser(NouUser.getText())) JOptionPane.showMessageDialog(comp, "Aquest nom d'usuari ja existeix, si us plau, tria'n un altre", capsalera, PLAIN_MESSAGE);
        else JOptionPane.showMessageDialog(comp, "Aquest nom d'usuari est? lliure, endavant", capsalera, PLAIN_MESSAGE);
    }
    public void creaUserNou(JTextField NouUsername, JTextField NovaPassword){
        if(macro.getContUser().existsUser(NouUsername.getText())) {
            JOptionPane.showMessageDialog(comp, "Aquest nom d'usuari ja existeix, si us plau, tria'n un altre", capsalera, WARNING_MESSAGE);
        }
        else if(NovaPassword.getText().length()==0) {
            JOptionPane.showMessageDialog(comp, "Escriu una contrassenya siusplau", capsalera, WARNING_MESSAGE);
        }
        else {
            macro.getContUser().addUser(NouUsername.getText(), NovaPassword.getText());
            JOptionPane.showMessageDialog(comp, "Felicitats, conta creada!", capsalera, WARNING_MESSAGE);
            if(userAdmin) {
                macro.getContUser().addAdmin(NouUsername.getText());
            }
        }
    }
    public void canviaDadesUser(JTextField NouUsername1, JTextField NovaPassword1){
        if(!macro.getUserActual().equals(NouUsername1.getText()) && macro.getContUser().existsUser(NouUsername1.getText())) {
            JOptionPane.showMessageDialog(comp, "Aquest nom d'usuari ja existeix, si us plau, tria'n un altre", capsalera, WARNING_MESSAGE);
        }
        else if(NovaPassword1.getText().length()==0) {
            JOptionPane.showMessageDialog(comp, "Escriu una contrassenya siusplau", capsalera, WARNING_MESSAGE);
        }
        else {
            macro.getContUser().setUsername(macro.getUserActual(), NouUsername1.getText());
            macro.getContUser().setPassword(macro.getUserActual(), NovaPassword1.getText());
            JOptionPane.showMessageDialog(comp, "Felicitats, dades d'usuari canviades!", capsalera, WARNING_MESSAGE);
        }
    }
    public void preaparaCreacioNovaCerca(Boolean modificacio,JList LCTotes, JList LPTotes, JTree Algorismes, JList Lsub, JList Lsub2, JList Lsub1, JTextField Cbusca1, JTextField Cpc, JSlider CpcImp, JSlider Csembla, JSlider Crelacio, JSpinner Cdada){
        if(macro.getContAdUs().getNumCats()<= 0) {
            JOptionPane.showMessageDialog(comp, "No es pot fer cap cerca ja que no hi ha Categories", capsalera, WARNING_MESSAGE);
        }
        else {
        ompleCategoriesExistents(LCTotes);
        omplePaginesExistents(LPTotes);
        Algorismes.expandRow(1);
        Algorismes.expandRow(3);
        Algorismes.expandRow(7);
        Algorismes.setSelectionRow(5);
        int cont;
        if(modificacio) {
            Collection<String> auxs = macro.getContUser().getSubCerca(macro.getUserActual(),cercaactual);
            Object[] aux3 = new Object[auxs.size()];
            cont = 0;
            Iterator<String> it3 = auxs.iterator();
            while(it3.hasNext()) {
                aux3[cont] = it3.next();
                ++cont;
            }
            Lsub.setListData(aux3);
            
            Collection<String> auxs2 = macro.getContUser().getEvitaPagCerca(macro.getUserActual(),cercaactual);
            Object[] aux5 = new Object[auxs2.size()];
            cont = 0;
            Iterator<String> it5 = auxs2.iterator();
            while(it5.hasNext()) {
                aux5[cont] = it5.next();
                ++cont;
            }
            Lsub2.setListData(aux3);
            
            Collection<String> auxs1 = macro.getContUser().getEvitaCatCerca(macro.getUserActual(),cercaactual);
            Object[] aux4 = new Object[auxs1.size()];
            cont = 0;
            Iterator<String> it4 = auxs1.iterator();
            while(it4.hasNext()) {
                aux4[cont] = it4.next();
                ++cont;
            }
            Lsub1.setListData(aux3);
            
            Cbusca1.setText(macro.getContUser().getPareCerca(macro.getUserActual(),cercaactual));
            Cpc.setText(macro.getContUser().getParaulaClauCerca(macro.getUserActual(),cercaactual));
            CpcImp.setValue(macro.getContUser().getParaulaImpCerca(macro.getUserActual(),cercaactual));
            Csembla.setValue(macro.getContUser().getSembCerca(macro.getUserActual(),cercaactual));
            Crelacio.setValue(macro.getContUser().getRelacioCerca(macro.getUserActual(),cercaactual));
            Cdada.setValue(macro.getContUser().getAlgDadaCerca(macro.getUserActual(),cercaactual));
            Integer alg = macro.getContUser().getAlgCerca(macro.getUserActual(),cercaactual);
            if(alg==1) Algorismes.setSelectionRow(2);
            else if(alg==2) {
                Integer tipus= macro.getContUser().getAlgTipuCerca(macro.getUserActual(),cercaactual);
                if(tipus==1) Algorismes.setSelectionRow(4);
                else if(tipus==2)Algorismes.setSelectionRow(5);
                else Algorismes.setSelectionRow(6);
            }
            else Algorismes.setSelectionRow(8);
        }
        else {
            guardada=0;
            Lsub.removeAll();
            Lsub1.removeAll();
            Lsub2.removeAll();
            Cbusca1.removeAll();
            Cpc.removeAll();
            CpcImp.setValue(0);
            Csembla.setValue(5);
            Crelacio.setValue(5);
            Cdada.setValue(0);
        }
        }
    }
    public void afegirFitxer(){
        JFileChooser input = new JFileChooser();
        int result = input.showOpenDialog(comp);
        if (result == JFileChooser.APPROVE_OPTION) {
            File aux =input.getSelectedFile();
                if(aux != null) {
                try {
                    System.out.println(aux);
                    long abans =System.currentTimeMillis();
                    macro.carregaDadesFitxer(aux);
                    long despres = System.currentTimeMillis();
                    System.out.println("Temps carregar fitxer: "+(despres-abans));
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ControladorVistes.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
                else System.out.println("Error, el fitxer es buit");
        }
    }
    public void visualitzaCerca(Boolean guardada,JTree arbre, JTextArea on) {
        //PREPAREM LA VISUALITZACIO D'AQUESTA CERCA
        //comunaEliminar = new PriorityQueue<>(1, Collections.reverseOrder());
    //ARBRE
        DefaultMutableTreeNode arrel = new DefaultMutableTreeNode("Comunitats Obtingudes");
        DefaultTreeModel Model = new DefaultTreeModel(arrel);
       // Resultat.setModel(treeModel);
        Integer numcom =  macro.getContUser().getNumComunitatsCerca(macro.getUserActual(), cercaactual);
	//System.out.println("Hi ha "+numcom+ " comunitats: ");
	for(Integer i = 1; i <= numcom; ++i) {
           // System.out.println("	A la " + i+ " comunitat hi ha les categories: ");
            DefaultMutableTreeNode prim = new DefaultMutableTreeNode("Comunitat "+i);
            arrel.add(prim);
            ArrayList<String> auxm = macro.getContUser().getCatCerca(macro.getUserActual(), cercaactual, i-1);
            Iterator<String> it4 = auxm.iterator();
            while(it4.hasNext()) {
                String nom = it4.next();
                DefaultMutableTreeNode seg = new DefaultMutableTreeNode(nom);
                prim.add(seg);
            }
	}
        arbre.setModel(Model);
        
        for (int i = 0; i < arbre.getRowCount(); i++) arbre.expandRow(i);

    //TEXT AREA
        //Preparem els strings en cada cas
        String algorisme;
        int algo = macro.getContUser().getAlgCerca(macro.getUserActual(), cercaactual);
        if(algo==1) algorisme = "Louvain";
        else if(algo==2) algorisme = "Girvan-Newman";
        else algorisme = "Clique";
        String tipu;
        algo = macro.getContUser().getAlgTipuCerca(macro.getUserActual(), cercaactual);
        if(algo==1) tipu= "Dispersio";
        else if(algo==2) tipu="Num Comunitats";
        else tipu="Max Betw";
        //Preparem les categories seleccionades
        int cont = 0;
        ArrayList<String> aux = macro.getContUser().getSubCerca(macro.getUserActual(), cercaactual);
        StringBuilder sb = new StringBuilder();
        for(String nom:aux) {
            sb.append("\n   "+(cont+1)+". "+nom);
            ++cont;
        }
        String subcat = sb.toString();
        //Preparem les categories a evitar
        cont = 0;
        ArrayList<String> aux2 = macro.getContUser().getEvitaCatCerca(macro.getUserActual(), cercaactual);
        StringBuilder sb2 = new StringBuilder();
        for(String nom:aux2) {
            sb2.append("\n   "+(cont+1)+". "+nom);
            ++cont;
        }
        String evita = sb2.toString();
        //Preparem les pagines a evitar
        cont = 0;
        ArrayList<String> aux3 = macro.getContUser().getEvitaPagCerca(macro.getUserActual(), cercaactual);
        StringBuilder sb3 = new StringBuilder();
        for(String nom:aux3) {
            sb3.append("\n   "+(cont+1)+". "+nom);
            ++cont;
        }
        String ignora = sb3.toString();
        //Imprimim
        String guard = "";
        if(guardada)  {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Nom: "+macro.getContUser().getNomCerca(macro.getUserActual(), cercaactual));
            sb4.append("\nComentari: "+macro.getContUser().getComentariCerca(macro.getUserActual(), cercaactual));
            sb4.append("\nData creació: "+macro.getContUser().getDataCreacioCerca(macro.getUserActual(), cercaactual));
            Date data = macro.getContUser().getDataModificacioCerca(macro.getUserActual(), cercaactual);
            //System.out.println("COMPARACIO DATES: "+data.compareTo(new Date()));
            if(data== null ) sb4.append("\nData ultima modificació: encara no s'ha modificat\n");
            else sb4.append("\nData ultima modificació: "+data +"\n");
            guard=sb4.toString();
        }
        on.setText(guard+"Algorisme: "+algorisme+"\nTipus de valor: "+tipu+"\nAmb la dada: "+macro.getContUser().getAlgDadaCerca(macro.getUserActual(), cercaactual)+
                "\nImportancia realci?: "+macro.getContUser().getRelacioCerca(macro.getUserActual(), cercaactual)+
                "\nImportancia semblan?a de noms: "+macro.getContUser().getSembCerca(macro.getUserActual(), cercaactual)+
                "\nParaula clau: "+macro.getContUser().getParaulaClauCerca(macro.getUserActual(), cercaactual)+
                "\n     Amb import?ncia: "+macro.getContUser().getParaulaImpCerca(macro.getUserActual(), cercaactual)+
                "\nCategoria pare:"+macro.getContUser().getPareCerca(macro.getUserActual(), cercaactual)+
                "\nConjunt de categories seleccionades:"+subcat+
                "\nConjunt de categories ignorades:"+evita+
                "\nConjunt de p?gines a ignorar:"+ignora);
    }
    public Boolean ferCerca(JTree Algorismes, JSpinner Cdada, JList Lsub, JList Lsub2, JList Lsub1, JSlider CpcImp, JTextField Cpc, JSlider Csembla, JSlider Crelacio, JTextField Cbusca1){
        long t1,t2;
 //FEM LA CERCA       
        if(guardada!=3)cercaactual = macro.getContUser().addNovaCerca(macro.getUserActual());
        Integer quin, tipus;
       t1= System.currentTimeMillis();
        TreePath arbre =Algorismes.getSelectionModel().getSelectionPath();
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) Algorismes.getLastSelectedPathComponent();

        if(arbre.equals(null)) {
            JOptionPane.showMessageDialog(comp, "Has de seleccionar un algorisme i tipus de cerca", capsalera, WARNING_MESSAGE);
            return false;
        }
        if(!node.isLeaf()){
            JOptionPane.showMessageDialog(comp, "Has de seleccionar un tipus d'execució de l'algorisme!", capsalera, WARNING_MESSAGE);
            return false;
        }
        if(arbre.getPathComponent(1).toString().equals("Louvain")) {
            quin=1;
            tipus=0;
         //   System.out.println("Louvain: quin 1 i tipus 0");
        }
        else if(arbre.getPathComponent(1).toString().equals("Newman-Girvan")) {
            quin=2;
            if(arbre.getPathComponent(2).toString().equals("Dispersio")) tipus=1;
            else if(arbre.getPathComponent(2).toString().equals("Numero Categories")) tipus=2;
            else tipus =3;
        //    System.out.println("Newman-Girvan: quin 2 i tipus "+tipus);
        }
        else {
            quin=3;
            tipus=0;
         //   System.out.println("Newman-Girvan: quin "+quin+" i tipus "+tipus);
        }
        Integer num =(Integer)Cdada.getValue();
        ListModel m = Lsub.getModel();
        ListModel m2 = Lsub1.getModel();
        ListModel m3 = Lsub2.getModel();
        int mida = m.getSize();
      //  System.out.println("Has seleccionat "+mida+" i es: "+ m.toString());
        int cont = 0;
        ArrayList<String> auxx1 = new ArrayList<String>();
        ArrayList<String> auxx2 = new ArrayList<String>();
        ArrayList<String> auxx3 = new ArrayList<String>();
        while (cont < mida) {
            auxx1.add(m.getElementAt(cont).toString());
            ++cont;
        }
       // System.out.println("mida aux1: "+mida);
       // mida = aux2.length-1;
        cont = 0;
        mida = m2.getSize();
        while (cont < mida) {
            auxx2.add(m2.getElementAt(cont).toString());
            ++cont;
        }
     //   System.out.println("mida aux2: "+mida);
      //   mida = aux3.length-1;
        cont = 0;
        mida = m3.getSize();
        while (cont < mida) {
            auxx3.add(m3.getElementAt(cont).toString());
            ++cont;
        }
       // System.out.println("mida aux3: "+mida);
        if(CpcImp.getValue()==0) Cpc.setText(new String());
        System.out.println("Fem la cerca amb "+macro.getContAdUs().getNumCats()+" categories i "+macro.getContAdUs().getNumPags()+" p?gines.");
        System.out.println("Alg: "+quin+", tipus: "+tipus+", user: "+macro.getUserActual()+ ", cerca num: "+cercaactual+", numDada: "+num+", paraula clau: "+ Cpc.getText()+", importancia pc: "+ CpcImp.getValue()+", imp relacio: "+ Crelacio.getValue()+", imp sembla: "+  Csembla.getValue()+", lsub: "+ auxx1+", lsub1: " +auxx2+", lsub2: "+auxx3+", cbusca1: "+ Cbusca1.getText());
        macro.getContUser().addCriterisCerca(false, macro.getUserActual(), cercaactual, Cpc.getText(), CpcImp.getValue(), Crelacio.getValue(), Csembla.getValue(), quin, tipus, num, auxx1, auxx2, auxx3, Cbusca1.getText());
       // System.out.println("he arribat aqui");
        macro.getContUser().ferCerca(macro.getUserActual(), cercaactual);
       // System.out.println("i he fet la cerca!");
       t2= System.currentTimeMillis();
       System.out.println("Temps total cerca: "+ (t2-t1));
        return true;
    }
    public void carregaCerquesFetes(JTextField jTextField7,JList LlistaCerques){
        jTextField7.setText("Tens "+macro.getContUser().getNumCerquesUser(macro.getUserActual())+" cerques fetes");
        Collection<String> auxc = macro.getContUser().getCerquesComunitats(macro.getUserActual());
        System.out.println("Les cerques son: "+auxc);
        Object[] aux2 = new Object[auxc.size()];
        int cont = 0;
        Iterator<String> it = auxc.iterator();
        while(it.hasNext()) {
            aux2[cont] = it.next();
            ++cont;
        }
        LlistaCerques.setListData(aux2);
    }
    public void carregaUsers(DefaultListModel UsersAct) {
        ArrayList<String> auxc = macro.getContUser().getUsers();
        for(String us: auxc)UsersAct.addElement(us);
        
      /*  ArrayList<String> auxc = macro.getContUser().getUsers();;
        Object[] aux2 = new Object[auxc.size()];
        int cont = 0;
        Iterator<String> it = auxc.iterator();
        while(it.hasNext()) {
            aux2[cont] = it.next();
            ++cont;
        }
        UsersAct.setListData(aux2);*/
    }
    
    
    public void treuCatComun(JTree Resultat, DefaultListModel modelos){
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) Resultat.getLastSelectedPathComponent();
    if (node == null)JOptionPane.showMessageDialog(comp, "Has de seleccionar una categoria!", capsalera, WARNING_MESSAGE);
    else {
    DefaultMutableTreeNode pare = (DefaultMutableTreeNode)node.getParent();
    if (!pare.equals(node.getRoot())) {
        Integer num = Integer.parseInt(pare.toString().substring(10))-1;
        System.out.println("Vull eliminar de la comunitat: " +num+" la categoria "+node.toString());
        if(!macro.getContUser().removeCatComunitatCerca(macro.getUserActual(), cercaactual, num,node.toString() )) System.out.println("ERROR en eliminar");
        
        DefaultTreeModel aux = (DefaultTreeModel)Resultat.getModel();
         modelos.addElement(node.toString());
        aux.removeNodeFromParent(node);
        if(macro.getContUser().getNumCatComunitatCerca(macro.getUserActual(),cercaactual,num)==0) {
            System.out.println("Ordeno eliminar a la comunitat "+num);
            comunaEliminar.add(num);
            //macro.getContUser().removeComunitatCerca(macro.getUserActual(),cercaactual,num);
            aux.removeNodeFromParent(pare);
        }
    } else {
        JOptionPane.showMessageDialog(comp, "Has de seleccionar una categoria, no una comunitat!", capsalera, WARNING_MESSAGE);
    }
    }
    }
        
    public void afegeixCatComun(JTree Resultat,DefaultListModel modelos, JList Penjades) {
    if(Penjades.getSelectedIndex()>=0) {
        DefaultTreeModel nou = (DefaultTreeModel)Resultat.getModel();
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) Resultat.getLastSelectedPathComponent();
        //macro.getContUser().get
        if (node == null)JOptionPane.showMessageDialog(comp, "Has de seleccionar a quina comunitat vols afegir la comunitat seleccionada!", capsalera, WARNING_MESSAGE);
        else {
            Integer num;
        TreeNode pare = node.getParent();
        if (!pare.equals(node.getRoot())) {
            nou.insertNodeInto(new DefaultMutableTreeNode(Penjades.getSelectedValue().toString()), (MutableTreeNode)pare, pare.getChildCount());
            num = Integer.parseInt(pare.toString().substring(10))-1;
        }
        else {
            nou.insertNodeInto(new DefaultMutableTreeNode(Penjades.getSelectedValue().toString()), (MutableTreeNode)node, node.getChildCount());
            num = Integer.parseInt(node.toString().substring(10))-1;
 
            System.out.println("Afegeixo a la comunitat "+node.toString().substring(10)+" la categoria"+Penjades.getSelectedValue().toString());
        }
        System.out.println("Vull afegir a la comunitat: " +num);
        if(!macro.getContUser().addCatComunitatCerca(macro.getUserActual(), cercaactual, num,Penjades.getSelectedValue().toString())) System.out.println("ERROR en afegir");
        if(comunaEliminar.contains(num)){
            comunaEliminar.remove(num);
            System.out.println("Trec de la llista d'eliminar a "+num);
        }
        modelos.remove(Penjades.getSelectedIndex());
        }
        }
        else JOptionPane.showMessageDialog(comp, "Has de seleccionar quina categoria vols afegir!", capsalera, WARNING_MESSAGE);

    }
    public static void main(String[] args) {
         Interficie.InterficiaProva1 aux = new Interficie.InterficiaProva1();
        //InterficieFinal aux = new InterficieFinal(); 
       //Interficie.Interficia1 aux = new Interficie.Interficia1();
        aux.setVisible(true);
         
   }
    
    
}
