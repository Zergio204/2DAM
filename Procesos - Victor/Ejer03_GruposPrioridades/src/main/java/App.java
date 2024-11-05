import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner (System.in);
		int numProc = 0;
		
		while(numProc<2) {
			System.out.println("Introduce un numero de procesos mayor o igual a 2: ");
			numProc = sc.nextInt();
		}
		
		Contador contador = new Contador(0);
		
		ThreadGroup grupo1 = new ThreadGroup("grupo1");
		ThreadGroup grupo2 = new ThreadGroup("grupo2");
		
		for (int i = 0; i < numProc; i++) {
			if(i==0) {
				Proceso p = new Proceso("p" + i,grupo1,contador);
				p.setPriority(Thread.MIN_PRIORITY);
				p.start();
			}else {
				Proceso p = new Proceso("p" + i,grupo2,contador);
				p.setPriority(Thread.MAX_PRIORITY);
				p.start();
			}
		}
		
	}

}
