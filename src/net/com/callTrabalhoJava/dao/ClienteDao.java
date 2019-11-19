package net.com.callTrabalhoJava.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.com.callTrabalhoJava.model.Cliente;

public class ClienteDao {
	private String jdbcURL = "jdbc:mysql://localhost:3306/DB_PROJETOJAVACRUD";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";
	
	public ClienteDao() {
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

	public void insertCliente(Cliente cliente) throws SQLException {
		String INSERT_USERS_SQL = "INSERT INTO TB_CLIENTE (razao, fantasia, cnpj, ie) VALUES (?, ?, ?, ?);";
		
		System.out.println(INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		//Connection connectio = getConnection();
		//System.out.println("connection: " + connectio);
		try (Connection connection = getConnection();
			//System.out.println("connection: " + connection);
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, cliente.getRazao());
			preparedStatement.setString(2, cliente.getFantasia());
			preparedStatement.setString(3, cliente.getCnpj());
			preparedStatement.setString(4, cliente.getIe());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Cliente selectCliente(int codigo) {
		Cliente cliente = null;
		String SELECT_USER_BY_ID = "SELECT * FROM TB_CLIENTE WHERE codigo =?";
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
				String razao = rs.getString("razao");
				String fantasia = rs.getString("fantasia");
				String cnpj = rs.getString("cnpj");
				String ie = rs.getString("ie");
				cliente = new Cliente(codigo, razao, fantasia, cnpj, ie);
				System.out.println(cliente);
			}
			connection.close();
		} catch (SQLException e) {
			printSQLException(e);
		}
		return cliente;
	}

	public List<Cliente> selectAllClientes() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		String SELECT_ALL_USERS = "SELECT * FROM TB_CLIENTE";
		List<Cliente> clientes = new ArrayList<>();
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
				String razao = rs.getString("razao");
				String fantasia = rs.getString("fantasia");
				String cnpj = rs.getString("cnpj");
				String ie = rs.getString("ie");
				clientes.add(new Cliente(codigo, razao, fantasia, cnpj, ie));
			}
			connection.close();
		} catch (SQLException e) {
			printSQLException(e);
		}
		return clientes;
	}

	public boolean deleteCliente(int codigo) throws SQLException {
		boolean rowDeleted;
		String DELETE_USERS_SQL = "DELETE FROM TB_CLIENTE WHERE codigo = ?;";
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
			statement.setInt(1, codigo);
			rowDeleted = statement.executeUpdate() > 0;
			connection.close();
		}
		return rowDeleted;
	}

	public boolean updateCliente(Cliente cliente) throws SQLException {
		boolean rowUpdated;
		String UPDATE_USERS_SQL = "UPDATE TB_CLIENTE SET razao = ?, fantasia= ?, cnpj =?, ie=? WHERE codigo = ?;";
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			statement.setString(1, cliente.getRazao());
			statement.setString(2, cliente.getFantasia());
			statement.setString(3, cliente.getCnpj());
			statement.setString(4, cliente.getIe());
			statement.setInt(5, cliente.getCodigo());

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
