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
			
			List<Thread> threads = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                Socket socket = server.accept();
                Thread thread = new Thread(() -> {
                    try (ObjectInputStream ois = new ObjectInputStream(socket.getInputStream())) {
                        Mensaje mensaje;
                        while ((mensaje = (Mensaje) ois.readObject()) != null) {
                            System.out.println("Mensaje recibido: " + mensaje);
                            if ("fin".equalsIgnoreCase(mensaje.getContenido())) {
                                break;
                            }
                        }
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                });
                threads.add(thread);
                thread.start();
            }
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
