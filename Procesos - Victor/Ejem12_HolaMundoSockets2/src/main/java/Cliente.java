import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 4444);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            
            // Thread para recibir mensajes
            new Thread(() -> {
                try {
                    while (true) {
                        Mensaje mensaje = (Mensaje) ois.readObject();
                        System.out.println(mensaje.Emisor() + ": " + mensaje.getContenido());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
            
            // Enviar mensajes
            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.print("Mensaje: ");
                String texto = sc.nextLine();
                oos.writeObject(new Mensaje("Cliente", texto));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}