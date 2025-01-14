
import java.io.*;
import java.net.*;

public class Cliente {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5000);
            System.out.println("Conectado al servidor");

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            // Thread para recibir mensajes
            new Thread(() -> {
                try {
                    String mensajeRecibido;
                    while ((mensajeRecibido = in.readLine()) != null) {
                        System.out.println(mensajeRecibido);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

            // Manejo de entrada del usuario en el thread principal
            String mensajeEnviado;
            while ((mensajeEnviado = userInput.readLine()) != null) {
                out.println(mensajeEnviado);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}