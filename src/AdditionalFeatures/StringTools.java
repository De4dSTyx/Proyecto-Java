package AdditionalFeatures;

public class StringTools {
	static public boolean isInAlphabet (char c) {	//Retorna true si el caracter esta en el alfabeto
		if((c>=65)&&(c<=90)||(c>=97)&&(c<=122)) return true;
		return false;
	}
	static public boolean isInAlphabet (char[] ca) {	//Lo de arriba pero para arrays de char
		boolean b = true;	//b de boolean
		for (int i = 0; i < ca.length; i++) {
			b &= isInAlphabet(ca[i]);
		}
		return b;	//Solo va a ser true si todos son true
	}
	static public boolean isInAlphabet (String str) {	//Lo de arriba pero para String
		boolean b = true;	//b de boolean
		for (int i = 0; i < str.length(); i++) {
			b &= isInAlphabet(str.charAt(i));
		}
		return b;	//Solo va a ser true si todos son true
	}	
	static public boolean isUpperCase (char c) {	//Retorna true si el caracter esta en mayúscula
		if((c>=65)&&(c<=90)) return true;
		return false;
	}
	static public boolean isLowerCase (char c) {	//Retorna true si el caracter esta en minúscula
		if((c>=97)&&(c<=122)) return true;
		return false;
	}
	static public boolean isLowerCase (char[] ca) {	//Retorna true si todo el array de caracteres esta en minúscula
		boolean b = true;
		for (int i = 0; i < ca.length; i++) {
			b &= isLowerCase(ca[i]);
		}
		return b;
	}
	static public boolean isVocal (char c) {	//Retorna true si el caracter es vocal
		if(c == 'a' || c == 'e' || c == 'i' ||
		   c == 'o' || c == 'u') return true;
		return false;	
	}
	static public char upperCase (char c) {	//Si estÃ¡ en minúscula, la pasa a mayúscula
		if(isLowerCase (c)) return (char) (c - 32);
		return c;
	}
	static public char lowerCase (char c) {	//Si estÃ¡ en mayúsucla, la pasa a minúscula
		if(isUpperCase (c)) return (char) (c + 32);
		return c;
	}
	static public char[] toStringArray (String str) {	//Convierte un String a un array
		char[] charArray = new char[str.length()];
		for (int i = 0; i < str.length(); i++) {
			charArray[i] = str.charAt(i);
		}
		return charArray;
	}
}
