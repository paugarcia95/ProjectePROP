/*
 * Controlador de la interficie
 */
package Interficie;

import static Interficie.InterficieWiki.macro;
import static Interficie.InterficieWiki.comp;
import static Interficie.InterficieWiki.capsalera;
import static Interficie.InterficieWiki.cercaactual;
import static Interficie.InterficieWiki.auxguard;
import static Interficie.InterficieWiki.userAdmin;
import static Interficie.InterficieWiki.comunaEliminar;

import domini.Categoria;
import domini.GrafDades;
import domini.Pagina;
import java.awt.Frame;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import javax.swing.DefaultListModel;
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
 * @author cristina.fontanet
 */
public class ControladorVistes {
    static JList<String> CategList;  
    static JList<String> PagList; 
    
    
    protected void afegeixCatComun(JTree Resultat,DefaultListModel modelos, JList Penjades, Integer cercaaqui) {
    if(Penjades.getSelectedIndex()>=0) {
        DefaultTreeModel nou = (DefaultTreeModel)Resultat.getModel();
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) Resultat.getLastSelectedPathComponent();
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
           }
            if(!macro.getContUser().addCatComunitatCerca(macro.getUserActual(), cercaaqui, num,Penjades.getSelectedValue().toString())) System.out.println("ERROR en afegir");
            if(comunaEliminar.contains(num))comunaEliminar.remove(num); 
            modelos.remove(Penjades.getSelectedIndex());
            Penjades.setSelectedIndex(0);
        }
    }
    else JOptionPane.showMessageDialog(comp, "Has de seleccionar quina categoria vols afegir!", capsalera, WARNING_MESSAGE);
    }
    
    protected Boolean afegirFitxer(){
        JFileChooser input = new JFileChooser();
        int result = input.showOpenDialog(comp);
        if (result == JFileChooser.APPROVE_OPTION) {
            File aux =input.getSelectedFile();
                if(aux != null) { 
                    if(!macro.carregaDadesFitxer(aux)) {
                        JOptionPane.showMessageDialog(comp, macro.getMissatgeError(), capsalera, ERROR_MESSAGE);
                        return false;
                    };
                }
                else {
                    System.out.println("Error, el fitxer es buit");
                    return false;
                }
        }
        return true;
    }
    
    protected void canviaDadesUser(JTextField NouUsername1, JTextField NovaPassword1){
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
    
    protected void carregaCerquesFetes(JTextField jTextField7,JList LlistaCerques){
        DefaultListModel llista = (DefaultListModel)LlistaCerques.getModel();
        boolean noguardat = false;
        ArrayList<String> aux = macro.getContUser().getCerquesComunitats(macro.getUserActual());
        llista.removeAllElements();
        for(String cerca: aux) {
            if(cerca!=null) llista.addElement(cerca);
            else noguardat = true;
        }
        if(noguardat)jTextField7.setText("Tens "+(macro.getContUser().getNumCerquesUser(macro.getUserActual())-1)+" cerques fetes");
        else jTextField7.setText("Tens "+macro.getContUser().getNumCerquesUser(macro.getUserActual())+" cerques fetes");
    }
    
    protected void carregaUsers(DefaultListModel UsersAct) {
        ArrayList<String> auxc = macro.getContUser().getUsers();
        UsersAct.removeAllElements();
        for(String us: auxc) {
            if(macro.getContUser().isAdmin(us))UsersAct.addElement(us.concat(" [ad]"));
            else UsersAct.addElement(us);
        }
    }
    
    protected void comprovaUsername(String NouUser){
        if(macro.getContUser().existsUser(NouUser)) JOptionPane.showMessageDialog(comp, "Aquest nom d'usuari ja existeix, si us plau, tria'n un altre", capsalera, PLAIN_MESSAGE);
        else JOptionPane.showMessageDialog(comp, "Aquest nom d'usuari esta lliure, endavant", capsalera, PLAIN_MESSAGE);
    }
    
    protected void creaUserNou(JTextField NouUsername, JTextField NovaPassword){
        if(NouUsername.getText().length()==0) JOptionPane.showMessageDialog(comp, "Escriu un nom d'usuari siusplau", capsalera, ERROR_MESSAGE);
        else if (NouUsername.getText().contains("|")||NouUsername.getText().contains("/")||NouUsername.getText().contains("\\")||NouUsername.getText().contains(":")||NouUsername.getText().contains("*")||NouUsername.getText().contains("?")||NouUsername.getText().contains("<")||NouUsername.getText().contains(">")||NouUsername.getText().contains("+")||NouUsername.getText().contains("\"")) JOptionPane.showMessageDialog(comp, "El nom d'usuari conté algun caràcter prohibit", capsalera, ERROR_MESSAGE);
        else if(macro.getContUser().existsUser(NouUsername.getText()))  JOptionPane.showMessageDialog(comp, "Aquest nom d'usuari ja existeix, si us plau, tria'n un altre", capsalera, WARNING_MESSAGE);
        else if(NovaPassword.getText().length()==0) JOptionPane.showMessageDialog(comp, "Escriu una contrassenya siusplau", capsalera, ERROR_MESSAGE);
        else if(NovaPassword.getText().contains("|")||NovaPassword.getText().contains("*")||NovaPassword.getText().contains("+")) JOptionPane.showMessageDialog(comp, "La contrassenya conté algun caràcter prohibit", capsalera, ERROR_MESSAGE);
        else {
            macro.getContUser().addUser(NouUsername.getText(), NovaPassword.getText());
            if(userAdmin) macro.getContUser().addAdmin(NouUsername.getText());
            else if(!macro.getContUser().existsAdmin()) {
                macro.getContUser().addAdmin(NouUsername.getText());
                JOptionPane.showMessageDialog(comp, "Felicitats, conta creada, ets administrador!", capsalera,INFORMATION_MESSAGE);
            }
            else JOptionPane.showMessageDialog(comp, "Felicitats, conta creada.", capsalera,INFORMATION_MESSAGE);
        }
    } 
    
    protected Boolean espoteliminar(String nom){
        return !nom.contains("[ad]");
    }
    
    protected Boolean ferCerca(JTree Algorismes, Integer Cdada, JList Lsub, JList Lsub2, JList Lsub1, Integer CpcImp, JTextField Cpc, Integer Csembla, Integer CrelacioCat, JTextField Cbusca1,Integer CrelacioPag,Integer CrelacioSuper, Integer CrelacioSub){
 long t1,t2;
 //RECOLLIM LES DADES PER A FER LA CERCA       
        if(auxguard==0)cercaactual = macro.getContUser().addNovaCerca(macro.getUserActual());
        Integer quin, tipus;
 t1= System.currentTimeMillis(); ////////////////////////////////////////////
        TreePath arbre =Algorismes.getSelectionModel().getSelectionPath();
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) Algorismes.getLastSelectedPathComponent();

        if(arbre == null) {
            JOptionPane.showMessageDialog(comp, "Has de seleccionar un algorisme i tipus de cerca", capsalera, WARNING_MESSAGE);
            return false;
        }
        if(!node.isLeaf()){
            JOptionPane.showMessageDialog(comp, "Has de seleccionar un tipus d'execució de l'algorisme!", capsalera, WARNING_MESSAGE);
            return false;
        }
        switch(arbre.getPathComponent(1).toString()) {
            case "Louvain": 
                quin=1;
                tipus=1;
                break;
            case "Newman-Girvan":
                quin=2;
                switch(arbre.getPathComponent(2).toString()) {
                    case "Dispersio":
                        tipus=1;
                        break;
                    case "Numero Categories":
                        tipus = 2;
                        break;
                    default:
                        tipus = 3;
                        break;
                }
                break;
            default:
                quin=3;
                tipus=1;
                break;
        }
        ListModel m = Lsub.getModel();
        ListModel m2 = Lsub1.getModel();
        ListModel m3 = Lsub2.getModel();
        int mida = m.getSize();
        int cont = 0;
        ArrayList<String> auxx1 = new ArrayList<String>();
        ArrayList<String> auxx2 = new ArrayList<String>();
        ArrayList<String> auxx3 = new ArrayList<String>();
        while (cont < mida) {
            auxx1.add(m.getElementAt(cont).toString());
            ++cont;
        }
        
        cont = 0;
        mida = m2.getSize();
        while (cont < mida) {
            auxx2.add(m2.getElementAt(cont).toString());
            ++cont;
        }
        
        cont = 0;
        mida = m3.getSize();
        while (cont < mida) {
            auxx3.add(m3.getElementAt(cont).toString());
            ++cont;
        }
        if(CpcImp==0) Cpc.setText(new String());
        ///////////////////////////////////////////////////////////////////////////////////////
        macro.getContUser().addCriterisCerca(false, macro.getUserActual(), cercaactual, Cpc.getText(), CpcImp, CrelacioCat, Csembla, quin, tipus, Cdada, auxx1, auxx2, auxx3, Cbusca1.getText(), CrelacioPag, CrelacioSuper, CrelacioSub);
                                                
        macro.getContUser().ferCerca(macro.getUserActual(), cercaactual);
       
 t2= System.currentTimeMillis();
 System.out.println("Temps total cerca: "+ (t2-t1));
       macro.getContUser().ordenaCerca(macro.getUserActual(), cercaactual);
        return true;
    }
    
    protected void netejaArbreCerca(Integer numcerca) {
        while(!comunaEliminar.isEmpty()) {
            if(!macro.getContUser().removeComunitatCerca(macro.getUserActual(),numcerca,comunaEliminar.poll()))JOptionPane.showMessageDialog(comp, "Hi ha hagut un error en eliminar una comunitat!", capsalera, ERROR_MESSAGE);
        }
    }
//es pot millorar eficiencia (que vagi carregant a mida q es va fent scroll)   
    protected void ompleCategoriesExistents(JList quina){         
        Collection<String> auxc = macro.getContDades().getCategories();
        Object[] aux2 = new Object[auxc.size()];
        int cont = 0;
        Iterator<String> it = auxc.iterator();
        while(it.hasNext()) {
            aux2[cont] = it.next();
            ++cont;
        }
        quina.setListData(aux2);
    }
    
    protected void ompleCategoriesExistentsConcret(JList quina, JTextField don){
        String busca = don.getText();
        Collection<String> aux = macro.getContDades().getCategories();
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
    
    protected void omplePaginesExistents(JList quina){
        Collection<String> auxc = macro.getContDades().getPagines();
        Object[] aux2 = new Object[auxc.size()];
        int cont = 0;
        Iterator<String> it = auxc.iterator();
        while(it.hasNext()) {
            aux2[cont] = it.next();
            ++cont;
        }
        quina.setListData(aux2);
    }
    
    protected void omplePaginesExistentsConcret(JList quina, JTextField don){
        String busca = don.getText();
        Collection<String> aux = macro.getContDades().getPagines();
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
    
    protected void omplePantallaEspera(JTextArea quin){
        ompleCriteris(quin, cercaactual,false);
    }
    
    protected void preaparaCreacioNovaCerca(Boolean modificacio,JList LCTotes, JList LPTotes, JTree Algorismes, JList Lsub, JList Lsub2, JList Lsub1, JTextField Cbusca1, JTextField Cpc, JSlider CpcImp, JSlider Csembla, JSlider CrelacioCat, JSpinner Cdada,JSlider CrelacioPag,JSlider CrelacioSuper, JSlider CrelacioSub){
        if(macro.getContDades().getNumCats()<= 0)  JOptionPane.showMessageDialog(comp, "No es pot fer cap cerca ja que no hi ha Categories", capsalera, WARNING_MESSAGE);
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
            Lsub2.setListData(aux5);
            
            Collection<String> auxs1 = macro.getContUser().getEvitaCatCerca(macro.getUserActual(),cercaactual);
            Object[] aux4 = new Object[auxs1.size()];
            cont = 0;
            Iterator<String> it4 = auxs1.iterator();
            while(it4.hasNext()) {
                aux4[cont] = it4.next();
                ++cont;
            }
            Lsub1.setListData(aux4);
            
            Cbusca1.setText(macro.getContUser().getPareCerca(macro.getUserActual(),cercaactual));
            Cpc.setText(macro.getContUser().getParaulaClauCerca(macro.getUserActual(),cercaactual));
            CpcImp.setValue(macro.getContUser().getParaulaImpCerca(macro.getUserActual(),cercaactual));
            Csembla.setValue(macro.getContUser().getSembCerca(macro.getUserActual(),cercaactual));
            CrelacioCat.setValue(macro.getContUser().getRelacioCatCerca(macro.getUserActual(),cercaactual));
            CrelacioPag.setValue(macro.getContUser().getRelacioPagCerca(macro.getUserActual(), cercaactual));
            CrelacioSub.setValue(macro.getContUser().getRelacionsSubsCerca(macro.getUserActual(),cercaactual));
            CrelacioSuper.setValue(macro.getContUser().getRelacionsSuperCerca(macro.getUserActual(),cercaactual));
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
            Lsub.removeAll();
            Lsub1.removeAll();
            Lsub2.removeAll();
            Cbusca1.removeAll();
            Cpc.removeAll();
            CpcImp.setValue(0);
            Cpc.setText("");
            Csembla.setValue(5);
            CrelacioCat.setValue(5);
            CrelacioPag.setValue(5);
            CrelacioSub.setValue(5);
            CrelacioSuper.setValue(5);
            Cdada.setValue(0);
        }
        }
    } 
    
    protected void treuCatComun(JTree Resultat, DefaultListModel modelos, Integer cercaaqui){
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) Resultat.getLastSelectedPathComponent();
        if (node == null|| node.isRoot())JOptionPane.showMessageDialog(comp, "Has de seleccionar una categoria!", capsalera, WARNING_MESSAGE);
        else {
        DefaultMutableTreeNode pare = (DefaultMutableTreeNode)node.getParent();
        if (!pare.equals(node.getRoot())) {
            Integer num = Integer.parseInt(pare.toString().substring(10))-1;
            if(!macro.getContUser().removeCatComunitatCerca(macro.getUserActual(), cercaaqui, num,node.toString() )) System.out.println("ERROR en eliminar");
        
            DefaultTreeModel aux = (DefaultTreeModel)Resultat.getModel();
            modelos.addElement(node.toString());
            aux.removeNodeFromParent(node);
            if(macro.getContUser().getNumCatComunitatCerca(macro.getUserActual(),cercaaqui,num)==0) {
                comunaEliminar.add(num);
                aux.removeNodeFromParent(pare);
            }
        } else  JOptionPane.showMessageDialog(comp, "Has de seleccionar una categoria, no una comunitat!", capsalera, WARNING_MESSAGE);
        }
    }   
    
    protected void visualitzarCategoriaCerca(Frame pare, JTree Resultat1) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) Resultat1.getLastSelectedPathComponent();
        if (node == null|| node.isRoot())JOptionPane.showMessageDialog(comp, "Has de seleccionar una categoria!", capsalera, WARNING_MESSAGE);
        else {
            DefaultMutableTreeNode pares = (DefaultMutableTreeNode)node.getParent();
            if (!pares.equals(node.getRoot())) {
                String quina = node.toString();
                VCategoria nova = new VCategoria(pare, true,macro.getContUser().isAdmin(macro.getUserActual()));
                nova.NomCat(quina);
            } 
            else  JOptionPane.showMessageDialog(comp, "Has de seleccionar una categoria, no una comunitat!", capsalera, WARNING_MESSAGE);
        }
    }
    
    protected void visualitzarCategoriaDe(JList quina){
        if(quina.getSelectedIndices().length>0) {
            String hy = quina.getSelectedValue().toString();
            VCategoria aux = new VCategoria(comp,true,macro.getContUser().isAdmin(macro.getUserActual()));
            aux.NomCat(hy);
        }
        else JOptionPane.showMessageDialog(comp, "Has de seleccionar alguna categoria de la llista!", capsalera, WARNING_MESSAGE);
    }
    
    protected void visualitzarPaginaDe(JList quina){
        if(quina.getSelectedIndices().length>0) {
            String hy = quina.getSelectedValue().toString();
           VPagina nova = new VPagina(comp, true, macro.getContUser().isAdmin(macro.getUserActual()));
            nova.NomPag(hy);
        }
        else JOptionPane.showMessageDialog(comp, "Has de seleccionar alguna p?gina de la llista!", capsalera, WARNING_MESSAGE);
    }
    
    protected void ompleCriteris(JTextArea on, Integer cercaaqui, Boolean guardada) {
        //Preparem els strings en cada cas
        String algorisme;
        int algo = macro.getContUser().getAlgCerca(macro.getUserActual(), cercaaqui);
        if(algo==1) algorisme = "Louvain";
        else if(algo==2) algorisme = "Girvan-Newman";
        else algorisme = "Clique";
        String tipu;
        algo = macro.getContUser().getAlgTipuCerca(macro.getUserActual(), cercaaqui);
        if(algo==1) tipu= "Dispersio";
        else if(algo==2) tipu="Num Comunitats";
        else tipu="Max Betw";
        
        //Preparem les categories seleccionades
        int cont = 0;
        ArrayList<String> aux = macro.getContUser().getSubCerca(macro.getUserActual(), cercaaqui);
        StringBuilder sb = new StringBuilder();
        for(String nom:aux) {
            sb.append("\n   "+(cont+1)+". "+nom);
            ++cont;
        }
        String subcat = sb.toString();
        //Preparem les categories a evitar
        cont = 0;
        ArrayList<String> aux2 = macro.getContUser().getEvitaCatCerca(macro.getUserActual(), cercaaqui);
        StringBuilder sb2 = new StringBuilder();
        for(String nom:aux2) {
            sb2.append("\n   "+(cont+1)+". "+nom);
            ++cont;
        }
        String evita = sb2.toString();
        //Preparem les pagines a evitar
        cont = 0;
        ArrayList<String> aux3 = macro.getContUser().getEvitaPagCerca(macro.getUserActual(), cercaaqui);
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
            sb4.append("Nom: "+macro.getContUser().getNomCerca(macro.getUserActual(), cercaaqui));
            sb4.append("\nComentari: "+macro.getContUser().getComentariCerca(macro.getUserActual(), cercaaqui));
            sb4.append("\nData creació: "+macro.getContUser().getDataCreacioCerca(macro.getUserActual(), cercaaqui));
            Date data = macro.getContUser().getDataModificacioCerca(macro.getUserActual(), cercaaqui);
            if(data== null ) sb4.append("\nData ultima modificació: encara no s'ha modificat\n");
            else sb4.append("\nData ultima modificació: "+data +"\n");
            guard=sb4.toString();
        }
        on.setText(guard+"Algorisme: "+algorisme+
                "\nTipus de valor: "+tipu+
                "\nAmb la dada: "+macro.getContUser().getAlgDadaCerca(macro.getUserActual(), cercaaqui)+
                "\nImportancia de les realcions entre categories: "+macro.getContUser().getRelacioCatCerca(macro.getUserActual(), cercaaqui)+
                "\nImportancia semblança de noms: "+macro.getContUser().getSembCerca(macro.getUserActual(), cercaaqui)+
                "\nImportancia de les subcategories: "+ macro.getContUser().getRelacionsSubsCerca(macro.getUserActual(), cercaaqui)+
                "\nImportancia de les supercategories: "+macro.getContUser().getRelacionsSuperCerca(macro.getUserActual(), cercaaqui)+
                "\nImportancia de les pagines: "+macro.getContUser().getRelacioPagCerca(macro.getUserActual(), cercaaqui)+
                "\nParaula clau: "+macro.getContUser().getParaulaClauCerca(macro.getUserActual(), cercaaqui)+
                "\n     Amb importància: "+macro.getContUser().getParaulaImpCerca(macro.getUserActual(), cercaaqui)+
                "\nCategoria pare:"+macro.getContUser().getPareCerca(macro.getUserActual(), cercaaqui)+
                "\nConjunt de categories seleccionades:"+subcat+
                "\nConjunt de categories ignorades:"+evita+
                "\nConjunt de pàgines a ignorar:"+ignora);
    }
    
    protected void visualitzaCerca(Boolean guardada,JTree arbre, JTextArea on, Integer cercaaqui) {
        //PREPAREM LA VISUALITZACIO D'AQUESTA CERCA
    //ARBRE
        DefaultMutableTreeNode arrel = new DefaultMutableTreeNode("Comunitats Obtingudes");
        DefaultTreeModel Model = new DefaultTreeModel(arrel);
        Integer numcom =  macro.getContUser().getNumComunitatsCerca(macro.getUserActual(), cercaaqui);
	
	for(Integer i = 1; i <= numcom; ++i) {
            DefaultMutableTreeNode prim = new DefaultMutableTreeNode("Comunitat "+i);
            arrel.add(prim);
            ArrayList<String> auxm = macro.getContUser().getCatCerca(macro.getUserActual(), cercaaqui, i-1);
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
       ompleCriteris(on,cercaaqui,guardada);
        
    }

    public static void main(String[] args) {
         Interficie.InterficieWiki aux = new Interficie.InterficieWiki();
        aux.setVisible(true);
         
   }
    
    
}
