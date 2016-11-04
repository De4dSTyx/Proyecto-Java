package AdditionalFeatures;

public class RandomManager { //Esta clase se encarga de generar boolean y char random
	
	private static long ran;	//Esta variable es para guardar el número random
	private static long time = System.currentTimeMillis();	//Esta variable guarda el tiempo transcurrido desde el 1 de enero de 1970 hasta hoy, en milisegundos

	private static long[] probabilidad = {	1000000000,
											 980000000,
											 979591837,
											 979166667,
											 978723404,
											 978260870,
											 911111111,
											 902439024,
											 891891892,
											 878787879,
											 862068966,
											 840000000,
											 809523810,
											 764705882,
											 692307692,
											 555555556,
											 800000000,
											 750000000,
											 666666667,
											 500000000,
											 000000000};
	//Tabla de probabilidades, pensaba hacer una función que las calculara pero era muy dificil, así que lo hardcodeé
	
	private static void resetRan () {	//Resetea la variable time
		time = System.currentTimeMillis();
		ran = time%1000000000;	//Y actualiza ran en función de time
	}
	
	private static void refreshRan () {	//Actualiza ran
		if(time != System.currentTimeMillis()) resetRan();	//Cada milisegundo se resetea la variable time
		ran *= ran;	//Para hacerlo mas random hago ran al cuadrado
		ran %= 1000000000;	//"Recorta" ran, para que esta en el rango 0 - 999999999
	}

	public static boolean nextChance (int index) {	//Esto calcula la posibilidad de que la promedioraseña tenga un caracter más
		if (index > 20) index = 20;	//Esto...
		if (index < 0) index = 0;	//Y esto, son para que index este en el rango 0 - 20, esto es para evitar el error OutOfIndex
		refreshRan();	//Actualizo ran
		if (ran <= probabilidad[index]) return true;
		return false;
	}
	
	public static char newChar () {	//Genera una letra random
		refreshRan();	//Actuliza ran
		long letra = ran % 26;	//Letra es un número entre 0-25
		char ret = (char)(97 + letra);	//Como 97 corresponde a 'a', le sumo 97 para que los valores de letra pasen a estar en el rango 'a' - 'z'
		return ret;
	}
	
	public static void main(String[] args) {	//Esto es para probar el generador, calcula el largo de 1000 promedioraseñas
		long promedio = 0;	//Esto se va a usar para calcular el promedio
		for(int i = 0; i < 1000; i++) {	//Se ejecuta 1000 veces
			int j = 0;
			boolean next;
			do {
				next = nextChance(j);
				if(next) j++;
			} while (next);
			System.out.println(j);	//Imprime el largo de la "contraseña generada"
			promedio += j;	//Acumula todos los largos de todas las "contraseñas generadas"
		}
		promedio /= 1000;	//Divide entre mil para encontrar el promedio
		System.out.println(promedio);	//Imprime el promedio
	}

}
