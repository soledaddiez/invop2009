package util;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class OperacionesSobreFechas {
	/**
	 * Suma 'dias' dias a la fecha dada
	 * @param fch
	 * @param dias
	 * @return
	 */
	public static Date fechaMas(Date fch, int dias){
	     Calendar cal = new GregorianCalendar();
	     cal.setTimeInMillis(fch.getTime());
	     cal.add(Calendar.DATE, dias);
	     return new Date(cal.getTimeInMillis());
	} 
	
	/**
	 * Resta 'años' años a la fecha dada
	 * @param fch
	 * @param dias
	 * @return
	 */
	public static Date anioMenos(Date fch, int anios){
	     Calendar cal = new GregorianCalendar();
	     cal.setTimeInMillis(fch.getTime());
	     cal.add(Calendar.YEAR, -anios);
	     return new Date(cal.getTimeInMillis());
	}
}
