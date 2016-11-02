package Main;

import AdditionalFeatures.*;
import java.util.Scanner;

public class Proyecto {
	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		PasswordList lista = new PasswordList();
		int menu = 1;
		int opc;
		do{
			printOptions(menu);
			opc = in.nextInt();
			PasswordList listaTemp;
			switch(menu) {
			case 1:
				switch(opc){
				case 1:
					menu = 2;
					break;
				case 2:
					listaTemp = new PasswordList(lista);
					showPasswordList(listaTemp);
					break;
				case 3:
					listaTemp = new PasswordList(lista);
					showSecurity(listaTemp);
					break;
				case 4:
					listaTemp = new PasswordList(lista);
					verify(listaTemp);
					break;
				case 5:
					menu = 3;
					break;
				case 0:
					menu = 0;
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
			case 2:
				switch(opc){
				case 1:
					lista.askForPasswords();
					break;
				case 2:
					System.out.print("Path del .txt : ");
					String input = in.next();
					listaTemp = FileLoader.load(input);
					lista.add(listaTemp);
					break;
				case 3:
					System.out.print("¿Cuántas? : ");
					int cant = in.nextInt();
					lista = generate(lista, cant);
					break;
				case 0:
					menu = 1;
				}
				break;
			case 3:
				switch(opc){
				case 1:
					lista = new PasswordList();
				default:
					menu = 1;
					break;
				}
				break;
			default:
				break;
			}
			System.out.println();
		} while (menu != 0);
	}
	
	private static void printOptions(int n) {
		switch (n) {
		case 1:
			System.out.println("1 Cargar contraseñas\n2 Ver contraseñas\n3 Ver seguridad\n4 Verificar contraseñas\n5 Eliminar contraseñas\n0 Salir");
			break;
		case 2:
			System.out.println("1 Añadir desde consola\n2 Añadir desde .txt\n3 Generar\n0 Volver");
			break;
		case 3:
			System.out.println("1 Borrar todo\n0 Volver (No borra)");
			break;
		}
		System.out.print("Opción: ");
	}
	
	private static void showPasswordList(PasswordList list) {
		System.out.println("Hay un total de " + list.length() + " contraseñas");
		String password;
		do {
			password = list.nextPassword();
			if (password != Codes.EOL) {
				System.out.println(password);
			}
		} while (password != Codes.EOL);
	}
	
	private static void showSecurity(PasswordList list) {
		String password;
		do {
			password = list.nextPassword();
			if (password != Codes.EOL) {
				System.out.print(password + " -> ");
				Security.printCheckResult(password);
			}
		} while (password != Codes.EOL);
	}
	
	private static void verify(PasswordList list) {
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
	
	private static PasswordList generate(PasswordList list, int c){
		long startTime = System.currentTimeMillis();
		for(int i = 0; i < c; i++){
			list.addPassword(new RandomPassword().toString());
		}
		long elapsedTime = System.currentTimeMillis() - startTime;
		System.out.println("Se tardó " + elapsedTime + " milisegundos en generar " + c + " contraseñas");
		return list;
	}
	
	private static void _62656e63686d61726b(int _6365726f73) { //507275656261206c61206361706163696461642064656c2070726f6772616d61
		PasswordList _6c69737461 = new PasswordList(); //437265616d6f7320756e2050617373776f72644c69737420646520707275656261
		
		for(int _69 = 0; _69 <= _6365726f73; _69++) { /*536520656a6563757461205f36333635373236663733202b20312076656365732c20
		6c61207072696d65726120636f6e20312c206465737075657320636f6e2031302c203130302c2079206173c3ad2e*/
			int _63616e7469646164 = 1;
			for(int _6a = 1; _6a <= _69; _6a++) {
				_63616e7469646164 *= 10;
			}
			generate(_6c69737461, _63616e7469646164); //47656e657261206c617320636f6e7472617365c3b16173
			_6c69737461 = new PasswordList(); //59206c617320626f727261
		}
	}
}
