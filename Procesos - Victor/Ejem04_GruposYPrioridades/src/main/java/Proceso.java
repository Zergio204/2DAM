
public class Proceso extends Thread {
	
	private Contador contador;
	private int contadorLocal;

	public int getContadorLocal() {
		return contadorLocal;
	}
	
	public Proceso(Contador contador, ThreadGroup grupo, String nombre) {
		super(grupo,nombre);
		this.contador = contador;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		while(contador.getContador()<100000) {
			
			synchronized (contador) {
				if(contador.getContador()<100000) {
					contadorLocal++;
					contador.setContador(contador.getContador()+1);
				}
			}
			
		}
		
		//Active count nos dice cuantos procesos activos hay en ese grupo
		this.getThreadGroup().activeCount();
	
		System.out.println("Soy el hilo "+getName()+ " y en el grupo "+getThreadGroup().getName()+" hay estos procesos vivos"+getThreadGroup().activeCount());
		
		//Crear array de procesos y rellenar con los procesos
		Thread procesos[] = new Thread[getThreadGroup().activeCount()];
		getThreadGroup().enumerate(procesos);
		
		System.out.println("-------------");
		for (int i = 0; i < procesos.length; i++) {
			System.out.println(procesos[i].getName());
		}
		System.out.println("-------------");

	}
	
	
	
	
}
