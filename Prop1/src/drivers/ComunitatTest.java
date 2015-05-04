package drivers;

import java.util.Map;
import java.util.TreeMap;

import domini.Categoria;
import domini.Comunitat;
import domini.ParaulaValor;
import junit.framework.TestCase;

/**
 * @author Dani
 *
 */
public class ComunitatTest extends TestCase{
	
	public ComunitatTest() {
		super("ComunitatTest");
	}
	
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testConstructorAtributs() {
		Comunitat c = new Comunitat(5);
		assertNotNull("No ha creat un objecte", c);
		assertTrue("Ha inicialitzat malament id", c.getId() == 5);
		assertNotNull("Ha inicialitzat malament categoriesComunitat", c.getMapCat());
		assertTrue("Ha inicialitzat malament categoriesComunitat", c.getNumeroDeCategories() == 0);
	}
	
	public void testConstructorBuit() {
		Comunitat c = new Comunitat();
		assertNotNull("No ha creat un objecte", c);
		assertTrue("Ha inicialitzat malament id", c.getId() == -1);
		assertNotNull("Ha inicialitzat malament categoriesComunitat", c.getMapCat());
		assertTrue("Ha inicialitzat malament categoriesComunitat", c.getNumeroDeCategories() == 0);
	}
	
	public void testSetId() {
		Comunitat c = new Comunitat(5);
		c.setId(2);
		assertTrue("No ha canviat id", c.getId() == 2);
	}
	
	public void testAddCat() {
		Comunitat c = new Comunitat(5);
		Categoria ca = new Categoria();
		c.addCat(ca);
		assertTrue("No ha afegit la Categoria", c.getCat(ca.getNom()) == ca);		
	}
	
	public void testRemoveCat() {
		Comunitat c = new Comunitat(5);
		Categoria ca = new Categoria();
		c.addCat(ca);
		c.removeCat(ca.getNom());
		assertTrue("No ha eliminat la Categoria", c.getNumeroDeCategories() == 0);
	}
	
	public void testSetMapCat() {
		Comunitat c = new Comunitat(5);
		Map<String,Categoria> m = new TreeMap<String,Categoria>();
		c.setMapCat(m);
		assertTrue("No ha canviat categoriesComunitat", c.getMapCat() == m);		
	}

}
