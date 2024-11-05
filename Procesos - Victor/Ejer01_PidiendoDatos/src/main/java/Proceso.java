

public class Proceso extends Thread {
	private Contador cont_general;
	private int cont_local = 0;
	private int nveces;
	public Proceso(String name,Contador cont,int nveces) {
		super(name);
		this.cont_general = cont;
		this.nveces = nveces;
		// TODO Auto-generated constructor stub
	}
	public Proceso(Contador cont_general,int nveces) {
		super();
		this.cont_general = cont_general;
		this.nveces = nveces;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while(cont_general.getCont()<nveces) {
			
			synchronized (cont_general) {
				if (cont_general.getCont() < nveces) {
					int aux = cont_general.getCont();
					aux++;
					cont_general.setCont(aux);
					cont_local++;
					System.out.println(Thread.currentThread().getName()+"->"+cont_local);
				}
			}
		}
		System.out.println(Thread.currentThread().getName()+" Se ha contado "+cont_local+" veces");
	}
	
	
}
