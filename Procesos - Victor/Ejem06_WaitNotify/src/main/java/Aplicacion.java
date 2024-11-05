import java.util.Scanner;

public class Aplicacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);

		Mensaje m = new Mensaje("");
		boolean bandera = true;
		
		ImpresoraMensajes impresora1 = new ImpresoraMensajes("Impresora1",m);
		impresora1.start();
		ImpresoraMensajes impresora2 = new ImpresoraMensajes("Impresora2",m);
		impresora2.start();
		ImpresoraMensajes impresora3 = new ImpresoraMensajes("Impresora3",m);
		impresora3.start();
		ImpresoraMensajes impresora4 = new ImpresoraMensajes("Impresora4",m);
		impresora4.start();
		
		do {
			
			System.out.println("Introduce un mensaje: ");
			String mensaje = sc.nextLine();
			m.setMenasje(mensaje);
			synchronized (m) {
				if(mensaje.equalsIgnoreCase("salir")) {
					bandera = false;
					m.notifyAll();
				}else {
					m.notify();
				}
			}
		} while(bandera);

	}

}
