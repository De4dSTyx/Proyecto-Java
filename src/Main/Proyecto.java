package Main;

import AdditionalFeatures.*;

public class Proyecto {
	public static void main(String[] args) {
		PasswordList lista = new PasswordList(); //Se crea la variable
		String input = null;	//Localizacion de los archivos de entrada y salida
		boolean log = false;
		if (args.length > 0) {	//Si hay argumentos...
			for (int i = 0; i < args.length; i++) {	//Pasa por todos los argumentos
				if (args[i].equalsIgnoreCase("log")) log = true;
				else input = args[i];
			}
			if (input != null) {	//Si hay un input
				System.out.println("Cargando desde archivo...");
				lista = FileLoader.load(input);	//Carga el archivo "input"
			} else lista.askForPasswords();	//Si hay argumentos pero no hay input, pide las contrase�as
		} else {
			lista.askForPasswords();	//Si no hay argumentos, pide las contrase�as
		}
		//------------ \|/ Ac� abajo ir�a el c�digo de verdad
		System.out.println(log?"true":"false");
		System.out.println("Las contrase�as (" + lista.length() + ") son:");
		String str;
		do {
			str = lista.nextPassword();
			if (str != Codes.EOL) System.out.println(str);
		} while (str != Codes.EOL);
	}
}
