package ejercicio2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import utiles.Teclado;
import java.util.HashMap;
/***
 * 2. Crea un programa que encripte un fichero que le pasamos como parámetro y almacene el resultado en otro, que también pasamos como parámetro, de manera que:

Si el programa no recibe dos parámetros termina con un error 1.

Si el programa recibe un solo parámetro guardará la información encriptada en el mismo archivo del que lee, pero antes advertirá al usuario de que machacará el 
archivo origen, dando opción a que la operación no se haga.

Si el fichero origen no existe (da error al abrirlo como lectura) el programa termina con un mensaje de error y código 2.

Si en el fichero destino no se puede escribir da error al abrirlo como lectura) el programa termina con un mensaje de error y código 2.

Para encriptar usa el método César, necesitarás una clave que debes pedir al usuario.
 * 
 * 
 * @author Sillero
 *
 */
public class Ejercicio2EncriptacionCesar_2 {
	public static void main(String[] args) throws IOException {
		
		//comprobamos el numero de parametros es correcto
		if (args.length != 2 && args.length != 1) {
			System.err.println("El numero de parametros es incorrecto");
			System.exit(1);
		}		
		
		//abrimos los ficheros de texto con los que trabajaremos.
		BufferedReader texto = null;
		BufferedWriter codificado = null;
		
		try {
			texto = new BufferedReader (new FileReader(args[0]));
			if(args.length == 2) {
				codificado = new BufferedWriter(new FileWriter(args[1]));
			}
			
		} catch ( IOException e) {
			System.err.println("Alguno de los ficheros no existe");
		}
		
		//especificamos la codificación
		//creamos una cadena con las letras del abecedario en mayus y otra con las letras rotadas para codificarlas.
		String letras = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
		
		int cod = ((Teclado.leerEntero("Introduzca el valor de la codificación.")) % letras.length());
		String letrasRot = letras.substring(cod, letras.length()-1) + letras.substring(0, cod);
	
		String linea= texto.readLine();
		String transcripcion = "";
		
		while( linea!= null) {
		
			for (int i=0 ; i<linea.length();i++) {
				//aqui buscamos la posicion de cada letra en el orden normal, y luego la asignamos a transcipcion
				//en caso de que sea un caracter especial, se plantará normalmente.
				int posicion =letras.indexOf(linea.substring(i,i+1).toUpperCase());
				if(posicion == -1)
					transcripcion += linea.substring(i,i+1);
				else
					transcripcion +=letrasRot.substring(posicion,posicion+1);
				
			}
			
			transcripcion += "\n";
			linea = texto.readLine();

		}
		if(args.length == 2)
			codificado.write(transcripcion);
		else {
			codificado = new BufferedWriter(new FileWriter(args[0]));
			codificado.write(transcripcion);
		}
		
		texto.close();
		codificado.close();
		
	}
	
}
