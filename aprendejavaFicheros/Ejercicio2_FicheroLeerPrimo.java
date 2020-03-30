package aprendejavaFicheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * Realiza un programa que lea el fichero creado en el ejercicio anterior y que muestrelosnúmerosporpantalla.

 * 
 * @author Sillero
 *
 */
public class Ejercicio2_FicheroLeerPrimo {

	public static void main(String[] args) {
		BufferedReader fichero = null;		
		try {
			fichero = new BufferedReader (new FileReader("primos.dat"));
			
		} catch ( IOException e) {
			System.err.println("El fichero no existe, o no se puede acceder a él.");
			System.exit(1);
		}
		
		int numero;
		
		while (true) {
			try {
				numero = fichero.read();
			} catch (IOException e) {
				break;
			}
			System.out.println(numero);
		}
	}

}
