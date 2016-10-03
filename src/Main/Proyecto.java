package Main;

import AdditionalFeatures.*;

public class Proyecto {
	public static void main(String[] args) {
		PasswordList lista = new PasswordList(); //Se crea la variable
		String input = null, output = null;	//Localizacion de los archivos de entrada y salida
		if (args.length > 0) {	//Si hay argumentos...
			for (int i = 0; i < args.length; i++) {	//Pasa por todos los argumentos
				if (args[i].substring(0, 1).equals("<")) input = args[i].substring(1);	//Agarro el primer caracter y lo comparo con "<", si empieza por "<" lo uso como input
				if (args[i].substring(0, 1).equals(">")) output = args[i].substring(1);	//Agarro el primer caracter y lo comparo con ">", si empieza por ">" lo uso como output
			}
			if (input != null) {	//Si hay un input
				System.out.println("Cargando desde archivo...");
				lista = FileLoader.load(input);	//Carga el archivo "input"
			} else lista.askForPasswords();	//Si hay argumentos pero no hay input, pide las contraseñas
		} else {
			lista.askForPasswords();	//Si no hay argumentos, pide las contraseñas
		}
		//------------ \|/ Acá abajo iría el código de verdad
		System.out.println("Las contraseñas (" + lista.length() + ") son:");
		String str;
		do {
			str = lista.nextPassword();
			if (str != Codes.EOL) System.out.println(str);
		} while (str != Codes.EOL);
	}
}
