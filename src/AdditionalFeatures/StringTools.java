package AdditionalFeatures;

public class StringTools {
	static public boolean isInAlphabet (char c) {	//Retorna true si el caracter esta en el alfabeto
		if((c>=65)&&(c<=90)||(c>=97)&&(c<=122)) return true;
		return false;
	}
	static public boolean isUpperCase (char c) {	//Retorna true si el caracter esta en may�scula
		if((c>=65)&&(c<=90)) return true;
		return false;
	}
	static public boolean isLowerCase (char c) {	//Retorna true si el caracter esta en min�scula
		if((c>=97)&&(c<=122)) return true;
		return false;
	}
	static public char upperCase (char c) {	//Si est� en min�scula, la pasa a may�scula
		if(isLowerCase (c)) return (char) (c - 32);
		return c;
	}
	static public char lowerCase (char c) {	//Si est� en may�sucla, la pasa a min�scula
		if(isUpperCase (c)) return (char) (c + 32);
		return c;
	}
}
