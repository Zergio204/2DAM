import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor {
    public static void main(String[] args) {
        ArrayList<Socket> clientSockets = new ArrayList<>();
        ArrayList<PrintWriter> clientWriters = new ArrayList<>();
        ArrayList<String> clientNames = new ArrayList<>();
        
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Servidor iniciado en puerto 5000");

            while (clientSockets.size() < 4) {
                Socket clientSocket = serverSocket.accept();
                clientSockets.add(clientSocket);
                
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                clientWriters.add(out);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                
                out.println("Por favor, ingresa tu nombre:");
                String clientName = in.readLine();
                clientNames.add(clientName);
                
                Mensaje conexionMsg = new Mensaje("Servidor", "Cliente " + clientName + " conectado. Total: " + clientSockets.size() + "/4");
                System.out.println(conexionMsg);

                final int clientIndex = clientSockets.size() - 1;
                new Thread(() -> {
                    try {
                        String mensajeRecibido;
                        while ((mensajeRecibido = in.readLine()) != null) {
                            Mensaje mensaje = new Mensaje(clientNames.get(clientIndex), mensajeRecibido);
                            System.out.println(mensaje);
                            // Enviar mensaje a todos los clientes
                            for (PrintWriter writer : clientWriters) {
                                writer.println(mensaje.toString());
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
            }

            // Thread para enviar pings
            new Thread(() -> {
                while (true) {
                    try {
                        Thread.sleep(5000);
                        Mensaje pingMsg = new Mensaje("Servidor", "ping");
                        for (PrintWriter writer : clientWriters) {
                            writer.println(pingMsg.toString());
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}