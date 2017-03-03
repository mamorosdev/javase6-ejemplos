package fechas;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Este ejemplo muestra como a�adir o restar d�as, horas, a�os 
 * o otras unidades de tiempo f�cilmente a cualquier una fecha.
 * @author Miquel�ngel
 *
 */
public class SumarFechas {

	public static void main(String[] args) {
		
		// Definir el d�a de hoy.
		Calendar calendar = Calendar.getInstance(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		System.out.println("Fecha actual " + sdf.format(calendar.getTime()));
		// A�adir X d�as.
		int dias = 15;
		Calendar calendar15 = calendar;
		calendar15.add(Calendar.DAY_OF_YEAR, dias);
        System.out.println("Fecha " + dias + 
        	" dias posteriores " + sdf.format(calendar15.getTime()));
        // A�adir X horas.
     	int horas = 48;
     	Calendar calendar48h = calendar;
     	calendar48h.add(Calendar.HOUR, horas);
        System.out.println("Fecha " + horas + 
        	" horas posteriores " + sdf.format(calendar48h.getTime()));
        // Restar 4 a�os.
     	int years = -4;
     	Calendar calendar_4ybefore = calendar;
     	calendar_4ybefore.add(Calendar.YEAR, years);
        System.out.println("Fecha " + years + 
        	" a�os antes " + calendar_4ybefore.getTime());
	}

}
