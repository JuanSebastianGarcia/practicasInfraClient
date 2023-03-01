package cajeroClient;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
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
		
		case 5: buscarArchivoTxt(); break;
		
		case 6: salir(); break;
		}
		
		
	}

	
	/*
	 * ESTE METODO SE ENCARGA DE BUSCAR UN ARCHIVO TXT Y ALMACENAR SU CONTENIDO
	 */
	private void buscarArchivoTxt() {
		
        // Crear un objeto JFileChooser
        JFileChooser chooser = new JFileChooser();

        // Mostrar el diálogo para seleccionar un archivo
        int resultado = chooser.showOpenDialog(null);

        // Si se seleccionó un archivo, obtener su ruta
        String rutaArchivo = null;
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = chooser.getSelectedFile();
            rutaArchivo = archivoSeleccionado.getAbsolutePath();
        }

        // Mostrar la ruta del archivo
        if (rutaArchivo != null) {
            
        	//invocacion
        	leerArchivotxt(rutaArchivo);
        	
        } else {
            System.out.println("No se seleccionó ningún archivo.");
        }
		
		
	}
	
	

	/*
	 * METODO QUE ME PERMITE LEER EL CONTENIDO DE UN ARCHIVO TXT
	 */
	private void leerArchivotxt(String rutaArchivo) {
		
		//se crea el archivo a leer y la variable que almacenara su contenido
		File archivo = new File(rutaArchivo);
		ArrayList<String> lineas = new ArrayList<>();

		try {
			BufferedReader lector = new BufferedReader(new FileReader(archivo));
			String linea = lector.readLine();
			while (linea != null) {
				lineas.add(linea);
				linea = lector.readLine();
			}
			lector.close();
		} catch (IOException e) {
			System.out.println("Hubo un error al leer el archivo: " + e.getMessage());
		}
		

		/* Mostrar las lineas almacenadas en el ArrayList
		for (String l : lineas) {
			System.out.println(l);
		}*/

		//invocacion
		String respuesta=client.enviarListaSolicitudes(lineas);

		JOptionPane.showMessageDialog(null, respuesta);
		
		ejecutarCodigo();
	}
	
	
	
	



	/*
	 * METODO QUE DA FINAL AL PROGRAMA
	 */
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
		
		String menu="1.retirar dinero \n 2.depositar dinero \n 3.consultar saldo \n 4.crear cuenta  \n 5.seleccionar un archivo txt \n 6.salir";
		
		int opcion=Integer.parseInt(JOptionPane.showInputDialog(menu));
		
		return opcion;
	}


}
