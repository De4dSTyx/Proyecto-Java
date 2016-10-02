package Main;

import AdditionalFeatures.*;

public class Proyecto {
	public static void main(String[] args) {
		PasswordList lista = new PasswordList(); //Se crea la variable
		try {	//Intenta cargar las contraseñas desde un archivo
			if(args[0]!=null) {
				FileLoader texto = new FileLoader (args[0]);
				lista = texto.load();
			} 
		}
		catch (ArrayIndexOutOfBoundsException aioobe) {	//Si da error, se las pide al usuario
			lista.askForPasswords();
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
