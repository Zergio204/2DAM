
public class Mensaje {

	private String menasje;

	public Mensaje(String menasje) {
		super();
		this.menasje = menasje;
	}

	public String getMenasje() {
		return menasje;
	}

	public void setMenasje(String menasje) {
		this.menasje = menasje;
	}

	@Override
	public String toString() {
		return "Mensaje [menasje=" + menasje + "]";
	}
	
	
	
}
