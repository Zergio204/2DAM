import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Socket socket = new Socket("localhost", 4444);){
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			Scanner sc = new Scanner(System.in);
			
			String mensaje;
            do {
                System.out.print("Escribe un mensaje: ");
                mensaje = sc.nextLine();
                oos.writeObject(new Mensaje("Cliente", mensaje));
                oos.flush();
            } while (!mensaje.equalsIgnoreCase("fin"));
				
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	
	}

}
