package projeto.afazenda;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe Fazenda
 * @author Grupo 7 - A Fazenda
 * @version 1.01
 *
 */
public class Fazenda {
	
	private List<Rebanho> rebanhos;
	private List<Vaqueiro> vaqueiros;
	private List<Touro> touros;
	
	
	/**
	 * Construtor default
	 */
	public Fazenda() {
		this.rebanhos = new ArrayList<Rebanho>();
		this.vaqueiros = new ArrayList<Vaqueiro>();
		this.touros = new ArrayList<Touro>();
	}
	
	
	/**
	 * 
	 * @return o total de vacas da fazenda
	 */
	public int getTotalDeVacas() {
		int totalDeVacas = 0;
		for (Rebanho reb : rebanhos) {
			totalDeVacas += reb.getQntdDeVacas();
		}
		return totalDeVacas;
	}
	
	/**
	 * 
	 * @return o total de Touros da Fazenda
	 */
	public int getTotalDeTouros() {
		return this.touros.size();
	}
	
	/**
	 * 
	 * @return o total de vaqueiros da fazenda
	 */
	public int getTotalDeVaqueiros() {
		return this.vaqueiros.size();
	}
	
	/**
	 * 
	 * @return o total de rebanhos da fazenda
	 */
	public int getTotalDeRebanhos() {
		return this.rebanhos.size();
	}
	
	/**
	 * Adiciona um novo Rebanho na Fazenda
	 * @param rebanho o rebanho a ser adicionado
	 * @return true em sucesso e false em caso de falha
	 * @throws Exception caso o rebanho passado seja null
	 */
	public boolean adicionaRebanho(Rebanho rebanho) throws Exception {
		if (rebanho == null) {
			throw new Exception("O rebanho passado nao pode ser null.");
		}
		for (Rebanho reb : this.rebanhos) {
			if (reb.equals(rebanho)) {
				return false;
			}
		}
		this.rebanhos.add(rebanho);
		return true;
	}
	
	/**
	 * Remove um Rebanho da fazenda
	 * @param rebanho o rebanho a ser removido
	 * @return true em sucesso e false em caso de falha
	 * @throws Exception caso o rebanho passado seja null
	 */
	public boolean removeRebanho(Rebanho rebanho) throws Exception {
		if (rebanho == null) {
			throw new Exception("O rebanho passado nao pode ser null.");
		}
		for (int i = 0; i < this.rebanhos.size(); i++) {
			if (rebanho.equals(this.rebanhos.get(i))) {
				this.rebanhos.remove(i);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Adiciona um novo Vaqueiro na Fazenda
	 * @param vaqueiro o vaqueiro a ser adicionado
	 * @return true em sucesso e false em caso de falha
	 * @throws Exception caso o vaqueiro passado seja null
	 */
	public boolean adicionaVaqueiro(Vaqueiro vaqueiro) throws Exception {
		if (vaqueiro == null) {
			throw new Exception("O vaqueiro passado nao pode ser null.");
		}
		for (Vaqueiro vaq : this.vaqueiros) {
			if (vaq.equals(vaqueiro)) {
				return false;
			}
		}
		this.vaqueiros.add(vaqueiro);
		return true;
	}
	
	/**
	 * Remove um Vaqueiro da Fazenda
	 * @param vaqueiro o vaqueiro a ser removido
	 * @return true em sucesso e false em caso de falha
	 * @throws Exception caso o vaqueiro passado seja null
	 */
	public boolean removeVaqueiro(Vaqueiro vaqueiro) throws Exception {
		if (vaqueiro == null) {
			throw new Exception("O vaqueiro passado nao pode ser null.");
		}
		for (int i = 0; i < this.vaqueiros.size(); i++) {
			if (vaqueiro.equals(this.vaqueiros.get(i))) {
				this.vaqueiros.remove(i);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Adiciona um Touro na Fazenda
	 * @param touro o touro a ser adicionado
	 * @return true em sucesso e false em caso de falha
	 * @throws Exception caso o touro passado seja null
	 */
	public boolean adicionaTouro(Touro touro) throws Exception {
		if (touro == null) {
			throw new Exception("O touro passado nao pode ser null.");
		}
		for (Touro tou : this.touros) {
			if (tou.equals(touro)) {
				return false;
			}
		}
		this.touros.add(touro);
		return true;
	}
	
	/**
	 * Remove um Touro da Fazenda
	 * @param touro o touro a ser removido
	 * @return true em sucesso e false em caso de falha
	 * @throws Exception caso o touro passado seja null
	 */
	public boolean removeTouro(int ID) throws Exception {
		if (proucuraTouro(ID) != -1) {
			this.touros.remove(proucuraTouro(ID));
			return true;
		}
		return false;
	}
	
	private int proucuraTouro(int ID) {
		for (Touro tou : this.touros) {
			if (tou.getID() == ID) {
				return this.touros.indexOf(tou);
			}
		}
		return -1;
	}
	
	/**
	 * 
	 * @return uma lista com os Rebanhos da Fazenda
	 */
	public List<Rebanho> listaRebanhos() {
		return rebanhos;
	}
	
	/**
	 * 
	 * @return uma lista com os Vaqueiros da Fazenda
	 */
	public List<Vaqueiro> listaVaqueiros() {
		return this.vaqueiros;
	}
	
	/**
	 * 
	 * @return uma lista com os Touros da Fazenda
	 */
	public List<Touro> listaTouros() {
		return this.touros;
	}

}
