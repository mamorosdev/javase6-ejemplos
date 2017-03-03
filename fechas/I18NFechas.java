package fechas;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Imprimir por pantalla una fecha en los muchos idiomas
 * que soporta la clase GregorianCalendar.
 * @author Miquel¿ngel
 *
 */
public class I18NFechas {
	public static void main(String[] args) {
		Calendar calendar;
		SimpleDateFormat sdf;
		// Imprimir una fecha en todos los idiomas.
		for(Locale locale : GregorianCalendar.getAvailableLocales()){
			calendar = GregorianCalendar.getInstance(locale);
			sdf = new SimpleDateFormat("dd MMMMMM yyyy hh:mm",locale);
			System.out.println("Date locale " + locale + 
				" " +  sdf.format(calendar.getTime()));
		}
	}
}
