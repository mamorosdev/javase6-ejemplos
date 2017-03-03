package distancias.array;

import java.util.List;

public class MainDistanciaCiudades {

	public static void main(String[] args) {

		double[][] distCiudades = { 
				{0,11.20,7.43,16.23,10.41,5.92},
				{11.20,0,7.97,23.41,14.58,10.31},
				{7.43,7.97,0,12.43,6.48,8.61},
				{16.23,23.41,12.43,0,7.98,11.31},
				{10.41,14.58,6.48,7.98,0,8.18},
				{5.92,10.31,8.61,11.31,8.18,0}
			};
		String[] nombreCiudades = {
			"Cambrils","MontRoig","MontBrio",
			"Reus","Riudoms","Vinyols"};
		
		int indiceCiudadO = 0;
		int indiceCiudadD = 1;
		
		int indiceCiudadOrigen = 3;
		int distanciaCiudadOrigen = 15;
		
		DistanciaCiudadesArray distanciaCiudades = 
			new DistanciaCiudadesArray(distCiudades,nombreCiudades);
		
		System.out.println("Distancia entre ciudad " + nombreCiudades[indiceCiudadO] + " c=(" + indiceCiudadO 
			+ ") y " + nombreCiudades[indiceCiudadD] + " c=(" + indiceCiudadD + ")");
		System.out.println(
				distanciaCiudades.distanciaEntreCiudades(
					indiceCiudadOrigen, indiceCiudadD) + " Km.");
		
		System.out.println("Ciudes a menos de " 
				+ distanciaCiudadOrigen + " km de " + nombreCiudades[indiceCiudadOrigen] + " c=(" + indiceCiudadOrigen + ")");
		
		List<Integer> resultados = 
				distanciaCiudades.distanciaCiudadesAlrededorCiudadOrigen(
				indiceCiudadOrigen,distanciaCiudadOrigen);
		for(int res: resultados) {
			System.out.println(nombreCiudades[res]);
		}
	}
}
