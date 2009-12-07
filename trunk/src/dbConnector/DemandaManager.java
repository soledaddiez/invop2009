package dbConnector;

import java.sql.ResultSet;
import java.sql.SQLException;

import excepciones.DataAccessException;

public class DemandaManager extends Conexion{

	public DemandaManager() throws Exception {
		super();
	}
	
	public double demandaMaxima(Long idProducto) throws DataAccessException {
		String query = "SELECT MAX(d.consumo) as maximo FROM demanda AS d WHERE id_producto = "+idProducto.longValue();
		double demandaMaxima = 0;
		try {
			this.openConexion();
			if ((this.con != null)&&(this.stmt != null)){ //si pudo conectar
				ResultSet rs;
		
				rs = stmt.executeQuery(query);
				if (rs.next()){
					demandaMaxima = new Double(rs.getString("maximo"));
				}
			}
			this.closeConexion();
			return demandaMaxima;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException(DataAccessException.ERROR_EJECUCION_CONSULTA);
		}	
	}
	
	public double demandaMinima(Long idProducto) throws DataAccessException {
		String query = "SELECT MIN(d.consumo) as minimo FROM demanda AS d WHERE id_producto = "+idProducto.longValue();
		double demandaMinima = 0;
		try {
			this.openConexion();
			if ((this.con != null)&&(this.stmt != null)){ //si pudo conectar
				ResultSet rs;
		
				rs = stmt.executeQuery(query);
				if (rs.next()){
					demandaMinima = new Double(rs.getString("minimo"));
				}
			}
			this.closeConexion();
			return demandaMinima;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException(DataAccessException.ERROR_EJECUCION_CONSULTA);
		}	
	}
}
