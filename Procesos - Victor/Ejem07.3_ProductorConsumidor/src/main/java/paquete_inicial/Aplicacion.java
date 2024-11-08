package paquete_inicial;

public class Aplicacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Informacion info= new Informacion();
		Productor produc= new Productor(info);
		Consumidor consu1= new Consumidor(info, "Consumidor1");
		Consumidor consu2= new Consumidor(info, "Consumidor2");
		Consumidor consu3= new Consumidor(info, "Consumidor3");
		produc.start();
		consu1.start();
		consu2.start();
		consu3.start();
		
		try {
			produc.join();
			consu1.join();
			consu2.join();
			consu3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Consumidor1 -> Consume " + consu1.getCont());
		System.out.println("Consumidor2 -> Consume " + consu2.getCont());
		System.out.println("Consumidor3 -> Consume " + consu3.getCont());
	}
}
