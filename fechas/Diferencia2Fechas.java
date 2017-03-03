package fechas;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Este ejemplo muestra como calcular la diferencia entre 2 fechas 
 * en días y horas.
 * @author MiquelÀngel
 *
 */
public class Diferencia2Fechas {

	public static void main(String[] args) {

		// Crear 2 instancias de Calendar para gestionar fechas.
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        
        // Dos formas de establecer las fechas
        cal1.set(2015, 11, 20);
        cal2.set(2016, 5, 3);

        // conseguir la representacion de la fecha en milisegundos
        long milis1 = cal1.getTimeInMillis();
        long milis2 = cal2.getTimeInMillis();

        // calcular la diferencia en milisengundos
        long diff = milis2 - milis1;

        // calcular la diferencia en horas
        long diffHours = diff / (60 * 60 * 1000);
        // calcular la diferencia en dias
        long diffDays = diff / (24 * 60 * 60 * 1000);

        // Definimos el formato para nostrar las fechas.
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        
        System.out.println("Fecha final " + sdf.format(cal2.getTime()));
        System.out.println("Fecha inicial " + sdf.format(cal1.getTime()));
        System.out.println("Diferencia en horas: " + diffHours + " horas.");
        System.out.println("Diferencia en dias: " + diffDays + " dias.");
	
	}

}
