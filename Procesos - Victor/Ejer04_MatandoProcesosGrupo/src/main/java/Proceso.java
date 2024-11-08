
public class Proceso extends Thread {

	String nombre;
	int numProceso;
	int contIndividual = 0;
	
	public Proceso(String nombre, int numProceso, ThreadGroup grupo) {
		super(grupo, nombre);
		this.nombre = nombre;
		this.numProceso = numProceso;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		while(!this.isInterrupted()) {
			contIndividual++;
			
		}
		
		System.out.println("Proceso " + this.numProceso + ": " + this.contIndividual);
		
	}	
	
}
