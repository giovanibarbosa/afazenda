package projeto.afazenda;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Classe Cobertura
 * 
 * @author Grupo 7 - A Fazenda
 * @version 1.1 8/11/2009
 */
public class Cobertura {

	private Date dataRealParto;
	private int touroID;
	private int vacaID;
	private Date dataInseminacao;
	private int coberturaID;

	/**
	 * Construtor da classe cobertura
	 * 
	 * @param dataInseminacao
	 * @param vacaID
	 * @param touroID
	 * @throws Exception
	 *             se o ID da Vaca ou do Touro for negativo
	 */

	public Cobertura(Date dataInseminacao, int vacaID, int touroID)
			throws Exception {
		if (vacaID < 0 || touroID < 0) {
			throw new Exception("ID negativo nao permitido");
		}
		this.dataInseminacao = dataInseminacao;
		this.vacaID = vacaID;
		this.touroID = touroID;
	}

	/**
	 * Altera a Data de Inseminacao, se, e somente se, a nova Data de
	 * Inseminacao nao for nula ou antes da data corrente
	 * 
	 * @param dataInseminacao
	 * @throws ParseException 
	 */
	public void setDataInseminacao(Date novaDataInseminacao) throws ParseException {
		if (novaDataInseminacao != null
				&& !(novaDataInseminacao.before(new Date()))) {
			this.dataInseminacao = novaDataInseminacao;
		}
	}

	/**
	 * Retorna a data da inseminacao
	 * 
	 * @return data inseminacao
	 */

	public Date getDataInseminacao() {
		return dataInseminacao;
	}

	/**
	 * Altera a data do parto se o novo dia for anterior ao dia presente nao
	 * permite alterar caso contrario altera a data
	 * 
	 * @param dataParto
	 */
	public void setDataParto(Date novaDataParto) {
		if (novaDataParto != null && (!novaDataParto.before(new Date()))) {
			this.dataRealParto = novaDataParto;
		}
	}

	/**
	 * Retorna data do parto
	 * 
	 * @return data parto
	 */
	public Date getDataParto() {
		return this.dataRealParto;
	}

	/**
	 * Seta o ID touro que inseminou a vaca
	 * 
	 * @param touroInseminador
	 */

	public void setIDTouroInseminador(int touroID) {
		if (touroID > 0) {
			this.touroID = touroID;
		}
	}

	/**
	 * Retorna o ID do Touro inseminador
	 * 
	 * @return touroInseminador
	 */
	public int getIDTouroInseminador() {
		return this.touroID;
	}
	
	/**
	 * 
	 * @return o ID da Vaca acobertada
	 */
	public int getVacaID() {
		return vacaID;
	}
	
	/**
	 * Altera o ID da Vaca que sera acobertada
	 * 
	 * @param vacaID
	 */
	public void setVacaID(int vacaID) {
		if(vacaID > 0) {
			this.vacaID = vacaID;
		}
	}

	/**
	 * Altera o ID da Cobertura
	 * 
	 * @param id
	 */
	public void setID(int id) {
		this.coberturaID = id;
	}

	/**
	 * @return o ID da Cobertura
	 */
	public int getID() {
		return this.coberturaID;
	}
	
	@SuppressWarnings("deprecation")
	public Date getPossivelDataParto () throws ParseException {
		this.dataInseminacao.setMonth(this.dataInseminacao.getMonth() + 9);
		String dataFormat = this.dataInseminacao.toString();
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		Date data = fmt.parse(dataFormat);
		return data; 
	}

}
