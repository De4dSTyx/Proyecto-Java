package Main;

import java.util.Scanner;

public class PasswordDatabase {
	private PasswordList[] listas;
	private boolean empty = true;
	Scanner in = new Scanner(System.in);
	
	public void addPassword(String str) {
		if (empty) {
			listas = new PasswordList[1];
			listas[0] = new PasswordList();
			listas[0].addPassword(str);
			empty = false;
		} else {
			String ret = listas[arrayLength() - 1].addPassword(str);
			if (ret == Codes.ERROR) {
				PasswordList[] temp = new PasswordList[arrayLength() + 1];
				for(int i = 0; i < arrayLength(); i++) {
					temp[i] = listas[i];
				}
				temp[arrayLength()] = new PasswordList();
				temp[arrayLength()].addPassword(str);
				listas = new PasswordList[temp.length];
				for(int i = 0; i < temp.length; i++) {
					listas[i] = temp[i];
				}
			}
		}
	}
	
	public void add(PasswordList list) {
		String str;
		int length = list.length();
		for(int i = 0; i < length; i++){
			str = list.nextPassword();
			addPassword(str);
		}
	}
	
	public void add(PasswordDatabase db)  {
		PasswordList list;
		for(int i = 0, l = db.arrayLength(); i < l; i++){
			list = db.getListArray ()[i];
			add(list);
		}
	}
	
	public String nextPassword() {
		if(!empty) {
			String password = listas[arrayLength() - 1].nextPassword();
			if (password == Codes.EOL) {
				deleteLastList();
				password = nextPassword();
			}
			return password;
		}
		return Codes.EOL;
	}
	
	private void deleteLastList() {
		if (!isEmpty()) {
			int newLength = arrayLength() - 1;
			if(newLength > 0) {
				PasswordList[] temp = new PasswordList[newLength];
				for(int i = 0; i < newLength; i++) {
					temp[i] = listas[i];
				}
				listas = new PasswordList[temp.length];
				for(int i = 0; i < temp.length; i++) {
					listas[i] = temp[i];
				}
			} else empty = true;
		}
	}
	
	public void askForPasswords (){
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
	
	private int arrayLength () {
		if(!isEmpty ()) {
			return listas.length;
		}
		return 0;
	}
	
	public int length () {
		if (!isEmpty ()) {
			int suma = 0;
			for (int i = 0, l = arrayLength(); i < l; i++) {
				suma += listas[i].length();
			}
			return suma;
		}
		return 0;
	}
	
	public PasswordList[] getListArray () {
		PasswordList[] temp = new PasswordList[arrayLength()];
		for (int i = 0; i < temp.length; i ++){
			temp[i] = new PasswordList(listas[i]);
		}
		return temp;
	}
	
	public boolean isEmpty () {
		return empty;
	}
	
	public PasswordDatabase () {
		
	}
	
	public PasswordDatabase (PasswordDatabase db) {
		listas = db.getListArray();
		empty = db.isEmpty();
	}
}
