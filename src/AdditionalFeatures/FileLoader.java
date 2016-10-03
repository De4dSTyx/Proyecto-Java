package AdditionalFeatures;

import Main.*;
import java.io.*;

public class FileLoader {	//Clase que se encarga de cargar contraseñas de archivos .txt
	
	static public PasswordList load(String path) {
		PasswordList lista = new PasswordList();
		try {	//Intenta ejecutar el código, pero pueden ocurrir dos posibles errores
			FileReader archivo = new FileReader(path);	//Abro el archivo con el path proporcionado
			BufferedReader lector = new BufferedReader(archivo);	//Como un Scanner pero para archivos, uso el archivo de antes
			String linea = null;
			while ((linea = lector.readLine()) != null) {	//Basicamente, mientras sigan habiendo lineas de texto que leer se seguirá ejecutando
				linea = linea.trim();	//Elimina los espacios al principio y final de la linea
				String[] palabras = linea.split(" "); //Separa las lineas por espacios
				for(int i = 0; i < palabras.length; i++){
					lista.addPassword(palabras[i]);	//Añade cada palabra a la lista de contraseñas
				}
			}
			archivo.close();
			lector.close();
		}
		catch (FileNotFoundException fnfe) {	//Primer error, no se encuentra el archivo. Con el catch evitamos que se detenga la ejecución al recibir este error
			System.out.println("No se encontró el archivo");
		}
		catch (IOException ioe) {	//Segundo error, un error relacionado con la entrada. Si no ponía esto no andaba...
			System.out.println("El archivo no tiene un formato válido para el lector");
		}
		return lista;	//Devuelve la PasswordList con todas las contraseñas cargadas
	}
	
}
