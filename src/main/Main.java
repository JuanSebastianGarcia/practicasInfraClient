package main;

import javax.swing.JOptionPane;

public class Main {

	
	//clase que se conecta con el servidor
	private static EchoTCPClient myConection =new EchoTCPClient();
	
	
	public static void main(String[] args) {
	
		//invocacion
		ejecutarPrograma();

	}
	
	
	/*
	 * METODO QUE DA INICIO A LA EJECUCION DEL CLIENTE
	 */
	public static void ejecutarPrograma(){
		
		
		String mensaje=JOptionPane.showInputDialog("ingrese el mensaje");
		
		myConection.realizarConexion(mensaje);
		
		
	}
	
	
}