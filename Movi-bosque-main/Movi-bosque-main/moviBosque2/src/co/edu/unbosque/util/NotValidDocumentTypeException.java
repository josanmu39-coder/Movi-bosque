package co.edu.unbosque.util;

public class NotValidDocumentTypeException extends Exception {

	public NotValidDocumentTypeException() {
		super("Error, el tipo de documento ingresado no es valido");
	}

	// Metodo que va en el controller
	public static void verificarTipoDocumento(String tipoDoc) throws NotValidDocumentTypeException {
		String tipo = tipoDoc.toLowerCase();

		if (!(tipo.equals("cedula") || tipo.equals("cedula de extranjeria") || tipo.equals("tarjeta de identidad"))) {
			throw new NotValidDocumentTypeException();
		}
	}
}
