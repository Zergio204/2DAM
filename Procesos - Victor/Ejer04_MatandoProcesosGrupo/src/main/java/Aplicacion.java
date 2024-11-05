
public class Aplicacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int numProcesos = 100;
		ThreadGroup grupoProcesos = new ThreadGroup("grupoProcesos");
		
		for (int i = 0; i < numProcesos; i++) {
			Proceso p = new Proceso("p" + i, i, grupoProcesos);
			p.start();
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		grupoProcesos.interrupt();
		
	}

}
