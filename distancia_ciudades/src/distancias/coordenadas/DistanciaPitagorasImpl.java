package distancias.coordenadas;

import static java.lang.Math.PI;

public class DistanciaPitagorasImpl implements IDistanciaCoordenadas {

		@Override
		public double distanciaEntreDosCiudades(Punto puntoOrigen,
				Punto puntoDestino) {
			double difLats = puntoDestino.getLatitud()-puntoOrigen.getLatitud();
			double difLongs = puntoDestino.getLongitud()-puntoOrigen.getLongitud();
			
			// Hay que convertir estas diferencias a radianes:
			// radianes = (PI/180) * grados
			double difLatsRad = (PI/180)*difLats;
			double difLongsRad = (PI/180)*difLongs;
			
//			double latIniRad = (PI/180)*coordPamplona.getLatitud();
//			double longIniRad = (PI/180)*coordPamplona.getLongitud();
			
			double a = Math.pow(difLats,2) + Math.pow(difLongs,2);
			double distanciaFinal = Math.sqrt(a) * 100;
			return distanciaFinal;
		}

	}
