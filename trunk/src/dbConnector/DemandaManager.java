package dbConnector;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DemandaManager extends Conexion{

	public DemandaManager() throws Exception {
		super();
	}

	public void executeQuery(String query) throws SQLException {
		if ((this.con != null)&&(this.stmt != null)){
			ResultSet rs = stmt.executeQuery(query);
		
			while (rs.next()){
				System.out.println("Nombre: " + rs.getString("nombre"));
				System.out.println("\tCapacidad: " + rs.getString("cc") + "cc.");
			}
			
			rs = stmt.executeQuery("select count(*) as cant from (select distinct fecha_demanda from demanda) as aux");
			while (rs.next()){
				System.out.println("cant: " + rs.getString("cant"));
			}
		}
	}

}
