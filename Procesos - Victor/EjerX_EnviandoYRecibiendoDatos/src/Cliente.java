import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {
        final Object lock = new Object();

        try (Socket socket = new Socket("localhost", 4444);
             ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
             Scanner sc = new Scanner(System.in)) {
            
            Thread escucharServidor = new Thread(() -> {
                
                    while (!Thread.currentThread().interrupted()) {
                    	try {
	                        Mensaje respuesta = (Mensaje) ois.readObject();
	                        System.out.println(respuesta.emisor() + ": " + respuesta.mensaje());
	                        
	                        /*synchronized (lock) {
	                            lock.notify();
	                        }*/
                    	} catch (IOException | ClassNotFoundException e) {
                            System.out.println("Conexión cerrada por el servidor");
                            Thread.currentThread().interrupt();
                        }
                    }
                
            });
            escucharServidor.start();
            String cadena=null;
            do {
                System.out.print("Escribe un mensaje: ");
                cadena = sc.nextLine();
                Mensaje mensaje = new Mensaje("Cliente", cadena);
                oos.writeObject(mensaje);

             /*   synchronized (lock) {
                    lock.wait();
                }*/
            } while (!cadena.equals("fin"));
            escucharServidor.interrupt();
        } catch (IOException  e) {
            e.printStackTrace();
        }
    }
}

