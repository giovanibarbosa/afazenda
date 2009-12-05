//package projeto.bd;
//
//import java.sql.Connection;
//import java.sql.Date;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class TiragensDAO {
//	private String driver = "com.mysql.jdbc.Driver";
//	private String banco = "AFazenda";
//	private String host = "localhost";
//	private String str_conn = "jdbc:mysql://" + host + ":3306/" + banco;
//	private String usuario = "root";
//	private String senha = "root";
//	private Connection conexao;
//	private Statement stmt;
//
//	private void conecta() {
//		try {
//			Class.forName(driver);
//			conexao = DriverManager.getConnection(str_conn, usuario, senha);
//			stmt = conexao.createStatement();
//		} catch (ClassNotFoundException e) {
//			System.out.println("Problemas com o carregamento do driver");
//		} catch (SQLException e) {
//			System.out.println("Problemas com a conexao com o banco de dados");
//		}
//	}
//
//	private void close() {
//		try {
//			stmt.close();
//		} catch (SQLException e) {
//			System.out.println("Comando não pôde ser fechado");
//		}
//		try {
//			conexao.close();
//		} catch (SQLException e) {
//			System.out.println("Conexao não pôde ser fechada");
//		}
//	}
//
//	public void ordenhar(Double qntdTirada, Date dataTiragem,
//			Integer vez, Integer vacaID) {
//		conecta();
//		String sql = "INSERT INTO Tiragens (qntdTirada, dataTiragem, vez, vacaID) VALUES (" + 
//		qntdTirada + ", '" + dataTiragem + "', " + vez + ", " + vacaID + ")";
//		try {
//			stmt.executeUpdate(sql);
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());
//		} finally {
//			close();
//		}
//	}
//}
