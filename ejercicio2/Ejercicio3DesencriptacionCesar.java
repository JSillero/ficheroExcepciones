package ejercicio2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import utiles.Teclado;

public class Ejercicio3DesencriptacionCesar {

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
				String letrasRot = letras.substring(cod, letras.length()-1) + letras.substring(0,cod);
				System.out.println(letrasRot);
				String linea= texto.readLine();
				String transcripcion = "";
				
				while( linea!= null) {
				
					for (int i=0 ; i<linea.length();i++) {
						//aqui buscamos la posicion de cada letra en el orden normal, y luego la asignamos a transcipcion
						//en caso de que sea un caracter especial, se plantará normalmente.
						int posicion = letrasRot.indexOf(linea.substring(i,i+1).toUpperCase());
						if(posicion == -1)
							transcripcion += linea.substring(i,i+1);
						else {						
							transcripcion +=letras.substring(posicion,posicion+1);
						}
						
					}
					
					transcripcion += "\n";
					linea = texto.readLine();

				}
				System.out.println(transcripcion);
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
