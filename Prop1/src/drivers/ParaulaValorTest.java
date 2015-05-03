package drivers;

import junit.framework.TestCase;
import domini.ParaulaValor;

/**
 * @author Dani
 *
 */

public class ParaulaValorTest extends TestCase {

	public ParaulaValorTest() {
		super("ParaulaValorTest");
	}
	
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testConstructorBuit() {
		ParaulaValor p = new ParaulaValor();
		assertNotNull("No ha creat un objecte", p);
		assertTrue("No ha inicialitzat correctament la paraula", p.getParaula() == "NoIndicat");
		assertTrue("No ha inicialitzat correctament el num", p.getNum() == 0);
	}
	
	public void testConstructorAtributs() {
		ParaulaValor p = new ParaulaValor("Medicina", 5);
		assertNotNull("No ha creat un objecte", p);
		assertTrue("No ha inicialitzat correctament la paraula", p.getParaula() == "Medicina");
		assertTrue("No ha inicialitzat correctament el num", p.getNum() == 5);
	}
	
	public void testSetParaula() {
		ParaulaValor p = new ParaulaValor("Medicina", 5);
		p.setParaula("Planta");
		assertTrue("No ha canviat correctament la paraula", p.getParaula() == "Planta");
	}
	
	public void testSetNum() {
		ParaulaValor p = new ParaulaValor("Medicina", 5);
		p.setNum(10);
		assertTrue("No ha canviat correctament el num", p.getNum() == 10);
		
	}

}
