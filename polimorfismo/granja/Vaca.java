// Es obligat implementar el metode o ferlo de nou abstracte.
package polimorfismo.granja;

public class Vaca extends Animal implements Lechera {

	public static void m(){		
	}

	@Override
	public void comer() {
		System.out.println("Come la vaca");
	} 
	
	public void donaLeche() {
		System.out.println("La vaca saca leche.");
	}
	
}
