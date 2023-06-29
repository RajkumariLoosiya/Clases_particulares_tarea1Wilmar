package logica_negocio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.PreparedStatement;
import java.util.stream.Stream;

import javax.swing.JOptionPane;
import basedatos.ConnectionBD;
import beans.Persona;

public class Logica_negocio {

	public void crearFichero(String nombreFichero, String direccion) {

		try {

			String fichero = direccion + nombreFichero + ".txt";
			if (new File(fichero).exists()) {
				System.err.println("El fichero ya existe");

			} else {

				FileWriter writer = new FileWriter(fichero);
				writer.close();
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void insertarPersona() {

		Persona persona = new Persona(JOptionPane.showInputDialog("Dame el nombre"),
				JOptionPane.showInputDialog("Dame el primer apellido"),
				JOptionPane.showInputDialog("Dame el segundo apellido"),
				Integer.parseInt(JOptionPane.showInputDialog("Dame la edad")),
				JOptionPane.showInputDialog("Dame el numero de telefono"), JOptionPane.showInputDialog("Dame el Dni"),
				JOptionPane.showInputDialog("Dame la direccion de residencia"));

		String asd = persona.toString();

		try {

			String direccion = JOptionPane.showInputDialog("Dame la direccion del fichero");
			String nombre = JOptionPane.showInputDialog("Dame nombre del fichero");
			String fichero = direccion + nombre + ".txt";

			FileWriter writer = new FileWriter(fichero);
			writer.write(asd);
			writer.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void insertarBaseDatos(String dirFicheroDatos, String nomFicheroDatos) {

// 		Se que es código basura, pero quiero que esté aquí para que veas que lo he creado todo desde java. 		
//		String query = "CREATE TABLE IF NOT EXISTS PERSONA (ID INT PRIMARY KEY auto_increment, NOMBRE VARCHAR(50), APELLIDO1 VARCHAR(50), APELLIDO2 VARCHAR(50), EDAD INT, NUMEROTELEFONO VARCHAR(50), DNI VARCHAR(50), DIRCASA VARCHAR(50))";
		String[] listaPersona = null;
		String fichero = dirFicheroDatos + nomFicheroDatos + ".txt";
		String query = "INSERT INTO PERSONA (NOMBRE,APELLIDO1,APELLIDO2,EDAD,NUMEROTELEFONO,DNI,DIRCASA) VALUES (?,?,?,?,?,?,?)";
		try {

			BufferedReader reader = new BufferedReader(new FileReader(fichero));
			String asd = reader.readLine();
			reader.close();
			listaPersona = Stream.of(asd).map(i -> i.split(",")).findFirst().orElse(null);

// 		Aquí te dejo el for corto de impresion que he utilizado.
//			for(String i: listaPersona) {
//				System.out.println(i);
//			}


			ConnectionBD conexionBD = new ConnectionBD();
			PreparedStatement pst = conexionBD.getConx().prepareStatement(query);
			
			pst.setString(1, listaPersona[0]);
			pst.setString(2, listaPersona[1]);
			pst.setString(3, listaPersona[2]);
			pst.setInt(4, Integer.parseInt(listaPersona[3]));
			pst.setString(5, listaPersona[4]);
			pst.setString(6, listaPersona[5]);
			pst.setString(7, listaPersona[6]);
			
			pst.executeUpdate();
			
			pst.close();
			conexionBD.closeConx();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
