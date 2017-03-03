/** 
 * @title PIEDRA PAPEL TIJERAS 
 * @author Miquel Àngel Amorós
 */
import static java.lang.Math.random;
import java.io.DataInputStream;

public class MainPiedraPapelTijeras {

	enum Combinacion { 
		PIEDRA(1), PAPEL(2), TIJERAS(3); 
		int opcion_j;
		Combinacion(int opcion_j) {
			this.opcion_j=opcion_j;
		}
		static Combinacion ordinal(int opcion_j) {
			return Combinacion.values()[opcion_j-1];
		}
	};
	
	/*
	 * Metodo que pide al jugador por consola si va a tirar PIEDRA PAPEL o TIJERAS.
	 */
	public static int elegir_mano (int cont, int opcion_j, DataInputStream in) 
			throws Exception {
		do {
			System.out.println("Debes introducir un numero entre el 1 y el 4.");
			System.out.println("Partida " + cont+ ". Introduce una opcion:");
			System.out.println("1.PIEDRA,2.PAPEL,3.TIJERAS,4.SALIR");
			opcion_j = Integer.parseInt(in.readLine());
		} while (opcion_j < 1 || opcion_j > 4);
		return opcion_j;
	}
	
	public static void main(String[] args) throws Exception {
		
		DataInputStream in = new DataInputStream(System.in);
		// Mano (jugada) del jugador y del ordenador.
		Combinacion mano_j, mano_o;
		int puntsj,puntso,empats;
		int ganador; /* 1 jugador, 0 ordenador, 2 empate */
		// Variables auxiliares.
		int opcion_j,opcion_o,cont;
		
		puntsj=0;
		puntso=0;
		empats=0;
		
		opcion_j = 0;
		cont = 1;
		ganador = 2;
		
		while(opcion_j!=4) {
			System.out.println("JUEGO DEL PEDRA, PAPEL O TIJERAS.");
			// Turno jugador
			opcion_j = elegir_mano(cont,opcion_j,in);
			mano_j = Combinacion.ordinal(opcion_j);
			// Jugada ordenador.
			opcion_o = (int) ( 1+ random() * 3);
			mano_o = Combinacion.ordinal(opcion_o);
			System.out.println(mano_j + " contra " + mano_o);
			// Forma simple de representar el empate.
			if(mano_j == mano_o) {
				ganador = 2;
			} else if (
				mano_j == Combinacion.PAPEL && mano_o == Combinacion.PIEDRA ||
				mano_j == Combinacion.PIEDRA && mano_o == Combinacion.TIJERAS ||
				mano_j == Combinacion.TIJERAS && mano_o == Combinacion.PAPEL
				) {
				ganador=1;
			} else { 
				// Todas las demas combinaciones son derrota del jugador.
				ganador=0;
			}
			
			if (ganador == 1){
				puntsj++;
				System.out.println("Ha ganado el jugador.");
			} else if (ganador == 0) {
				puntso++;
				System.out.println("Ha ganado el ordenador.");
			} else {
				empats++;
				System.out.println("Empate!");
			}
			System.out.println("------ Recuento de partidas ----");
			System.out.println("Victorias jugador: " + puntsj);
			System.out.println("Victorias ordenador: " + puntso);
			System.out.println("Empates: " + empats);
			System.out.println();
			cont++;
		}
	}

}