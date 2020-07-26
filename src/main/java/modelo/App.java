package modelo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		/*
		 * 
		 * 
		 * */

		Uf uf = new Uf();
		System.out.println("Bienvenido");
		String opcion;

		do {
			opcion = Menu.menuPrincipal();
			if (opcion.equals("1")) {
				uf.valorUfActual();
			}
			if (opcion.equals("2")) {
				uf.fijarValorUfHora();
			}
			if (opcion.equals("3")) {
				uf.fijarValorDia();
			}
			if (opcion.equals("4")) {
				uf.fijarTotalDias();
			}

		} while (!opcion.equalsIgnoreCase("5"));

	}
}
