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
		
		Contador contador= new Contador(0);
		
		MiProceso proceso = new MiProceso("ProcesoHijo",contador);
		proceso.start(); //el metodo start ejecuta automaticamente el metodo run.
		MiProceso proceso2 = new MiProceso("ProcesoHijo2",contador);
		proceso2.start(); //el metodo start ejecuta automaticamente el metodo run.
		MiProceso proceso3 = new MiProceso("ProcesoHijo3",contador);
		proceso3.start(); //el metodo start ejecuta automaticamente el metodo run.
		
		System.out.println("Hola Mundo");
		
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + "HolaMundo desde Aplicacion");
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		

	}

}
