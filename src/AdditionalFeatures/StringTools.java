package AdditionalFeatures;

public class StringTools {
	static public boolean isInAlphabet (char c) {	//Retorna true si el caracter esta en el alfabeto
		if((c>=65)&&(c<=90)||(c>=97)&&(c<=122)) return true;
		return false;
	}
	static public boolean isUpperCase (char c) {	//Retorna true si el caracter esta en mayúscula
		if((c>=65)&&(c<=90)) return true;
		return false;
	}
	static public boolean isLowerCase (char c) {	//Retorna true si el caracter esta en minúscula
		if((c>=97)&&(c<=122)) return true;
		return false;
	}
	static public char upperCase (char c) {	//Si está en minúscula, la pasa a mayúscula
		if(isLowerCase (c)) return (char) (c - 32);
		return c;
	}
	static public char lowerCase (char c) {	//Si está en mayúsucla, la pasa a minúscula
		if(isUpperCase (c)) return (char) (c + 32);
		return c;
	}
}
