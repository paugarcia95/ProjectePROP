/**
 * 
 */
package drivers;

import java.util.ArrayList;
import java.util.HashSet;
import cercaComunitats.Graf;
import domini.Categoria;
import domini.ControladorTraduirAlgorisme;
import domini.Criteris;
import domini.GrafDades;
import domini.Pagina;
import domini.ParaulaValor;


/**
 * @author Alr
 *
 */



public class driverTraduirAlgorisme {
	/**
	 * @param args
	 */
	 
	 
	public static void main(String[] args) {
		GrafDades G = new GrafDades();
		/*EntradaSortidaDadesGraf obj = new EntradaSortidaDadesGraf();
		try {
			G = obj.loadGraph("C:/Users/Alr/Desktop/Prova1.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		/*Categoria aux1 = new Categoria("sanitat"); // PROVA METGES
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
		G.addCC(aux2, aux4);*/
		
		
		Categoria aux1 = new Categoria("sexualitat"); // Prova Sexualitat
		Categoria aux2 = new Categoria("asexual");
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
		
		/*Categoria aux1 = new Categoria("familia"); // Prova familia
		Categoria aux2 = new Categoria("pare");
		G.addCC(aux1,aux2);
		Categoria aux3 = new Categoria("mare");
		G.addCC(aux1,aux3);
		Categoria aux4 = new Categoria("fill");
		G.addCC(aux2,aux4);
		G.addCC(aux3,aux4);*/
		
		Criteris cri = new Criteris();
		cri.setAlgorisme(2);
		cri.setDada(5);
		
		cri.setRelacionsCat(5); // Relacions cat-pg
		cri.setTipuCerca(2); ///???
		ArrayList<Categoria> c2 = new ArrayList<Categoria>();
		ArrayList<Categoria> c = new ArrayList<Categoria>();
		ArrayList<Pagina> s = new ArrayList<Pagina>();
		cri.setSubconjCat(c2);
		ParaulaValor caca = new ParaulaValor("ho", 0);
		cri.setParaulaClau(caca);
		cri.setEvitaCat(c);
		cri.setEvitaPag(s);
		cri.setSemblaNom(0);
		String sa = new String();
		cri.setPare(sa);
		
		
		ControladorTraduirAlgorisme trd = new ControladorTraduirAlgorisme();
		Graf fora = new Graf(trd.GrafDadestoGraf(G, cri));
		HashSet<String> naa = new HashSet<String>(fora.getNodes());
		ArrayList<String> n2 = new ArrayList<String>();
		n2.addAll(naa);
		for(String hhh : n2) {
			System.out.print("Element: ");
			System.out.print(hhh);
			System.out.print(" ");
		}
		System.out.println("");
		for(int q = 0; q < n2.size(); ++q) {
			for(int g = q+1; g < n2.size(); ++g) {
				if(fora.existeixAresta(n2.get(q), n2.get(g))) {
					System.out.print("Cat1: ");
					System.out.print(n2.get(q));
					System.out.print(" -Pes de ");
					System.out.print(fora.getPes(n2.get(q), n2.get(g)));
					System.out.print("- Cat2: ");
					System.out.print(n2.get(g));
					System.out.println();
				}
			}
		}
		System.out.println("SACABOOOOO");
	}

}
