package ExecutorServices2;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Aplicacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<ProcesoCallable> listaPocesos = new ArrayList<ProcesoCallable>();
		for (int i = 0; i < 10; i++) {
			listaPocesos.add(new ProcesoCallable());
		}
		
		ExecutorService executor = Executors.newFixedThreadPool(10);
		ArrayList<Future<Integer>> listaResultados = new ArrayList<Future<Integer>>();
		
		try {
			listaResultados = (ArrayList<Future<Integer>>) executor.invokeAll(listaPocesos);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (Future<Integer> resultado : listaResultados) {
			
			
		}
		
	}

}
