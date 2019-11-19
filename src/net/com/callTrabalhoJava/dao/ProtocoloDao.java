package net.com.callTrabalhoJava.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.com.callTrabalhoJava.model.Protocolo;

public class ProtocoloDao {
	private String jdbcURL = "jdbc:mysql://localhost:3306/DB_PROJETOJAVACRUD";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";
	
	public ProtocoloDao() {
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

	public void insertProtocolo(Protocolo protocolo) throws SQLException {
		String INSERT_USERS_SQL = "INSERT INTO TB_PROTOCOLO (problema, resolucao, dataAbertura, dataFechamento) VALUES (?, ?, ?, ?);";
		
		System.out.println(INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		Connection connectio = getConnection();
		System.out.println("connection: " + connectio);
		try (Connection connection = getConnection();
			//System.out.println("connection: " + connection);
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			java.sql.Date dataAbertura = new java.sql.Date (protocolo.getDataAbertura().getTime());
			java.sql.Date dataFechamento = new java.sql.Date (protocolo.getDataFechamento().getTime());
			preparedStatement.setString(1, protocolo.getProblema());
			preparedStatement.setString(2, protocolo.getResolucao());
			preparedStatement.setDate(3, dataAbertura);
			preparedStatement.setDate(4, dataFechamento);
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Protocolo selectProtocolo(int codigo) {
		Protocolo protocolo = null;
		String SELECT_USER_BY_ID = "SELECT * FROM TB_PROTOCOLO WHERE codigo =?";
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
				String problema = rs.getString("problema");
				String resolucao = rs.getString("resolucao");
				Date dataAbertura = rs.getDate("dataAbertura");
				Date dataFechamento = rs.getDate("dataFechamento");
				protocolo = new Protocolo(codigo, problema, resolucao, dataAbertura, dataFechamento);
				System.out.println(protocolo);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return protocolo;
	}

	public List<Protocolo> selectAllProtocolos() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		String SELECT_ALL_USERS = "SELECT * FROM TB_PROTOCOLO";
		List<Protocolo> protocolos = new ArrayList<>();
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
				String problema = rs.getString("problema");
				String resolucao = rs.getString("resolucao");
				Date dataAbertura = rs.getDate("dataAbertura");
				Date dataFechamento = rs.getDate("dataFechamento");
				protocolos.add(new Protocolo(codigo, problema, resolucao, dataAbertura, dataFechamento));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return protocolos;
	}

	public boolean deleteProtocolo(int codigo) throws SQLException {
		boolean rowDeleted;
		String DELETE_USERS_SQL = "DELETE FROM TB_PROTOCOLO WHERE codigo = ?;";
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
			statement.setInt(1, codigo);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateProtocolo(Protocolo protocolo) throws SQLException {
		boolean rowUpdated;
		String UPDATE_USERS_SQL = "UPDATE TB_PROTOCOLO SET problema = ?, resolucao= ?, dataAbertura =?, dataFechamento=? WHERE codigo = ?;";
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			java.sql.Date dataAbertura = new java.sql.Date (protocolo.getDataAbertura().getTime());
			java.sql.Date dataFechamento = new java.sql.Date (protocolo.getDataFechamento().getTime());
			statement.setString(1, protocolo.getProblema());
			statement.setString(2, protocolo.getResolucao());
			statement.setDate(3, dataAbertura);
			statement.setDate(4, dataFechamento);
			statement.setInt(5, protocolo.getCodigo());

			rowUpdated = statement.executeUpdate() > 0;
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
