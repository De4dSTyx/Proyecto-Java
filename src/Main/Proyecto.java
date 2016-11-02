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
		for(int i = 0; i < c; i++){
			list.addPassword(Generator.generate());
		}
		return list;
	}
}
