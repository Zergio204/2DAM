package callable2;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Aplicacion {

	public static void main(String[] args) {
		
		ArrayList<ProcesoCallable> listaProcesos = new ArrayList<ProcesoCallable>();
		for (int i = 0; i < 10; i++) {
			listaProcesos.add(new ProcesoCallable());
		}
		
		ExecutorService executor = Executors.newFixedThreadPool(10);
		ArrayList<Future<Integer>> listaResultados = new ArrayList<Future<Integer>>();
		try {
			listaResultados=(ArrayList<Future<Integer>>) executor.invokeAll(listaProcesos);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Future<Integer> resultado : listaResultados) {
			try {
				System.out.println(resultado.get());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		executor.shutdown();

	}

}
