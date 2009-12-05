package projeto.afazenda;

import java.util.List;
import java.util.ArrayList;

/**
 * Classe Vaca
 * 
 * @author Grupo 07 - A Fazenda
 * 
 */
public class Vaca extends Bovino {

	private int ID;
	private int qntdFilhos;
	private Vaqueiro vaqueiroResponsavel;
	private List<Cobertura> coberturas = new ArrayList<Cobertura>();
	private List<Vacina> vacinas = new ArrayList<Vacina>();

	/**
	 * Construtor de uma Vaca
	 * 
	 * @param ID
	 *            o ID da vaca
	 * @param nome
	 *            o nome da vaca
	 * @param idade
	 *            a idade da vaca
	 * @param qntdFilhos
	 *            a quantidade de filhos da vaca
	 * @throws Exception
	 *             caso a idade seja menor ou igual a zero ou a quantidade de
	 *             filho seja menor qu zero
	 */
	public Vaca(String nome, int idade, int qntdFilhos) throws Exception {
		super(nome, idade);
		if (!(String.valueOf(qntdFilhos).matches("[0-9]+")) || qntdFilhos < 0) {
			throw new Exception("Quantidade de filhos invalida!");
		}
		this.qntdFilhos = qntdFilhos;
	}

	/**
	 * 
	 * @return o ID da vaca
	 */
	public int getID() {
		return this.ID;
	}

    public void setID(int id) {
    	if (id > 0) {
        	ID = id;
        }
    }

	/**
	 * 
	 * @return a quantidade de filhos da vaca
	 */
	public int getQntdFilhos() {
		return this.qntdFilhos;
	}

	/**
	 * 
	 * @return o vaqueiro responsavel pela vaca
	 */
	public Vaqueiro getVaqueiroResponsavel() {
		return this.vaqueiroResponsavel;
	}

	/**
	 * 
	 * @return uma lista com todas as coberturas da vaca
	 */
	public List<Cobertura> listaCobertura() {
		return this.coberturas;
	}

	/**
	 * 
	 * @return uma lista com as vacinas tomadas por uma vaca
	 */
	public List<Vacina> listaVacinas() {
		return this.vacinas;
	}

	/**
	 * Adiciona um filho a vaca
	 */
	public void adicionarFilho() {
		this.qntdFilhos += 1;
	}

	/**
	 * Remove um filho da vaca
	 */
	public void diminuirQntdFilhos() {
		if (getQntdFilhos() > 0) {
			this.qntdFilhos -= 1;
		}
	}

	/**
	 * Seta o Vaqueiro responsavel pela Vaca
	 * 
	 * @param vaqueiro
	 *            o vaqueiro
	 */
	public void setVaqueiroResponsavel(Vaqueiro vaqueiro) {
		if (vaqueiro != null) {
			this.vaqueiroResponsavel = vaqueiro;
		}
	}

	/**
	 * Adiciona uma Cobertura a Vaca
	 * 
	 * @param cobertura
	 *            a cobertura a ser adicionada
	 * @return true em sucesso e false em caso de falha
	 * @throws Exception
	 *             caso a cobertura seja null
	 */
	public boolean adicionaCobertura(Cobertura cobertura) throws Exception {
		if (cobertura == null) {
			throw new Exception("A cobertura passada nao pode ser null.");
		}
		for (Cobertura cob : this.coberturas) {
			if (cobertura.equals(cob)) {
				return false;
			}
		}
		this.coberturas.add(cobertura);
		return true;
	}

	/**
	 * Remove uma Cobertura da Vaca
	 * 
	 * @param cobertura
	 *            a cobertura a ser removida
	 * @return true em sucesso e false em caso de falha
	 * @throws Exception
	 *             caso a cobertura passada seja null
	 */
	public boolean removeCobertura(Cobertura cobertura) throws Exception {
		if (cobertura == null) {
			throw new Exception("A cobertura passada nao pode ser null.");
		}
		for (int i = 0; i < this.coberturas.size(); i++) {
			if (cobertura.equals(this.coberturas.get(i))) {
				this.coberturas.remove(i);
				return true;
			}
		}
		return false;
	}

	/**
	 * Adiciona uma Vacina a Vaca
	 * 
	 * @param vacina
	 *            a vacina a ser adicionada
	 * @return true em sucesso e false em caso de falha
	 * @throws Exception
	 *             caso a vacina passada seja null
	 */
	public boolean adicionaVacina(Vacina vacina) throws Exception {
		if (vacina == null) {
			throw new Exception("A vacina passada nao pode ser null.");
		}
		this.vacinas.add(vacina);
		return true;
	}

	/**
	 * Remove uma Vacina da colecao de vacinas da Vaca
	 * 
	 * @param vacina
	 *            a vacina a ser removida
	 * @return true em sucesso e false em caso de falha
	 * @throws Exception
	 *             caso a vacina passada seja null
	 */
	public boolean removeVacina(Vacina vacina) throws Exception {
		if (vacina == null) {
			throw new Exception("A vacina passada nao pode ser null.");
		}
		for (int i = 0; i < this.vacinas.size(); i++) {
			if (vacina.equals(this.vacinas.get(i))) {
				this.vacinas.remove(i);
				return true;
			}
		}
		return false;
	}

	/**
	 * Representacao em String de uma Vaca
	 */
	@Override
	public String toString() {
		return "Vaca: " + getNome() + " | " + "ID: " + getID();
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Vaca)) {
			return false;
		}
		Vaca vaca = (Vaca) o;
		if (vaca.getNome().equals(getNome()) && vaca.getIdade() == getIdade()
				&& vaca.getID() == vaca.getID()
				&& vaca.getQntdFilhos() == getQntdFilhos()) {
			return true;
		}
		return false;
	}

}
