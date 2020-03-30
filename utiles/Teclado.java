package utiles;
import java.util.Scanner;

public class Teclado {
	
	static Scanner s = new Scanner(System.in);
	
	public static String leerCaracter() {
		
		String cadena= s.nextLine();
		return cadena;
		
	}
	
	public static String leerCaracter(String msg) {
		
		System.out.println(msg);
		
		return leerCaracter();
		
	}
	
	public static int leerEntero() {
		int entero=-1;
		boolean puerta= true;
		do {
		
			try {
				entero = Integer.parseInt(leerCaracter());
				puerta= false;
			} catch (NumberFormatException e) {
				System.err.println("ERROR: introduzca un entero.");
			}
			
		}while(puerta);
		
		return entero;
	}
	
	public static int leerEntero(String msg) {
		System.out.println(msg);
		
		return leerEntero();
	}

}
