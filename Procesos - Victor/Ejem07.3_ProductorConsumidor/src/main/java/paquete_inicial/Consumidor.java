package paquete_inicial;

public class Consumidor extends Thread{

	Informacion info;
	int cont;

	public Consumidor(Informacion info, String nombre) {
		super(nombre);
		this.info = info;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while (info.getCont()<10) {	
			synchronized (info) {
				if(info.getCont()<10) {
					System.out.println(Thread.currentThread().getName() + ": " + info.consumir() + " - " + info.getCont());
				}
			}
			cont++;
		}
	}

	public int getCont() {
		return cont;
	}
}
