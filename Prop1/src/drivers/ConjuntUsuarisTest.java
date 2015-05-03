package drivers;

import domini.ConjuntUsuaris;
import domini.Usuari;
import junit.framework.TestCase;

/**
 * @author Dani
 *
 */
public class ConjuntUsuarisTest extends TestCase{

	public ConjuntUsuarisTest() {
		super("ConjuntUsuarisTest");
	}
	
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testConstructor() {
		ConjuntUsuaris c = new ConjuntUsuaris();
		assertNotNull("No ha creat un objecte", c);
		assertTrue("Ha inicialitzat malament el Map d'usuaris", c.getNombreUsers() == 0);
	}
	
	public void testAddUsser() {
		ConjuntUsuaris c = new ConjuntUsuaris();
		Usuari u = new Usuari();
		c.addUser(u);
		assertTrue("No ha afegit l'usuari", c.exists(u));
		assertTrue("No ha afegit l'usuari", c.exists("NoIndicat"));
		assertTrue("No ha afegit l'usuari", c.getUser("NoIndicat") == u);
		assertTrue("No ha afegit l'usuari", c.getNombreUsers() == 1);
	}
	
	public void testSetUsername() {
		ConjuntUsuaris c = new ConjuntUsuaris();
		Usuari u = new Usuari();
		c.addUser(u);
		c.setUsername("NoIndicat", "Dani");
		assertTrue("No ha canviat el nom de l'usuari", !c.exists("NoIndicat"));
		assertTrue("No ha canviat el nom de l'usuari", c.exists("Dani"));		
	}
	
	

}
