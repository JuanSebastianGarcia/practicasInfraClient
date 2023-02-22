package cajeroServidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HiloServer extends Thread{
	
	
	Singleton singleton=Singleton.getInstance();

	
	//atributos necesarios para la conexion con el servidor
	private ServerSocket server;
	private Socket socket;
	
	private DataInputStream flujoEntrada;
	private DataOutputStream flujoSalida;
	
	private String mensaje;

	
	/*
	 * 
	 */
	public void run(){
		
		try {
			
			server= new ServerSocket(1111);//se establece el servidor
			
			
			while(true){
				
				//invocacion
				realizarConexion();

				//se cierran todas las conexiones
				flujoSalida.close();
				flujoEntrada.close();
				socket.close();
				
				System.out.println("el cliente se desconecto");

			}
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	/*
	 * METODO QUE ESPERA A QUE EL CLIENTE SE CONECTE Y RECIBE UNA PETICION
	 */
	public void realizarConexion() throws IOException{
		
		
		System.out.println("el servidor esta escuchando");
		socket=server.accept();//se espera a que el cliente se conecte
		
		
		//se establece la conexion entre mi flujo de salida y el socket
		flujoEntrada = new DataInputStream(socket.getInputStream());
		flujoSalida = new DataOutputStream(socket.getOutputStream());
		
		
		
		mensaje=flujoEntrada.readUTF();//se recibe la peticion del cliente
		
		System.out.println(mensaje);
		
		//invocacion
		String peticion=procesarCadenaPeticion();
		
		//invocacion
		removerPeticion();
		elegirPeticionPrincipal(peticion);
		
	}

	
	/*
	 * METODO QUE SE ENCARGA DE ELEGIR LO QUE EL USUARIO SOLICITO
	 */
	private void elegirPeticionPrincipal(String peticion) throws IOException {
		
		switch(peticion){
		
		case "retirarDinero":     	    retirarDinero();           break;
		case "depositarDinero":         depositarDinero();         break;
		case "solicitarInformacion":    solicitarInformacion();    break;
		case "crearUsuario":            crearUsuario();            break;
		
		}
		
	}

	
	
	
	
	
	/*
	 * METODO QUE CREA UN USUARIO
	 */
	private void crearUsuario() throws IOException {
		
		//se almacena el documento y la cantidad de dinero que el usuario desea
		String nombre=procesarCadenaPeticion();
		removerPeticion();
		String documento = procesarCadenaPeticion();
		removerPeticion();
		
		String respuesta=singleton.crearUsuario(nombre,documento);
	
		flujoSalida.writeUTF(respuesta);
	}


	/*
	 * METODO QUE SE ENCARGA DE ENVIAR LA INFORMACION DE CUENTA DE UN USUARIO
	 */
	private void solicitarInformacion() throws IOException {
		
		
		//se almacena el documento y la cantidad de dinero que el usuario desea
		String documento=procesarCadenaPeticion();
		removerPeticion();
		
		
		String respuesta=singleton.consultarInformacion(documento);
		
		flujoSalida.writeUTF(respuesta);
		
	}


	/*
	 * METODO QUE SE ENCARGA DE DEPOSTIAR DINERO EN UNA CUENTA DE UN USUARIO
	 */
	private void depositarDinero() throws IOException {
		
		//se almacena el documento y la cantidad de dinero que el usuario desea
		String documento=procesarCadenaPeticion();
		removerPeticion();
		double cantidadDinero = Double.parseDouble(procesarCadenaPeticion());
		removerPeticion();
		
		
		String respuesta=singleton.depositarDinero(documento,cantidadDinero);
	
		flujoSalida.writeUTF(respuesta);
	}


	/*
	 * METODO QUE SE ENCARGA DE HACER EL PROCESO PARA RETIRAR DINERO
	 */
	private void retirarDinero() throws IOException {
		
		//se almacena el documento y la cantidad de dinero que el usuario desea
		String documento=procesarCadenaPeticion();
		removerPeticion();
		double cantidadDinero = Double.parseDouble(procesarCadenaPeticion());
		removerPeticion();
		
		
		String respuesta=singleton.retirarDinero(documento,cantidadDinero);
		
		flujoSalida.writeUTF(respuesta);
		
	}


	/*
	 * ESTE METODO SE ENCARGA DE COMENZAR A RECORRER LA PETICION DEL USUARIO
	 * ALMACENANDO EL PRIMER DATO DE LA SOLICITUD
	 */
	private String procesarCadenaPeticion() {
		
		String primeraPeticion="";//esta variable almacenara lo que el usuario solicito al servidor
		int bandera=0;
		
		for(int i=0;i<mensaje.length() && bandera==0;i++){
			
			if(mensaje.charAt(i)=='#'){
				bandera=1;
			}else{
				primeraPeticion+=mensaje.charAt(i);
			}

		}
		
		return primeraPeticion;
	}



	/*
	 * ESTE METODO SE ENCARGA DE REMOVER LA PRIMER SOLICITUD DEL MENSAJE
	 */
	public void removerPeticion(){

		//inicilizacion
		String nuevoMensaje="";
		int simboloEncontrado=0;


		for(int i=0;i<mensaje.length();i++){

			if(simboloEncontrado==1){
				nuevoMensaje+=mensaje.charAt(i);
			}


			if(mensaje.charAt(i)=='#'){
				simboloEncontrado=1;
			}


		}

		//se almacena la nueva cadena
		mensaje=nuevoMensaje;
	}


	

}
