package net.com.callTrabalhoJava.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.com.callTrabalhoJava.model.Configuracao;

public class ConfiguracaoDao {
	private String jdbcURL = "jdbc:mysql://localhost:3306/DB_PROJETOJAVACRUD";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";
	
	public ConfiguracaoDao() {
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

	public void insertConfiguracao(Configuracao configuracao) throws SQLException {
		String INSERT_USERS_SQL = "INSERT INTO TB_CONFIGURACAO (mensagem1, mensagem2, mensagem3, mensagem4) VALUES (?, ?, ?, ?);";
		
		System.out.println(INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		Connection connectio = getConnection();
		System.out.println("connection: " + connectio);
		try (Connection connection = getConnection();
			//System.out.println("connection: " + connection);
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, configuracao.getMensagem1());
			preparedStatement.setString(2, configuracao.getMensagem2());
			preparedStatement.setString(3, configuracao.getMensagem3());
			preparedStatement.setString(4, configuracao.getMensagem4());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Configuracao selectConfiguracao(int codigo) {
		Configuracao configuracao = null;
		String SELECT_USER_BY_ID = "SELECT * FROM TB_CONFIGURACAO WHERE codigo =?";
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
				String mensagem1 = rs.getString("mensagem1");
				String mensagem2 = rs.getString("mensagem2");
				String mensagem3 = rs.getString("mensagem3");
				String mensagem4 = rs.getString("mensagem4");
				configuracao = new Configuracao(codigo, mensagem1, mensagem2, mensagem3, mensagem4);
				System.out.println(configuracao);
			}
			connection.close();
		} catch (SQLException e) {
			printSQLException(e);
		}
		return configuracao;
	}

	public List<Configuracao> selectAllConfiguracoes() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		String SELECT_ALL_USERS = "SELECT * FROM TB_CONFIGURACAO";
		List<Configuracao> configuracoes = new ArrayList<>();
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
				String mensagem1 = rs.getString("mensagem1");
				String mensagem2 = rs.getString("mensagem2");
				String mensagem3 = rs.getString("mensagem3");
				String mensagem4 = rs.getString("mensagem4");
				configuracoes.add(new Configuracao(codigo, mensagem1, mensagem2, mensagem3, mensagem4));
			}
			connection.close();
		} catch (SQLException e) {
			printSQLException(e);
		}
		return configuracoes;
	}

	public boolean deleteConfiguracao(int codigo) throws SQLException {
		boolean rowDeleted;
		String DELETE_USERS_SQL = "DELETE FROM TB_CONFIGURACAO WHERE codigo = ?;";
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
			statement.setInt(1, codigo);
			rowDeleted = statement.executeUpdate() > 0;
			connection.close();
		}
		return rowDeleted;
	}

	public boolean updateConfiguracao(Configuracao configuracao) throws SQLException {
		boolean rowUpdated;
		String UPDATE_USERS_SQL = "UPDATE TB_CONFIGURACAO SET mensagem1 = ?, mensagem2= ?, mensagem3 =?, mensagem4=? WHERE codigo = ?;";
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			statement.setString(1, configuracao.getMensagem1());
			statement.setString(2, configuracao.getMensagem2());
			statement.setString(3, configuracao.getMensagem3());
			statement.setString(4, configuracao.getMensagem4());
			statement.setInt(5, configuracao.getCodigo());

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
