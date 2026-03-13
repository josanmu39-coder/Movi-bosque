package co.edu.unbosque.util;

public class NotValidMailFormatException extends Exception{

	public NotValidMailFormatException() {
		super("Error, el formato del correo ingresado no es correcto, verifique que termine en @unbosque.edu.co");
	}
	
	//Metodo que va en el controler
	public static void verificarCorreo(String correo) throws NotValidMailFormatException {
		String dominio = "@unbosque.edu.co";
		
		if (correo.length()<dominio.length()) {
			throw new NotValidMailFormatException();
		}
		int inicioDom = correo.length()-dominio.length();
		for (int i = 0; i< dominio.length(); i++) {
			if (correo.charAt(i+inicioDom) != dominio.charAt(i)) {
				throw new NotValidMailFormatException();
			}
		}
	}
}
