package persistencia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import cajeroServidor.Persona;


public class Persistencia {




	/*
	 * RUTAS PARA AMACENAR LOS ARCHIVOS
	 */

	public static final String RUTA_ARCHIVO_USUARIOS="srcServer/resources/archivoUsuarios.txt";


	/*
	 * METODO QUE PERSISTE LOS DATOS DE LAS PERSONAS
	 */
	public static void almacenarPersonas(HashMap<String, Persona> listaPersonas) throws IOException {

        /*
         * CREAR UN ARRAYLIST VACIO
         */

          ArrayList<Persona> listaP = new ArrayList<>();

        /*
         * ELEMENTOS DEL HASHMAP Y LO VAMOS AGREGANDO AL ARRAYLIST
         */

        for (Persona value : listaPersonas.values()) {
            listaP.add(value);
        }

		String contenido = "";

		/*
		 * RECORREMOS Y VAMOS AGREGANDO SEPARANDO POR #
		 */

		for(int i=0;i<listaP.size();i++){

			contenido+= listaP.get(i).getCedula()+"#"+listaP.get(i).getNombre()+"#"+ listaP.get(i).getDineroActual()+"\n";


		}

		ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_USUARIOS, contenido, false);

	}

}
