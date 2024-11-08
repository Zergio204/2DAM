package servlets;

public class Persona {

	String nombre;
	String edad;
	String tlfn;
	
	public Persona(String nombre, String edad, String tlfn) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.tlfn = tlfn;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getTlfn() {
		return tlfn;
	}

	public void setTlfn(String tlfn) {
		this.tlfn = tlfn;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + ", tlfn=" + tlfn + "]";
	}
	
	
	
}
