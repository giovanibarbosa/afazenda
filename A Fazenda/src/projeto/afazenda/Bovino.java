package projeto.afazenda;

/**
 * Classe que representa um Bovino
 * 
 * @author Grupo 7 - A Fazenda
 * @version 1.1 10/10/2009
 * 
 */
public abstract class Bovino {
	private String nome;
	private int idade;

	/**
	 * Construtor que cria um Bovino
	 * 
	 * @param nome
	 *            O nome do Bovino
	 * @param idade
	 *            A idade do Bovino
	 * @throws Exception
	 *             Caso o nome seja vazio ou nulo e caso a idade seja menor ou
	 *             igual a 0
	 */
	public Bovino(String nome, int idade) throws Exception {
		if (!(String.valueOf(idade).matches("[0-9]+")) || idade < 0) {
			throw new Exception("Idade invalida");
		}
		this.idade = idade;
		if (nome == null || nome.isEmpty()) {
			this.nome = "Sem Nome";
		} else {
			this.nome = nome;
		}
	}
	
	/**
	 * Seta um nome para o Bovino
	 * @param nome o nome a ser setado
	 */
	public void setNome(String nome) {
		if (nome == null || nome.isEmpty()) {
			this.nome = "Sem Nome";
		} else {
			this.nome = nome;
		}
	}

	/**
	 * Recupera o nome do Bovino
	 * 
	 * @return O nome do Bovino
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Recupera a idade do Bovino
	 * 
	 * @return A idade do Bovino
	 */
	public int getIdade() {
		return idade;
	}
	
	/**
	 * Acrescenta em um ano a idade da Vaca
	 */
	public void acrescentaIdade() {
		this.idade += 1;
	}
	
	/**
	 * Remove em um ano a idade da Vaca
	 */
	public void diminuiIdade() {
		if (idade > 0) {	
			this.idade -= 1;
		}
	}

	/**
	 * Representacao String de um Bovino
	 * 
	 * @return Uma String Bovino
	 */
	public abstract String toString();

	/**
	 * Compara se o Bovino eh igual a outro objeto
	 * 
	 * @return true caso o objeto a ser comparado seja igual a este Bovino,
	 *         false caso contrario
	 */
	public abstract boolean equals(Object o);

}
