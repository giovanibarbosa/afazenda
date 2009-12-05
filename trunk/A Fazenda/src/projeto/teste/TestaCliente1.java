package projeto.teste;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import projeto.afazenda.Cliente;

/**
 * Classe de testes para o Cliente
 * 
 * @author Grupo 07 - A Fazenda
 *
 */
public class TestaCliente1 {
	
	private Cliente c1;
	private Cliente c2;
	
	@Before
	public void setUp() throws Exception {
		c1 = new Cliente("Manoel Fresco", "11122244455", "Rua dos Clientes, 100. Bairro dos Clientes.", "8333335555");
		c2 = new Cliente("Joaquim", "22233344466", "Rua dos Clientes, 10. Bairro dos Clientes.", "8311112222");
	}
	
	@Test (expected = Exception.class)
	public void testaNomeNull() throws Exception {
		Cliente c3 = new Cliente("a23ad", "11122233366", "Rua dos cornos, 11. Bairro dos Cornos.", "8344445555");
	}
	
	@Test (expected = Exception.class)
	public void testaNomeVazio() throws Exception {
		Cliente c3 = new Cliente(null, "11122233366", "Rua dos cornos, 11. Bairro dos Cornos.", "8344445555");
	}
	
	@Test (expected = Exception.class)
	public void testaCpfNull() throws Exception {
		Cliente c3 = new Cliente("Corno", null, "Rua dos cornos, 11. Bairro dos Cornos.", "8344445555");
	}
	
	@Test (expected = Exception.class)
	public void testaCpfVazio() throws Exception {
		Cliente c3 = new Cliente("Corno", "", "Rua dos cornos, 11. Bairro dos Cornos.", "8344445555");
	}
	
	@Test (expected = Exception.class)
	public void testaEnderecoNull() throws Exception {
		Cliente c3 = new Cliente("Corno", "11122233366", null, "8344445555");
	}
	
	@Test (expected = Exception.class)
	public void testaEnderecoVazio() throws Exception {
		Cliente c3 = new Cliente("Corno", "11122233366", "", "8344445555");
	}
	
	@Test (expected=Exception.class)
	public void testaGetNome() {
		Assert.assertEquals("Nome errado", "Manoel Fresco", c1.getNome());
		Assert.assertEquals("Nome errado", "Joaquim", c2.getNome());
		c1.setNome("");
		c2.setNome(null);
		Assert.assertEquals("Nome errado", "Manoel Fresco", c1.getNome());
		Assert.assertEquals("Nome errado", "Joaquim", c2.getNome());
		c1.setNome("M4no3l");
		c2.setNome("Joa$%quim?");
		Assert.assertEquals("Nome errado", "Manoel Fresco", c1.getNome());
		Assert.assertEquals("Nome errado", "Joaquim", c2.getNome());
		c1.setNome("Ze");
		c2.setNome("Joao");
		Assert.assertEquals("Nome errado", "Ze", c1.getNome());
		Assert.assertEquals("Nome errado", "Joao", c2.getNome());
	}
	
	@Test
	public void testaGetCpf() {
		Assert.assertEquals("Cpf errado", "111.222.444-55", c1.getCpf());
		Assert.assertEquals("Cpf errado", "222.333.444-66", c2.getCpf());
	}
	
	@Test(expected=Exception.class)
	public void testaGetEndereco() {
		Assert.assertEquals("Endereco errado", "Rua dos Clientes, 100. Bairro dos Clientes.", c1.getEndereco());
		Assert.assertEquals("Endereco errado", "Rua dos Clientes, 10. Bairro dos Clientes.", c2.getEndereco());
		c1.setEndereco("");
		c2.setEndereco(null);
		Assert.assertEquals("Endereco errado", "Rua dos Clientes, 100. Bairro dos Clientes.", c1.getEndereco());
		Assert.assertEquals("Endereco errado", "Rua dos Clientes, 10. Bairro dos Clientes.", c2.getEndereco());
		c1.setEndereco("Rua dos cornos, 11. Bairro dos Cornos.");
		c2.setEndereco("Rua dos cornos, 12. Bairro dos Cornos.");
		Assert.assertEquals("Endereco errado", "Rua dos cornos, 11. Bairro dos Cornos.", c1.getEndereco());
		Assert.assertEquals("Endereco errado", "Rua dos cornos, 12. Bairro dos Cornos.", c2.getEndereco());
	}
	
	@Test(expected=Exception.class)
	public void testaGetTelefone() throws Exception {
		Cliente c3 = new Cliente("Corno", "11122233366", "Rua dos cornos, 11. Bairro dos Cornos.", "");
		Cliente c4 = new Cliente("Corno2", "11122233377", "Rua dos cornos, 12. Bairro dos Cornos.", null);
		Assert.assertEquals("Telefone errado", "Sem Telefone", c3.getTelefone());
		Assert.assertEquals("Telefone errado", "Sem Telefone", c4.getTelefone());
		Assert.assertEquals("Telefone errado", "(83)3333-5555", c1.getTelefone());
		c1.setTelefone("");
		Assert.assertEquals("Telefone errado", "Sem Telefone", c1.getTelefone());
		c1.setTelefone("8333334444");
		Assert.assertEquals("Telefone errado", "(83)3333-4444", c1.getTelefone());
		c1.setTelefone(null);
		Assert.assertEquals("Telefone errado", "Sem Telefone", c1.getTelefone());
	}
	
}
