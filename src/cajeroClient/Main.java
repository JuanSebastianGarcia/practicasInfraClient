package cajeroClient;

import javax.swing.JOptionPane;

public class Main {

	public ConectionServer client=new ConectionServer();
	
	
	public static void main(String[] args) {
	
		Main main=new Main();
		
		main.ejecutarCodigo();

	}
	
	
	/*
	 * METODO QUE DA INICIO A LA EJECUCION DEL CODIGO
	 */
	public void ejecutarCodigo(){
		
		//se solicita la opcion al usuario
		int opcion=imprimirMenu();
		
		
		switch(opcion){
		case 1: retirarDinero();   break;
			
		case 2: agregarDinero();   break;
		
		case 3: consultarInformacion(); break;
		
		case 4: crearCuenta();  break;
		
		case 5: salir(); break;
		}
		
		
	}

	public void salir(){
	
		System.out.println("gracias por usar");
	}
	
	/*
	 * METODO QUE SE ENCARGA DE CREAR UNA CUENTA NUEVA DE USUARIO
	 */
	public void crearCuenta(){
		
		//solicitud de datos
		String documentoUsuario=JOptionPane.showInputDialog("ingrese el documento del usuario");
		String nombreUsuario=JOptionPane.showInputDialog("digite el nombre del usuario");
		
		//invocacion
		String respuesta=client.crearCuenta(documentoUsuario, nombreUsuario);
		
		
		JOptionPane.showMessageDialog(null, respuesta);
		
		
		ejecutarCodigo();
		
	}
	
	
	
	/*
	 * METODO QUE SE ENCARGA DE HACER LA SOLICITUD DE INFORMACION DE UN USUARIO
	 */
	public void consultarInformacion(){
		
		//solicitud de datos
		String documentoUsuario=JOptionPane.showInputDialog("ingrese el documento del usuario");
		
		//invocacion
		String respuesta=client.solicitarInformacion(documentoUsuario);
		
		JOptionPane.showMessageDialog(null, respuesta);
		
		
		ejecutarCodigo();
		
	}
	
	

	/*
	 * METODO EL CUAL SE ENCARGA DE AGREGAR DINERO A UNA CUENTA
	 */
	public void agregarDinero(){
		
		//solicitud de datos
		String documentoUsuario=JOptionPane.showInputDialog("ingrese el documento del usuario");
		double cantidadDinero=Double.parseDouble(JOptionPane.showInputDialog("cuanto dinero desea agregar"));

		
		//invocacion
		String respuesta=client.agregarDinero(cantidadDinero, documentoUsuario);
		
		JOptionPane.showMessageDialog(null, respuesta);
		
		ejecutarCodigo();
		
	}
	
	
	/*
	 * METODO EL CUAL SE ENCARGA DE COMENZAR CON LA FUNCIONALIDAD DE RETIRAR DINERO
	 */
	public void retirarDinero(){
		
		//solicitud de datos
		String documentoUsuario=JOptionPane.showInputDialog("digite el documento del usuario");
		double cantidadDinero=Double.parseDouble(JOptionPane.showInputDialog("cuanto dinero desea retirar"));

		//invocacion
		String respuesta=client.retirarDinero(cantidadDinero, documentoUsuario);
		
		
		JOptionPane.showMessageDialog(null, respuesta);
		
		ejecutarCodigo();
		
	}
	

	/*
	 * METODO QUE CONTIENE LAS FUNCIONALIDADES DEL CODIGO EN UN MENU 
	 */
	public int imprimirMenu(){
		
		String menu="1.retirar dinero \n 2.depositar dinero \n 3.consultar saldo \n 4.crear cuenta";
		
		int opcion=Integer.parseInt(JOptionPane.showInputDialog(menu));
		
		return opcion;
	}


}
