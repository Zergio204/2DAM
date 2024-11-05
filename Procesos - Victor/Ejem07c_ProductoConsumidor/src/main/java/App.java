
public class App {

	public static void main(String[] args) {
		/* Coodinamos para que productor consumidor
		 * esperen uno por el otro para que no se produzca y 
		 * dato y nadie lo consuma
		 */
		Informacion info = new Informacion();
		Productor productor = new Productor(info);
		Consumidor consumidor = new Consumidor(info);
		productor.start();
		consumidor.start();
		
	}

}
