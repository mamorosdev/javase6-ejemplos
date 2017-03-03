package colecciones;
import java.util.*;
import java.util.Map.Entry;

public class MapaHash {
	
	public static void main(String[] args) {
		
		Map<String,Persona> mapa = new HashMap <String,Persona>();
		mapa.put("123", new Persona("123","Josep","Alvarez",20,"JS@C.C"));
		mapa.put("321", new Persona("321","Maria","Catala",40,"AXAL@L.C"));
		mapa.put("451", new Persona("451","Miquel","Fortuny",30,"OOO@O.C"));
		mapa.put("265", new Persona("265","Sara","Fortuny",25,"SSS@O.C"));
		
		Set<Map.Entry<String,Persona>> set = mapa.entrySet();
		Iterator<Entry<String, Persona>> it = set.iterator();
		
		while(it.hasNext()) {
			Entry<String, Persona> parellkv = it.next();
			String clau = parellkv.getKey();
			Persona valor = parellkv.getValue();
			System.out.println("Clau = " + clau);
			System.out.println("Valor = " + valor);
		}
		
	}
}
