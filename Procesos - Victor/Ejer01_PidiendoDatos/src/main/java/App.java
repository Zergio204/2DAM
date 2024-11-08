

import java.util.ArrayList;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("¿Cuantos procesos quieres generar?");
		int nprocesos = in.nextInt();
		System.out.println("¿Cuantas veces quieres que cuente?");
		int nveces = in.nextInt();
		
		Contador c = new Contador(0);
		for(int i = 0;i<nprocesos;i++) {
			Proceso p = new Proceso("p"+(i+1),c,nveces);
			p.start();
		}
	}

}
