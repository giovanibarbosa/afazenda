package projeto.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import projeto.afazenda.Caixa;
import projeto.afazenda.Cliente;

public class CaixaDAO {
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
	
	public List<Caixa> consultaTotaisDoCaixa() {
		conecta();
		List<Caixa> caixas = new ArrayList<Caixa>();
		String sql = "select total, dataDaAtualizacao from Caixa";
		Caixa caixaTemp;
		try {
			stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				caixaTemp = new Caixa();
				caixas.add(caixaTemp);
			}
		} catch (SQLException e) {
			// TODO: handle exception
		} catch (Exception e) {
			e.getMessage();
		} finally {
			close();
		}
		return caixas;
	}
}
