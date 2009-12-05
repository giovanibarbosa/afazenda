package projeto.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import projeto.afazenda.Touro;
import projeto.afazenda.Vaca;

public class TourosDAO {
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

	public void insereTouro(Touro touro) {
		conecta();
		String sql = "insert into Touros (nome, idade) values (?,?)";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, touro.getNome());
			stmt.setInt(2, touro.getIdade());
			stmt.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
	}
	
	public List<Touro> getTodosTouros() {
		conecta();
		
		List<Touro> touros = new ArrayList<Touro>();
		String sql = "select idTouro, nome, idade from Touros";
		Touro touroTemp;
		try {
			stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				touroTemp = new Touro(rs.getString(2), rs.getInt(3));
				touroTemp.setID(rs.getInt(1));
				touros.add(touroTemp);
			}
		} catch (SQLException e) {
			// TODO: handle exception
		} catch (Exception e) {
			e.getMessage();
		} finally {
			close();
		}
		return touros;
	}
}
