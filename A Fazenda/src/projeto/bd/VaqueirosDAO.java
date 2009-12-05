package projeto.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import projeto.afazenda.Vaca;
import projeto.afazenda.Vaqueiro;

public class VaqueirosDAO {
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

	public void insereVaqueiro(String vaqueiroCPF, String nome,
			String endereco, Integer idade) {
		conecta();
		String sql = "INSERT INTO Vaqueiros (vaqueiroCPF, nome, endereco, idade) VALUES ('"
				+ vaqueiroCPF
				+ "', '"
				+ nome
				+ "', '"
				+ endereco
				+ "', "
				+ idade + ")";
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
	}

	public void removeVaqueiro(String cpf) {
		conecta();
		String sql = "DELETE FROM Vaqueiros WHERE vaqueiroCPF = ('" + cpf
				+ "')";
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
	}

	public void atualizaNome(String novoNome, String cpf) {
		conecta();
		String sql = "UPDATE Vaqueiros SET nome = '" + novoNome
				+ "' WHERE vaqueiroCPF = " + cpf;
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
	}

	public void atualizaEndereco(String novoEndereco, String cpf) {
		conecta();
		String sql = "UPDATE Vaqueiros SET endereco = '" + novoEndereco
				+ "' WHERE vaqueiroCPF = " + cpf;
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
	}

	public void atualizaIdade(Integer novaIdade, String cpf) {
		conecta();
		String sql = "UPDATE Vaqueiros SET idade = " + novaIdade
				+ " WHERE vaqueiroCPF = " + cpf;
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
	}

	public List<Vaqueiro> getTodosVaqueiros() {
		conecta();
		List<Vaqueiro> vaqueiros = new ArrayList<Vaqueiro>();
		String sql = "select vaqueiroCPF, nome, endereco, idade from Vaqueiros";
		Vaqueiro vaqueiroTemp;
		try {
            ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				vaqueiroTemp = new Vaqueiro(rs.getString(1), rs.getString(2),
						rs.getString(3), rs.getInt(4));
				vaqueiros.add(vaqueiroTemp);
			}
		} catch (SQLException e) {
			// TODO: handle exception
		} catch (Exception e) {
			e.getMessage();
		} finally {
			close();
		}
		return vaqueiros;
	}
}
