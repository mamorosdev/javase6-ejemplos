package distancias.coordenadas;

import static java.lang.Math.PI;

import java.util.List;

public class DistanciaHaversineImpl implements IDistanciaCoordenadas {

	public DistanciaHaversineImpl() {
		super();
	}

	final static int RADIO_TIERRA_KM = 6378;
	
	@Override
	public double distanciaEntreDosCiudades(Punto puntoOrigen,
			Punto puntoDestino) {
		double difLats = puntoDestino.getLatitud()-puntoOrigen.getLatitud();
		double difLongs = puntoDestino.getLongitud()-puntoOrigen.getLongitud();
		
		// Hay que convertir estas diferencias a radianes:
		// radianes = (PI/180) * grados
		double difLatsRad = (PI/180)*difLats;
		double difLongsRad = (PI/180)*difLongs;
		double latIniRad = (PI/180)*puntoOrigen.getLatitud();
		double longIniRad = (PI/180)*puntoOrigen.getLongitud();
		
		// Ahora si, calculamos: 
		// a = sin²(Δlat/2) + cos(lat1) · cos(lat2) · sin²(Δlong/2)
		
		double a = Math.sin(difLatsRad/2) * Math.sin(difLatsRad/2) 
			+ Math.cos(latIniRad) * Math.cos(longIniRad) 
			* Math.sin(difLongsRad/2) * Math.sin(difLongsRad/2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		double distanciaFinal = RADIO_TIERRA_KM * c;
		return distanciaFinal;
	}

}
