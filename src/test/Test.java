package test;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;

public class Test {

    public static void main(String[] args) {

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
           leerArchivotxt(rutaArchivo);
        } else {
            System.out.println("No se seleccionó ningún archivo.");
        }
        
    }
    
    
	/*
	 * METODO QUE ME PERMITE LEER EL CONTENIDO DE UN ARCHIVO TXT
	 */
	private static void leerArchivotxt(String rutaArchivo) {
		
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

		// Mostrar las lineas almacenadas en el ArrayList
		for (String l : lineas) {
			System.out.println(l);
		}


	}
	
	
	
}