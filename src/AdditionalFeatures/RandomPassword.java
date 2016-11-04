package AdditionalFeatures;

import Main.*;

public class RandomPassword {	//Clase encargada de generar contrase�as aleatorias, las genera char por char para asegurarse que cumple las condiciones especificadas
	private char[] password;	//Array en el que se guarda la contrase�a a medida que se crea
	private boolean empty;	//Almacena true cuando password est� vacio, si no es false
	private int consCont;	//Contador de consonantes
	private int vocaCont;	//Contador de vocales
	private char lastChar;	//Almacena el �ltimo caracter generado
	private boolean thereIsVocal;	//Almacena si la contrase�a generada tiene vocal o no
	
	private void addChar (char c) {	//A�ade un char al final del array password
		if (empty) {	//Si est� vac�o...
			password = new char[1];	//Crea un nuevo array (de un char)
			password[0] = c;	//A�ade el char
			empty = false;	//Deja de estar vacio
		} else {	//Si NO est� vac�o...
			/* Mediante el uso de una variable temporal
			 * se guarda la contrase�a actual en temp
			 * se alarga la contrase�a en 1
			 * se recupera los valores de temp
			 * y se a�ade el char al final
			 */
			char[] temp = new char[password.length + 1];
			for(int i = 0; i < password.length; i++){
				temp[i] = password[i];
			}
			temp[password.length] = c;
			password = new char[temp.length];
			for(int i = 0; i < temp.length; i++){
				password[i] = temp[i];
			}
		}
		lastChar = c;	//Guarda el �ltimo caracter
		updateStats();	//Actualiza los contadores
	}
	
	private void updateStats () {	//Actualiza los contadores
		if (StringTools.isVocal(lastChar)) {
			vocaCont++;
			consCont =  0;
			thereIsVocal = true;
		}
		else {
			vocaCont = 0;
			consCont++;
		}
	}
	
	public String toString () {	//Devuelve la contrase�a generada, en forma de String
		String ret = new String(password);
		return ret;
	}
	
	private int length (){	//Devuelve la longitud actual de la contrase�a
		if(!empty) return password.length;
		return 0;
	}
	
	public RandomPassword (){	//Clase encargara de generar la contrase�a, se repite hasta que est� todo correcto
		do{
			reset();	//La resetea para asegurarse de que est� vacia antes de generarla
			generate();	//Genera una contrase�a
		} while (!thereIsVocal);	//Checkea si tiene una vocal, si no se vuelva a generar
	}
	
	private void reset () {	//Resetea la contrase�a generada
		password = new char[0];
		empty = true;
		consCont = 0;
		vocaCont = 0;
		lastChar = Codes.EMPTYCHAR;
		thereIsVocal = false;
	}
	
	private void generate () {	//Encargado de generar UNA contrase�a
		boolean next;
		do {
			next = RandomManager.nextChance(length());	//Calcula la posibilidad de que se a�ada una letra m�s con RandomManager
			if (next) addChar(genChar());	//Si existe la posibilidad, a�ade una letra ( addChar() ), que acaba de generar con genChar()
		} while (next);	//Cuando ya no sea posible agregar mas letras, se sale del bucle
	}
	
	private char genChar () {	//Genera un carater con la clase RandomManager y checkea si cumple con las condiciones necesarias, si no genera otro
		char c;
		do {
			c = RandomManager.newChar();
		} while (!checkChar(c));
		return c;
	}
	
	private boolean checkChar (char c) {	//Checkea se el char...
		if (c != 'o' && c != 'e') {
			if (c == lastChar) return false;	//...es distinto del �ltimo a�adido, ...
		}
		if (StringTools.isVocal(c)) {
			if (vocaCont >= 2) return false;	//...que no hay tres vocales seguidas o ...
		} else {
			if (consCont >= 2) return false;	//...tres consonantes seguidas.
		}
		return true;	//Si pasa todas las pruebas retorna true
	}
}
