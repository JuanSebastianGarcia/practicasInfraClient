package cajeroServidor;

import java.util.HashMap;

public class Singleton {

	
	//atributos
	HashMap<String,Persona> listaPersonas=new HashMap<String, Persona>();
	private static Singleton singleton;
	
	
	
	
	/*
	 * INSTANCIA PRINCIPAL
	 */
	public static Singleton getInstance(){
		
		if(singleton==null){
			singleton=new Singleton();
		}
		return singleton;
	}




	/*
	 * METODO QUE CONSULTA EN UNA LISTA DE USUARIOS SI SE PUEDE RETIRAR CIERTA CANTIDAD DE DINERO
	 */
	public String retirarDinero(String documento, double cantidadDinero) {
		
		String respuesta="";
		
		if(listaPersonas.get(documento)!=null){
			
		}else{
			respuesta="el usuario no ha sido encontrado";
		}
		
		
		
		return respuesta;
	}
	
	
	
	
	
	
	
}
