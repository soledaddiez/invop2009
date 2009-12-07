package dbConnector;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import util.OperacionesSobreFechas;

import cosasAEliminar.ValoresASacarDeAlgunLado;

import excepciones.DataAccessException;

public class DemandaManager extends Conexion{

	public DemandaManager(){
		super();
	}
	
	/**
	 * Obtiene el mayor de los años para los que se registra una demanda para un producto dado
	 * @param idProducto
	 * @return
	 * @throws DataAccessException
	 */
	private int getAnioMayor(Long idProducto) throws DataAccessException{
		String query = "SELECT MAX(d.fecha_demanda) as fecha_maxima FROM demanda AS d WHERE id_producto = "+idProducto.longValue();
		String fecha_maxima;
		int anio = 0;
		try {
			this.openConexion();
			if ((this.con != null)&&(this.stmt != null)){ //si pudo conectar
				ResultSet rs;
		
				rs = stmt.executeQuery(query);
				if (rs.next()){
					fecha_maxima = rs.getString("fecha_maxima");
					anio = new Integer(fecha_maxima.split("-")[0]);
				}
			}
			this.closeConexion();
			return anio;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException(DataAccessException.ERROR_EJECUCION_CONSULTA);
		}	
	}
	
	/**
	 * Obtiene la máxima demanda para un producto desde el dia actual hasta la cantidad de dias indicados (sin importar el año)
	 * @param idProducto
	 * @param cantidadDeDias
	 * @return
	 * @throws DataAccessException
	 * @throws ParseException 
	 */
	public double demandaMaxima(Long idProducto, int cantidadDeDias) throws DataAccessException {
		
		Date fecha_inicio = ValoresASacarDeAlgunLado.FECHA_INICIO; //TODO acomodar esto
		double demandaMaxima = 0;
		double demandaAux;
		
		String query;		
		
		try {
			this.openConexion();
			if ((this.con != null)&&(this.stmt != null)){ //si pudo conectar
				ResultSet rs;
		
				for (int i=0; i<ValoresASacarDeAlgunLado.CANTIDAD_ANIOS_A_CONSIDERAR; i++){
					// armo el Query
					query = "SELECT MAX(d.consumo) as maximo FROM demanda AS d WHERE id_producto = "+idProducto.longValue();
					query += " and fecha_demanda between '"+((new SimpleDateFormat("dd/MM/yyyy")).format(fecha_inicio)).toString();
					query += "' and '"+((new SimpleDateFormat("dd/MM/yyyy")).format(OperacionesSobreFechas.fechaMas(fecha_inicio, cantidadDeDias))).toString()+"'";
					//<- fin query
				
					rs = stmt.executeQuery(query);
					if (rs.next()){
						demandaAux = new Double(rs.getString("maximo"));
						
						if(demandaAux > demandaMaxima) 
							demandaMaxima = demandaAux;
					}
					fecha_inicio = OperacionesSobreFechas.anioMenos(fecha_inicio, 1);
				}
			}
			this.closeConexion();
			return demandaMaxima;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException(DataAccessException.ERROR_EJECUCION_CONSULTA);
		}	
	}
	
	/**
	 * Obtiene la mínima demanda para un producto desde el dia actual hasta la cantidad de dias indicados (sin importar el año)
	 * @param idProducto
	 * @param cantidadDeDias
	 * @return
	 * @throws DataAccessException
	 * @throws ParseException 
	 */
	public double demandaMinima(Long idProducto, int cantidadDeDias) throws DataAccessException {
		Date fecha_inicio = ValoresASacarDeAlgunLado.FECHA_INICIO; //TODO acomodar esto
		String query;
		double demandaMinima = Double.MAX_VALUE;
		double demandaAux;
		
		try {
			this.openConexion();
			if ((this.con != null)&&(this.stmt != null)){ //si pudo conectar
				ResultSet rs;
		
				for (int i=0; i<ValoresASacarDeAlgunLado.CANTIDAD_ANIOS_A_CONSIDERAR; i++){
					// armo el Query
					query = "SELECT MIN(d.consumo) as minimo FROM demanda AS d WHERE id_producto = "+idProducto.longValue();
					query += " and fecha_demanda between '"+((new SimpleDateFormat("dd/MM/yyyy")).format(fecha_inicio)).toString();
					query += "' and '"+((new SimpleDateFormat("dd/MM/yyyy")).format(OperacionesSobreFechas.fechaMas(fecha_inicio, cantidadDeDias))).toString()+"'";
					//<- fin query
				
					rs = stmt.executeQuery(query);
					if (rs.next()){
						demandaAux = new Double(rs.getString("minimo"));
						
						if(demandaAux < demandaMinima) 
							demandaMinima = demandaAux;
					}
					fecha_inicio = OperacionesSobreFechas.anioMenos(fecha_inicio, 1);
				}
			}
			this.closeConexion();
			return (demandaMinima==Double.MAX_VALUE)?0:demandaMinima;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException(DataAccessException.ERROR_EJECUCION_CONSULTA);
		}	
	}
}
