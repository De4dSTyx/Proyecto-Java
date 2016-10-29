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
			} else lista.askForPasswords();	//Si hay argumentos pero no hay input, pide las contraseñas
		} else {
			lista.askForPasswords();	//Si no hay argumentos, pide las contraseñas
		}
		//------------ \|/ Acà abajo irìa el còdigo de verdad
		System.out.println(log?"true":"false");
		System.out.println("Las contraseñas (" + lista.length() + ") son:");
		String str;
		boolean isPasswordCorrect = false;
		do {
			str = lista.nextPassword();
			if (str != Codes.EOL) {
				isPasswordCorrect = PasswordVerifier.verify(str);
				if (isPasswordCorrect) System.out.println("<" + str + "> es aceptado");
				else System.out.println("<" + str + "> no fue aceptado");
			}
		} while (str != Codes.EOL);
	}
}
