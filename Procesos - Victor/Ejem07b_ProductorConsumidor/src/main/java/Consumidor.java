
public class Consumidor extends Thread{

	Informacion info;
	private int contador = 0;
	
	public Consumidor(Informacion info, String name) {
		// TODO Auto-generated constructor stub
		super(name);
		this.info=info;
	}
	
	public int getContador(){
		return contador;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		for(int i = 0; i < 10; i++)
		{
			System.out.println(info.consumir() + " " + getName());
		    try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
		    contador++;
		}
		
	} 
	

}
