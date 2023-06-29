package beans;

public class Persona {

	private String nombre;
	private String apellido1; 
	private String apellido2; 
	private int edad;
	private String numeroTelefono;
	private String Dni;
	private String direccionResidencia;

	public Persona(String nombre, String apellido1, String apellido2, int edad, String numeroTelefono, String dni, String direccionResidencia) {

		this.nombre = nombre;
		this.apellido1 = apellido1; 
		this.apellido2 = apellido2;
		this.edad = edad;
		this.numeroTelefono = numeroTelefono;
		this.Dni = dni;
		this.direccionResidencia = direccionResidencia;
	}
	
	

	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellido1() {
		return apellido1;
	}



	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}



	public String getApellido2() {
		return apellido2;
	}



	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}



	public int getEdad() {
		return edad;
	}



	public void setEdad(int edad) {
		this.edad = edad;
	}



	public String getNumeroTelefono() {
		return numeroTelefono;
	}



	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}



	public String getDni() {
		return Dni;
	}



	public void setDni(String dni) {
		Dni = dni;
	}



	public String getDireccionResidencia() {
		return direccionResidencia;
	}



	public void setDireccionResidencia(String direccionResidencia) {
		this.direccionResidencia = direccionResidencia;
	}



	@Override
	public String toString() {
		return nombre + "," + apellido1 + "," + apellido2 + "," + edad + "," + numeroTelefono + "," + Dni + "," + direccionResidencia;
	}

}
