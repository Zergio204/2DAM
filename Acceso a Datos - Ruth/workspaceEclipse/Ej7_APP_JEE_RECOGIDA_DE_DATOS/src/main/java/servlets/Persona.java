package servlets;

/*
APLICACIÓN JEE DE RECOGIDA DE DATOS
Crea una pequeña aplicación de recogida de datos personales (dni/nif, nombre,
apellidos, dirección, teléfono, correo) a través de una jsp que contiene un botón
“Enviar” que llevará a otra jsp que mostrará el formulario con los datos
introducidos y los campos deshabilitados. Esta jsp contiene un botón “Volver” que
permitirá volver al formulario de recogida de datos. 

RecogidaPersona.jsp -> ServletPersona.java -> MostrarPersona.jsp
							|
							v
						Persona.java
*/

public class Persona {
	private String dni;
	private String nombre;
	private String apellidos;
	private String direccion;
	private String telefono;
	private String correo;

	public Persona() {
		super();
	}

	public Persona(String dni, String nombre, String apellidos, String direccion, String telefono, String correo) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correo = correo;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", direccion=" + direccion
				+ ", telefono=" + telefono + ", correo=" + correo + "]";
	}

}