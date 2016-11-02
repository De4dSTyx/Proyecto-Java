package AdditionalFeatures;

import Main.*;

public class RandomPassword {
	private char[] password;
	private boolean empty;
	private int consCont;
	private int vocaCont;
	private char lastChar;
	private boolean thereIsVocal;
	
	private void addChar (char c) {
		if (empty) {
			password = new char[1];
			password[0] = c;
			empty = false;
		} else {
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
		lastChar = c;
		updateStats();
	}
	
	private void updateStats () {
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
	
	public String toString () {
		String ret = new String(password);
		return ret;
	}
	
	private int length (){
		if(!empty) return password.length;
		return 0;
	}
	
	public RandomPassword (){
		do{
			reset();
			generate();
		} while (!thereIsVocal);
	}
	
	private void reset () {
		password = new char[0];
		empty = true;
		consCont = 0;
		vocaCont = 0;
		lastChar = Codes.EMPTYCHAR;
		thereIsVocal = false;
	}
	
	private void generate () {
		boolean next;
		do {
			next = RandomManager.nextChance(length());
			if (next) addChar(genChar());//add
		} while (next);
	}
	
	private char genChar () {
		char c;
		do {
			c = RandomManager.newChar();
		} while (!checkChar(c));
		return c;
	}
	
	private boolean checkChar (char c) {
		if (c != 'o' && c != 'e') {
			if (c == lastChar) return false;
		}
		if (StringTools.isVocal(c)) {
			if (vocaCont >= 2) return false;
		} else {
			if (consCont >= 2) return false;
		}
		return true;
	}
}
