package paquete_inicial;

public class Productor extends Thread{
	
	Informacion info;

	public Productor(Informacion info) {
		super();
		this.info = info;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		for(int i=0; i<10; i++) {
			info.producir();
		}
	}
}
