package dbConnector;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
//	private int getAnioMayor(Long idProducto) throws DataAccessException{
//		String query = "SELECT MAX(d.fecha_demanda) as fecha_maxima FROM demanda AS d WHERE id_producto = "+idProducto.longValue();
//		String fecha_maxima;
//		int anio = 0;
//		try {
//			this.openConexion();
//			if ((this.con != null)&&(this.stmt != null)){ //si pudo conectar
//				ResultSet rs;
//		
//				rs = stmt.executeQuery(query);
//				if (rs.next()){
//					if(rs.getString("fecha_maxima") != null){
//						fecha_maxima = rs.getString("fecha_maxima");
//						anio = new Integer(fecha_maxima.split("-")[0]);
//					}
//				}
//			}
//			this.closeConexion();
//			return anio;
//		} catch (SQLException e) {
//			e.printStackTrace();
//			throw new DataAccessException(DataAccessException.ERROR_EJECUCION_CONSULTA);
//		}	
//	}

	/**
	 * Obtiene la demanda para un producto la cantidad de dias indicados desde la fecha dada
	 * @param idProducto
	 * @param cantidadDeDias
	 * @return
	 * @throws DataAccessException
	 * @throws ParseException 
	 */
	public double demandaPorProducto(Long idProducto, Date fecha_inicio, int cantidadDeDias) throws DataAccessException {
		
		double demanda = 0;
		
		String query = "SELECT SUM(d.consumo) as consumo FROM demanda AS d WHERE id_producto = "+idProducto.longValue();
		query += " and fecha_demanda between '"+((new SimpleDateFormat("dd/MM/yyyy")).format(fecha_inicio)).toString();
		query += "' and '"+((new SimpleDateFormat("dd/MM/yyyy")).format(OperacionesSobreFechas.fechaMas(fecha_inicio, cantidadDeDias))).toString()+"'";
		
		try {
			this.openConexion();
			if ((this.con != null)&&(this.stmt != null)){ //si pudo conectar
				ResultSet rs;
		
				rs = stmt.executeQuery(query);
				if (rs.next()){
					if(rs.getString("consumo") != null)
						demanda = new Double(rs.getString("consumo"));		
				}
			}
			this.closeConexion();
			return demanda;
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
		
		for (int i=0; i<ValoresASacarDeAlgunLado.CANTIDAD_ANIOS_A_CONSIDERAR; i++){
			demandaAux = this.demandaPorProducto(idProducto, fecha_inicio, cantidadDeDias);
						
			if(demandaAux > demandaMaxima) 
				demandaMaxima = demandaAux;
				
			fecha_inicio = OperacionesSobreFechas.anioMenos(fecha_inicio, 1);
		}
		
		return demandaMaxima;	
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
		
		double demandaMinima = Double.MAX_VALUE;
		double demandaAux;
		
		for (int i=0; i<ValoresASacarDeAlgunLado.CANTIDAD_ANIOS_A_CONSIDERAR; i++){
			demandaAux = this.demandaPorProducto(idProducto, fecha_inicio, cantidadDeDias);
					
			if(demandaAux < demandaMinima) 
				demandaMinima = demandaAux;
			
			fecha_inicio = OperacionesSobreFechas.anioMenos(fecha_inicio, 1);
		}
		return (demandaMinima==Double.MAX_VALUE)?0:demandaMinima;	
	}
	/**
	 * Obtiene la cantidad de demandas existentes para el periodo indicado cuyo valor se encuentra entre los limites
	 * @param limite_inferior
	 * @param limite_superior
	 * @throws DataAccessException 
	 */
	public int getCantidadDemandasEnIntervalo(Long idProducto, double limite_inferior, double limite_superior) throws DataAccessException {
		int cantidad = 0;
		
		Date fecha_inicio = ValoresASacarDeAlgunLado.FECHA_INICIO; //TODO acomodar esto
		double demanda;
		
		for (int i=0; i<ValoresASacarDeAlgunLado.CANTIDAD_ANIOS_A_CONSIDERAR; i++){
				
			demanda = this.demandaPorProducto(idProducto, fecha_inicio, ValoresASacarDeAlgunLado.CANTIDAD_DE_DIAS_PERIODO);
		
			if((demanda >= limite_inferior) && (demanda < limite_superior))
				cantidad++;
			
			fecha_inicio = OperacionesSobreFechas.anioMenos(fecha_inicio, 1);
		}
		
		return cantidad;
	}
}
