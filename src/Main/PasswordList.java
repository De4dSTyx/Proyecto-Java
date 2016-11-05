package Main;

import java.util.Scanner;

public class PasswordList {	//Clase para almacenar una lista de contrase�as
	
	private String[] passwords;	//Array de Strings que contiene todas las contrase�as
	private boolean empty = true; //Boolean que indica si la lista est� vac�a
	final static public int max = 5000;	//M�ximo de contrase�as que puede almacenar una lista
	Scanner in = new Scanner(System.in);	//El Scanner
	
	public String addPassword (String str) {	//M�todo que a�ade un valor de tipo String al final de la lista de contrase�as "passwords"
		if(length() < max) {
			if (empty) {	//Si est� vac�o...
				passwords = new String[1];
				passwords[0] = str;	//Simplemente a�ade el primer String
				empty = false;	//Y deja de estar vac�o
			} else {
				String[] temp = new String[passwords.length + 1];	//Crea un nuevo array de Strings, con un valor mas que "passwords"
				for(int i = 0; i < passwords.length; i++){
					temp[i] = passwords[i];	//Copia todo los valores de "passwords" a "temp"
				}
				temp[passwords.length] = str; //A�ade el nuevo String en el �ltimo �ndice de "temp"
				passwords = new String[temp.length]; //Vuelve a crear "passwords", con el tama�o de "temp"
				for(int i = 0; i < temp.length; i++){
					passwords[i] = temp[i];	//Copia todo los valores de "temp" a "passwords"
				}
			}
			return Codes.OK;	//OK si todo sali� bien
		} else return Codes.ERROR;	//ERROR si se alcanz� el m�ximo
	}
	
	public void add (PasswordList list) {	//A�ade una lista a esta
		//Este m�todo qued� obsoleto por el m�todo add() de PasswordDatabase
		//Si la suma de las contrase�as existentes, mas las que se van a a�adir, sobrepasan el m�ximo (5000), se pierden contrase�as
		//Por lo que este m�todo no deber�a ser usado
		String str;
		do {
			str = list.nextPassword();
			if (str != Codes.EOL) addPassword(str);
		} while (str != Codes.EOL);
	}
	
	public String nextPassword () {	//Devuelve la primer contrase�a guardada
		if(!empty){//Si no esta vac�o... (si lo est� no hay nada que leer)
			if(passwords.length == 1) { //Si queda una contrase�a
				empty = true;	//Lo marca como vac�o (evita que se pueda leer varias veces el �ltimo valor, ya que no se borra)
				return passwords[0];	//Y devuelve la �ltima contrase�a
			} else {
				String[] temp = new String[passwords.length];	//Crea un nuevo array de Strings igual que "passwords"
				for(int i = 0; i < passwords.length; i++){
					temp[i] = passwords[i];	//Copia todo los valores de "passwords" a "temp"
				}
				passwords = new String[temp.length - 1]; //Vuelve a crear "passwords", con un valor menos que "temp"
				for(int i = 0; i < (temp.length - 1); i++){
					passwords[i] = temp[i+1];	//Copia todo los valores de "temp" a "passwords" movi�ndolos una posici�n hacia delante
				}
				return temp[0]; //Devuelve el primero de "temp", que era el primero de "passwords"
			}
		}
		return Codes.EOL;	//CODIGO EOL (End Of List)
	}
	
	public int length (){	//Devuelve el largo de la l�sta de contrase�as
		if(!empty) return passwords.length;
		return 0;
	}
	
	public PasswordList (){	//Este metodo se ejecuta cada vez que se declara una variable (un objeto) de tipo (de la clase) PasswordList
		
	}
	
	public String[] getStringArray () {	//Devuelve el array "passwords"
		return passwords;
	}
	
	public boolean isEmpty () {	//Devuelve el boolean "empty"
		return empty;
	}
	
	public PasswordList (PasswordList template) {	//Crea una lista, usando los valores de otra (template). B�sicamente, la copia
		passwords = template.getStringArray();
		empty = template.isEmpty();
	}
}
