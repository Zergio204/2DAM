import java.io.Serializable;

public record Mensaje(String Emisor, String Mensaje) implements Serializable {
	
	public String getContenido() {
		return this.Mensaje;
	}
	
}
