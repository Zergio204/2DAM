/**
 * 
 */
package paquete_inicial;

/**
 * 
 */
public class Aplicacion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Contador contador = new Contador(0);
		
		
		
		MiProceso proceso = new MiProceso("Proceso hijo",contador);
		proceso.start();
		MiProceso proceso2 = new MiProceso("Proceso2 hijo",contador);
		proceso2.start();
		MiProceso proceso3 = new MiProceso("Proceso3 hijo",contador);
		proceso3.start();		
		MiProceso proceso4 = new MiProceso("Proceso4 hijo",contador);
		proceso4.start();		
		
		
		System.out.println("Hola mundo");
		
		
		
		/*for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName()+"Hola mundo desde Aplicacion");
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
	}

}
