package Fonaments;
import static java.lang.Math.*;
import static java.lang.System.out;

public class StaticImports {
	
	public static void main(String[] args) {
		out.println("Cosinus de 0 = " + Math.cos(0));
		// FORMAT I PRINTF
		double cosinus60 = Math.cos(PI/3);
		out.printf("%1$b%1$s %n","false");
		// out.printf("%1$2.2$d","cosinus60");
		out.format("%0", cosinus60);
	}
}
