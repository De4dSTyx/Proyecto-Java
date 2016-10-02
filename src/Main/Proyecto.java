package Main;

import AdditionalFeatures.*;

public class Proyecto {
	public static void main(String[] args) {
		PasswordList lista = new PasswordList(); //Se crea la variable
		try {	//Intenta cargar las contrase�as desde un archivo
			if(args[0]!=null) {
				FileLoader texto = new FileLoader (args[0]);
				lista = texto.load();
			} 
		}
		catch (ArrayIndexOutOfBoundsException aioobe) {	//Si da error, se las pide al usuario
			lista.askForPasswords();
		}
		//------------ \|/ Ac� abajo ir�a el c�digo de verdad
		System.out.println("Las contrase�as (" + lista.length() + ") son:");
		String str;
		do {
			str = lista.nextPassword();
			if (str != Codes.EOL) System.out.println(str);
		} while (str != Codes.EOL);
	}
}
