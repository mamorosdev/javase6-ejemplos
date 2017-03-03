package distancias.coordenadas;

import java.util.ArrayList;
import java.util.List;

public class DistanciaCoordenadasMain {

	public static double[] distanciaEntreMuchasCiudades(
			List<Punto> listaPuntos,
			IDistanciaCoordenadas distCoord) {
		int numeroEtapas = listaPuntos.size()-1;
		double[] resultado = new double[numeroEtapas];
		for(int i = 0; i < numeroEtapas; i++) {
			resultado[i]=distCoord.distanciaEntreDosCiudades(
				listaPuntos.get(i),listaPuntos.get(i+1));
		}
		return resultado;
	}
	
	public static void main(String[] args) {
		Punto coordPamplona 
			= new Punto("Pamplona",42.817989,-1.644215);
		Punto coordLogrono 
			= new Punto("Logroño",42.465775,-2.449995);
		System.out.println("Distancia 2 ciudades : ");
		System.out.println(coordPamplona);
		System.out.println(coordLogrono);
		
		IDistanciaCoordenadas distCoordPitagoras 
			= new DistanciaPitagorasImpl();
		System.out.print("distCoordPitagoras = ");
		System.out.println(distCoordPitagoras.distanciaEntreDosCiudades(
			coordPamplona, coordLogrono));
		
		IDistanciaCoordenadas distCoordHaversine 
			= new DistanciaHaversineImpl();
		System.out.print("distCoordHaversine = ");
		System.out.println(distCoordHaversine.distanciaEntreDosCiudades(
			coordPamplona, coordLogrono));
		
		Punto coordZaragoza 
			= new Punto("Zaragoza",41.6917473,-1.2072536);
		Punto coordBarcelona 
			= new Punto("Barcelona",41.3948976,2.0787273);
		
		List<Punto> ruta = new ArrayList<Punto>();
		ruta.add(coordBarcelona);
		ruta.add(coordZaragoza);
		ruta.add(coordPamplona);
		ruta.add(coordLogrono);
		System.out.println("Distancia entre las siguientes ciudades : ");
		for(Punto p: ruta)
			System.out.print(p.getEtiqueta()+ " ");
		
		System.out.println();
		System.out.println("Distancia Harvesiana => ");
		double[] distCiudadesHarv = distanciaEntreMuchasCiudades(ruta,distCoordHaversine);
		for(double num: distCiudadesHarv)
			System.out.println(num+",");
		
		System.out.println("Distancia Euclideana (Pitagoras) => ");
		double[] distCiudadesEucl = distanciaEntreMuchasCiudades(ruta,distCoordPitagoras);
		for(double num: distCiudadesEucl)
			System.out.println(num+",");
	}

}
