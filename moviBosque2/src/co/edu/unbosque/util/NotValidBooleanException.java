package co.edu.unbosque.util;

public class NotValidBooleanException extends Exception{

	public NotValidBooleanException() {
		super("Error, la respuesta tiene que ser unicamente un: si/no");
	}
}
