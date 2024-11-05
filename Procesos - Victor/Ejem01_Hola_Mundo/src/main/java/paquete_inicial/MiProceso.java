/**
 * 
 */
package paquete_inicial;


/**
 * 
 */
public class MiProceso extends Thread {

	private Contador contador;
	
	public MiProceso(String name, Contador contador) {
		super(name);
		// TODO Auto-generated constructor stub
		this.contador=contador;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + "->" + contador.getContador());
			int aux=contador.getContador();
			aux++;
			contador.setContador(aux);
			/*try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}
		
	}

}
