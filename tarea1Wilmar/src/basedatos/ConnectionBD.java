package basedatos;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionBD {
	
	String nombreBaseDatos = "jdbc:h2:~/base_datos_proyecto1";
	String userName = "";
	String passWd = "";
	Connection conx = null; 
	
	public ConnectionBD() {
		
		try {
			Class.forName("org.h2.Driver");
			conx = DriverManager.getConnection(nombreBaseDatos, userName, passWd);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}	
	
	public Connection getConx() {
		return conx;
	}

	public void closeConx() {
		conx = null; 
	}
	
	
	
	
}
