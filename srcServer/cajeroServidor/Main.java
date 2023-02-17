package cajeroServidor;

import mainTcp.EchoTCPClient;

public class Main {
		
	//clase que se conecta con el servidor
	private static Conexion myConection =new Conexion();
		
	
	public static void main(String[] args) {
		
		Main main=new Main();
		
		//invocation
		main.onServer();
		
	}


	
	/*
	 * SE DA INICIO A LA EJECUCION DEL CODIGO ENCENDIENDO EL SERVIDOR
	 */
	public void onServer(){
		
		myConection.onServer();
	}

}
