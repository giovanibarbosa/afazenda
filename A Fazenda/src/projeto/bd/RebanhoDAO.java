package projeto.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import projeto.afazenda.Rebanho;

public class RebanhoDAO {
	private String driver = "com.mysql.jdbc.Driver";
	private String banco = "AFazenda";
	private String host = "localhost";
	private String str_conn = "jdbc:mysql://" + host + ":3306/" + banco;
	private String usuario = "root";
	private String senha = "root";
	private Connection conexao;
	private java.sql.PreparedStatement stmt;

	private void conecta() {
		try {
			Class.forName(driver);
			conexao = DriverManager.getConnection(str_conn, usuario, senha);
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
	
	public String getNomeRebanho(Integer rebanhoID) {
		conecta();

		String retorno = "";
		String sql = "SELECT nome from Vacas WHERE rebanhoID = " + rebanhoID;
		try {
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();

			retorno = rs.getString(1);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
			}
		return retorno;
	}

	public void insereRebanho(Rebanho rebanho) {
		conecta();
		String sql = "insert into Rebanhos (nome) values (?)";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, rebanho.getNome());
			stmt.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
	}
	
	public List<Rebanho> getTodosRebanhos() {
		conecta();
		List<Rebanho> rebanhos = new ArrayList<Rebanho>();
		String sql = "select rebanhoID, nome from Rebanhos";
		Rebanho rebanhoTemp;
		try {
			stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				rebanhoTemp = new Rebanho(rs.getString(2));
				rebanhoTemp.setID(rs.getInt(1));
				rebanhos.add(rebanhoTemp);
			}
		} catch (SQLException e) {
			// TODO: handle exception
		} catch (Exception e) {
			e.getMessage();
		} finally {
			close();
		}
		return rebanhos;
	}
}
