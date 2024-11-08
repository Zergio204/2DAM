
public class Proceso extends Thread{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
//		boolean salir = false;
//		while(!salir) {
//			System.out.println("Proceso en ejecucion");
//			if (Thread.currentThread().isInterrupted()) {
//				salir = true;
//			}
//		}
		 
		while(Thread.currentThread().isInterrupted()) {
			System.out.println("Proceso en ejecucion");
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
				Thread.currentThread().interrupt(); //this.interrupt();
			}
		}
	}
	
}
