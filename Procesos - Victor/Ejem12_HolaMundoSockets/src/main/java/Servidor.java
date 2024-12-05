import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (ServerSocket server= new ServerSocket(4444)){
			System.out.println("Servidor escuchando en el puerto 4444");
			
			for (int i = 0; i < 2; i++) {
				Socket socket=server.accept();
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				Mensaje obj = (Mensaje) ois.readObject();
				System.out.println(obj);
				
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				oos.writeObject(new Mensaje("Servidor","Hola, me llegó tu mensaje"));
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
