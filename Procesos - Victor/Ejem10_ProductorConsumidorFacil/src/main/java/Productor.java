import java.util.concurrent.ArrayBlockingQueue;

public class Productor extends Thread {

	ArrayBlockingQueue<Integer> buffer;
	
	public Productor(ArrayBlockingQueue<Integer> buffer) {
		this.buffer=buffer;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		
		for (int i = 0; i < 100; i++) {
			try {
				buffer.put(i);
				System.out.println("Productor produce: " + i);
				System.out.println("Lista con " + buffer.size() + " elementos");
				//Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
