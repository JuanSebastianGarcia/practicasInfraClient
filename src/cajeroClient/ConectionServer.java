package cajeroClient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class ConectionServer {

	//atributos para la coneccion
	private static Socket miSocket;
	private static DataOutputStream flujoSalida;
	private DataInputStream flujoEntrada;


	/*
	 * METODO CONSTRUCTOR
	 */
	public ConectionServer(){}


	/*
	 * METODO QUE SOLICITA AL SERVIDOR PARA RETIRAR DINERO
	 */
	public  String retirarDinero(double cantidadDinero,String documento){

		String respuesta="";

		try {

			//la direccion o ubicacion del servidor y el puerto por el cual se va a enviar la infromación
			miSocket =  new Socket("localhost", 1111);

			//se establece la conexion entre mi flujo de salida y el socket
			flujoSalida = new DataOutputStream(miSocket.getOutputStream());
			flujoEntrada = new DataInputStream(miSocket.getInputStream());

			
			String mensaje="retirarDinero#"+documento+"#"+cantidadDinero;
			//se envia el mensaje al servidor
			flujoSalida.writeUTF(mensaje);
			respuesta=flujoEntrada.readUTF();

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

	
	/**
	 * METODO QUE SOLICITA AL SERVIDOR AGREGAR DINERO
	 */
	public  String agregarDinero(double cantidadDinero,String documento){

		String respuesta="";

		try {

			//la direccion o ubicacion del servidor y el puerto por el cual se va a enviar la infromación
			miSocket =  new Socket("localhost", 1111);

			//se establece la conexion entre mi flujo de salida y el socket
			flujoSalida = new DataOutputStream(miSocket.getOutputStream());
			flujoEntrada = new DataInputStream(miSocket.getInputStream());

			
			String mensaje="depositarDinero#"+documento+"#"+cantidadDinero;
			
			//se envia el mensaje al servidor
			flujoSalida.writeUTF(mensaje);
			respuesta=flujoEntrada.readUTF();

			
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

	
	/**
	 * METODO QUE SOLICITA AL SERVIDOR INFORMACION DE LA CUENTA
	 */
	public String solicitarInformacion(String documento){

		String respuesta="";

		try {

			//la direccion o ubicacion del servidor y el puerto por el cual se va a enviar la infromación
			miSocket =  new Socket("localhost", 1111);

			//se establece la conexion entre mi flujo de salida y el socket
			flujoSalida = new DataOutputStream(miSocket.getOutputStream());
			flujoEntrada = new DataInputStream(miSocket.getInputStream());

			
			String mensaje="solicitarInformacion#"+documento;
			
			//se envia el mensaje al servidor
			flujoSalida.writeUTF(mensaje);
			respuesta=flujoEntrada.readUTF();


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

	
	/**
	 * METODO QUE SOLICITA AL SERVIDOR CREAR UNA CUENTA
	 */
	public String crearCuenta(String documento,String nombre){

		String respuesta="";

		try {

			//la direccion o ubicacion del servidor y el puerto por el cual se va a enviar la infromación
			miSocket =  new Socket("localhost", 1111);

			//se establece la conexion entre mi flujo de salida y el socket
			flujoSalida = new DataOutputStream(miSocket.getOutputStream());
			flujoEntrada = new DataInputStream(miSocket.getInputStream());
			
			String mensaje="crearUsuario#"+nombre+"#"+documento;

			//se envia el mensaje al servidor y se espera su respuesta
			flujoSalida.writeUTF(mensaje);
			respuesta=flujoEntrada.readUTF();


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


	public String enviarListaSolicitudes(ArrayList<String> lineas) {

		String respuesta="la lista de operaciones ha sido realizada";

		for(int i=0;i<lineas.size();i++){
			try {

				//la direccion o ubicacion del servidor y el puerto por el cual se va a enviar la infromación
				miSocket =  new Socket("localhost", 1111);

				//se establece la conexion entre mi flujo de salida y el socket
				flujoSalida = new DataOutputStream(miSocket.getOutputStream());
				flujoEntrada = new DataInputStream(miSocket.getInputStream());
				
				String mensaje=lineas.get(i);
				System.out.println(mensaje);

				//se envia el mensaje al servidor y se espera su respuesta
				flujoSalida.writeUTF(mensaje);
				respuesta=flujoEntrada.readUTF();


				//se cierran las conexiones
				flujoSalida.close();
				flujoEntrada.close();
				miSocket.close();



			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				respuesta="ha ocurrido un error";
			}

		
		
		}


		return respuesta;
	}

	
	
	
	
	
}
