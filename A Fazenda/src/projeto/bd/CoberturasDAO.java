package projeto.bd;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import projeto.afazenda.Cobertura;
import projeto.afazenda.Vaqueiro;

public class CoberturasDAO {
	private String driver = "com.mysql.jdbc.Driver";
	private String banco = "AFazenda";
	private String host = "localhost";
	private String str_conn = "jdbc:mysql://" + host + ":3306/" + banco;
	private String usuario = "root";
	private String senha = "root";
	private Connection conexao;
	private Statement stmt;

	private void conecta() {
		try {
			Class.forName(driver);
			conexao = DriverManager.getConnection(str_conn, usuario, senha);
			stmt = conexao.createStatement();
		} catch (ClassNotFoundException e) {
			System.out.println("Problemas com o carregamento do driver");
		} catch (SQLException e) {
			System.out.println("Problemas com a conexao com o banco de dados");
		}
	}

	private void close() {
		try {
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Comando não pôde ser fechado");
		}
		try {
			conexao.close();
		} catch (SQLException e) {
			System.out.println("Conexao não pôde ser fechada");
		}
	}

	public void insereCobertura(Date dataDaInseminacao, Integer idTouro,
			Date previsaoDeParto, Date dataRealDoParto, Integer vacaID) {
		conecta();
		String sql = "INSERT INTO Coberturas (dataInseminacao, idTouro, previsaoDeParto, dataRealParto, vacaID) VALUES ('"
				+ dataDaInseminacao
				+ "', "
				+ idTouro
				+ ", '"
				+ previsaoDeParto
				+ "', '" + dataRealDoParto + "', " + vacaID + ")";
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
	}

	public void atualizaDataRealParto(Date dataReal, Integer id) {
		conecta();
		String sql = "UPDATE Coberturas SET dataRealParto = '" + dataReal
				+ "' WHERE coberturaID = " + id;
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
	}

	public List<Cobertura> getTodasCoberturas() {
		conecta();
		List<Cobertura> coberturas = new ArrayList<Cobertura>();
		String sql = "select coberturaID, dataInseminacao, idTouro, "
				+ "previsaoDeParto, dataRealParto, vacaID from Coberturas";
		Cobertura coberturaTemp;
		try {
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				coberturaTemp = new Cobertura(rs.getDate(2), rs.getInt(6), rs.getInt(3));
				coberturaTemp.setID(rs.getInt(1));
				coberturas.add(coberturaTemp);
			}
		} catch (SQLException e) {
			// TODO: handle exception
		} catch (Exception e) {
			e.getMessage();
		} finally {
			close();
		}
		return coberturas;
	}
}
