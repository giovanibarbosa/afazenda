package projeto.afazenda;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Classe que representa uma Tiragem
 * @author Grupo 07 - A Fazenda
 *
 */
public class Tiragem {
	
	private int tiragemID;
	private double qntdTirada;
	private Date dataTiragem;
	private int vez;
	private int vacaID;
	
	/**
	 * Construtor de uma Tiragem
	 * @param qntdTirada a quantidade de leite tirada
	 * @param dataTiragem a data da tiragem
	 * @param vez a vez da tiragem
	 * @param vacaID o ID da vaca que foi tirado o leite
	 */
	public Tiragem(double qntdTirada,Date dataTiragem, int vez, int vacaID){
		this.qntdTirada = qntdTirada;
		this.vez = vez;
		this.dataTiragem = dataTiragem;
		this.vacaID = vacaID;
	}

	/**
	 * retorna o id da tiragem
	 * @return tiragemID
	 */
	public int getTiragemID() {
		return tiragemID;
	}

	/**
	 * set o novo id da tiragem
	 * @param tiragemID
	 */
	public void setTiragemID(int novaTiragemID) {
		if (novaTiragemID > 0) {
			this.tiragemID = novaTiragemID;
		}
	}

	/**
	 * retorna a quantidade tirada
	 * @return qntdTirada
	 */
	public double getQntdTirada() {
		return qntdTirada;
	}

	/**
	 * seta um novo valor, maior que zero, para a quantidade tirada
	 * @param novaQntdTirada
	 */
	public void setQntdTirada(double novaQntdTirada) {
		if(novaQntdTirada > 0){
			this.qntdTirada = novaQntdTirada;
		}
	}

	/**
	 * retorna a data da tiragem
	 * @return dataTiragem
	 */
	public Date getDataTiragem() {
		return dataTiragem;
	}

	/**
	 * set data da tiragem, para uma data posterior a do dia corrente
	 * @param dataTiragem
	 */
	public void setDataTiragem(Date novaDataTiragem) {
		Calendar calendario = new GregorianCalendar();
		if(novaDataTiragem != null && !novaDataTiragem.before(calendario.getTime()))
			this.dataTiragem = novaDataTiragem;
	}

	/**
	 * retorna vez
	 * @return vez
	 */
	public int getVez() {
		return vez;
	}

	/**
	 * set vez
	 * @param vez
	 */
	public void setVez(int NovaVez) {
		if (vez > 0) {
			this.vez = NovaVez;
		}
	}

	/**
	 * retorna id da vaca
	 * @return vacaID
	 */
	public int getVacaID() {
		return vacaID;
	}

	/**
	 * set o id da vaca
	 * @param vacaID
	 */
	public void setVacaID(int vacaID) {
		this.vacaID = vacaID;
	}

}
