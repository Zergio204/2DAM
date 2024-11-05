import java.util.Random;

public class Aplicacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Random r = new Random();
		int cont = 0;
		
		while(cont!=3) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			int num1 = r.nextInt();
			int num2 = r.nextInt();
			int num3 = r.nextInt();
			int num4 = r.nextInt();
			int num5 = r.nextInt();
			
			Proceso p1 = new Proceso("p1", num1);
			Proceso p2 = new Proceso("p2", num2);
			Proceso p3 = new Proceso("p3", num3);
			Proceso p4 = new Proceso("p4", num4);
			Proceso p5 = new Proceso("p5", num5);
			
			cont++;
		}
		
	}

}
