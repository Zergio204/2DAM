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

		MiProceso proceso1 = new MiProceso("Proceso hijo", contador);
		proceso1.start();
		MiProceso proceso2 = new MiProceso("Proceso2 hijo", contador);
		proceso2.start();
		MiProceso proceso3 = new MiProceso("Proceso3 hijo", contador);
		proceso3.start();

		System.out.println("Hola mundo");
		//Bucle, en este caso sirve para que se vea más la alternancia de los procesos en la CPU
		for (int i = 0; i < 100; i++) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
