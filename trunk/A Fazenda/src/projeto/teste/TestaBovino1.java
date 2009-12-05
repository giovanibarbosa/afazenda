package projeto.teste;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import projeto.afazenda.Bovino;

/**
 * Classe de Testes do Bovino
 * 
 * 
 * @author Grupo 07 - A Fazenda
 * 
 * @version 1.0 07/10/2009
 *
 */
public class TestaBovino1 {

	private Bovino b1;
	private Bovino b2;

	public class BovinoConcreto extends Bovino {
		
		public BovinoConcreto(String nome, int idade) throws Exception {
			super(nome, idade);
		}

		@Override
		public String toString() {
			return "Bovino " + getNome() + ", " + getIdade() + " ano(s) de idade.";
		}

		@Override
		public boolean equals(Object o) {
			if (!(o instanceof BovinoConcreto)) {
				return false;
			}
			BovinoConcreto bovino = (BovinoConcreto) o;
			if (bovino.getNome().equals(getNome()) && bovino.getIdade() == getIdade()) {
				return true;
			}
			return false;
		}

	}
	
	@Before
	public void setUp() throws Exception {
		b1 = new BovinoConcreto("Boi Zebu", 4);
		b2 = new BovinoConcreto("Vaca Mimosa", 5);
	}
	
	@Test (expected = Exception.class)
	public void testaBovinoIdadeNegativa() throws Exception {
		Bovino b3 = new BovinoConcreto("Boizao", -3);
	}
	
	@Test
	public void testaBovinoNomeNull() throws Exception {
		Bovino b3 = new BovinoConcreto(null, 2);
		Assert.assertEquals("Nome devia ser: Sem Nome", "Sem Nome", b3.getNome());
		Assert.assertEquals("Idade errada", 2, b3.getIdade());
	}
	
	@Test
	public void testaBovinoNomeVazio() throws Exception {
		Bovino b3 = new BovinoConcreto("", 2);
		Assert.assertEquals("Nome devia ser: Sem Nome", "Sem Nome", b3.getNome());
		Assert.assertEquals("Idade errada", 2, b3.getIdade());
	}
	
	@Test
	public void testaGetNome() {
		Assert.assertEquals("Nome Errado.", "Boi Zebu", b1.getNome());
		Assert.assertEquals("Nome Errado.", "Vaca Mimosa", b2.getNome());
	}
	
	@Test
	public void testaGetIdade() {
		Assert.assertEquals("Idade Errada.", 4, b1.getIdade());
		Assert.assertEquals("Idade Errada.", 5, b2.getIdade());
		b1.acrescentaIdade();
		b2.acrescentaIdade();
		Assert.assertEquals("Idade Errada.", 5, b1.getIdade());
		Assert.assertEquals("Idade Errada.", 6, b2.getIdade());
		for (int i = 0; i < 22; i++) {
			b1.diminuiIdade();
			b2.diminuiIdade();
		}
		Assert.assertEquals("Idade Errada.", 0, b1.getIdade());
		Assert.assertEquals("Idade Errada.", 0, b2.getIdade());
	}
	
	@Test
	public void testaToString() {
		Assert.assertTrue("toString() errado.", "Bovino Boi Zebu, 4 ano(s) de idade.".equals(b1.toString()));
		Assert.assertTrue("toString() errado.", "Bovino Vaca Mimosa, 5 ano(s) de idade.".equals(b2.toString()));
	}
	
}
