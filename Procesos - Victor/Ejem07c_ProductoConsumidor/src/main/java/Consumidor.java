
public class Consumidor extends Thread {
	private Informacion info;
	
	
	public  Consumidor(Informacion info) {
		super();
		this.info = info;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0;i<10;i++) {
			System.out.println(info.consumir());
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
