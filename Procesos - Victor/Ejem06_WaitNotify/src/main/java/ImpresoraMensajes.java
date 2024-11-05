
public class ImpresoraMensajes extends Thread {

	Mensaje mensaje;
	
	public ImpresoraMensajes(String nombreProceso, Mensaje m) {
		super(nombreProceso);
		mensaje = m;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		do {
			synchronized (mensaje) {
				try {
					mensaje.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + ": " +  mensaje.getMenasje());
			}
		}while(!mensaje.getMenasje().toString().equalsIgnoreCase("salir"));
		
	}

	
	
	
}
