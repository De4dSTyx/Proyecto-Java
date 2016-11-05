package Main;

import AdditionalFeatures.*;	//Import nos permite usar otras clases del otro package, en este caso utilizaremos StringTools

public class PasswordVerifier { //
	static public boolean verify (String str) {//
		boolean passcorrect = true; //Variable auxiliar booleana, que indica si la contraseña está bien					
		char[] charArray = str.toCharArray(); //Creamos un char array y pasamos el string (str) a char array
		boolean vocalVerifier = false; // Creamos otra variable booleana específca para ver si la regla de vocales es cierta
		char lastChar = Codes.EMPTYCHAR; //Le damos un valor a la variable lastChar que equivale a '0', usando la constante Codes.EMPTYCHAR
		int contVocals = 0;  //Declaramos valores para los contadores.
		int contCons = 0;
		if(str.length() > 20 || str.length() < 1 ||
			!StringTools.isInAlphabet(charArray) || !StringTools.isLowerCase(charArray)) passcorrect = false; //Si la contraseña no se encuentra en el rango 1 - 20, o tiene caracteres que no estan en el alfabeto, o tiene caracteres en minúscula, passcorrect pasa a ser false porque por lo menos una regla no se cumple
		if (passcorrect){ //Si con el if anterior passcorrect es false, no hay necesidad de verificar las otras reglas porque la contraseña ya esta mal
			for(int i = 0; i < str.length() ; i++){ //Verificamos cada caracter de la contraseña
				if (!passcorrect) break; //Para que no siga desde un principio si ya sabemos que esta mal.
				vocalVerifier |= StringTools.isVocal(charArray[i]);  //vocalVerifier ese igual a vocalVerifier OR ... bueno, lo que dice ahí
				if(StringTools.isVocal(charArray[i])){ //Si charArray[i] es vocal, el contador de vocales suma 1
					contCons = 0;
					contVocals++;
				} else {  //Si no, entonces el contador de consonantes suma 1
					contVocals = 0;
					contCons++;
				}
				if(contVocals > 2 || contCons > 2) passcorrect = false; //Si el contador de vocales es mayor a dos o el contador de consonantes mayor a dos entonces passcorrect pasa a ser false porque una regla no se cumple
				if (lastChar != Codes.EMPTYCHAR) { //Si lastChar no tiene un valor de '0' (si no es el primer char del array)...
					if (lastChar != 'o' && lastChar != 'e') { //Verifica si el caracter anterior no es igual a 'o' y también verifica si no es igual a 'e' ya que esta es una excepción de la regla 
						if (lastChar == charArray[i]) passcorrect = false; //Si el caracter que está siendo verificado es igual al anterior, entonces passcorect pasa a ser false.
					}
				}
				lastChar = charArray[i]; //Finalmente, lastChar pasa a ser charArray[i], para la próxima la próxima iteración del bucle
			}
			passcorrect &= vocalVerifier; //Asignamos el valor de passcorrect como passcorrect AND vocalVerifier, de esta forma si vocalVerifier era false, al terminar el bucle for, passcorrect pasa a ser false porque una regla no se cumple
		}	
		return passcorrect;	//Devuelve passcorrect, si pasó todas las pruebas debería ser true
	}
}
