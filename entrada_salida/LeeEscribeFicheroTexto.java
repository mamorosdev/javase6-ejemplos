package entsal;
import java.io.*;

public class LeeEscribeFicheroTexto {

	public static void main(String[] args) throws IOException {
		
		// Escriptura de fitxer.
		try {
			BufferedWriter nouf = new BufferedWriter( new FileWriter ("fitxer.txt") );
			nouf.write("Multiples de 3:");
			nouf.newLine();
			for (int i = 0; i <= 100; i++) {
				Integer num = new Integer(i*3);
				nouf.write(num.toString());
				nouf.newLine();
			}
			nouf.close();
		} catch (IOException ioe) {
			System.out.println("Excepcio de Fitxers.");
		}
		
		// Lectura del fitxer escrit.
		try {
			FileReader fr = new FileReader("fitxer.txt");
			BufferedReader fite = new BufferedReader ( fr );
			System.out.println( "Llegeixo fitxer creat => ");
			String line="";
			boolean endof = false;
			while ( !endof ) {
				line = fite.readLine();
				if (line != null) {
					System.out.println(line);
				} else {
					endof = true;
				} 
			}  
			fite.close();
			/*
			String line;
			while( (line = fite.readLine()) != null ) {
				System.out.println(line);
			}
		 */
		} catch (IOException ioe) {
			System.out.println("Fitxer no trobat!");
		}
	}
}
