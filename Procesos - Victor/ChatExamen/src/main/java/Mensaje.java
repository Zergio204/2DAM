
public class Mensaje {
	
	private String emisor;
	private String mensaje;
	
	public Mensaje(String emisor, String mensaje) {
		this.emisor = emisor;
		this.mensaje = mensaje;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return emisor + " -> " + mensaje;
	}
}
