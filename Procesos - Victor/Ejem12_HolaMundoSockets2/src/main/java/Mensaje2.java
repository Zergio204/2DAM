
public final class Mensaje2 
{
	private final String emisor="";
	private final String mensaje="";
	
	public Mensaje2(String emisor, String mensaje) {
		emisor = emisor;
		mensaje = mensaje;
	}

	public String getEmisor() {
		return emisor;
	}

	public String getMensaje() {
		return mensaje;
	}

	@Override
	public String toString() {
		return "Mensaje2 [emisor=" + emisor + ", mensaje=" + mensaje + "]";
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		else if (emisor.equals(((Mensaje2) obj).emisor) && mensaje.equals(((Mensaje2) obj).mensaje))
			return true;
		else
			return false;
	}

}
