import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Servidor {
    private static List<ObjectOutputStream> clientes = new ArrayList<>();

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(4444)) {
            System.out.println("Servidor escuchando en el puerto 4444");
            
            while (true) {
                Socket socket = server.accept();
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                clientes.add(oos);
                
                new Thread(() -> {
                    try {
                        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                        
                        while (true) {
                            Mensaje mensaje = (Mensaje) ois.readObject();
                            System.out.println("Mensaje recibido: " + mensaje.getContenido());
                            
                            // Enviar a todos los clientes
                            for (ObjectOutputStream cliente : clientes) {
                                cliente.writeObject(mensaje);
                                cliente.flush();
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
