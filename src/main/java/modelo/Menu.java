package modelo;

import java.util.Scanner;

public class Menu {
	
	public static Scanner sc = new Scanner(System.in);
	public static String menuPrincipal() {
		
		System.out.println("Bienvenido");
		System.out.println("¿Que desea hacer?");
		System.out.println("1-saber el valor de la UF");
		System.out.println("2-Valor hora en base a Uf");
		System.out.println("3-Valor dia en base a Uf");
		System.out.println("4-Saber el total en base a dias trabajados");
		System.out.println("5-Salir");
		System.out.println("");
		String opcion = sc.nextLine();
		return opcion;
	}

}
