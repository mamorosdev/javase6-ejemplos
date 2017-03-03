package entsal;
import java.util.Date;
import java.io.*;

public class EscribeFechaBin implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public static void main(String[] args)  {
		
		Date data = new Date();
		try {
			ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream("data.bin") );
			oos.writeObject(data);
			System.out.println("He escrito la Fecha = " + data.toString());
			oos.close();
		} catch (Exception e) {
			
		}
	}
}
