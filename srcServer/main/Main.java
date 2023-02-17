package main;

public class Main{

	
	
	
	public static void main(String[] args) {
	
		//invocacion
		ejecutarPrograma();

	}

	
	public static void ejecutarPrograma(){
		
		
		EchoTCPServer server=new EchoTCPServer();
		
		server.onServer();
		
	}
}
