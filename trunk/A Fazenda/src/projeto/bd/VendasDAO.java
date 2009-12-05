package projeto.bd;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VendasDAO {
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

	public void vender(Double qntdDeLeite, Double valor, String clienteCPF, Date dataDeVenda) {
		conecta();
		String sql = "INSERT INTO Vendas (qntdDeLeite, valor, clienteCPF, Date dataDeVenda) VALUES (" + 
		qntdDeLeite + ", " + valor + ", '" + clienteCPF + "', '" + dataDeVenda + "')";
		try {
			stmt.executeUpdate(sql);
			stmt.close();
			computaCaixa(dataDeVenda);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {			
			close();
		}
	}
	
	private void computaCaixa(Date dataDaAtualizacao) { 
		Double total = 0.0;
		try {
			ResultSet rs = stmt.executeQuery("SELECT valor FROM Vendas");
			while (rs.next()) {
				total += rs.getDouble(1);
			}
			stmt.close();
			String sql = "INSERT INTO Caixa (total, dataDaAtualizacao) VALUES (" + total + ", '" + dataDaAtualizacao + "')'";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
