package mainTcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class EchoTCPClient {

	
	//atributos para la coneccion
	private static Socket miSocket;
	private static DataOutputStream flujoSalida;
	private DataInputStream flujoEntrada;
	
	
	/*
	 * METODO CONSTRUCTOR
	 */
	public EchoTCPClient(){
		
	}
	
	
	/*
	 * METODO QUE REALIZA LA CONEXION AL SERVIDOR
	 */
	public String realizarConexion(String mensaje){
		
		String respuesta="";
		
		try {
			
			//la direccion o ubicacion del servidor y el puerto por el cual se va a enviar la infromación
			miSocket =  new Socket("localhost", 1111);

			//se establece la conexion entre mi flujo de salida y el socket
			flujoSalida = new DataOutputStream(miSocket.getOutputStream());
			flujoEntrada = new DataInputStream(miSocket.getInputStream());

			//se envia el mensaje al servidor
			flujoSalida.writeUTF(mensaje);
			mensaje=flujoEntrada.readUTF();
			
			respuesta="el mensaje ha sido enviado y el mesaje regresado fue "+mensaje;
			
			
			//se cierran las conexiones
			flujoSalida.close();
			flujoEntrada.close();
			miSocket.close();

			
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			respuesta="ha ocurrido un error";
		}
		
		
		
		
		return respuesta;
	}
	
}
