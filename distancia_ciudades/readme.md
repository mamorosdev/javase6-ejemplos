# DistanciaCiudadesJava

Proyecto JavaSE que nos muestra varias formas para obtener la distancia entre 2 ciudades por consola.

Está dividido en 2 paquetes:

### distancias.array

Este método es muy rudimentario; consiste en guardar en una matriz bidimensional las distancias entre todas las 
ciudades que nos interesan. Es preciso pero ineficiente y difícil de mantener.

Podría mejorar este código poniendo los datos en un fichero y triangulando la matriz,  pero creo que ya queda claro
como funciona este modo de obtener distancias.

### distancias.coordenadas

Esta clase calcula la distancia entre 2 ciudades a partir de sus coordenadas geográficas con métodos científicos.
Como este problema puede tener varias soluciones, he usado esta interfaz:

public interface IDistanciaCoordenadas {

	public double distanciaEntreDosCiudades(
		Punto puntoOrigen, Punto puntoDestino);
		
}

Y luego he desarrollado 2 implementaciones; basadas en fórmulas matemáticas muy conocidas.

#### DistanciaPitagorasImpl 

Pensada para espacios bidimensionales.

https://es.wikipedia.org/wiki/Distancia_euclidiana

#### DistanciaHaversineImpl

Pensada para espacios tridimensionales esféricos como la Tierra.

https://es.wikipedia.org/wiki/F%C3%B3rmula_del_Haversine

Faltaria subir una 3a impolementación usando la API de Google Maps o otro GIS.
