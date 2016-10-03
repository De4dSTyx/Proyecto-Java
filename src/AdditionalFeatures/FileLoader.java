package AdditionalFeatures;

import Main.*;
import java.io.*;

public class FileLoader {	//Clase que se encarga de cargar contrase�as de archivos .txt
	
	static public PasswordList load(String path) {
		PasswordList lista = new PasswordList();
		try {	//Intenta ejecutar el c�digo, pero pueden ocurrir dos posibles errores
			FileReader archivo = new FileReader(path);	//Abro el archivo con el path proporcionado
			BufferedReader lector = new BufferedReader(archivo);	//Como un Scanner pero para archivos, uso el archivo de antes
			String linea = null;
			while ((linea = lector.readLine()) != null) {	//Basicamente, mientras sigan habiendo lineas de texto que leer se seguir� ejecutando
				linea = linea.trim();	//Elimina los espacios al principio y final de la linea
				String[] palabras = linea.split(" "); //Separa las lineas por espacios
				for(int i = 0; i < palabras.length; i++){
					lista.addPassword(palabras[i]);	//A�ade cada palabra a la lista de contrase�as
				}
			}
			archivo.close();
			lector.close();
		}
		catch (FileNotFoundException fnfe) {	//Primer error, no se encuentra el archivo. Con el catch evitamos que se detenga la ejecuci�n al recibir este error
			System.out.println("No se encontr� el archivo");
		}
		catch (IOException ioe) {	//Segundo error, un error relacionado con la entrada. Si no pon�a esto no andaba...
			System.out.println("El archivo no tiene un formato v�lido para el lector");
		}
		return lista;	//Devuelve la PasswordList con todas las contrase�as cargadas
	}
	
}
