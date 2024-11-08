import java.util.Random;

public class Informacion {
	
	private int dato;
	Random r = new Random();
	
	
	public synchronized void producir()
	{
		dato = r.nextInt();
		notify();
	}
	
	public synchronized int consumir()
	{
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return dato;

	}
}
