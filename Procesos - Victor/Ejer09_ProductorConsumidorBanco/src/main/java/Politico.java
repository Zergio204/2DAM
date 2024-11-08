
public class Politico extends Thread{

	private int dineroRobado;
	private Banco banco;
	
	public Politico(String nombre, Banco banco) {
		super(nombre);
		this.banco = banco;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
	}
	
	
	
}
