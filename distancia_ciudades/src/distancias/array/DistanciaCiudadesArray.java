package distancias.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Algoritmo para encontrar las ciudades cercanas a una ciudad seleccionada, 
 * basado en una matriz con las distancias entre la ciudades. 
 * @author Miquel Àngel Amorós
 *
 */
public class DistanciaCiudadesArray {

	private double[][] distCiudades;
	private String[] nombreCiudades;
	
	public DistanciaCiudadesArray(
		double[][] distCiudades,
		String[] nombreCiudades) {
		this.distCiudades=distCiudades;
		this.nombreCiudades=nombreCiudades;
	}
	
	public double distanciaEntreCiudades(
			int indiceCiudadO, int indiceCiudadD) {
		return distCiudades[indiceCiudadO][indiceCiudadD];
	}
	
	public List<Integer> distanciaCiudadesAlrededorCiudadOrigen(
			int indiceCiudadO, int distAlrededor) {
		List<Integer> indiceCiudades = new ArrayList<Integer>();
		double[] distsCiudad = distCiudades[indiceCiudadO];
		for(int i = 0 ; i < distsCiudad.length; i++) {
			if( (distsCiudad[i] > 0) && (distsCiudad[i] <= distAlrededor) ) {
				indiceCiudades.add(i);
			}
		}
		return indiceCiudades;
	}
	
}