package AdditionalFeatures;

public class Security {
 
	public static int Check(String pass) {	//Checkea la seguridad de una contraseña en base a su longitud, y retorna un número del 1 al 5
		int SecurityLength = pass.length();
		if (SecurityLength <=0) {
			return 0; //0 es ERROR
		} else if (SecurityLength <=4) {
			return 1;	//1 es que la seguridad es Muy baja
		} else if (SecurityLength <=8) {
			return 2;	//2 es que la seguridad es Baja
		} else if (SecurityLength <=12) {
			return 3;	//3 es que la seguridad es Normal
		} else if (SecurityLength <=16) {
			return 4;	//4 es que la seguridad es Alta
		} else if(SecurityLength <=20) {
			return 5;	//5 es que la seguridad es Muy alta
		}
		return 0;	//0 es ERROR
	}

	public static void printCheckResult(String pass) {	//Interpreta el número que retorna Check() y lo pasa a una String. Y lo imprime
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
