package entsal;
import java.io.*;
import java.util.Date;

public class LeeFechaBin {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args)  {
		
		try {
			ObjectInputStream ois = new ObjectInputStream( new FileInputStream("data.bin") );
			Date data = (Date) ois.readObject();
			System.out.println("He leido la Fecha = " + data.toString());
			ois.close();
		} catch (Exception e) {
			
		}
	}
}
