
public class Productor extends Thread {
	private Informacion info;
	
	
	public Productor(Informacion i) {
		super();
		this.info = i;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
			
		for(int i = 0;i<10;i++) {
			info.producir();
			
		}
		
		
	}
}
