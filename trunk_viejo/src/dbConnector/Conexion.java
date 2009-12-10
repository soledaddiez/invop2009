package dbConnector;

import java.sql.*;

import excepciones.DataAccessException;

public abstract class Conexion{
	Connection con;
	Statement stmt;
	
	public void openConexion() throws DataAccessException{
		String driver = "org.postgresql.Driver";
		String connectString = "jdbc:postgresql://localhost:5432/Investigacion";
		String user = "postgres";
		String password = "postgres";
		
		try {
			Class.forName(driver);
			try {
				this.con = DriverManager.getConnection(connectString, user , password);
				this.stmt = this.con.createStatement();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DataAccessException(DataAccessException.ERROR_CONEXION);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DataAccessException(DataAccessException.ERROR_CLASES_INEXISTENTES);
		}
		
	}
	
	public void closeConexion() throws DataAccessException{
		try {
			this.stmt.close();
			this.con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException(DataAccessException.ERROR_CONEXION);
		}
	}
}
