

import java.util.concurrent.atomic.AtomicInteger;


public class Aplicacion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Contador contador = new Contador(0);
		AtomicInteger contador = new AtomicInteger(0);
		
		MiProceso proceso = new MiProceso("Proceso hijo",contador);
		proceso.start();
		MiProceso proceso2 = new MiProceso("Proceso2 hijo",contador);
		proceso2.start();
		MiProceso proceso3 = new MiProceso("Proceso3 hijo",contador);
		proceso3.start();		
		MiProceso proceso4 = new MiProceso("Proceso4 hijo",contador);
		proceso4.start();		
		
		
		System.out.println("Hola mundo");
		
		


}

}
