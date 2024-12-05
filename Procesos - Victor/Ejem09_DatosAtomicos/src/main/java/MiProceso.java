import java.util.concurrent.atomic.AtomicInteger;

public class MiProceso extends Thread {

	private AtomicInteger contador;
	private int contadorLocal=0;

	public MiProceso(String name, AtomicInteger contador) {
		super(name);
		// TODO Auto-generated constructor stub
		this.contador=contador;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while(contador.get() < 1000)
		{		
			System.out.println(Thread.currentThread().getName()+"->"+contador.getAndIncrement());
			
		}
		System.out.println(Thread.currentThread().getName()+"->"+contadorLocal);
	}

	
	
	
	
	
	
	
	
}
