package projeto.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import projeto.afazenda.Cliente;

public class ClientesDAO {
	private String driver = "com.mysql.jdbc.Driver";
	private String banco = "AFazenda";
	private String host = "localhost";
	private String str_conn = "jdbc:mysql://" + host + ":3306/" + banco;
	private String usuario = "root";
	private String senha = "root";
	private Connection conexao;
	private java.sql.PreparedStatement stmt;
	public static DefaultTableModel modelo = new DefaultTableModel();

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

	public void insereCliente(Cliente cliente) {
		conecta();
		String sql = "insert into Clientes (clienteCPF, nome, endereco, telefone) values (?,?,?,?)";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cliente.getCpf());
			stmt.setString(2, cliente.getNome());
			stmt.setString(3, cliente.getEndereco());
			stmt.setString(4, cliente.getTelefone());
			stmt.execute();
		} catch (SQLException e) {
			e.notify();
		} finally {
			close();
		}
	}

	public void removeCliente(Cliente cliente) {
		conecta();
		String sql = "DELETE FROM Clientes WHERE clienteCPF = (?)";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cliente.getCpf());
			stmt.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
	}

	public void atualizaNome(String novoNome, Cliente cliente) {
		conecta();
		String sql = "UPDATE Clientes SET nome=(?) WHERE clienteCPF=(?)";
		cliente.setNome(novoNome);
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getCpf());
			stmt.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
	}

	public void atualizaEndereco(String novoEndereco, Cliente cliente) {
		conecta();
		cliente.setEndereco(novoEndereco);
		String sql = "UPDATE Clientes SET endereco=(?) WHERE clienteCPF=(?)";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cliente.getEndereco());
			stmt.setString(2, cliente.getCpf());
			stmt.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
	}

	public void atualizaTelefone(String novoTel, Cliente cliente) {
		conecta();
		cliente.setTelefone(novoTel);
		String sql = "UPDATE Clientes SET telefone=(?) WHERE clienteCPF=(?)";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cliente.getTelefone());
			stmt.setString(2, cliente.getCpf());
			stmt.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
	}

	public void atualizaTotalComprado(Double novoTotal, Cliente cliente) {
		conecta();
		// cliente.setTotalComprado(novoTotal);
		String sql = "UPDATE Clientes SET totalCompradp=(?) WHERE clienteCPF=(?)";
		try {
			stmt = conexao.prepareStatement(sql);
			// stmt.setString(1, cliente.getTotalComprado());
			stmt.setString(2, cliente.getCpf());
			stmt.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
	}

//	public DefaultTableModel consultarClientes() {
//		conecta();
//		
//		modelo.addColumn("CPF");
//		modelo.addColumn("Nome");
//		modelo.addColumn("Endereço");
//		modelo.addColumn("Telefone");
//		modelo.addColumn("Total Comprado");
//		String sql = "select * from Clientes";
//		try {
//			stmt = conexao.prepareStatement(sql);
//			ResultSet rs = stmt.executeQuery();
//			while (rs.next()) {
//				modelo.addRow(new Object[] { rs.getString(1), rs.getString(2),
//						rs.getString(3), rs.getString(4), rs.getDouble(5) });
//			}
//			return modelo;
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());
//			return null;
//		} finally {
//			close();
//		}
//	}
	
	public List<Cliente> getTodosClientes() {
		conecta();
		List<Cliente> clientes = new ArrayList<Cliente>();
		String sql = "select clienteCPF, nome, endereco, telefone from Clientes";
		Cliente clienteTemp;
		try {
			stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				clienteTemp = new Cliente(rs.getString(1), rs.getString(2), 
						rs.getString(3), rs.getString(4));
				clientes.add(clienteTemp);
			}
		} catch (SQLException e) {
			// TODO: handle exception
		} catch (Exception e) {
			e.getMessage();
		} finally {
			close();
		}
		return clientes;
	}
}
