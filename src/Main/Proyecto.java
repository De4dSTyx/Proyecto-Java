package Main;

import AdditionalFeatures.*;
import java.util.Scanner;

public class Proyecto {
	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		PasswordDatabase lista = new PasswordDatabase();	//Base de datos principal
		int menu = 1;	//Al haber varios menús, con esta variable guardamos el manú actual
		/* Hay 4 menús:
		 * 1 - El menú principal
		 * 2 - El menú de "Cargar contraseñas"
		 * 3 - El menú de "Borrar contraseñas"
		 * 0 - No es un menú, es para salír del programa
		 */
		int opc;	//Guarda la opción ingresada por el usuario
		do{
			printOptions(menu);	//Imprime las opciones del menú correspondiente
			opc = in.nextInt();	//Guarda la respuesta del usuario
			PasswordDatabase listaTemp;	//Base de datos temporal usada para poder sacar datos sin modificar la base de datos principal
			switch(menu) {	//Dependiendo de la variable menu...
			case 1:	//Para el menú principal hay gran cantidad de opciones posibles
				switch(opc){
				case 1:
					menu = 2;	//Si se elije la opción 1 del primer menú, se va al segundo menú
					break;
				case 2:	//Si se elije la opción 2
					listaTemp = new PasswordDatabase(lista);	//Se copia la base de datos principal en la temporal
					showPasswordDatabase(listaTemp);	//Y muestra las contraseñas de la temporal
					break;
				case 3:	//Si se elije la opción 3
					listaTemp = new PasswordDatabase(lista);	//Igual que en la 2
					showSecurity(listaTemp);	//Pero acá se muestra la seguridad de las contraseñas
					break;
				case 4:	//En la opción 4
					listaTemp = new PasswordDatabase(lista);	//Se hace una copia al igual que en las opciones 2 y 3
					verify(listaTemp);	//Y verifica las contraseñas según las reglas dadas en la
					break;
				case 5:	//En la opción 5
					menu = 3; //Se pasa al tercer menú
					break;
				case 0:	//Y con la opción cero
					menu = 0; //Se sale del programa
					break;
				case Codes._45617374657220456767: //45617374657220456767
					System.out.println("4269656e76656e69646f2061206c612068657272616d69656e74612064652042656e63686d61726b696e672e\n"
							+ "457374612068657272616d69656e746120736520656e6375656e7472612061637475616c6d656e746520287920656e20"
							+ "666f726d61207065726d616e656e7465292022656e206465736172726f6c6c6f222c20706f72206c6f20717565206c6120"
							+ "7574696c697a616369c3b36e206465206c61206d69736d612071756564612062616a6f20737520726573706f6e736162"
							+ "696c69646164207920637269746572696f2e\n457320706f7369626c6520717565206f63757272616e206572726f726573"
							+ "20647572616e7465206c6120656a6563756369c3b36e20792070756564617320706572646572206c6f207265616c697a"
							+ "61646f2068617374612061686f72612e\n53692065737461206465206163756572646f20636f6e206573746f2c2070726f"
							+ "736967612e\n\n4375c3a16e746f73206365726f733f203a20"); //4d656e73616a6520646520746578746f20616d696761626c65205e5e
					int _6365726f73 = in.nextInt(); //4775617264616d6f73206c61207265737075657374612064656c207573756172696f
					_62656e63686d61726b(_6365726f73); //56616d6f7320616c206d65746f646f205f363236353665363336383664363137323662
					break;
				}
				break;
			case 2:	//Para el menú de cargar contraseñas
				switch(opc){
				case 1:	//La primer opción, pide al usuario que ingrese contraseñas a mano
					lista.askForPasswords();
					break;
				case 2:	//La segundda, carga contraseñas de un .txt
					System.out.print("Path del .txt : ");
					String input = in.next();	//Pide al usuario la ubicación del .txt (en relación con el .jar exportado)
					listaTemp = FileLoader.load(input);	//Carga las contraseñas del archivo de texto
					lista.add(listaTemp);	//Y las añade al la base de datos principal
					break;
				case 3:	//Y la tercera las genera aleatoreamente
					System.out.print("¿Cuántas? : ");
					int cant = in.nextInt();	//Cuantas quiere generar el usuario
					lista = generate(lista, cant);	//Genera la cantidad de contraseñas especificadas por el usuario
					break;
				case 0: //Por último, con la opción 0, vuelve al menú principal
					menu = 1;
				}
				break;
			case 3:	//Para el menú de borrar contraseñas hay dos opciones
				switch(opc){
				case 1:	//Opción 1, borra la base de datos
					lista = new PasswordDatabase();
				case 0: //Opción 0, vuelve al menú principal
					menu = 1;
					break;
				}
				break;
			default:
				break;
			}
			System.out.println();
		} while (menu != 0);	//Cuando menu es 0 sale del programa
	}
	
	private static void printOptions(int n) {	//Imprime las opciones del menú correspondiente
		switch (n) {
		case 1:	//Para el menú principal imprime lo siguiente:
			System.out.println("1 Cargar contraseñas\n2 Ver contraseñas\n3 Ver seguridad\n4 Verificar contraseñas\n5 Eliminar contraseñas\n0 Salir");
			break;
		case 2:	//Para el menú de cargar contraseñas imprime:
			System.out.println("1 Añadir desde consola\n2 Añadir desde .txt\n3 Generar\n0 Volver");
			break;
		case 3:	//Y para el menú de barrar contraseñas imprime:
			System.out.println("1 Borrar todo\n0 Volver (No borra)");
			break;
		}
		System.out.print("Opción: ");//Al final, imprime esta linea para que el usuario ingrese la opción
	}
	
	private static void showPasswordDatabase(PasswordDatabase list) {  //método que va escribiendo las contraseñas una por una hasta llegar al End Of List, también nos indica la cantidad de contraseñas ingresadas.
		System.out.println("Hay un total de " + list.length() + " contraseñas");
		String password;
		do {
			password = list.nextPassword();
			if (password != Codes.EOL) {
				System.out.println(password);
			}
		} while (password != Codes.EOL);
	}
	
	private static void showSecurity(PasswordDatabase list) { //método que nos indica la seguridad una por una de las contraseñas ingresadas
		String password;
		do {
			password = list.nextPassword();
			if (password != Codes.EOL) {
				System.out.print(password + " -> ");
				Security.printCheckResult(password);
			}
		} while (password != Codes.EOL);
	}
	
	private static void verify(PasswordDatabase list) { //método "verificador" que utiliza a la clase PasswordVerifier para eso, verificar las contraseñas ingresadas y nos dice si son aceptadas o no
		String password;
		boolean isPasswordCorrect;
		do {
			password = list.nextPassword();
			if (password != Codes.EOL) {
				isPasswordCorrect = PasswordVerifier.verify(password);
				if (isPasswordCorrect) System.out.println("<" + password + "> es aceptado");
				else System.out.println("<" + password + "> no fue aceptado");
			}
		} while (password != Codes.EOL);
	}
	
	private static PasswordDatabase generate(PasswordDatabase list, int c){ 
		long startTime = System.currentTimeMillis(); 
		for(int i = 0; i < c; i++){  //utilizamos un for para añadir, en este caso, c cantidad de contraseñas
			list.addPassword(new RandomPassword().toString()); //genera una contraseña totalmente aleatoria, la pasa a un string y finalmente la añade a la lista
		}
		long elapsedTime = System.currentTimeMillis() - startTime;//tiempo que transcurrió al generar las contraseñas
		System.out.println("Se tardó " + elapsedTime + " milisegundos en generar " + c + " contraseñas"); //Nos indica cuánto tiempo en milisegundos tardó en generar las contraseñas
		return list;
	}
	
	private static void _62656e63686d61726b(int _6365726f73) { //507275656261206c61206361706163696461642064656c2070726f6772616d61
		PasswordDatabase _6c69737461 = new PasswordDatabase(); //437265616d6f7320756e2050617373776f72644c69737420646520707275656261
		
		for(int _69 = 0; _69 <= _6365726f73; _69++) { /*536520656a6563757461205f36333635373236663733202b20312076656365732c20
		6c61207072696d65726120636f6e20312c206465737075657320636f6e2031302c203130302c2079206173c3ad2e*/
			int _63616e7469646164 = 1;
			for(int _6a = 1; _6a <= _69; _6a++) {
				_63616e7469646164 *= 10;
			}
			generate(_6c69737461, _63616e7469646164); //47656e657261206c617320636f6e7472617365c3b16173
			_6c69737461 = new PasswordDatabase(); //59206c617320626f727261
		}
	}
}
