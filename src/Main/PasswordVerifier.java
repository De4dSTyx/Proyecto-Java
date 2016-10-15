package Main;

import AdditionalFeatures.*;	//Con esto podes usar clases de AdditionalFeatures (StringTools puede servir)

public class PasswordVerifier {
	static public boolean verify (String str) {//Esto fue los que dijimos en clase, lo del método static bla bla bla...
		boolean passcorrect = true;							
		char[] charArray = str.toCharArray();
		boolean vocalVerifier = false;
		char lastChar;
		int contVocals = 0;
		int contCons = 0;
		if(str.length() > 20 || str.length() < 1 ||
				!StringTools.isInAlphabet(charArray) || !StringTools.isLowerCase(charArray)) passcorrect = false;
		if (passcorrect){
			for(int i = 0; i < str.length() ; i++){
				if (!passcorrect) break;
				vocalVerifier |= StringTools.isVocal(charArray[i]);
				if(StringTools.isVocal(charArray[i])){
					contCons = 0;
					contVocals++;
				} else {
					contVocals = 0;
					contCons++;
				}
				if(contVocals > 2 || contCons > 2) passcorrect = false;
				//Acá faltaría el lastChar para que checkee las dos ultimas letras.
			}
		}	
		return passcorrect;	//Cambiá true por lo que sea
	}
}
