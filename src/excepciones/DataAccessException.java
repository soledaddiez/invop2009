package excepciones;

import java.sql.SQLException;

public class DataAccessException extends SQLException {
	
	public static String ERROR_CONEXION = "ERROR_CONEXION";
	public static String ERROR_CLASES_INEXISTENTES = "ERROR_CLASES_INEXISTENTES";
	
	String msg;

	public DataAccessException(String msg) {
		super();
		this.msg = msg;
	}
}
