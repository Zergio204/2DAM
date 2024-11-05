
public class Aplicacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Proceso p = new Proceso();
		p.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p.interrupt();
		System.out.println("He matado a mi hijo");
		
	}

}
