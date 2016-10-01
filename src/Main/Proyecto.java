package Main;

public class Proyecto {
	public static void main(String[] args) {
		PasswordList lista = new PasswordList(); //Se crea la variable, y debería pedir los valores para la lista
		System.out.println("Las contraseñas (" + lista.length() + ") son:");
		String str;
		do {
			str = lista.nextPassword();
			if (str != Codes.EOL) System.out.println(str);
		} while (str != Codes.EOL);
	}
}
