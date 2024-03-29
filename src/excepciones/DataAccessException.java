package excepciones;

import java.sql.SQLException;

import org.hibernate.HibernateException;

public class DataAccessException extends SQLException {

	private static final long serialVersionUID = 1L;

	public static final String ERROR_EJECUCION_CONSULTA = "ERROR_EJECUCION_CONSULTA";
	public static final String ERROR_CONEXION = "ERROR_CONEXION";
	public static final String ERROR_CLASES_INEXISTENTES = "ERROR_CLASES_INEXISTENTES";
	
	String msg;
	HibernateException e;

	public DataAccessException(String msg) {
		super();
		this.msg = msg;
	}

	public DataAccessException(HibernateException e) {
		this.e = e;
		e.printStackTrace();
	}
}
