import java.util.concurrent.ArrayBlockingQueue;

public class Aplicacion {

	public static void main(String[] args) {

		ArrayBlockingQueue<Integer> buffer = new ArrayBlockingQueue<>(10);
		
		
		Productor productor = new Productor(buffer);
		Consumidor consumidor = new Consumidor("consumidor1",buffer);
		productor.start();
		consumidor.start();
		
		Consumidor consumidor2 = new Consumidor("consumidor2",buffer);
		consumidor2.start();
		Consumidor consumidor3 = new Consumidor("consumidor3",buffer);
		consumidor3.start();

	}

}
