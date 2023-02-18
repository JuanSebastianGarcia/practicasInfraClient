package cajeroServidor;

import mainTcp.EchoTCPClient;

public class Main {
	
		
	
	public static void main(String[] args) {
		
		Main main=new Main();
		
		//invocation
		main.onServer();
		
	}


	
	/*
	 * SE DA INICIO A LA EJECUCION DEL CODIGO ENCENDIENDO EL SERVIDOR
	 */
	public void onServer(){
		
		HiloServer hilo=new HiloServer();
		
		
		hilo.run();
	}

}
