package projeto.teste;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import projeto.afazenda.*;

/**
 * Classe de testes da Vaca
 * 
 * @author Grupo 07 - A Fazenda
 * 
 * @version 1.0 07/10/2009
 *
 */
public class TestaVaca1 {
	
	private Vaca v1;
	private Vaca v2;
	
	
	@Before
	public void setUp() throws Exception {
		v1 = new Vaca("Mimosa", 4, 0);
		v2 = new Vaca("Amarela", 6, 1);
	}
	
	@Test
	public void testaNumFilhoNegativo() throws Exception {
		Vaca v3 = new Vaca("Malhada", 2, -1);
	}
	
	@Test
	public void testaGetQntdFilhos() {
		Assert.assertEquals("Quantidade de filhos errada.", 0, v1.getQntdFilhos());
		Assert.assertEquals("Quantidade de filhos errada.", 1, v2.getQntdFilhos());
		v1.diminuirQntdFilhos();
		v2.diminuirQntdFilhos();
		Assert.assertEquals("Quantidade de filhos errada.", 0, v1.getQntdFilhos());
		Assert.assertEquals("Quantidade de filhos errada.", 0, v2.getQntdFilhos());
		for (int i = 1; i < 10; i++) {
			v1.adicionarFilho();
			v2.adicionarFilho();
			Assert.assertEquals("Quantidade de filhos errada.", i, v1.getQntdFilhos());
			Assert.assertEquals("Quantidade de filhos errada.", i, v2.getQntdFilhos());
		}
	}
	
	@Test
	public void testaGetVaqueiroResponsavel() throws Exception {
		Assert.assertEquals(null, v1.getVaqueiroResponsavel());
		Assert.assertEquals(null, v2.getVaqueiroResponsavel());
		Vaqueiro vaqueiro = new Vaqueiro("12345678910", "chico bento", "rua", 24);
		v1.setVaqueiroResponsavel(vaqueiro);
		Assert.assertEquals(vaqueiro, v1.getVaqueiroResponsavel());
		v1.setVaqueiroResponsavel(null);
		Assert.assertEquals(vaqueiro, v1.getVaqueiroResponsavel());
	}
	
	@Test (expected = Exception.class)
	public void testeAdicionaCoberturaNull() throws Exception {
		v2.adicionaCobertura(null);
	}
	
	@Test
	public void testaAdicionaCobertura() throws Exception {
		Cobertura cob1 = new Cobertura(new Date(), 2, 3);
		Cobertura cob2 = new Cobertura(new Date(), 3, 4);
		Cobertura cob3 = new Cobertura(new Date(), 4, 5);
		
		Assert.assertTrue(v1.adicionaCobertura(cob1));
		Assert.assertTrue(v1.adicionaCobertura(cob2));
		Assert.assertTrue(v2.adicionaCobertura(cob2));
		Assert.assertTrue(v2.adicionaCobertura(cob3));
		
		Assert.assertFalse(v1.adicionaCobertura(cob1));
		Assert.assertFalse(v2.adicionaCobertura(cob2));
	}
	
	@Test
	public void testaRemoveCobertura() throws Exception {
		Cobertura cob1 = new Cobertura(new Date(), 2, 3);
		Cobertura cob2 = new Cobertura(new Date(), 3, 4);
		Cobertura cob3 = new Cobertura(new Date(), 4, 5);
		
		Assert.assertTrue(v1.adicionaCobertura(cob1));
		Assert.assertTrue(v1.adicionaCobertura(cob2));
		Assert.assertTrue(v2.adicionaCobertura(cob2));
		Assert.assertTrue(v2.adicionaCobertura(cob3));
		
		Assert.assertFalse(v2.removeCobertura(cob1));
		Assert.assertFalse(v1.removeCobertura(cob3));
		
		Assert.assertTrue(v1.adicionaCobertura(cob3));
		Assert.assertTrue(v2.adicionaCobertura(cob1));
		
		Assert.assertTrue(v2.removeCobertura(cob1));
		Assert.assertTrue(v1.removeCobertura(cob3));
	}
	
	@Test (expected = Exception.class)
	public void testaAdicionaVacinaNull() throws Exception {
		v2.adicionaVacina(null);
	}
	
	@Test (expected = Exception.class)
	public void testaRemoveVacinaNull() throws Exception {
		Vacina vacina1 = new Vacina("Vacina Contra Queda de Cabelo", 1.5);
		v1.adicionaVacina(vacina1);
		v1.removeVacina(null);
	}
	
	@Test
	public void testaAdicionaVacina() throws Exception {
		Vacina vacina1 = new Vacina("Vacina Contra Queda de Cabelo", 1.5);
		Vacina vacina2 = new Vacina("Vacina Contra Sarampo", 0.8);
		Assert.assertTrue(v1.adicionaVacina(vacina1));
		Assert.assertTrue(v1.adicionaVacina(vacina1));
		Assert.assertTrue(v1.adicionaVacina(vacina2));
		Assert.assertEquals(3, v1.listaVacinas().size());
	}
	
	@Test
	public void testaRemoveVacina() throws Exception {
		Vacina vacina1 = new Vacina("Vacina Contra Queda de Cabelo", 1.5);
		Vacina vacina2 = new Vacina("Vacina Contra Sarampo", 0.8);
		Assert.assertTrue(v1.adicionaVacina(vacina1));
		Assert.assertEquals(1, v1.listaVacinas().size());
		Assert.assertFalse(v1.removeVacina(vacina2));
		Assert.assertTrue(v1.removeVacina(vacina1));
		Assert.assertEquals(0, v1.listaVacinas().size());
	}
	
}
