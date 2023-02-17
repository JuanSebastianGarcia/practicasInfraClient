package main;

public class EchoTCPServer {

	
	/*
	 * CONSTRUCTOR
	 */
	public EchoTCPServer(){}
	
	
	/*
	 * methot that on server
	 */
	public void onServer(){
		
		HiloServer hilo = new HiloServer();
		
		
		hilo.run();
	}
	
}
