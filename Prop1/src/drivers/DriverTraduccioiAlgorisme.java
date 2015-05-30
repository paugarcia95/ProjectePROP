/**
 * 
 */
package drivers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

import cercaComunitats.Graf;
import domini.Categoria;
import domini.Criteris;
import domini.GrafDades;
import domini.Pagina;
import domini.ParaulaValor;
import domini.TraduccioiAlgorisme;


/**
 * @author Alr
 *
 */



public class DriverTraduccioiAlgorisme {
	/**
	 * @param args
	 */
	 
	 
	public static void main(String[] args) {
		GrafDades G = new GrafDades();
		System.out.print("Escull un joc de proves (1,2,3)");
		@SuppressWarnings("resource")
		Scanner hu = new Scanner(System.in);
		Integer jj = hu.nextInt();
		if(jj == 1) {
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
			Categoria aux11 = new Categoria("operacio");
			G.addCC(aux11, aux2);
			G.addCC(aux11, aux4);
            Pagina aux12 = new Pagina("agulla22222");
            G.addCP(aux2, aux12);
            G.addCP(aux4, aux12);
		}
		
		else if(jj == 2) {
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
		}
		else {
			Categoria aux1 = new Categoria("familia"); // Prova familia
			Categoria aux2 = new Categoria("pare");
			G.addCC(aux1,aux2);
			Categoria aux3 = new Categoria("mare");
			G.addCC(aux1,aux3);
			Categoria aux4 = new Categoria("fill");
			G.addCC(aux2,aux4);
			G.addCC(aux3,aux4);
			G.addCC(aux4,aux1);
		}
		
		Criteris cri = new Criteris();
		cri.setAlgorisme(2);
		cri.setDada(2);
		
		cri.setRelacionsCat(5); // Relacions cat-pg
		cri.setRelacionsPag(5);
		cri.setRelacionsSubs(5);
		cri.setRelacionsSuper(5);
		
		cri.setTipuCerca(2); ///???
		ArrayList<String> c2 = new ArrayList<String>(); // Subconjunt
		ArrayList<String> c = new ArrayList<String>(); // Evitar
		ArrayList<String> s = new ArrayList<String>();
		cri.setSubconjCat(c2);
		ParaulaValor utilitzable = new ParaulaValor("ho", 0);
		cri.setParaulaClau(utilitzable);
		cri.setEvitaCat(c);
		cri.setEvitaPag(s);
		cri.setSemblaNom(5);
		String sa = new String();
		cri.setPare(sa);
		
		
		TraduccioiAlgorisme trd = new TraduccioiAlgorisme();
		Graf fora = new Graf(trd.grafdadestograf(G, cri));
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
		//System.out.println("SACABOOOOO");
	}

}
