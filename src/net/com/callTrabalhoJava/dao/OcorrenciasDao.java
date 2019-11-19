package net.com.callTrabalhoJava.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.com.callTrabalhoJava.model.Ocorrencias;

public class OcorrenciasDao {
	private String jdbcURL = "jdbc:mysql://localhost:3306/DB_PROJETOJAVACRUD";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";
	
	public OcorrenciasDao() {
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

	public void insertOcorrencias(Ocorrencias ocorrencias) throws SQLException {
		String INSERT_USERS_SQL = "INSERT INTO TB_OCORRENCIAS (data, nomeUsuario, descricao, motivo) VALUES (?, ?, ?, ?);";
		
		System.out.println(INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		Connection connectio = getConnection();
		System.out.println("connection: " + connectio);
		try (Connection connection = getConnection();
			//System.out.println("connection: " + connection);
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			java.sql.Date data = new java.sql.Date (ocorrencias.getData().getTime());
			preparedStatement.setDate(1, data);
			preparedStatement.setString(2, ocorrencias.getNomeUsuario());
			preparedStatement.setString(3, ocorrencias.getDescricao());
			preparedStatement.setString(4, ocorrencias.getMotivo());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Ocorrencias selectOcorrencias(int codigo) {
		Ocorrencias ocorrencias = null;
		String SELECT_USER_BY_ID = "SELECT * FROM TB_OCORRENCIAS WHERE codigo =?";
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
				Date data = rs.getDate("data");
				String nomeUsuario = rs.getString("nomeUsuario");
				String descricao = rs.getString("descricao");
				String motivo = rs.getString("motivo");
				ocorrencias = new Ocorrencias(codigo, data, nomeUsuario, descricao, motivo);
				System.out.println(ocorrencias);
			}
			connection.close();
		} catch (SQLException e) {
			printSQLException(e);
		}
		return ocorrencias;
	}

	public List<Ocorrencias> selectAllOcorrencias() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		String SELECT_ALL_USERS = "SELECT * FROM TB_OCORRENCIAS";
		List<Ocorrencias> ocorrencias = new ArrayList<>();
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
				Date data = rs.getDate("data");
				String nomeUsuario = rs.getString("nomeUsuario");
				String descricao = rs.getString("descricao");
				String motivo = rs.getString("motivo");
				ocorrencias.add(new Ocorrencias(codigo, data, nomeUsuario, descricao, motivo));
			}
			connection.close();
		} catch (SQLException e) {
			printSQLException(e);
		}
		return ocorrencias;
	}

	public boolean deleteOcorrencias(int codigo) throws SQLException {
		boolean rowDeleted;
		String DELETE_USERS_SQL = "DELETE FROM TB_OCORRENCIAS WHERE codigo = ?;";
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
			statement.setInt(1, codigo);
			rowDeleted = statement.executeUpdate() > 0;
			connection.close();
		}
		return rowDeleted;
	}

	public boolean updateOcorrencias(Ocorrencias ocorrencias) throws SQLException {
		boolean rowUpdated;
		String UPDATE_USERS_SQL = "UPDATE TB_OCORRENCIAS SET data = ?, nomeUsuario= ?, descricao =?, motivo=? WHERE codigo = ?;";
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			java.sql.Date data = new java.sql.Date (ocorrencias.getData().getTime());
			statement.setDate(1, data);
			statement.setString(2, ocorrencias.getNomeUsuario());
			statement.setString(3, ocorrencias.getDescricao());
			statement.setString(4, ocorrencias.getMotivo());
			statement.setInt(5, ocorrencias.getCodigo());

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
