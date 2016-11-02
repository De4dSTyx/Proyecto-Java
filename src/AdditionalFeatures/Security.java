package AdditionalFeatures;

public class Security {
 
	public static int Check(String pass) {
		int SecurityLength = pass.length();
		if (SecurityLength <=0) {
			return 0; //0 es ERROR
		} else if (SecurityLength <=4) {
			return 1;
		} else if (SecurityLength <=8) {
			return 2;
		} else if (SecurityLength <=12) {
			return 3;
		} else if (SecurityLength <=16) {
			return 4;
		} else if(SecurityLength <=20) {
			return 5;
		}
		return 0;
	}

	public static void printCheckResult(String pass) {
		int checkResult = Check(pass);
		switch(checkResult) {
		case 1:
			System.out.println("Muy baja");
			break;
		case 2:
			System.out.println("Baja");
			break;
		case 3:
			System.out.println("Normal");
			break;
		case 4:
			System.out.println("Alta");
			break;
		case 5:
			System.out.println("Muy alta");
			break;
		default:
			System.out.println("Fuera de rango");
			break;
		}
	}
}
