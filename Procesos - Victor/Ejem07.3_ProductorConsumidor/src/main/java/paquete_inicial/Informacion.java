package paquete_inicial;

import java.util.Random;

public class Informacion {
	private int dato;
	private boolean consumido=true;
	private int cont=0;
	
	public int getCont() {
		return cont;
	}

	Random r= new Random();
	
	public synchronized void producir() {
		if(!consumido) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
		cont++;
		dato=r.nextInt();
		consumido = false;
		notify();	
	}
	
	public synchronized int consumir() {
		if(consumido) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		consumido=true;
		notify();
		return dato;
	}
}
