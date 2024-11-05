
public class Productor extends Thread{
	
	Informacion info;
	
	public Productor(Informacion info) {
		// TODO Auto-generated constructor stub
		this.info=info;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0; i < 30; i++)
		{
			info.producir();
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	} 
	

}
