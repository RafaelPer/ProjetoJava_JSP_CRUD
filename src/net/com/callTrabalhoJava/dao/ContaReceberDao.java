package net.com.callTrabalhoJava.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.com.callTrabalhoJava.model.ContaReceber;

public class ContaReceberDao {
	private String jdbcURL = "jdbc:mysql://localhost:3306/DB_PROJETOJAVACRUD";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";
	
	public ContaReceberDao() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public void insertContaReceber(ContaReceber contareceber) throws SQLException {
		String INSERT_USERS_SQL = "INSERT INTO TB_CONTARECEBER (emissao, vencimento, pagamento, valor) VALUES (?, ?, ?, ?);";
		
		System.out.println(INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		Connection connectio = getConnection();
		System.out.println("connection: " + connectio);
		try (Connection connection = getConnection();
			//System.out.println("connection: " + connection);
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			java.sql.Date emissao = new java.sql.Date (contareceber.getEmissao().getTime());
			java.sql.Date vencimento = new java.sql.Date (contareceber.getVencimento().getTime());
			java.sql.Date pagamento = new java.sql.Date (contareceber.getPagamento().getTime());
			preparedStatement.setDate(1, emissao);
			preparedStatement.setDate(2, vencimento);
			preparedStatement.setDate(3, pagamento);
			preparedStatement.setFloat(4, contareceber.getValor());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public ContaReceber selectContaReceber(int codigo) {
		ContaReceber contareceber = null;
		String SELECT_USER_BY_ID = "SELECT * FROM TB_CONTARECEBER WHERE codigo =?";
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setInt(1, codigo);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				Date emissao = rs.getDate("emissao");
				Date vencimento = rs.getDate("vencimento");
				Date pagamento = rs.getDate("pagamento");
				float valor = rs.getFloat("valor");
				contareceber = new ContaReceber(codigo, emissao, vencimento, pagamento, valor);
				System.out.println(contareceber);
			}
			connection.close();
		} catch (SQLException e) {
			printSQLException(e);
		}
		return contareceber;
	}

	public List<ContaReceber> selectAllContasReceber() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		String SELECT_ALL_USERS = "SELECT * FROM TB_CONTARECEBER";
		List<ContaReceber> contasReceber = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int codigo = rs.getInt("codigo");
				Date emissao = rs.getDate("emissao");
				Date vencimento = rs.getDate("vencimento");
				Date pagamento = rs.getDate("pagamento");
				float valor = rs.getFloat("valor");
				System.out.println("valor: "+valor);
				contasReceber.add(new ContaReceber(codigo, emissao, vencimento, pagamento, valor));
				//System.out.println(valor);
			}
			connection.close();
		} catch (SQLException e) {
			printSQLException(e);
		}
		System.out.println(contasReceber);
		return contasReceber;
	}

	public boolean deleteContaReceber(int codigo) throws SQLException {
		boolean rowDeleted;
		String DELETE_USERS_SQL = "DELETE FROM TB_CONTARECEBER WHERE codigo = ?;";
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
			statement.setInt(1, codigo);
			rowDeleted = statement.executeUpdate() > 0;
			connection.close();
		}
		return rowDeleted;
	}

	public boolean updateContaReceber(ContaReceber contareceber) throws SQLException {
		boolean rowUpdated;
		String UPDATE_USERS_SQL = "UPDATE TB_CONTARECEBER SET emissao = ?, vencimento= ?, pagamento =?, valor=? WHERE codigo = ?;";
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			java.sql.Date emissao = new java.sql.Date (contareceber.getEmissao().getTime());
			java.sql.Date vencimento = new java.sql.Date (contareceber.getVencimento().getTime());
			java.sql.Date pagamento = new java.sql.Date (contareceber.getPagamento().getTime());
			statement.setDate(1, emissao);
			statement.setDate(2, vencimento);
			statement.setDate(3, pagamento);
			statement.setFloat(4, contareceber.getValor());
			statement.setInt(5, contareceber.getCodigo());

			rowUpdated = statement.executeUpdate() > 0;
			connection.close();
		}
		return rowUpdated;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
}
