
public class Ejem03_Runable {
	
	public static void main(String[] args) {
		//Proceso p = new Proceso();
	
	
		Thread hilo = new Thread(new Runnable() { 
			@Override
			public void run() {
				System.out.println("Hola mundo desde el proceso");
			}
		});
		hilo.start();
		
		//con notacion lambda
		//Thread hilo = new Thread(() -> {
		//	System.out.println("Hola mundo desde el proceso");
		//});
		
	}
}
