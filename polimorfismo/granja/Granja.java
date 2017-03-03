package polimorfismo.granja;

public class Granja {
	public static void main(String[] args) {
		Animal[] animales = {new Vaca(), 
							new Cerdo(),
							new Cerdo(),
							new Cerdo()
		};
	
		// animals[0].donaLeche();
	}

	private static void alimentarAnimales(Animal[] animals) {
		for(Animal a : animals){
			a.comer();
			if (a instanceof Vaca) {
				Vaca v = (Vaca) a;
				v.donaLeche();
			}
		}
		
	}
}
