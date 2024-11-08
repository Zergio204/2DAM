
public class Aplicacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Informacion info = new Informacion();
		Productor productor = new Productor(info);
		Consumidor consumidor = new Consumidor(info, "Consumidor 1");
		Consumidor consumidor2 = new Consumidor(info, "Consumidor 2");
		Consumidor consumidor3 = new Consumidor(info, "Consumidor 3");
		consumidor.start();
		consumidor2.start();
		consumidor3.start();
		productor.start();
		
		try {
			productor.join();
			consumidor.join();
			consumidor2.join();
			consumidor3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Consumidor 1: " + consumidor.getContador());
		System.out.println("Consumidor 2: " + consumidor2.getContador());
		System.out.println("Consumidor 3: " + consumidor3.getContador());
		
	}

}
