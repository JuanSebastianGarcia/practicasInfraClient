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
			
			
			respuesta=listaPersonas.get(documento).retirarDinero(cantidadDinero);
			
			
			
		}else{
			respuesta="el usuario no ha sido encontrado";
		}
		
		
		
		return respuesta;
	}





	
	/*
	 * METODO QUE REALIZA UN DEPOSITO DE DINERO A UN USUARIO
	 */
	public String depositarDinero(String documento, double cantidadDinero) {
		
		String respuesta="";
		
		if(listaPersonas.get(documento)!=null){
			
			
			respuesta=listaPersonas.get(documento).depositarDinero(cantidadDinero);
			
			
			
		}else{
			respuesta="el usuario no ha sido encontrado";
		}
		
		
		
		return respuesta;
	}



	/*
	 * METODO QUE RETORNA LA INFORMACION DE UN USUARIO SOLICITADO
	 */
	public String consultarInformacion(String documento) {
	
		String respuesta="";
		
		if(listaPersonas.get(documento)!=null){
			
			
			respuesta=listaPersonas.get(documento).toString();
			
			
			
		}else{
			respuesta="el usuario no ha sido encontrado";
		}
		
		
		
		return respuesta;
	}



	/*
	 * METODO QUE CREA UN USUARIO
	 */
	public String crearUsuario(String nombre, String documento) {
		
		String respuesta="el usuario ha sido creado";
		
		Persona persona=new Persona(nombre, documento);
		listaPersonas.put(documento, persona);
		
		
		return respuesta;
	}
	
	
	
	
	
	
	
}
