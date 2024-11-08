
public class Banco {

	private int dineroDisponible = 23000000;

	public Banco() {
		super();
	}

	public int getDineroDisponible() {
		return dineroDisponible;
	}

	public void setDineroDisponible(int dineroDisponible) {
		this.dineroDisponible = dineroDisponible;
	}
	
	public int robar(int dineroRobo) {
		if(dineroDisponible>0) {
			if(dineroDisponible<dineroRobo) {
				return dineroDisponible;
			}else {
				setDineroDisponible(dineroDisponible - dineroRobo);
				return dineroRobo;
			}
		}else {
			return dineroDisponible;
		}
		
	}
	
}
