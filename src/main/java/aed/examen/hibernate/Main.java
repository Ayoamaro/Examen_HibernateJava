package aed.examen.hibernate;

import java.util.Scanner;

/**
 * @author Ayoze Amaro
 *
 */
public class Main {

	private static Scanner sc = new Scanner(System.in);
	private static boolean salirOpciones = false;
	private static boolean salirInicio = false;

	public static void main(String[] args) {
		
		while (salirInicio == false) {
			menuInicial();
		}
		
		while (salirOpciones == false) {
			menuOpciones();
		}
	}
	
	private static void menuInicial() {
		try {
			System.out.println("");
			System.out.println("¡Bienvenido al Examen Hibernate de Java!");
			System.out.println("INSERCCIÓN DE DATOS");
			System.out.println("1. Insertar categorías");
			System.out.print("Opción: ");
			String select = sc.nextLine();
			System.out.println("");

			switch (select) {
				case "1":
					Funciones.insertarCategorias();
					salirInicio = true;
					System.out.println("");
					break;
				default:
					Funciones.insertarCategorias();
					salirInicio = true;
					System.out.println("");
					break;
			}
		} catch(Exception ex) {
			System.out.println("ERROR: " + ex);
		}
	}
	
	private static void menuOpciones() {
		try {
			System.out.println("");
			System.out.println("OPCIONES DISPONIBLES. Realizado por Ayoze Amaro");
			System.out.println("1. Insertar Componente SIN Descripción");
			System.out.println("2. Insertar Componente CON Descripción");
			System.out.println("3. Eliminar Componente");
			System.out.println("4. Visualizar Categorías");
			System.out.println("5. Visualizar Componentes CON Descripción");
			System.out.println("6. Salir");
			System.out.print("Opción: ");
			String select = sc.nextLine();
			System.out.println("");

			switch (select) {
				case "1":
					Funciones.insertarComponenteSinDescripcion();
					break;
				case "2":
					Funciones.insertarComponenteConDescripcion();
					break;
				case "3":
					Funciones.listarComponentes();
					System.out.print("Elige el componente a borrar: ");
					String codComponenteBorrar = sc.nextLine();
					Funciones.eliminarComponente(codComponenteBorrar);
					System.out.println("");
					break;
				case "4":
					Funciones.listarCategorias();
					break;
				case "5":
					Funciones.listarComponentes();
					break;
				case "6":
					salirOpciones = true;
					System.out.println("");
					System.out.println("¡ADIÓS!");
					break;
				default:
					salirOpciones = true;
					System.out.println("");
					System.out.println("¡ADIÓS!");
					break;
			}
		} catch(Exception ex) {
			System.out.println("ERROR: " + ex);
		}
	}

}
