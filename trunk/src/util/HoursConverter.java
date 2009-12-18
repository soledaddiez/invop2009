package util;

public class HoursConverter {
	public static String getString(double hours){
		int hs = (int) Math.floor(hours);
		int mins = (int) Math.floor(((hours - hs) * 60.0));
		String str = "";
		if(hs < 10)
			str += "0";
		str += hs+":";
		if(mins < 10)
			str += "0";
		str += mins;
		return str;
	}
}
