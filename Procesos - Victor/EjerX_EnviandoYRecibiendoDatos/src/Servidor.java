import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Servidor {

    private static final List<ObjectOutputStream> clientesConectados = new ArrayList<>();

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(5); 
        try (ServerSocket server = new ServerSocket(4444)) {
            System.out.println("Servidor escuchando en el puerto 4444");

            while (true) {
                Socket socket = server.accept();
                pool.execute(() -> manejarCliente(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            pool.shutdown();
        }
    }

    private static void manejarCliente(Socket socket) {
        try (ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
             ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream())) {

            agregarCliente(oos);

            Mensaje mensaje = null;
            do  {
                mensaje = (Mensaje) ois.readObject();
                System.out.println("Mensaje recibido: " + mensaje.mensaje());
                if (mensaje.mensaje().equals("fin")){
                   // eliminarCliente(socket);
                	clientesConectados.remove(oos);
                	oos.close();
                }
                reenviarMensajeATodos(mensaje);
            } while (!mensaje.mensaje().equals("fin"));
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Cliente desconectado");
        } 
    }

    private static void agregarCliente(ObjectOutputStream oos) {
        //synchronized (clientesConectados) {
            clientesConectados.add(oos);
        //}
    }

    /*private static void eliminarCliente(Socket socket) {
        //synchronized (clientesConectados) {
            clientesConectados.removeIf(oos -> {
                try {
                    oos.close();
                    return true;
                } catch (IOException e) {
                    return false;
                }
            });
       // }
    }*/

    private static void reenviarMensajeATodos(Mensaje mensaje) {
        //synchronized (clientesConectados) {
            for (ObjectOutputStream oos : clientesConectados) {
                try {
                    oos.writeObject(mensaje);
                } catch (IOException e) {
                    System.out.println("Error al enviar mensaje a un cliente");
                }
            }
       // }
    }
}

