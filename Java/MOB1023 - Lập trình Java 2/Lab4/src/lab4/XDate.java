package lab4;

import java.sql.Date;
import java.text.SimpleDateFormat;



public class XDate {
	static SimpleDateFormat fmDate = new SimpleDateFormat();
	public static java.util.Date parse(String textDate,String pattern) throws RuntimeException{
		fmDate.applyPattern(pattern);
		try {
			return fmDate.parse(textDate);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	
	public static java.util.Date parse(String textDate) throws RuntimeException{
		return XDate.parse(textDate,"dd-MM-yyyy");
	}
}
