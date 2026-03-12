package co.edu.unbosque.view;

import java.util.Scanner;

public class Consola {
	Scanner lector = new Scanner(System.in);
	
	public int leerNumeroEntero() {
		return lector.nextInt();
	}
	public float leerNumeroFlotante() {
		return lector.nextFloat();
	}
	public double leerNumeroDoble() {
		return lector.nextDouble();
	}
	public long leerNumeroLargo() {
		return lector.nextLong();
	}
	public short leerNumeroCorto() {
		return lector.nextShort();
	}
	public boolean leerBooleano() {
		String entrada= lector.nextLine();

		if(entrada.toLowerCase().contains("si")) {
		return true;
	}else {
		return false;
		}
	}
		
	public String leerLinea() {
		return lector.nextLine();
	}
	
	public String leerPalabra() {
		return lector.next();
	}
	public char leerCaracter() {
			return lector.next().charAt(0);
		
		
	}
	public void imprimirConSalto(String texto) {
		System.out.println(texto);
	}
	public void imprimirCorrido(String texto) {
		System.out.print(texto);
	}
	//  cuando se está leyendo un int, o float, o double, etc. y lo siguiente que esté 
	// leyendo sea una linea de caracteres debo quemar el resto de la linea
}
