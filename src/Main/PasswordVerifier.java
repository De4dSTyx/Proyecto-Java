package Main;

import AdditionalFeatures.*;	//Con esto podes usar clases de AdditionalFeatures (StringTools puede servir)

public class PasswordVerifier {
	static public boolean verify (String str) {//Esto fue los que dijimos en clase, lo del método static bla bla bla...
		boolean passcorrect = true;		//Variable auxiliar booleana					
		char[] charArray = str.toCharArray(); //Creamos un char array y pasamos el string (str) a char array
		boolean vocalVerifier = false; // Creamos otra boolean específca para ver si la regla de vocales es cierta
		char lastChar = Codes.EMPTYCHAR;
		int contVocals = 0;
		int contCons = 0;
		if(str.length() > 20 || str.length() < 1 ||
			!StringTools.isInAlphabet(charArray) || !StringTools.isLowerCase(charArray)) passcorrect = false; //Utilizamos todo en opuesto para
		if (passcorrect){
			for(int i = 0; i < str.length() ; i++){ //Verificamos cada caracter de la contraseña y pasa lo siguiente
				if (!passcorrect) break; //Para que no siga desde un principio.
				vocalVerifier |= StringTools.isVocal(charArray[i]);  //Si vocalVerifier es igual...
				if(StringTools.isVocal(charArray[i])){ //Contador de Vocales
					contCons = 0;
					contVocals++;
				} else {  //Contador de Consonantes
					contVocals = 0;
					contCons++;
				}
				if(contVocals > 2 || contCons > 2) passcorrect = false; //Si el contador de vocales o el contador de consonantes es mayor a dos...
				if (lastChar != Codes.EMPTYCHAR) { //Si lastChar no tiene un valor de 0 sigue 
					if (lastChar != 'o' && lastChar != 'e') { //Verifica si el caracter anterior no es igual a o y también verifica si no es igual a e
						if (lastChar == charArray[i]) passcorrect = false; //Si el caracter que está siendo verificado es igual al anterior...
					}
				}
				lastChar = charArray[i]; //Después de todo eso si logró pasar, efectivamente lastChar ES igual a charArray[i]
			}
			passcorrect &= vocalVerifier;
		}	
		return passcorrect;	//Cambiá true por lo que sea
	}
}
