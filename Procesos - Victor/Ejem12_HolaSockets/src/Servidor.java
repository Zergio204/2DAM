import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Servidor {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (ServerSocket server= new ServerSocket(4444)){
			System.out.println("Servidor escuchando en el puerto 4444");
			
			for (int i = 0; i < 5; i++) {
				Socket socket = server.accept();
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				//ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				
				Thread procesoCliente = new Thread(() -> {
					List<Mensaje> obj =new ArrayList<Mensaje>();
					try {
						Mensaje mensaje=(Mensaje) ois.readObject();
						while(!mensaje.mensaje().equals("Fin"))
						{
							obj.add(mensaje);
							System.out.println(mensaje.toString());
							mensaje=(Mensaje) ois.readObject();
						}
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					/*for (Mensaje mensaje : obj) {
						System.out.println(mensaje);
					}*/
				});
				
				procesoCliente.start();
				Mensaje mensaje = new Mensaje("Servidor","Mensaje recibido");
				//oos.writeObject(mensaje);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
}