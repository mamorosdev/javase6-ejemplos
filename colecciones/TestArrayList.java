package colecciones;

import java.util.*;

public class TestArrayList {
	
	public static void main(String[] args) {
		
		// Prova Comparable! Comparem amb un criteri natural.
		List<Persona> persones = new ArrayList<Persona>();
		persones.add(new Persona("123","Josep","Alvarez",20,"JS@C.C"));
		persones.add(new Persona("321","Maria","Catala",40,"AXAL@L.C"));
		persones.add(new Persona("265","Tania","Rives",25,"tr@O.C"));
		persones.add(new Persona("451","Miquel","Fortuny",30,"OOO@O.C"));
		persones.add(new Persona("265","Sara","Fortuny",35,"SSS@O.C"));
		Collections.sort(persones);
		Iterator<Persona> it = persones.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		// Prova Comparator! Comparem amb un criteri, com la edat.
		// Comparator es una classe que defineix aquest criteri, i l'hem
		// declarada com a metode estatic a la classe Persona.
		Collections.sort(persones,Persona.comparaPerEdat());
		Iterator<Persona> ited = persones.iterator();
		while (ited.hasNext()) {
			System.out.println(ited.next());
		}
		int[][] a = new int[2][2];
		Object o = a;
		System.out.println(a);
		// reverse, binarySearch.
	}

}
