package co.edu.unbosque.util;

public class NotValidCharacterException extends Exception{

	public NotValidCharacterException() {
		super("Error, caracter ingresado no valido");
	}
}
