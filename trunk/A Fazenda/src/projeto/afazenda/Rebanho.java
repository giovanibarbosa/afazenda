package projeto.afazenda;

import java.util.List;
import java.util.ArrayList;

/**
 * Classe Rebanho
 * @author Grupo 07 - A Fazenda
 *
 */
public class Rebanho {
	
	private String nome;
	private int ID;
	private List<Vaca> rebanho = new ArrayList<Vaca>();
	
	/**
	 * Construtor default do Rebanho
	 * @param nome o nome do rebanho
	 */
	public Rebanho(String nome) {
		if (nome == null || nome.isEmpty()) {
			this.nome = "Sem Nome";
		} else {
			this.nome = nome;
		}
	}
	
	/**
	 * 
	 * @return o nome do rebanho
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Seta o nome do rebanho
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
	 * 
	 * @return o ID do rebanho
	 */
	public int getID() {
		return this.ID;
	}
	
	public void setID(int id) {
		if (id > 0) {
			this.ID = id;
		}
	}
	
	/**
	 * 
	 * @return uma lista com as vacas da fazenda
	 */
	public List<Vaca> listarVacas() {
		return this.rebanho;
	}
	
	/**
	 * Adiciona uma Vaca no Rebanho
	 * @param vaca a vaca a ser adicionada
	 * @return true em sucesso e false em caso de falha
	 * @throws Exception caso a vaca passada seja null
	 */
	public boolean adicionaVaca(Vaca vaca) throws Exception {
		if (vaca == null) {
			throw new Exception("A vaca passada nao pode ser null.");
		}
		for (Vaca vc : this.rebanho) {
			if (vaca.equals(vc)) {
				return false;
			}
		}
		this.rebanho.add(vaca);
		return true;
	}
	
	/**
	 * Remove uma Vaca do Rebanho
	 * @param ID o ID da vaca a ser removida
	 * @return true em sucesso e false em caso de falha
	 * @throws Exception caso a vaca passada seja null
	 */
	public boolean removeVaca(int ID) {
		if (proucuraVaca(ID) != -1) {
			this.rebanho.remove(proucuraVaca(ID));
			return true;
		}
		return false;
	}
	
	private int proucuraVaca(int ID) {
		for (Vaca vc : this.rebanho) {
			if (vc.getID() == ID) {
				return this.rebanho.indexOf(vc);
			}
		}
		return -1;
	}

	/**
	 * 
	 * @return o tamanho do rebanho
	 */
	public int getQntdDeVacas() {
		return this.rebanho.size();
	}
	
	/**
	 * Representacao em String de um Rebanho
	 */
	@Override
	public String toString() {
		return "Rebanho: " + getNome() + " | Tamanho do Rebanho: " + getQntdDeVacas();
	}
	
}