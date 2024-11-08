
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Contador contador = new Contador(0);
		
		Proceso p1 = new Proceso("p1",contador);
		p1.start();
		Proceso p2 = new Proceso("p2",contador);
		p2.start();
		Proceso p3 = new Proceso("p3",contador);
		p3.start();
		
		//Preguntar IA que me explique acerca del Runable
		
	}

}
