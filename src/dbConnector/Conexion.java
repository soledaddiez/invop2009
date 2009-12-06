package dbConnector;

import java.sql.*;

public abstract class Conexion{
	Connection con;
	Statement stmt;
	
	public void openConexion() throws Exception{
		String driver = "org.postgresql.Driver";
		String connectString = "jdbc:postgresql://localhost:5432/Investigacion";
		String user = "postgres";
		String password = "postgres";
		
		Class.forName(driver);
		this.con = DriverManager.getConnection(connectString, user , password);
		this.stmt = this.con.createStatement();
	}
	
	public void closeConexion() throws SQLException{
		this.stmt.close();
		this.con.close();
	}
}
