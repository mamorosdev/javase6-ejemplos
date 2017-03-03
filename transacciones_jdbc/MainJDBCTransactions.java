import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Ejemplo de las operaciones más habituales a bases de datos SQL que realizo 
 * mediante la librerias de Java y un driver JDBC; teniendo en cuenta 
 * el uso de transacciones cuando es necesario.
 */
public class MainJDBCTransactions {

	private static String driver = "com.mysql.jdbc.Driver";
	private static String dbserver = "jdbc:mysql://localhost:3306/examples";
	private static String user = "dev82";
	private static String password = "dev82";
	private static Connection conexion;
	
	public static void main(String[] args) {
		try {
			// Paso 1. Establecer conexion
			Class.forName(driver);
			conexion = DriverManager.getConnection(
		    		dbserver, user, password);
			System.out.println("Conexion establecida.\n");
			// Paso 2. 
			// Insertamos unos clientes de prueba.
			// fillAccounts(conexion);
			
			// Paso 3.
			// Verificamos los clientes estan insertados mediante una consulta.
			queryAccounts(conexion);
			
			// Paso 4. Preparar las operaciones de nuestra transacción.
			String idCuentaEmisora = "A201";
			Double dineroTransferencia = 300.0;
			String idCuentaReceptora = "A101";
			System.out.println("PRUEBA TRANSACCIONES.\n" +
				"Cliente cuenta " + idCuentaEmisora + 
				" transfiere " + dineroTransferencia + 
				" al cliente con cuenta " + idCuentaReceptora);
			
			//	P1 Comprobar si existe nuestra cuenta y hay saldo en nuestra cuenta.
			//	P2 Comprobar los datos de la cuenta del receptor (que existe y puede recibir dinero, etc...).
			//	P3 Retirar el dinero de nuestra cuenta
			//  	P4 Ingresar el dinero en la cuenta del receptor.
			// 	Voy a dar por supuesto que las 4 operaciones se haran en la 
			// 	misma transacción.
			// 	La forma de indicar el inicio de una transacción en JDBC es 
			/	desactivar el modo autocommit, activado por defecto.
			conexion.setAutoCommit(false);
			
			//	P1 Comprobar si existe nuestra cuenta y hay saldo en nuestra cuenta.
			String selectCuentaEmisora = "select * from accounts where id_account=? and money > ?";
			PreparedStatement query_emisora = 
				conexion.prepareStatement(selectCuentaEmisora);
			query_emisora.setString(1,idCuentaEmisora);
			query_emisora.setDouble(2,dineroTransferencia);
			ResultSet rsAccount = query_emisora.executeQuery();
			boolean resultado = rsAccount.first();
			System.out.println(
				"Comprobar si existe nuestra cuenta y hay saldo en nuestra cuenta => "
				+ resultado);
			
			//	P2 Comprobar los datos de la cuenta del receptor (que existe y puede recibir dinero, etc...).
			if(resultado) {
				String selectCuentaReceptora = 
					"select * from accounts where id_account=?";
				PreparedStatement query_receptora = 
					conexion.prepareStatement(selectCuentaReceptora);
				query_receptora.setString(1,idCuentaReceptora);
				ResultSet rsAccount2 = query_receptora.executeQuery();
				resultado = rsAccount2.first();
			}
			System.out.println(
					"Comprobar los datos de la cuenta del receptor (que existe y puede recibir dinero, etc...) => "
					+ resultado);
			String sacarDineroEmisor = 
				"update accounts set money=money-? where id_account=?";
			String ingresarDinerReceptor = 
				"update accounts set money=money+? where id_account=?";
			//  P3 Retirar el dinero de nuestra cuenta.
			if(resultado) {
				PreparedStatement update_emisor = 
					conexion.prepareStatement(sacarDineroEmisor);
				update_emisor.setDouble(1,dineroTransferencia);
				update_emisor.setString(2,idCuentaEmisora);
				resultado = update_emisor.executeUpdate() == 1;
			}
			System.out.println(
				"Retirar el dinero de nuestra cuenta. => "
				+ resultado);
			
			// Forzar un rollback introduciendo un id de cuenta inexistente.
			// idCuentaReceptora= "LOL";
			
			//  P4 Ingresar el dinero en la cuenta del receptor.
			if(resultado) {
				PreparedStatement update_receptor = 
					conexion.prepareStatement(ingresarDinerReceptor);
				update_receptor.setDouble(1,dineroTransferencia);
				update_receptor.setString(2,idCuentaReceptora);
				resultado = update_receptor.executeUpdate() == 1;
			}
			System.out.println(
				"Ingresar el dinero en la cuenta del receptor. => "
				+ resultado);
			
			if(resultado) {
				System.out.println("La transacción se ha realizado correctamente.");
				conexion.commit();
			} else {
				System.out.println("Alguna operacion ha ido mal; todo sigue igual.");
				conexion.rollback();
			}
			System.out.println();
			queryAccounts(conexion);
			
	    } catch (ClassNotFoundException | SQLException e) {
	    	e.printStackTrace();
			System.out.println("Conexion fallida!");
	    } finally {
	    	try {
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    }
	}
	
	public static void queryAccounts(Connection conexion) throws SQLException {
		PreparedStatement query_accounts = 
			conexion.prepareStatement("select * from accounts");
		ResultSet rsAccounts = query_accounts.executeQuery();
		printResultSet(rsAccounts,"ACCOUNTS");
	}

	private static void printResultSet(ResultSet rst, String table_name) throws SQLException {
		ResultSetMetaData cab = rst.getMetaData();
		int numCols = cab.getColumnCount();
		boolean primeraLinea = true;
		System.out.println("Registros de la consulta en la tabla " + table_name);
		while (rst.next()) {
			if(primeraLinea) {
				for(int i = 1; i <= numCols; i++) {
					System.out.print(cab.getColumnName(i)+"\t");
				}
				System.out.println();
				primeraLinea = false;
			}
			for(int i = 1; i < numCols+1; i++) {
				System.out.print(rst.getString(i) + "\t\t");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	/**
	 * Ejemplo con insercion múltiple de 5 clientes.
	 * He aprendido inserción múltiple en:
	 * https://github.com/chuidiang/chuidiang-ejemplos/blob/master/JAVA_SE/src/com/chuidiang/ejemplos/JdbcBatchInsertUpdate.java
	 */
	public static void fillAccounts(Connection conexion) throws SQLException {
		String[][] datosCuentas = {
				{"A1","BANK","15680340.00"},
				{"A101","ONG","24520.50"},
				{"A201","Laura Soler","2367.20"},
				{"A257","Enrique Martinez","520.00"},
				{"A510","Ayuntamiento1","-14520.50"}
		};
		PreparedStatement insert_account= conexion.prepareStatement(
	            "insert into accounts (id_account,id_client,money) values (?,?,?)",
	            Statement.RETURN_GENERATED_KEYS);
		// Vamos añadiendo los datos al proceso batch.
	        for (String[] dato : datosCuentas) {
	        	insert_account.setString(1, dato[0]);
	        	insert_account.setString(2, dato[1]);
	        	insert_account.setDouble(3, Double.parseDouble(dato[2]));
	        	insert_account.addBatch();
	        }
	        // Ejecutamos el batch, que devuelve un array de forma que cada posicion
	        // contiene el numero de filas afectadas por cada insert.
	        int[] aciertos = insert_account.executeBatch();
	        
	        for (int i = 0; i < datosCuentas.length; i++) {
	           System.out.println("La insercion de " + datosCuentas[i][0] + " da "
	                 + aciertos[i] + " inserciones");
	        }
	        // Claves que se han generado; debido a la opcion Statement.RETURN_GENERATED_KEYS
	        ResultSet rs = insert_account.getGeneratedKeys();
	        int contador = 0;
	        while (rs.next()) {
	           System.out.println(datosCuentas[contador][0] + 
	        		" tiene clave "+rs.getInt(1));
	           contador++;
	        }
	        System.out.println();
	}
}
