package aprendejavaFicheros;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * Escribe un programa que guarde en un fichero con nombre primos.dat los númerosprimosquehayentre 1  y 500.

 * 
 * @author Sillero
 *
 */
public class Ejercicio1_FicherosPrimos {

	public static void main(String[] args) throws IOException {
		 boolean esprimo;
		 int numero=1;
		 //abrimos/creamos el fichero a llenar.
		 BufferedWriter fichero = null;
		 try {
			fichero = new BufferedWriter(new FileWriter("primos.dat"));
		} catch (IOException e) {
			System.err.println("No se puede acceder al fichero en cuestión.");
			System.exit(1);
		}
		 
		 while (numero<500) {
			 
			esprimo=true;
			numero+=1;
			
			for(int i=1; i<(numero/2+1) ;i++) {
				if(numero%i==0 && i!=1) {
					esprimo=false;
				}
			}
			if(esprimo) {
				fichero.write(numero);
				System.out.println(numero);
			}
			 
		 }
		 fichero.close();
	}

}
