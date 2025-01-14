import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		List<Mensaje> mensajes = new ArrayList<Mensaje>();
		
		try (Socket socket = new Socket("localhost", 4444);){
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			
			String mensajeString;
			do {
				mensajeString = sc.nextLine();
				Mensaje mensaje = new Mensaje("Cliente",mensajeString);
				mensajes.add(mensaje);
				oos.writeObject(mensaje);
			}
			while(!mensajeString.equals("Fin"));
			
			
			/*ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			Mensaje obj = (Mensaje) ois.readObject();
			System.out.println(obj);*/
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} /*catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
			
		
	}
}
