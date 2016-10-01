package Main;

public class PasswordList {	//Clase para almacenar la lista de contrase�as
	
	private String[] passwords;	//Array de Strings que contiene todas las contrase�as
	private boolean empty = true; //Boolean que indica si la lista est� vac�a
	
	public void addPassword (String str) {	//M�todo que a�ade un valor de tipo String al final de la lista de contrase�as "passwords"
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
	}
	
	public String nextPassword () {
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
				for(int i = 0; i < temp.length; i++){
					passwords[i] = temp[i+1];	//Copia todo los valores de "temp" a "passwords" movi�ndolos una posici�n hacia delante
				}
				return temp[0]; //Devuelve el primero de "temp", que era el primero de "passwords"
			}
		}
		return new String(Codes.ERROR); //CODIGO ERROR
	}
}
