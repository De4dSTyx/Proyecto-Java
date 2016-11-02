package AdditionalFeatures;

public class RandomManager {
	private static long ran = System.currentTimeMillis()%1000000000;

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
	
	private static void refreshRan () {
		ran *= ran;
		ran %= 1000000000;
	}

	public static boolean nextChance (int index) {
		refreshRan();
		if (ran <= probabilidad[index]) return true;
		return false;
	}
	
	public static char newChar () {
		refreshRan();
		long letra = ran % 26;
		char ret = (char)(97 + letra);
		return ret;
	}
	
	public static void main(String[] args) {
		//Esto es para probar el generador
		for(int i = 0; i < 1000; i++) {
			int j = 0;
			boolean next;
			do {
				next = nextChance(j);
				if(next) j++;
			} while (next);
			System.out.println(j);
		}
	}

}
