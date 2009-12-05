package projeto.teste;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import projeto.afazenda.*;

/**
 * Classe de testes da Fazenda
 * 
 * @author Grupo 07 - A Fazenda
 *
 */

public class TestaFazenda1 {
	
	private Fazenda fazenda;
	
	@Before
	public void setUp() throws Exception {
		fazenda = new Fazenda();
	}
	
	@Test
	public void testaAdicionaTouro() throws Exception {
		Touro t1 = new Touro("Boizao", 3);
		Touro t2 = new Touro("Boi Zebu", 8);
		
		Assert.assertEquals("Quantidade de touros errada", 0, fazenda.getTotalDeTouros());
		
		Assert.assertTrue(fazenda.adicionaTouro(t1));
		Assert.assertTrue(fazenda.adicionaTouro(t2));
		Assert.assertEquals("Quantidade de touros errada", 2, fazenda.getTotalDeTouros());
	
		Assert.assertFalse(fazenda.adicionaTouro(t1));
		Assert.assertEquals("Quantidade de touros errada", 2, fazenda.getTotalDeTouros());

	}
	
	@Test
	public void testaRemoveTouro() throws Exception{
		Touro t1 = new Touro("Boizao", 3);
		Touro t2 = new Touro("Boi Zebu", 8);
		Touro t3 = new Touro("Touro Bandido", 10);
		t1.setID(1);
		t2.setID(2);
		t3.setID(3);
		
		Assert.assertEquals("Quantidade de touros errada", 0, fazenda.getTotalDeTouros());
		
		Assert.assertTrue(fazenda.adicionaTouro(t1));
		Assert.assertTrue(fazenda.adicionaTouro(t2));
		Assert.assertEquals("Quantidade de touros errada", 2, fazenda.getTotalDeTouros());
		
		Assert.assertFalse(fazenda.removeTouro(t3.getID()));
		
		Assert.assertTrue(fazenda.removeTouro(t1.getID()));
		Assert.assertEquals("Quantidade de touros errada", 1, fazenda.getTotalDeTouros());
		Assert.assertTrue(fazenda.removeTouro(t2.getID()));
		Assert.assertEquals("Quantidade de touros errada", 0, fazenda.getTotalDeTouros());
		
		fazenda.adicionaTouro(t3);
		Assert.assertEquals("Quantidade de touros errada", 1, fazenda.getTotalDeTouros());
		Assert.assertTrue(fazenda.removeTouro(t3.getID()));
		Assert.assertEquals("Quantidade de touros errada", 0, fazenda.getTotalDeTouros());
	}
	
	@Test
	public void testaAdicionaVaqueiro() throws Exception{
		Vaqueiro v1 = new Vaqueiro("12345678910", "Roberto", "Rua dos Cornos", 34);
		Vaqueiro v2 = new Vaqueiro("01987654321", "Teobaldo", "Rua dos Doidos", 32);
		
		Assert.assertEquals("Quantidade de vaqueiros errada", 0, fazenda.getTotalDeVaqueiros());
		
		Assert.assertTrue(fazenda.adicionaVaqueiro(v1));
		Assert.assertTrue(fazenda.adicionaVaqueiro(v2));
		Assert.assertEquals("Quantidade de vaqueiros errada", 2, fazenda.getTotalDeVaqueiros());
		
		Assert.assertFalse(fazenda.adicionaVaqueiro(v1));
		Assert.assertEquals("Quantidade de vaqueiros errada", 2, fazenda.getTotalDeVaqueiros());
	}
	
	@Test
	public void testaRemoveVaqueiro() throws Exception{
		Vaqueiro v1 = new Vaqueiro("12345678910", "Roberto", "Rua dos Cornos", 34);
		Vaqueiro v2 = new Vaqueiro("01987654321", "Teobaldo", "Rua dos Doidos", 32);
		Vaqueiro v3 = new Vaqueiro("45612307896", "Tota", "Rua dos Toba", 35);
		
		Assert.assertEquals("Quantidade de vaqueiros errada", 0, fazenda.getTotalDeVaqueiros());
		
		Assert.assertTrue(fazenda.adicionaVaqueiro(v1));
		Assert.assertTrue(fazenda.adicionaVaqueiro(v2));
		Assert.assertEquals("Quantidade de vaqueiros errada", 2, fazenda.getTotalDeVaqueiros());
		
		Assert.assertFalse(fazenda.removeVaqueiro(v3));
		
		Assert.assertTrue(fazenda.removeVaqueiro(v1));
		Assert.assertEquals("Quantidade de vaqueiros errada", 1, fazenda.getTotalDeVaqueiros());
		Assert.assertTrue(fazenda.removeVaqueiro(v2));
		Assert.assertEquals("Quantidade de vaqueiros errada", 0, fazenda.getTotalDeVaqueiros());
		
		fazenda.adicionaVaqueiro(v3);
		Assert.assertEquals("Quantidade de vaqueiros errada", 1, fazenda.getTotalDeVaqueiros());
		Assert.assertTrue(fazenda.removeVaqueiro(v3));
		Assert.assertEquals("Quantidade de vaqueiros errada", 0, fazenda.getTotalDeVaqueiros());
	}
	
	@Test
	public void testaAdicionaRebanho() throws Exception{
		Rebanho reb1 = new Rebanho("Rebanho do Norte");
		Rebanho reb2 = new Rebanho("Rebanho do Sul");
		Vaca v1 = new Vaca("Mimosa", 4, 0);
		Vaca v2 = new Vaca("Amarela", 6, 1);
		Vaca v3 = new Vaca("Fedorenta", 4, 4);
		Vaca v4 = new Vaca("Chica", 3, 3);
		reb1.adicionaVaca(v1);
		reb2.adicionaVaca(v2);
		
		Assert.assertEquals("Quantidade de vacas errada", 0, fazenda.getTotalDeVacas());
		Assert.assertEquals("Quantidade de rebanhos errada", 0, fazenda.getTotalDeRebanhos());
		
		Assert.assertTrue(fazenda.adicionaRebanho(reb1));
		Assert.assertTrue(fazenda.adicionaRebanho(reb2));
		Assert.assertEquals("Quantidade de vacas errada", 2, fazenda.getTotalDeVacas());
		Assert.assertEquals("Quantidade de rebanhos errada", 2, fazenda.getTotalDeRebanhos());
		
		reb1.adicionaVaca(v3);
		reb1.adicionaVaca(v4);
		Assert.assertEquals("Quantidade de vacas errada", 4, fazenda.getTotalDeVacas());
		Assert.assertEquals("Quantidade de rebanhos errada", 2, fazenda.getTotalDeRebanhos());
	}
	
	@Test
	public void testaRemoveRebanho()throws Exception{
		Rebanho reb1 = new Rebanho("Rebanho do Norte");
		Rebanho reb2 = new Rebanho("Rebanho do Sul");
		
		Assert.assertEquals("Quantidade de rebanhos errada", 0, fazenda.getTotalDeRebanhos());
		
		Assert.assertFalse(fazenda.removeRebanho(reb1));
		Assert.assertFalse(fazenda.removeRebanho(reb2));
		
		fazenda.adicionaRebanho(reb1);
		fazenda.adicionaRebanho(reb2);
		Assert.assertEquals("Quantidade de rebanhos errada", 2, fazenda.getTotalDeRebanhos());
		
		Assert.assertTrue(fazenda.removeRebanho(reb2));
		Assert.assertEquals("Quantidade de rebanhos errada", 1, fazenda.getTotalDeRebanhos());
		Assert.assertTrue(fazenda.removeRebanho(reb1));
		Assert.assertEquals("Quantidade de rebanhos errada", 0, fazenda.getTotalDeRebanhos());
		
	}
}
