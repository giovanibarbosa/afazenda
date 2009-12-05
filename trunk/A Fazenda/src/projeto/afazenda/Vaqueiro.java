package projeto.afazenda;

/**
 * Classe que representa um Vaqueiro
 * @author Grupo 07 - A Fazenda
 *
 */
public class Vaqueiro {
	private String cpf;
	private String nome;
	private int idade;
	private String endereco;
	
	/**
	 * Construtor de um Vaqueiro
	 * @param cpf o cpf do vaqueiro
	 * @param nome o nome do vaqueiro
	 * @param endereco o endereco do vaqueiro
	 * @param idade a idade do vaqueiro
	 * @throws Exception caso o nome, o cpf, o endereco ou a idade sejam invalidas
	 */
	public Vaqueiro(String cpf, String nome, String endereco, int idade) throws Exception {
		
		if (cpf == null || cpf.length() != 11) {
			throw new Exception("Cpf Invalido");
		}
		if (nome == null || nome.isEmpty()) {
			throw new Exception("Nome Invalido");
		}
		if (idade <= 0) {
			throw new Exception("Idade Invalida");
		}
		this.cpf = cpf;
		this.nome = nome;
		this.endereco = endereco;
		this.idade = idade;
	}
	
	/**
	 * 
	 * @return o cpf do Vaqueiro
	 */
	public String getCpf() {
		return cpf;
	}
	
	/**
	 * Seta o cpf do vaqueiro
	 * @param cpf do vaqueiro
	 */
	public void setCpf(String cpf) {
		if (cpf != null && cpf.length() == 11) {
			this.cpf = cpf;
		}
	}
	
	/**
	 * 
	 * @return o nome do vaqueiro
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Seta o nome do Vaqueiro
	 * @param nome o novo nome do Vaqueiro
	 */
	public void setNome(String nome) throws Exception {
		if (nome != null && !(nome.isEmpty())) {
			this.nome = nome;
		}
	}
	
	/**
	 * 
	 * @return a idade do Vaqueiro
	 */
	public int getIdade() {
		return idade;
	}
	
	/**
	 * 
	 * @param idade
	 * @throws Exception
	 */
	public void setIdade(int idade) {
		if (idade > 0) {
			this.idade = idade;
		}
	}

	/**
	 * 
	 * @return o endereco do Vaqueiro
	 */
	public String getEndereco() {
		return endereco;
	}
	
	/**
	 * Seta o endereco do Vaqueiro
	 * @param endereco o novo endereco do Vaqueiro
	 */
	public void setEndereco(String endereco) {
		if (endereco != null && !endereco.isEmpty()) {
			this.endereco = endereco;
		}
	}

}
