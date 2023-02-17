package cajeroServidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Conexion {

	//atributos para la coneccion
	private static Socket miSocket;
	private static DataOutputStream flujoSalida;
	private DataInputStream flujoEntrada;
	
	
	/*
	 * CONSTRUCTOR
	 */
	public Conexion(){
		
	}
	
	
	/*
	 * METODO QUE INICIA EL SERVIDOR
	 */
	public void onServer() {
		
		HiloServer hilo=new HiloServer();
		
		
		hilo.run();
	}

}
