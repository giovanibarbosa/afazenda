package projeto.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import projeto.afazenda.Vacina;

public class VacinasDAO {
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

	public void vacinar(String nome, Double dosagem, Integer vacaID) {
		conecta();
		String sql = "INSERT INTO Vacinas (nome, dosagem, vacaID) VALUES ('"
				+ nome + "', " + dosagem + ", " + vacaID + ")";
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
	}

	public List<Vacina> getTodasVacinas() {
		conecta();
		List<Vacina> vacinas = new ArrayList<Vacina>();
		String sql = "select nome, dosagem, vacaID from Vacinas";
		Vacina vacinaTemp;
		try {
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				vacinaTemp = new Vacina(rs.getString(1), rs.getDouble(2));
				vacinaTemp.vacinar(rs.getInt(3));
				vacinas.add(vacinaTemp);
			}
		} catch (SQLException e) {
			// TODO: handle exception
		} catch (Exception e) {
			e.getMessage();
		} finally {
			close();
		}
		return vacinas;
	}
}
