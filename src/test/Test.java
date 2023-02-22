package test;
import java.io.File;
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
            System.out.println("La ruta del archivo es: " + rutaArchivo);
        } else {
            System.out.println("No se seleccionó ningún archivo.");
        }
    }
}