package main;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ConexionServer {

	
	//atributos para la coneccion
	private static Socket miSocket;
	private static DataOutputStream flujoSalida;
	
	
	
	/*
	 * METODO CONSTRUCTOR
	 */
	public ConexionServer(){
		
	}
	
	
	/*
	 * METODO QUE REALIZA LA CONEXION AL SERVIDOR
	 */
	public String realizarConexion(String mensaje){
		
		String respuesta="";
		
		try {
			
			//la direccion o ubicacion del servidor y el puerto por el cual se va a enviar la infromación
			miSocket =  new Socket("localhost", 9090);

			//se establece la conexion entre mi flujo de salida y el socket
			flujoSalida = new DataOutputStream(miSocket.getOutputStream());

			//se envia el mensaje al servidor
			flujoSalida.writeUTF(mensaje);
			flujoSalida.close();

			respuesta="el mensaje ha sido enviado";
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			respuesta="ha ocurrido un error";
		}
		
		
		
		
		return respuesta;
	}
	
}
