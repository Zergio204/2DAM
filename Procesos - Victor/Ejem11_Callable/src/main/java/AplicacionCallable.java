import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AplicacionCallable {

	public static void main(String[] args) {
		/*Thread proceso = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Proceso en ejecucion");
			}
		}); 
		proceso.start();*/
		// Con Lambda
		//Thread proceso = new Thread(() -> System.out.println("Proceso en ejecucion"));
		
		
		/*Callable<Integer> tarea =new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				System.out.println("Proceso en ejecucion");
				return 10;
			}
		};*/

		Callable<Integer> tarea = () -> {
			System.out.println("Proceso en ejecucion");
			Thread.sleep(5000);
			return 33;
		};
		
		ExecutorService executor = Executors.newSingleThreadExecutor();
		Future<Integer> futureTarea=executor.submit(tarea);
		
		System.out.println("Esperando el resultado");
		try {
			System.out.println("El resultado es: "+futureTarea.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			executor.shutdown();
		}

	}

}
