package AdditionalFeatures;

import Main.*;

public class TempPassword {
	private char[] password;
	private boolean empty = true;
	private int consCont = 0;
	private int vocaCont = 0;
	private char lastChar = Codes.EMPTYCHAR;
	private boolean thereIsVocal = false;
	
	public void addChar (char c) {
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
	}
	
	private void updateStats () {
		//CODIGO SENSUAL QUE TENHO QUE ESCRIBIR;;; EN ALGUN MOMENTO;;;
	}
	
	public String toString () {
		String ret = new String(password);
		return ret;
	}
	
	public int length (){
		if(!empty) return password.length;
		return 0;
	}
	
	public TempPassword (){
		
	}
}
