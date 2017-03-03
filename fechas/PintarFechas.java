package fechas;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Imprimir por pantalla los 365 dias de un año.
 * @author MiquelÀngel
 *
 */
public class PintarFechas {

	public static void main(String[] args) {
		// Imprimir pantalla los 365 dias de un año.
		int year = 2015;
		Locale l = new Locale("es_ES");
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMMMMM yyyy",l);
		Calendar firstDayYear = GregorianCalendar.getInstance(l);
		Calendar lastDayYear = GregorianCalendar.getInstance(l);
		// Ojo; los meses van del 0 al 11!
		firstDayYear.set(year,00,01);
		lastDayYear.set(year,11,32);
		while(!firstDayYear.getTime().equals(lastDayYear.getTime())) {
			System.out.println(sdf.format(firstDayYear.getTime()));
			firstDayYear.add(Calendar.DAY_OF_YEAR, 1);
		}
	}

}
