package co.edu.unbosque.util;

public class NotValidCharacterException extends Exception{

	public NotValidCharacterException() {
		super("Error, carácter ingresado no valido");
	}
}
