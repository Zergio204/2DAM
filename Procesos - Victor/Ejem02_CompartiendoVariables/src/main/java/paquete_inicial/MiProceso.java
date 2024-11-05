 package paquete_inicial;

public class MiProceso extends Thread {

	private Contador contador;
	private int contadorLocal=0;

	public MiProceso(String name, Contador contador) {
		super(name);
		// TODO Auto-generated constructor stub
		this.contador=contador;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while(contador.getContador() < 1000)
		{		
			synchronized (contador) {
				if(contador.getContador()<1000) {
				int aux = contador.getContador();
				aux++;
				contador.setContador(aux);
				System.out.println(Thread.currentThread().getName()+"->"+contador.getContador());
			
				}
			}
			if(contador.getContador()<1000) {
				contadorLocal++;
			}
			/*try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}
		System.out.println(Thread.currentThread().getName()+"->"+contadorLocal);
	}

	
	
	
	
	
	
	
	
}
