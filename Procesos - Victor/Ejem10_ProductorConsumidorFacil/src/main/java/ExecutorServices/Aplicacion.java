package ExecutorServices;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Aplicacion {

	public static void main(String[] args) {

		ArrayBlockingQueue<Integer> buffer = new ArrayBlockingQueue<>(10);
		
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		Productor productor = new Productor(buffer);
		Consumidor consumidor = new Consumidor("consumidor1",buffer);
		productor.start();
		
		//consumidor.start();
		
		Consumidor consumidor2 = new Consumidor("consumidor2",buffer);
		//consumidor2.start();
		Consumidor consumidor3 = new Consumidor("consumidor3",buffer);
		//consumidor3.start();
		
		executor.submit(consumidor);
		executor.submit(consumidor2);
		executor.submit(consumidor3);
		try {
			productor.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		executor.shutdown();
		try {
			if (!executor.awaitTermination(4, TimeUnit.SECONDS)) {
				executor.shutdownNow();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Fin de la aplicacion");
		

	}

}
