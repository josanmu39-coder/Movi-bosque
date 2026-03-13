package co.edu.unbosque.util;

public class NotValidFacultyException extends Exception {

	public NotValidFacultyException() {
		super("Error, facultad no valida");
	}

	// Metodo que va en el Controller
	public static void verificarFacultad(String facultad) throws NotValidFacultyException{
		String facu = facultad.toLowerCase();
		if (!(facu.equals("ingenieria") || facu.equals("medicina") || facu.equals("matematicas") || facu.equals("artes"))) {
			throw new NotValidFacultyException();
		}
	}
}
