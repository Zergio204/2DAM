
public class Proceso extends Thread {
	
	Contador cont;
	String nombre;
	int contadorLocal = 0;

	public Proceso(String nombre, ThreadGroup grupo, Contador cont) {
		super(grupo,nombre);
		this.cont = cont;
		this.nombre = nombre;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		while(cont.getContador()<100000) {
			synchronized (cont) {
				if(cont.getContador()<100000) {
					
					int aux = cont.getContador();
					aux++;
					cont.setContador(aux);
					
					System.out.println(this.nombre + " " + cont.toString());
					
				}
			}
			
			if(cont.getContador()<100000) {
				contadorLocal++;
			}
			
		}
		
		System.out.println(this.nombre + " ha contado: " + contadorLocal);
		
	}
	
	
	
	
}
