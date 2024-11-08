
public class Aplicacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Informacion info=new Informacion();
		Productor productor=new Productor(info);
		Consumidor consumidor=new Consumidor(info);
		consumidor.start();
		productor.start();
	
	}

}
