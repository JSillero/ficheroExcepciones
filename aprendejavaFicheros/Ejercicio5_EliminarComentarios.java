package aprendejavaFicheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * EscribeunprogramacapazdequitarloscomentariosdeunprogramadeJava. Seutilizaríadelasiguientemanera:
quita_commentarios PROGRAMA_ORIGINAL PROGRAMA_LIMPIO Porejemplo:
quita_comentarios hola.java holav2.java creaunficheroconnombre holav2.java quecontieneelcódigode hola.java pero sinloscomentarios.

 * @author Sillero
 *
 */
public class Ejercicio5_EliminarComentarios {

	public static void main(String[] args) throws IOException {
		
		//comprovación de numero de argumentos correcto.
		if(args.length != 1) {
			System.err.println("Numero de parametros erroneo.(Introduzca uno solo que sea el archivo de java al que se le quiten los comentarios)");
			System.exit(1);
		}
		
		//apertura y o creacion de ficheros.
		BufferedWriter ficheroDestino = null;
		BufferedReader ficheroOrigen = null; 
		
		try {
			ficheroDestino = new BufferedWriter(new FileWriter(args[0].substring(0, args[0].length()-6) +"v2.java" ));
			ficheroOrigen = new BufferedReader(new FileReader(args[0]));
		
		} catch (IOException e) {
			System.err.println("No se puede acceder al fichero en cuestión.");
			System.exit(1);
		}
		
		//accedemos al archivo
		String linea = ficheroOrigen.readLine();
		//com y com largo sirven para identificar cuando no se debera de escribir en el programa final por presencia de comentarios
		Boolean comLargo = false;
		Boolean com = false;
		
		while(linea != null) {
			//Se comprueba cuando hay signos que indican comentario
			if(linea.indexOf("//") != -1)
				com = true;
			else if(!comLargo && linea.indexOf("/**") != -1)
				comLargo = true;
			else if(linea.indexOf("*/") != -1) {
				com = true;
				comLargo = false;
			}
			if(!com && !comLargo)
				ficheroDestino.write(linea + "\n");
			//se resetea el comentario de una linea
			com=false;
			
			//lectura de siguiente linea
			linea = ficheroOrigen.readLine();
			
		}
		ficheroDestino.close();
		ficheroOrigen.close();
	}

}
