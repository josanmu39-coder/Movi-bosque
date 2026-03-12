package co.edu.unbosque.util;

public class MissingValueException extends Exception{

	public MissingValueException() {
		super("Error, este campo no se puede dejar vacío");
	}
}
