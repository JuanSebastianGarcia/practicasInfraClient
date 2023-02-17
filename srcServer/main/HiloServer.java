package main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HiloServer extends Thread{

	
	//attributes
	private ServerSocket server;
	private Socket socket;
	
	private DataInputStream flujoEntrada;
	private static DataOutputStream flujoSalida;
	
	private String mensaje;

	
	
	/*
	 *
	 */
	@Override
	public void run() {
		
		try {
			
			server= new ServerSocket(1111);//se establece el servidor
			
			
			while(true){
				
				System.out.println("el servidor esta escuchando");
				
				socket=server.accept();//se espera a que el cliente se conecte
				
				//se establece la conexion entre mi flujo de salida y el socket
				flujoEntrada = new DataInputStream(socket.getInputStream());
				flujoSalida = new DataOutputStream(socket.getOutputStream());
				
				mensaje=flujoEntrada.readUTF();//se recibe el mensaje del cliente
				System.out.println(mensaje);
				flujoSalida.writeUTF(mensaje);
				
				//se cierran todas las conexiones
				flujoEntrada.close();
				socket.close();
				
				System.out.println("el cliente se desconecto");

			}
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
}
