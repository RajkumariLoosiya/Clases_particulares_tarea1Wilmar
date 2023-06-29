package mainysubmenu;

import javax.swing.JOptionPane;

import interfaz.Interfaz;
import logica_negocio.Logica_negocio;

public class Submenu extends Interfaz{

	public void activacionSubmenu() {
		
		Logica_negocio logicanegocio = new Logica_negocio(); 

		int op = 0;

		do {

			switch (op = impresionSubmenu() ) {

				case 1: {
						logicanegocio.crearFichero(JOptionPane.showInputDialog("Dame el nombre del fichero"), JOptionPane.showInputDialog("Dame la ruta exacta del fichero"));
					break;
				}
	
				case 2: {
					logicanegocio.insertarPersona();
					break;
				}
	
				case 3: {
					logicanegocio.insertarBaseDatos(JOptionPane.showInputDialog("Dame la ruta del fichero que quieras leer"), JOptionPane.showInputDialog("Dame el nombre del fichero"));
					break;
				}
	
				case 4: {
					break;
				}
			}

		} while (op <= 3);

	}

}
