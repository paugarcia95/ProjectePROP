package drivers;

import java.util.ArrayList;

import domini.Pagina;
import domini.Categoria;
import domini.ParaulaValor;
import domini.Criteris;
import junit.framework.TestCase;

/**
 * @author Dani
 *
 */

public class CriterisTest extends TestCase{
	
	public CriterisTest() {
		super("CriterisTest");
	}
	
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testConstructorAtributs() {
		ParaulaValor p = new ParaulaValor("Medicina", 5);
		ArrayList<Categoria> sub = new ArrayList<Categoria>();
		ArrayList<Categoria> evitaCategoria = new ArrayList<Categoria>();
		ArrayList<Pagina> evitaPagina = new ArrayList<Pagina>();
		Criteris c = new Criteris(p, 1, 2, 3, 4, 5, sub, evitaCategoria, evitaPagina, "Metge");
		assertNotNull("No ha creat un objecte", c);
		assertTrue("Ha posat malament paraulaClau", c.getParaulaClau() == p);
		assertTrue("Ha posat malament relacionsCat", c.getRelacionsCat() == 1);
		assertTrue("Ha posat malament semblaNom", c.getSemblaNom() == 2);
		assertTrue("Ha posat malament algorisme", c.getAlgorisme() == 3);
		assertTrue("Ha posat malament tipuCerca", c.getTipuCerca() == 4);
		assertTrue("Ha posat malament dada", c.getDada() == 5);
		assertTrue("Ha posat malament subconjCat", c.getSubconjCat() == sub);
		assertTrue("Ha posat malament evitaCat", c.getEvitaCat() == evitaCategoria);
		assertTrue("Ha posat malament evitaPag", c.getEvitaPag() == evitaPagina);
		assertTrue("Ha posat malament pare", c.getPare().equals("Metge"));
	}
	
	public void testConstructorBuit() {
		Criteris c = new Criteris();
		assertNotNull("No ha creat un objecte", c);
		assertNotNull("Ha inicialitzat malament paraulaClau", c.getParaulaClau());
		assertTrue("Ha inicialitzat malament relacionsCat", c.getRelacionsCat() == 5);
		assertTrue("Ha inicialitzat malament semblaNom", c.getSemblaNom() == 0);
		assertTrue("Ha inicialitzat malament algorisme", c.getAlgorisme() == 2);
		assertTrue("Ha inicialitzat malament tipuCerca", c.getTipuCerca() == 1);
		assertTrue("Ha inicialitzat malament dada", c.getDada() == 5);
		assertNotNull("Ha inicialitzat malament subconjCat", c.getSubconjCat());
		assertNotNull("Ha inicialitzat malament evitaCat", c.getEvitaCat());
		assertNotNull("Ha inicialitzat malament evitaPag", c.getEvitaPag());
		assertNotNull("Ha inicialitzat malament pare", c.getPare());
	}
	
	public void testSetParaulaClau() {
		ParaulaValor p = new ParaulaValor("Medicina", 5);
		ArrayList<Categoria> sub = new ArrayList<Categoria>();
		ArrayList<Categoria> evitaCategoria = new ArrayList<Categoria>();
		ArrayList<Pagina> evitaPagina = new ArrayList<Pagina>();
		Criteris c = new Criteris(p, 1, 2, 3, 4, 5, sub, evitaCategoria, evitaPagina, "Metge");
		ParaulaValor pa = new ParaulaValor("Metge", 2);
		c.setParaulaClau(pa);
		assertTrue("No ha canviat la paraulaClau", c.getParaulaClau() == pa);
	}
	
	public void testSetRelacionsCat() {
		ParaulaValor p = new ParaulaValor("Medicina", 5);
		ArrayList<Categoria> sub = new ArrayList<Categoria>();
		ArrayList<Categoria> evitaCategoria = new ArrayList<Categoria>();
		ArrayList<Pagina> evitaPagina = new ArrayList<Pagina>();
		Criteris c = new Criteris(p, 1, 2, 3, 4, 5, sub, evitaCategoria, evitaPagina, "Metge");
		c.setRelacionsCat(10);
		assertTrue("No ha canviat la relacionsCat", c.getRelacionsCat() == 10);
	}
	
	public void testSetSemblaNom() {
		ParaulaValor p = new ParaulaValor("Medicina", 5);
		ArrayList<Categoria> sub = new ArrayList<Categoria>();
		ArrayList<Categoria> evitaCategoria = new ArrayList<Categoria>();
		ArrayList<Pagina> evitaPagina = new ArrayList<Pagina>();
		Criteris c = new Criteris(p, 1, 2, 3, 4, 5, sub, evitaCategoria, evitaPagina, "Metge");
		c.setSemblaNom(9);
		assertTrue("No ha canviat semblaNom", c.getSemblaNom() == 9);
	}
	
	public void testSetAlgorisme() {
		ParaulaValor p = new ParaulaValor("Medicina", 5);
		ArrayList<Categoria> sub = new ArrayList<Categoria>();
		ArrayList<Categoria> evitaCategoria = new ArrayList<Categoria>();
		ArrayList<Pagina> evitaPagina = new ArrayList<Pagina>();
		Criteris c = new Criteris(p, 1, 2, 3, 4, 5, sub, evitaCategoria, evitaPagina, "Metge");
		c.setAlgorisme(1);
		assertTrue("No ha canviat el algorisme", c.getAlgorisme() == 1);
	}
	
	public void testSetTipuCerca() {
		ParaulaValor p = new ParaulaValor("Medicina", 5);
		ArrayList<Categoria> sub = new ArrayList<Categoria>();
		ArrayList<Categoria> evitaCategoria = new ArrayList<Categoria>();
		ArrayList<Pagina> evitaPagina = new ArrayList<Pagina>();
		Criteris c = new Criteris(p, 1, 2, 3, 4, 5, sub, evitaCategoria, evitaPagina, "Metge");
		c.setTipuCerca(7);
		assertTrue("No ha canviat el tipuCerca", c.getTipuCerca() == 7);
	}
	
	public void testSetDada() {
		ParaulaValor p = new ParaulaValor("Medicina", 5);
		ArrayList<Categoria> sub = new ArrayList<Categoria>();
		ArrayList<Categoria> evitaCategoria = new ArrayList<Categoria>();
		ArrayList<Pagina> evitaPagina = new ArrayList<Pagina>();
		Criteris c = new Criteris(p, 1, 2, 3, 4, 5, sub, evitaCategoria, evitaPagina, "Metge");
		c.setDada(6);
		assertTrue("No ha canviat la dada", c.getDada() == 6);
	}
	
	public void testSetSubconjCat() {
		ParaulaValor p = new ParaulaValor("Medicina", 5);
		ArrayList<Categoria> sub = new ArrayList<Categoria>();
		ArrayList<Categoria> evitaCategoria = new ArrayList<Categoria>();
		ArrayList<Pagina> evitaPagina = new ArrayList<Pagina>();
		Criteris c = new Criteris(p, 1, 2, 3, 4, 5, sub, evitaCategoria, evitaPagina, "Metge");
		ArrayList<Categoria> sub2 = new ArrayList<Categoria>();
		c.setSubconjCat(sub2);
		assertTrue("No ha canviat el subconjCat", c.getSubconjCat() == sub2);
	}
	
	public void testSetEvitaCat() {
		ParaulaValor p = new ParaulaValor("Medicina", 5);
		ArrayList<Categoria> sub = new ArrayList<Categoria>();
		ArrayList<Categoria> evitaCategoria = new ArrayList<Categoria>();
		ArrayList<Pagina> evitaPagina = new ArrayList<Pagina>();
		Criteris c = new Criteris(p, 1, 2, 3, 4, 5, sub, evitaCategoria, evitaPagina, "Metge");
		ArrayList<Categoria> evita1 = new ArrayList<Categoria>();
		c.setEvitaCat(evita1);
		assertTrue("No ha canviat el evitaCat", c.getEvitaCat() == evita1);
	}
	
	public void testSetEvitaPag() {
		ParaulaValor p = new ParaulaValor("Medicina", 5);
		ArrayList<Categoria> sub = new ArrayList<Categoria>();
		ArrayList<Categoria> evitaCategoria = new ArrayList<Categoria>();
		ArrayList<Pagina> evitaPagina = new ArrayList<Pagina>();
		Criteris c = new Criteris(p, 1, 2, 3, 4, 5, sub, evitaCategoria, evitaPagina, "Metge");
		ArrayList<Pagina> evita1 = new ArrayList<Pagina>();
		c.setEvitaPag(evita1);
		assertTrue("No ha canviat el evitaPag", c.getEvitaPag() == evita1);
	}
	
	public void testSetPare() {
		ParaulaValor p = new ParaulaValor("Medicina", 5);
		ArrayList<Categoria> sub = new ArrayList<Categoria>();
		ArrayList<Categoria> evitaCategoria = new ArrayList<Categoria>();
		ArrayList<Pagina> evitaPagina = new ArrayList<Pagina>();
		Criteris c = new Criteris(p, 1, 2, 3, 4, 5, sub, evitaCategoria, evitaPagina, "Metge");
		c.setPare("Nou");
		assertTrue("No ha canviat el pare", c.getPare().equals("Nou"));
	}

}
