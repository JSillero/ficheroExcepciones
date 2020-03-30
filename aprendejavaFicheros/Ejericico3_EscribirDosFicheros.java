package aprendejavaFicheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Escribe un programa que guarde en un fichero el contenido de otros dos ficheros,
 *  de tal forma que en el fichero resultante aparezcan las líneas de los primeros dos ficheros mezcladas, 
 *  es decir, la primera línea será del primer fichero, la segunda será del segundo fichero, la tercera será la siguiente del primerfichero,etc.
 *  
 *   Los nombres de los dos ficheros origen y el nombre del fichero destino se deben pasar como argumentos en la línea de comandos. 
 *   Hay que tener en cuenta que los ficheros de donde se van cogiendo las líneas pueden tener tamaños diferentes.

 * 
 * 
 */
public class Ejericico3_EscribirDosFicheros {

	public static void main(String[] args) throws IOException {
		
		//declaracion de variables
		String cadena1 = "";
		String cadena2 = "";
		
		
		//comprobamos que usamos el numero correcto de argumentos, en caso contrario el programa termina con un codigo de error 0 
		if(args.length !=3) {
			System.err.println("Numero de argumentos incorrecto.");
			System.exit(1);
		}
		
		//abrimos los ficheros a usar
		 BufferedWriter ficheroDestino = null;
		 BufferedReader fichero1 = null; 
		 BufferedReader fichero2 = null; 
		 try {
			ficheroDestino = new BufferedWriter(new FileWriter(args[2]));
			fichero1 = new BufferedReader(new FileReader(args[0]));
			fichero2 = new BufferedReader(new FileReader(args[1]));

		} catch (IOException e) {
			System.err.println("No se puede acceder al fichero en cuestión.");
			System.exit(1);
		}
		 
		 
		 //escribir dentro del fichero destino
		do{
			 cadena1 = fichero1.readLine();
			 cadena2 = fichero2.readLine();
			 
			 if(cadena1 != null)
				 ficheroDestino.write(cadena1 + "\n");
			 if(cadena2 != null)
				 ficheroDestino.write(cadena2 + "\n");
			 
		 }while(cadena1 != null || cadena2 != null);
		 
		//cierre de ficheros
		 fichero1.close();
		 fichero2.close();
		 ficheroDestino.close();
	}

}
