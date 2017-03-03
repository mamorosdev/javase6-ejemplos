package Fonaments;

public class TestEnum {

	public static enum Notas {
		INSUFICIENTE,
		SUFICIENTE,
		NOTABLE,
		EXCELENTE
	};
	
	public static void main(String[] args) {
		for(Notas n: Notas.values()){
			System.out.println(n.toString());
		}
		System.out.println("Nota final de Laura " 
			+ Notas.NOTABLE);
	}

}
