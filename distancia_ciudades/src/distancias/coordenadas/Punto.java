package distancias.coordenadas;

public class Punto {
	
	private String etiqueta;
	private double latitud;
	private double longitud;
	
	public Punto(String etiqueta, double latitud, double longitud) {
		super();
		this.etiqueta = etiqueta;
		this.latitud = latitud;
		this.longitud = longitud;
	}
	public String getEtiqueta() {
		return etiqueta;
	}
	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}
	public double getLatitud() {
		return latitud;
	}
	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}
	public double getLongitud() {
		return longitud;
	}
	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
	@Override
	public String toString() {
		return "Punto [etiqueta=" + etiqueta + ", latitud=" + latitud
				+ ", longitud=" + longitud + "]";
	}
	
}
