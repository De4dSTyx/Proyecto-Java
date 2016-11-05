package Main;

import java.util.Scanner;

public class PasswordDatabase {	//Base de datos de contraseñas
	
	/*Una explicación de la lógica del programa:
	 * Esta clase se encarga de almacernar y utilizar las contraseñas
	 * Para mejorar el rendimiento las contraseñas se almacenan en "listas" de 5000
	 * Con ese fin se creo la clase PasswordList
	 */
	
	private PasswordList[] listas;	//Array de listas, cada una de 5000 contraseñas
	private boolean empty = true;	//Almacena si el array "listas" esta vacío o no
	Scanner in = new Scanner(System.in);
	
	public void addPassword(String str) {	//Añade una contraseña al final del array
		if (empty) {	//Si esta vacío
			listas = new PasswordList[1];	//Crea un array de una lista
			listas[0] = new PasswordList();	//Crea la lista
			listas[0].addPassword(str);	//Añade la contraseña
			empty = false;	//Y deja de estar vacío
		} else {	//Si no
			String ret = listas[arrayLength() - 1].addPassword(str);	//Intenta añadir la contraseña en la última lista
			if (ret == Codes.ERROR) {	//Si la última lista está llena
				PasswordList[] temp = new PasswordList[arrayLength() + 1];
				for(int i = 0; i < arrayLength(); i++) {
					temp[i] = listas[i];
				}
				temp[arrayLength()] = new PasswordList();	//Se crea una nueva
				temp[arrayLength()].addPassword(str);	//Y se añade la contraseña
				listas = new PasswordList[temp.length];
				for(int i = 0; i < temp.length; i++) {
					listas[i] = temp[i];
				}
			}
		}
	}
	
	public void add(PasswordList list) {	//Añade una lista de contraseñas a la base de datos
		//Añade las contraseñas una por una
		String str;
		int length = list.length();
		for(int i = 0; i < length; i++){
			str = list.nextPassword();
			addPassword(str);
		}
	}
	
	public void add(PasswordDatabase db)  {	//Este método añade una base de datos existente, a esta
		//Para esto se toman las distintas listas dentro de la variable "listas" de "db"
		//Y se añaden a esta Database con add(PasswordList list)
		PasswordList list;
		for(int i = 0, l = db.arrayLength(); i < l; i++){
			list = db.getListArray ()[i];
			add(list);
		}
	}
	
	public String nextPassword() {	//Devuelve la primer contraseña almacenada
		if(!empty) {
			String password = listas[0].nextPassword();	//Consigue la primer contraseña de la primer lista
			if (password == Codes.EOL) {	//Si la primer lista se queda vacía
				deleteFirstList();	//La borra
				password = nextPassword();	//Y prueba con la siguiente
			}
			return password;
		}
		return Codes.EOL;
	}
	
	private void deleteFirstList() {	//Mueve todas las listas dentro del array, una posición hacia adelante
		if (!isEmpty()) {
			int newLength = arrayLength() - 1;
			if(newLength > 0) {
				PasswordList[] temp = new PasswordList[newLength];	//Variable temporal
				for(int i = 0; i < newLength; i++) {
					temp[i] = listas[i+1];	//Se copian todos los valores movidos una posición, por lo que se pierde el primero
				}
				listas = new PasswordList[temp.length];
				for(int i = 0; i < temp.length; i++) {
					listas[i] = temp[i];	//Se recuperan los valores de "temp"
				}
			} else empty = true;
		}
	}
	
	public void askForPasswords (){	//Método encargado de tomar los valores ingresados por el usuario mediante la consola
		System.out.println("Ingrese la lista de contraseñas. Una por línea. Ingrese 'fin' para finalizar\n");
		String str;
		do {
			System.out.print("> ");
			str = in.next();	//Guarda el input del usuario
			if (!str.equals("fin")) {	//Si no es "fin"...
				addPassword(str); //La añade a la lista
			}
		} while (!str.equals("fin"));
	}
	
	private int arrayLength () {	//Devuelve la contidad de listas dentro del array
		if(!isEmpty ()) {
			return listas.length;
		}
		return 0;
	}
	
	public int length () {	//Devuelve la contidad total de contraseñas
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
