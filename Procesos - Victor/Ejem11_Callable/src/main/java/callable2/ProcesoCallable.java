package callable2;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public class ProcesoCallable implements Callable<Integer> {

	private static AtomicInteger contador = new AtomicInteger(0);
	
	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		return contador.getAndIncrement();
	}

}
