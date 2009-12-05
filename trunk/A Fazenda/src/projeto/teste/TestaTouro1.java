package projeto.teste;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import projeto.afazenda.Touro;

/**
 * Classe de testes do Touro
 * 
 * @author Grupo 07 - A Fazenda
 * 
 * @version 1.0 07/10/2009
 *
 */
public class TestaTouro1 {
	
	private Touro t1;
	private Touro t2;
	
	@Before
	public void setUp() throws Exception {
		t1 = new Touro("Boi Zebu", 8);
		t2 = new Touro("Boizinho", 3);
	}
	
	@Test
	public void testaNomeNull() throws Exception {
		Touro t3 = new Touro(null, 1);
	}
	
	@Test
	public void testaNomeVazio() throws Exception {
		Touro t3 = new Touro("", 9);
	}
	
}
