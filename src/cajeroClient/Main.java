package cajeroClient;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	public ConectionServer client=new ConectionServer();
	public static Main mainClass= new Main();
	
	
	public static Main getInstance(){
		
		return mainClass;
	}
	

	/*
	 * METODO PRINCIPAL
	 */
	public static void main(String[] args) {

		launch(args);

	}
	

	/*
	 * METODO QUE INICIA EL CICLO DE VIDA DE LA INTERFAZ GRAFICA
	 */
	@Override
	//METODO QUE DA INICIO A LA INTERFAZ GRAFICA
	public void start(Stage primaryStage) throws Exception,InvocationTargetException {


		try{


		Parent root=FXMLLoader.load(getClass().getResource("/cajeroClient/MenuPrincipal.fxml"));


		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle(" MARKET PLACE");
		primaryStage.show();
		}
		catch(Exception InvocationTargetException ){

			System.out.println(InvocationTargetException.getCause());
		}

	}

	
	
	/*
	 * ESTE METODO SE ENCARGA DE BUSCAR UN ARCHIVO TXT Y ALMACENAR SU CONTENIDO
	 */
	public void buscarArchivoTxt() {
		
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
		
		
	}




	

}
