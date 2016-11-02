package Main;

import java.util.Scanner;

public class PasswordList {	//Clase para almacenar la lista de contraseñas
	
	private String[] passwords;	//Array de Strings que contiene todas las contraseñas
	private boolean empty = true; //Boolean que indica si la lista está vacía
	Scanner in = new Scanner(System.in);	//El Scanner
	
	public void addPassword (String str) {	//Método que añade un valor de tipo String al final de la lista de contraseñas "passwords"
		if (empty) {	//Si está vacío...
			passwords = new String[1];
			passwords[0] = str;	//Simplemente añade el primer String
			empty = false;	//Y deja de estar vacío
		} else {
			String[] temp = new String[passwords.length + 1];	//Crea un nuevo array de Strings, con un valor mas que "passwords"
			for(int i = 0; i < passwords.length; i++){
				temp[i] = passwords[i];	//Copia todo los valores de "passwords" a "temp"
			}
			temp[passwords.length] = str; //Añade el nuevo String en el último índice de "temp"
			passwords = new String[temp.length]; //Vuelve a crear "passwords", con el tamaño de "temp"
			for(int i = 0; i < temp.length; i++){
				passwords[i] = temp[i];	//Copia todo los valores de "temp" a "passwords"
			}
		}
	}
	
	public void add (PasswordList list) {
		String str;
		do {
			str = list.nextPassword();
			if (str != Codes.EOL) addPassword(str);
		} while (str != Codes.EOL);
	}
	
	public String nextPassword () {
		if(!empty){//Si no esta vacío... (si lo está no hay nada que leer)
			if(passwords.length == 1) { //Si queda una contraseña
				empty = true;	//Lo marca como vacío (evita que se pueda leer varias veces el último valor, ya que no se borra)
				return passwords[0];	//Y devuelve la última contraseña
			} else {
				String[] temp = new String[passwords.length];	//Crea un nuevo array de Strings igual que "passwords"
				for(int i = 0; i < passwords.length; i++){
					temp[i] = passwords[i];	//Copia todo los valores de "passwords" a "temp"
				}
				passwords = new String[temp.length - 1]; //Vuelve a crear "passwords", con un valor menos que "temp"
				for(int i = 0; i < (temp.length - 1); i++){
					passwords[i] = temp[i+1];	//Copia todo los valores de "temp" a "passwords" moviéndolos una posición hacia delante
				}
				return temp[0]; //Devuelve el primero de "temp", que era el primero de "passwords"
			}
		}
		return Codes.EOL;	//CODIGO EOL (End Of List)
	}
	
	public void askForPasswords (){
		System.out.println("Ingrese la lista de contraseñas. Una por línea. Ingrese 'fin' para finalizar\n");
		String str;
		do {
			System.out.print("> ");
			str = in.next();	//Guarda el input del usuario
			if (!str.equals("fin")) {	//Si no es "fin"...
				addPassword(str); //La añade a la lista
				if(empty) empty = false;
			}
		} while (!str.equals("fin"));
	}
	
	public int length (){
		if(!empty) return passwords.length;
		return 0;
	}
	
	public PasswordList (){	//Este metodo se ejecuta cada vez que se declara una variable (un objeto) de tipo (de la clase) PasswordList
		
	}
	
	public String[] getStringArray () {
		return passwords;
	}
	
	public boolean isEmpty () {
		return empty;
	}
	
	public PasswordList (PasswordList template) {
		passwords = template.getStringArray();
		empty = template.isEmpty();
	}
}
