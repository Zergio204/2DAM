package ExecutorServices;
import java.util.concurrent.ArrayBlockingQueue;

public class Consumidor extends Thread {

	ArrayBlockingQueue<Integer> buffer;
	private int numeroDatosConsumidos;
	
	public Consumidor(String nombre,ArrayBlockingQueue<Integer> buffer) {
		super(nombre);
		this.buffer=buffer;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		boolean continuar=true;
		for (int i = 0; i < 100 && continuar; i++) {
            try {
                System.out.println("Consumidor consume: " + buffer.take());
                numeroDatosConsumidos++;
                System.out.println("Consumidor "+Thread.currentThread().getName()+" ha consumido " + numeroDatosConsumidos + " elementos");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                //e.printStackTrace();
            	continuar=false;
                System.err.println("Tiene que salir");
            }
		}
	}

}
