package projeto.teste;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import projeto.afazenda.Vaqueiro;

/**
 * Classe de testes para o Vaqueiro
 * 
 * @author Grupo 07 - A Fazenda
 * 
 */

public class TestaVaqueiro1 {
	
	private Vaqueiro vaq1;
	private Vaqueiro vaq2;

	@Before
	public void setUp() throws Exception {
		vaq1 = new Vaqueiro("12345678910", "Roberto", "Rua dos Cornos", 34);
		vaq2 = new Vaqueiro("01987654321", "Teobaldo", "Rua dos Doidos", 32);
	}

	@Test(expected=Exception.class)
	public void testConstrutorExceptionNomeNull() throws Exception {
		Vaqueiro v3 = new Vaqueiro("45612307896", null, "Rua dos Toba", 35);
	}

	@Test(expected=Exception.class)
	public void testConstrutorExceptionNomeVazio() throws Exception {
		Vaqueiro v3 = new Vaqueiro("45612307896", "", "Rua dos Toba", 35);
	}
	
	@Test(expected=Exception.class)
	public void testConstrutorCPFNull() throws Exception {
		Vaqueiro v3 = new Vaqueiro(null, "Tota", "Rua dos Toba", 35);
	}
	
	@Test(expected=Exception.class)
	public void testConstrutorCPFVazio() throws Exception {
		Vaqueiro v3 = new Vaqueiro("", "Tota", "Rua dos Toba", 35);
	}
	
	@Test(expected=Exception.class)
	public void testConstrutorTamanhoCPFInvalido() throws Exception {
		Vaqueiro v3 = new Vaqueiro("0121", "Tota", "Rua dos Toba", 35);
		Vaqueiro v4 = new Vaqueiro("65432164321313541", "Juquinha", "Rua dos Vaqueiros", 22);
	}
		
	@Test
	public void testGetCPF() {
		Assert.assertEquals("CPF errado", "12345678910", vaq1.getCpf());
		
		vaq1.setCpf("");
		Assert.assertEquals("CPF errado", "12345678910", vaq1.getCpf());
		
		vaq1.setCpf(null);
		Assert.assertEquals("CPF errado", "12345678910", vaq1.getCpf());
		
		vaq1.setCpf("122");
		Assert.assertEquals("CPF errado", "12345678910", vaq1.getCpf());
		
		vaq1.setCpf("45632145654775665");
		Assert.assertEquals("CPF errado", "12345678910", vaq1.getCpf());
		
		vaq1.setCpf("23178645910");
		Assert.assertEquals("CPF errado", "23178645910", vaq1.getCpf());
	}
	
	@Test
	public void testGetIdade() {
		Assert.assertEquals("Idade errada", 32, vaq2.getIdade());
		
		vaq2.setIdade(0);
		Assert.assertEquals("Idade errada", 32, vaq2.getIdade());
		
		vaq2.setIdade(-45);
		Assert.assertEquals("Idade errada", 32, vaq2.getIdade());
		
		vaq2.setIdade(33);
		Assert.assertEquals("Idade errada", 33, vaq2.getIdade());
	}
	
	@Test
	public void testGetEndereco() throws Exception {
		Assert.assertEquals("Endereco incorreto", "Rua dos Cornos", vaq1.getEndereco());
		
		vaq1.setEndereco(null);
		Assert.assertEquals("Endereco incorreto", "Rua dos Cornos", vaq1.getEndereco());
		
		vaq1.setEndereco("");
		Assert.assertEquals("Endereco incorreto", "Rua dos Cornos", vaq1.getEndereco());
	}
}
