package projeto.afazenda;

/**
 * Classe que representa uma Vacina
 * 
 * @author Grupo 07 - A Fazenda
 * 
 */
public class Vacina {

	private double dosagem;
	private String nome;
	private int vacaID;

	/**
	 * Construtor de uma Vacina
	 * 
	 * @param nome
	 *            o nome da vacina
	 * @param dosagem
	 *            a dosagem da vacina
	 * @throws Exception
	 *             caso a dosagem seja menor ou igual a zero, ou caso o nome
	 *             seja nulo ou vazio
	 */
	public Vacina(String nome, double dosagem) throws Exception {
		if (dosagem <= 0) {
			throw new Exception("Dosagem invalida");
		}
		if (nome == null || nome.isEmpty()) {
			throw new Exception("Nome vacina invalido");
		}
		this.dosagem = dosagem;
		this.nome = nome;

	}
	
	/**
	 * Altera o nome da Vacina
	 * @param novoNome
	 */
	public void setNome(String novoNome) {
		if (novoNome != null && !nome.isEmpty()) {
			this.nome = novoNome;
		}
	}
	
	/**
	 * 
	 * @return o nome da Vacina
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Altera a dosagem da Vacina
	 * @param novaDosagem
	 */
	public void setDosagem(double novaDosagem) {
		if (novaDosagem > 0) {
			this.dosagem = novaDosagem;
		}
	}
	
	/**
	 * 
	 * @return a dosagem da Vacina
	 */
	public double getDosagem() {
		return dosagem;
	}

	/**
	 * Vacina uma Vaca com a Vacina
	 * @param vacaID o ID da vaca a ser vacinada
	 */
	public void vacinar(int vacaID) {
		if (vacaID > 0 && this.vacaID == 0) {
			this.vacaID = vacaID;
		}
	}

	/**
	 * @return o ID da Vaca vacinada
	 */
	public int getIDVacaVacinada() {
		return vacaID;
	}

}
