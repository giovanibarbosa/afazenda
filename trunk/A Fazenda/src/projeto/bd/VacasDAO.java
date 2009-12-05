package projeto.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import projeto.afazenda.Cliente;
import projeto.afazenda.Rebanho;
import projeto.afazenda.Vaca;

public class VacasDAO {
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

	public void insereVaca(String nome, Integer qntdDeFilhos, int idade,
			String vaqueiroCPF, Integer rebanhoID) {
		conecta();
		String sql = "INSERT INTO Vacas (nome, qntdDeFilhos, idade, vaqueiroCPF, rebanhoID) VALUES('"
				+ nome
				+ "', "
				+ qntdDeFilhos
				+ ", "
				+ idade
				+ ", '"
				+ vaqueiroCPF
				+ "', "
				+ rebanhoID + ")";
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
	}

	public void removeVaca(Integer id) {
		conecta();
		String sql = "DELETE FROM Vacas WHERE vacaID = (" + id + ")";
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
	}
	
	public String getNomeVaca(Integer vacaID) {
		conecta();

		String retorno = "";
		String sql = "SELECT nome from Vacas WHERE vacaID = " + vacaID;
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
	
	public String getVaqueiroCPF(Integer vacaID) {
		conecta();

		String retorno = "";
		String sql = "SELECT vaqueiroCPF from Vacas WHERE vacaID = " + vacaID;
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

    public int getIdadeVaca(Integer vacaID) {
        conecta();

        int retorno=0;
        String sql ="SELECT idade from Vacas WHERE vacaID = " + vacaID;

        try {
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            retorno = rs.getInt(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            close();
        }

        return retorno;
       }

    public int getQtdeFilho(Integer vacaID) {
        conecta();

        int retorno=0;
        String sql = "SELECT qntdDeFilhos from Vacas WHERE vacaID = " + vacaID;
        try {
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            retorno= rs.getInt(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            close();
        }

        return retorno;
    }

	public void atualizaQntdDeFIlhos(Integer novaQntd, Integer id) {
		conecta();
		String sql = "UPDATE Vacas SET qntdDeFilhos = " + novaQntd + " WHERE vacaID = " + id;
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
	}

    public void atualizaIdade(Integer novaIdade, Integer id) {
		conecta();
		String sql = "UPDATE Vacas SET idade = " + novaIdade + " WHERE vacaID = " + id;
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
	}

	public void atualizaNome(String nome, Integer id) {
		conecta();
		String sql = "UPDATE Vacas SET nome = '" + nome + "' WHERE vacaID = " + id;
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
	}
	
	public void atualizaVaqueiro(String novoCPF, Integer id) {
		conecta();
		String sql = "UPDATE Vacas SET vaqueiroCPF = '" + novoCPF + "' WHERE vacaID = " + id;
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
	}
	
	public void atualizaRebanho(Integer novoRebanho, Integer id) {
		conecta();
		String sql = "UPDATE Vacas SET rebanhoID = " + novoRebanho + " WHERE vacaID = " + id;
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
	}
	
	public void atualizaApartada(String isApartada, Integer id) {
		conecta();
		String sql = "UPDATE Vacas SET apartada = '" + isApartada + "' WHERE vacaID = " + id;
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
	}
	
	public void atualizaInseminada(String isInseminada, Integer id) {
		conecta();
		String sql = "UPDATE Vacas SET inseminada = '" + isInseminada + "' WHERE vacaID = " + id;
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
	}
	
	public List<Vaca> getTodasVacas(int rebanhoID) {
		conecta();
		List<Vaca> vacas = new ArrayList<Vaca>();
		String sql = "select vacaID, nome, idade, qntdDeFilhos from Vacas where rebanhoID = " + rebanhoID;
		Vaca vacaTemp;
		try {
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				vacaTemp = new Vaca(rs.getString(2), rs.getInt(3), rs.getInt(4));
				vacaTemp.setID(rs.getInt(1));
				vacas.add(vacaTemp);
				
			}
		} catch (SQLException e) {
			// TODO: handle exception
		} catch (Exception e) {
			e.getMessage();
		} finally {
			close();
		}
		return vacas;
	}
}
