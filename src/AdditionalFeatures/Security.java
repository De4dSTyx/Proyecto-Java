package AdditionaFeatures;
import java.util.Scanner;


public class Security {
 
	public static int Check(String pass) {
		int SecurityLength = pass.length();
		if (SecurityLength <=0)
		{
			return 0; //0 es ERROR
		}
		else if (SecurityLength <=4)
		{
			return 1;
		}
		else if (SecurityLength <=8)
		{
			return 2;
		}
		else if (SecurityLength <=12)
		{
			return 3;
		}
		else if (SecurityLength <=16)
		{
			return 4;
		}
		else if(SecurityLength <=20)
		{
			return 5;
		}
	}

}
