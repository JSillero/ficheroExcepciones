package utiles;

public class Menu {
	String titulo;
	String[] opciones;
	
	public Menu(String titulo , String[] opciones) {
		this.titulo = titulo;
		this.opciones = opciones;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String[] getOpciones() {
		return opciones;
	}

	public void setOpciones(String[] opciones) {
		this.opciones = opciones;
	}
	
	/**
	 * Muestra el menu por pantalla.
	 */
	private void mostrar() {
		
		System.out.println(titulo+":,\n");
		
		int num =1;
		
		for (String x : this.getOpciones()){
			System.out.println(num+".-"+x);
			num+=1;
		}
		
	}
	
	/**
	 * Pide un valor numerico valido acorde a las opciones posibles. Incluyendo la ultima : SALIR.
	 * @return valor de la opcion
	 */
	private int recogerOpcion() {
		int numero= -1;
		while(true) {
			
			numero=Teclado.leerEntero();
			
			if(numero>0 && numero< this.getOpciones().length+2)
				break;
			
			System.out.println("Introduzca un valor entre 1 y " + (this.getOpciones().length+1));
		}
		
		return numero;			
	}
	
	/**
	 * Muestra el menu y pide una opcion valida, implementa recogerOpcion y mostrar
	 * @return
	 */
	public int gestionar() {
		this.mostrar();
		return this.recogerOpcion();
	}
	
	
}
