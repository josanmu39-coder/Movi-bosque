package co.edu.unbosque.util;

public class NotValidSpaceException extends Exception{
	
	public NotValidSpaceException() {
		super("Error, no se permite poner espacios");
	}
}
