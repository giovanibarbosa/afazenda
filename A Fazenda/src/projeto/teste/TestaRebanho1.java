package projeto.teste;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import projeto.afazenda.*;

/**
 * Classe de testes do Rebanho
 * 
 * @author Grupo 07 - A Fazenda
 * 
 *
 */
public class TestaRebanho1 {
	private Rebanho r1;
	private Rebanho r2;
	
	@Before
	public void setUp() throws Exception {
		r1 = new Rebanho("Rebanho");
		r2 = new Rebanho("Rebanha");
	}
	@Test
	public void testaNomeNull() throws Exception {
		Rebanho r3 = new Rebanho(null);
		Assert.assertEquals("Rebanho sem nome",r3.getNome(),"Sem Nome");
	}
	
	@Test
	public void testaNomeVazio() throws Exception {
		Rebanho r4 = new Rebanho("");
		Assert.assertEquals("Rebanho sem nome",r4.getNome(),"Sem Nome");
	}
	
	@Test
	public void getNome() throws Exception {
		Assert.assertEquals("Rebanho sem nome",r1.getNome(),"Rebanho");
		Assert.assertEquals("Rebanho sem nome",r2.getNome(),"Rebanha");
	}
	
	@Test
	public void testaAdicionaVaca() throws Exception {
		Assert.assertEquals("Rebanho sem vacas",r1.getQntdDeVacas(),0);
		Vaca v1 = new Vaca("Mimosa", 7, 3);	
		r1.adicionaVaca(v1);
		Assert.assertEquals("Rebanho com uma vaca",r1.getQntdDeVacas(),1);
		Vaca v2 = new Vaca("Leiteira", 4, 0);
		r1.adicionaVaca(v2);
		Assert.assertEquals("Rebanho com duas vacas",r1.getQntdDeVacas(),2);
				
	}
	
	@Test (expected = Exception.class)
	public void testaAdicionaVacaNull() throws Exception {
		Vaca v3 = null;
		Assert.assertEquals("A vaca passada nao pode ser null",r1.adicionaVaca(v3));
	}
	
	@Test
	public void testaRemoveVaca() throws Exception {
		Assert.assertEquals("Rebanho sem vacas",r1.getQntdDeVacas(),0);
		Vaca v1 = new Vaca("Mimosa", 7, 3);	
		r1.adicionaVaca(v1);
		Vaca v2 = new Vaca("Leiteira", 4, 0);
		r1.adicionaVaca(v2);
		Assert.assertEquals("Rebanho com duas vacas",r1.getQntdDeVacas(),2);
		r1.removeVaca(v1.getID());
		Assert.assertEquals("Rebanho com uma vaca",r1.getQntdDeVacas(),1);
				
	}
	
	@Test
	public void listarVaca() throws Exception {
		Vaca v1 = new Vaca("Mimosa", 7, 3);
		r1.adicionaVaca(v1);
		Vaca v2 = new Vaca("Leiteira", 4, 0);
		r1.adicionaVaca(v2);
		Vaca v3 = new Vaca("Surpresa", 12, 0);
		r1.adicionaVaca(v3);
		Assert.assertEquals(3,r1.listarVacas().size());
		r1.removeVaca(v2.getID());
		Assert.assertEquals(2,r1.listarVacas().size());
	
	}
}
