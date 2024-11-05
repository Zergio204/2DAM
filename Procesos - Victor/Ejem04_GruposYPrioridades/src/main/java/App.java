
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Contador contador=new Contador();
		//Crea grupos
		ThreadGroup pares=new ThreadGroup("Pares");
		ThreadGroup impares=new ThreadGroup("Impares");
		
		//Creaomos procesos y ponemos prioridades
		Proceso proceso1 = new Proceso(contador,impares,"p1");
		proceso1.setPriority(Thread.MAX_PRIORITY);
		Proceso proceso2 = new Proceso(contador,pares,"p2");
		proceso2.setPriority(Thread.MIN_PRIORITY);
		Proceso proceso3 = new Proceso(contador,impares,"p3");
		proceso3.setPriority(Thread.MAX_PRIORITY);
		Proceso proceso4 = new Proceso(contador,pares,"p4");
		proceso4.setPriority(Thread.MIN_PRIORITY);
		
		proceso1.start();
		proceso2.start();
		proceso3.start();
		proceso4.start();
		
		try {
			//Esta instruccion hace que el programa se tenga que asegurar que han finalizado para continuar con la aplicación
			proceso1.join();
			proceso2.join();
			proceso3.join();
			proceso4.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Soy el hilo " + proceso1.getName() + " y he terminado con el contador " + proceso1.getContadorLocal());
		System.out.println("Soy el hilo " + proceso2.getName() + " y he terminado con el contador " + proceso2.getContadorLocal());
		System.out.println("Soy el hilo " + proceso3.getName() + " y he terminado con el contador " + proceso3.getContadorLocal());
		System.out.println("Soy el hilo " + proceso4.getName() + " y he terminado con el contador " + proceso4.getContadorLocal());
		
	}

}
