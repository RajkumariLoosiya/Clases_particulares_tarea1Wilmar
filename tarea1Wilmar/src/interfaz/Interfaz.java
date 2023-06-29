package interfaz;

import javax.swing.JOptionPane;

public class Interfaz {
	
	public int impresionSubmenu() {
	
		
		return Integer.parseInt(JOptionPane.showInputDialog(
				"*APLICACIÓN PRIMERA TAREA*" + "\n"+
				"1. Crear un fichero" + "\n"+
				"2. Insertar persona en un fichero" + "\n"+
				"3. Guardar fichero de personas en la base de datos" + "\n"+
				"4. Salir"
				)); 
	}

}
