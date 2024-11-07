
public class Ventanilla {
	
	public static void main() {
		// TODO Auto-generated method stub
		Banco banco = new Banco();
		
		for(int i=0; i<10 ; i++) {
			Politico p = new Politico("Político " + i, banco);
		}
		
		
	}

}
