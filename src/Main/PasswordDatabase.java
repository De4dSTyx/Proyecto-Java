package Main;

import java.util.Scanner;

public class PasswordDatabase {	//Base de datos de contrase�as
	
	/*Una explicaci�n de la l�gica del programa:
	 * Esta clase se encarga de almacernar y utilizar las contrase�as
	 * Para mejorar el rendimiento las contrase�as se almacenan en "listas" de 5000
	 * Con ese fin se creo la clase PasswordList
	 */
	
	private PasswordList[] listas;	//Array de listas, cada una de 5000 contrase�as
	private boolean empty = true;	//Almacena si el array "listas" esta vac�o o no
	Scanner in = new Scanner(System.in);
	
	public void addPassword(String str) {	//A�ade una contrase�a al final del array
		if (empty) {	//Si esta vac�o
			listas = new PasswordList[1];	//Crea un array de una lista
			listas[0] = new PasswordList();	//Crea la lista
			listas[0].addPassword(str);	//A�ade la contrase�a
			empty = false;	//Y deja de estar vac�o
		} else {	//Si no
			String ret = listas[arrayLength() - 1].addPassword(str);	//Intenta a�adir la contrase�a en la �ltima lista
			if (ret == Codes.ERROR) {	//Si la �ltima lista est� llena
				PasswordList[] temp = new PasswordList[arrayLength() + 1];
				for(int i = 0; i < arrayLength(); i++) {
					temp[i] = listas[i];
				}
				temp[arrayLength()] = new PasswordList();	//Se crea una nueva
				temp[arrayLength()].addPassword(str);	//Y se a�ade la contrase�a
				listas = new PasswordList[temp.length];
				for(int i = 0; i < temp.length; i++) {
					listas[i] = temp[i];
				}
			}
		}
	}
	
	public void add(PasswordList list) {	//A�ade una lista de contrase�as a la base de datos
		//A�ade las contrase�as una por una
		String str;
		int length = list.length();
		for(int i = 0; i < length; i++){
			str = list.nextPassword();
			addPassword(str);
		}
	}
	
	public void add(PasswordDatabase db)  {	//Este m�todo a�ade una base de datos existente, a esta
		//Para esto se toman las distintas listas dentro de la variable "listas" de "db"
		//Y se a�aden a esta Database con add(PasswordList list)
		PasswordList list;
		for(int i = 0, l = db.arrayLength(); i < l; i++){
			list = db.getListArray ()[i];
			add(list);
		}
	}
	
	public String nextPassword() {	//Devuelve la primer contrase�a almacenada
		if(!empty) {
			String password = listas[0].nextPassword();	//Consigue la primer contrase�a de la primer lista
			if (password == Codes.EOL) {	//Si la primer lista se queda vac�a
				deleteFirstList();	//La borra
				password = nextPassword();	//Y prueba con la siguiente
			}
			return password;
		}
		return Codes.EOL;
	}
	
	private void deleteFirstList() {	//Mueve todas las listas dentro del array, una posici�n hacia adelante
		if (!isEmpty()) {
			int newLength = arrayLength() - 1;
			if(newLength > 0) {
				PasswordList[] temp = new PasswordList[newLength];	//Variable temporal
				for(int i = 0; i < newLength; i++) {
					temp[i] = listas[i+1];	//Se copian todos los valores movidos una posici�n, por lo que se pierde el primero
				}
				listas = new PasswordList[temp.length];
				for(int i = 0; i < temp.length; i++) {
					listas[i] = temp[i];	//Se recuperan los valores de "temp"
				}
			} else empty = true;
		}
	}
	
	public void askForPasswords (){	//M�todo encargado de tomar los valores ingresados por el usuario mediante la consola
		System.out.println("Ingrese la lista de contrase�as. Una por l�nea. Ingrese 'fin' para finalizar\n");
		String str;
		do {
			System.out.print("> ");
			str = in.next();	//Guarda el input del usuario
			if (!str.equals("fin")) {	//Si no es "fin"...
				addPassword(str); //La a�ade a la lista
			}
		} while (!str.equals("fin"));
	}
	
	private int arrayLength () {	//Devuelve la contidad de listas dentro del array
		if(!isEmpty ()) {
			return listas.length;
		}
		return 0;
	}
	
	public int length () {	//Devuelve la contidad total de contrase�as
		if (!isEmpty ()) {
			int suma = 0;
			for (int i = 0, l = arrayLength(); i < l; i++) {
				suma += listas[i].length();	//Suma el largo de todas las listas
			}
			return suma;
		}
		return 0;
	}
	
	public PasswordList[] getListArray () {	//Devuelve el array de listas "listas"
		PasswordList[] temp = new PasswordList[arrayLength()];
		for (int i = 0; i < temp.length; i ++){
			temp[i] = new PasswordList(listas[i]);
		}
		return temp;
	}
	
	public boolean isEmpty () {	//Devuelve "empty"
		return empty;
	}
	
	public PasswordDatabase () {
		
	}
	
	public PasswordDatabase (PasswordDatabase db) {	//Copia otra base de datos
		listas = db.getListArray();
		empty = db.isEmpty();
	}
}
