package com.example.ejemconexionsockets;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {
		
		try (ServerSocket server = new ServerSocket(4444); Socket socket = server.accept();){
			
			ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());
			
			Mensaje mensaje = (Mensaje) entrada.readObject();
			
			System.out.println(mensaje.toString());
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
