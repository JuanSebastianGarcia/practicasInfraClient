package mainUDP;

import java.util.Scanner;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.DatagramPacket;


public class EchoUDPClient {

	//attributes
	private static final Scanner SCANNER = new Scanner(System.in);
	public static final String SERVER = "localhost";
	public static final int PORT = 3500;
	
	
	/*
	 * CONSTRUCTOR
	 */
	public EchoUDPClient() {
		System.out.println("ECHO UDP CLIENT...");
	}
	
	
	
	/*
	 * METODO QUE EJECUTA LA CONEXION CON EL SERVIDOR ENVIANDO Y RECIBIENDO UN MENSAJE
	 * DEL MISMO
	 */
	public void makeProtocol() throws Exception {
		
		DatagramSocket clientSideSocket = new DatagramSocket();
		
		//lectura del mensaje
		System.out.print("ingrese un mensaje");
		String fromUser = SCANNER.nextLine();
		
		//invocacion
		send(fromUser, clientSideSocket);//se envia el mensaje al servidor
		
		//invocacion
		String fromServer = (String) receive(clientSideSocket);//se recibe el mensaje del servidor
		
		
		System.out.println("[Client] from server: "+fromServer);
		
		clientSideSocket.close();
	}
	
	
	/*
	 * METODO QUE ENVIA EL MENSAJE AL SERVIDOR
	 */
	private void send(String messageToSend, DatagramSocket socket) throws Exception {
		
		//se convierte el mensaje en un arreglo de caracteres
		byte[] mensaje = messageToSend.getBytes();
		
		//se agrega la direccion del servidor
		InetAddress serverIPAddress = InetAddress.getByName(SERVER);
		
		//se crea el datagrama y se almacena en un paquete
		//el datagrama contiene toda la informacion necesaria
		DatagramPacket packetToSend = new DatagramPacket(mensaje, mensaje.length, serverIPAddress, PORT);
		
		//se envia el mensaje
		socket.send(packetToSend);
	
	}
	
	
	
	/*
	 * METODO QUE RECIBE EL MENSAJE DEL SERVIDOR
	 */
	private String receive(DatagramSocket socket) throws Exception {
		
		//SE CREA UN ARREGLO DE CARACTERES PARA RECIBIR UN MENSAJE
		byte[] bufferToReceive = new byte [ 1024 ];
		
		//se crea un paquete en el cual se almacena los datos que llegan del servidor
		DatagramPacket packetToReceive = new DatagramPacket(bufferToReceive, bufferToReceive.length);
		
		//se recibe el mensaje
		socket.receive(packetToReceive);
		
		String receivedMessage = new String(packetToReceive.getData(), 0, packetToReceive.getLength());	
		
		return receivedMessage;
	}
	
	
	
	
	/*
	 * METODO PRINCIPAL
	 */
	public static void main(String args[]) throws Exception {
		
		EchoUDPClient ec = new EchoUDPClient();
		ec.makeProtocol();
	
	}
	
}
