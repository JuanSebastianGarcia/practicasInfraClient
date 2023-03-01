package persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class ArchivoUtil {



	/*
	 * METODO QUE GUARDA EL CONTENIDO POR PARAMETRO EN UN ARCHIVO TXT
	 */
	public static void guardarArchivo(String ruta,String contenido, Boolean flagAnexarContenido) throws IOException {

		FileWriter fw = new FileWriter(ruta,true);
		BufferedWriter bfw = new BufferedWriter(fw);
		bfw.write(contenido);
		bfw.close();
		fw.close();

	}

	/*
	 * METODO QUE CARGA LA INFORMACION DE UN ARCHIVO Y LA RETORNA
	 */
	public static ArrayList<String> leerArchivo(String rutaArchivoUsuarios) throws IOException {

		ArrayList<String> contenido=new ArrayList<>();

		FileReader fr= new FileReader(rutaArchivoUsuarios);
		BufferedReader bfr=new BufferedReader(fr);
		String linea="";

		while((linea=bfr.readLine())!=null){

			contenido.add(linea);

		}

		bfr.close();
		fr.close();

		return contenido;
	}


	/*
	 * METODO ENCARGADO DE GUARDAR LA INFORMACION DE UN LOG
	 */
	public static void guardarRegistroLog(String mensajeLog,int nivel,String accion,String rutaArchivo){


		//inicializacion de variables
		String log="";
		Logger LOGGER = Logger.getLogger(accion);
		FileHandler fileHandler = null;
		LocalDateTime fechaSistema=LocalDateTime.now();

		try {

			fileHandler= new FileHandler(rutaArchivo,true);
			fileHandler.setFormatter(new SimpleFormatter());
			LOGGER.addHandler(fileHandler);

			switch(nivel){

			case 1:
					LOGGER.log(Level.INFO,accion+"-"+mensajeLog+" fecha:"+fechaSistema+"\n");

				break;

			case 2:
					LOGGER.log(Level.WARNING,accion+"-"+mensajeLog+" fecha:"+fechaSistema+"\n");
				break;

			case 3:
					LOGGER.log(Level.SEVERE,accion+"-"+mensajeLog+" fecha:"+fechaSistema+"\n");
				break;

			}


		} catch (SecurityException | IOException e) {

			System.out.println("el error esta al cargar el archivo log"+e.getCause());
		}









	}



}
