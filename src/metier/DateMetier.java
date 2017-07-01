package metier;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateMetier {
	/**
	 * Cette méthode permet de créer une date
	 * @param dateString
	 * @return
	 */
	public static Date initDate(String dateString){
		SimpleDateFormat dateformat2 = new SimpleDateFormat("yyyy/MM/dd");
		try {
			return dateformat2.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
