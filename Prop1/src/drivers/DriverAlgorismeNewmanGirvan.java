/**
 * 
 */
package drivers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

import cercaComunitats.AlgorismeNewmanGirvan;
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
public class DriverAlgorismeNewmanGirvan {
	
	public static void main(String[] args) {
	/*	Criteris cri = new Criteris();
		cri.setAlgorisme(2);
		cri.setDada(2);
		GrafDades G = new GrafDades();
		cri.setRelacionsCat(5); // Relacions cat-pg
		cri.setTipuCerca(2); ///???
		ArrayList<Categoria> c2 = new ArrayList<Categoria>(); // Subconjunt
		ArrayList<Categoria> c = new ArrayList<Categoria>(); // Evitar
		ArrayList<Pagina> s = new ArrayList<Pagina>();
		cri.setSubconjCat(c2);
		ParaulaValor utilitzable = new ParaulaValor("ho", 0);
		cri.setParaulaClau(utilitzable);
		cri.setEvitaCat(c);
		cri.setEvitaPag(s);
		cri.setSemblaNom(0);
		String sa = new String();
		cri.setPare(sa);
		
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
		
		System.out.println("Categories: "+ aux1.getNom() + " " + aux2.getNom() + " " + aux3.getNom() + " " + aux4.getNom() +" " + aux5.getNom() +" " + aux6.getNom() + " " + aux7.getNom());
		System.out.println("Relaciones: sexualitat CC asexual  sexualitat CC heterosexual  sexualitat CC asexual  sexualitat CC sexe  heterosexual CC embaras  sexe CC embaras  asexual CC infertil  homosexual CC infertil");
		System.out.print("Escull un dels metodes d'execucio (1,2,3)");
		TraduccioiAlgorisme trd = new TraduccioiAlgorisme();
		Graf fora = new Graf(trd.grafdadestograf(G, cri));
		@SuppressWarnings("resource")
		Scanner hu = new Scanner(System.in);
		Integer jj = hu.nextInt();
		HashSet<HashSet<String>> solucio = new HashSet<HashSet<String>>();
		if(jj == 1) solucio = AlgorismeNewmanGirvan.executa(fora,cri.getDada());
		else if(jj == 2) solucio = AlgorismeNewmanGirvan.executaNum(fora,cri.getDada());
		else solucio = AlgorismeNewmanGirvan.executabet(fora,cri.getDada());
		int itit = 1;
		for(HashSet<String> uu : solucio) {
			System.out.print("Comunitat " + itit);
			System.out.print(uu);
			++itit;
		}*/
	}
}
