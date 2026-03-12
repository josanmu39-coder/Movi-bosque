package co.edu.unbosque.controller;
import co.edu.unbosque.model.persistence.*;
import co.edu.unbosque.util.MissingValueException;
import co.edu.unbosque.util.NegativeNumberException;
import co.edu.unbosque.util.NotValidBooleanException;
import co.edu.unbosque.util.NotValidCharacterException;
import co.edu.unbosque.util.NotValidSpaceException;
import co.edu.unbosque.util.OutOfRangeException;
import co.edu.unbosque.model.*;
import co.edu.unbosque.view.*;

public class Controller {
	
	private Consola con;
	private AdministradorDAO ADAO;
	private EstudianteDAO EDAO;
	private BusDAO BDAO;
	private DocenteDAO DDAO;
	private TrenDAO TDAO;
	
public Controller() {
con = new Consola();
}
	
public void run() {
		cicloPrincipal: while (true) {
		con.imprimirConSalto ( "MoviBosque");
		con.imprimirConSalto("Seleccione su rol dentro de la universidad: \n 1. Administrativo \n 2. Profesor \n 3. Estudiante \n 4. Salir");

		int opcionRol = con.leerNumeroEntero();
		con.leerLinea();

		switch (opcionRol) {
		case 1:
			mostrarMenuAdministrador();
			break;
		case 2:
			mostrarMenuProfesor();
			break;
		case 3:
			mostrarMenuEstudiante();
			break;
		case4:{
			con.imprimirConSalto("Adios");
			break cicloPrincipal;		
		}
		default:
			con.imprimirConSalto("Opcion invalida");
		}
	}
}

private void mostrarMenuProfesor() {
	cicloPersonas: while (true) {
		con.imprimirConSalto("Digite la funcion que desea hacer:" + " \n 1. Reservar transporte" + " \n 2. Agregar docentes"+ "3.Ver Lista de estudiantes"+"\n 4. Menú anterior");
		int opcionMenuPersonas = con.leerNumeroEntero();con.leerLinea();
		switch (opcionMenuPersonas) {
		case 1: {
		reservarTransporte();
			break;
		}
		case 2:
		agregarDocente();
			break;
		case 3: {
		mostrarListaEstudiantes();
			break;
		}
		case 4: {
			break cicloPersonas;
		}
		default:
			con.imprimirConSalto("Opcion invalida.");

		}
	}
}

public void mostrarMenuEstudiante() {
	cicloPersonas: while (true) {
		con.imprimirConSalto("Digite la funcion que desea hacer:" + " \n 1. Reservar transporte" + " \n 2. Agregar estudintes"+ "\n 3. Menú anterior");
		int opcionMenuPersonas = con.leerNumeroEntero();con.leerLinea();
		switch (opcionMenuPersonas) {
		case 1: {
		reservarTransporte();
			break;
		}
		case 2: {
		agregarEstudiante();
			break;
		}
		case 3: {
			break cicloPersonas;
		}
		default:
			con.imprimirConSalto("Opcion invalida.");

		}
	}
}

public void mostrarMenuAdministrador() {
	cicloPersonas: while (true) {
		con.imprimirConSalto("Digite la funcion que desea hacer:" + " \n 1. Reservar transporte" + " \n 2. Administrar Estudiantes"
				+ " \n 3. Administrar docentes  " +"\n4. Administrar administrativos " + "\n 5. Menú anterior");
		int opcionMenuPersonas = con.leerNumeroEntero();
		switch (opcionMenuPersonas) {
		case 1: {
		reservarTransporte();
			break;
		}
		case 2: {
		mostrarCRUDEstudiante();
			break;
		}
		case 3: {
		mostrarCRUDDocente();
			break;
		}
		case 4: {
		mostrarCRUDAdministrativos();
				break;
			}
		case 5: {
			break cicloPersonas;
		}
		default:
			con.imprimirConSalto("Opcion invalida.");

		}
	}
}

public void mostrarCRUDAdministrativos() {
	
}

public void mostrarCRUDDocente() {
	
}

public void mostrarCRUDEstudiante() {
	
}

public void mostrarListaEstudiantes() {
	
}

public void reservarTransporte() {
	
}

public void agregarEstudiante() {
	
}

public void agregarDocente() {
	
}


//Zona de excepciones propias
public void verificarNumeroEntero(int numero) throws NegativeNumberException {
	if (numero < 0) {
		throw new NegativeNumberException();
	}
}

public void verificarNumeroLargo(long numero) throws NegativeNumberException {
	if (numero < 0) {
		throw new NegativeNumberException();
	}
}

public void verificarNumeroCorto(short numero) throws NegativeNumberException {
	if (numero < 0) {
		throw new NegativeNumberException();
	}
}
public void verificarVacio(String texto) throws MissingValueException {
	if (texto.equals("")) {
		throw new MissingValueException();
	}
}

public void verificarBooleano(String texto) throws NotValidBooleanException {
    String respuesta = texto.toLowerCase();
    
    if (!respuesta.equals("si") && !respuesta.equals("no")) {
        throw new NotValidBooleanException();
    }
}
public static void verificarCaracteresEspeciales(String texto) throws NotValidCharacterException {
    String simbolos = "?¿@;:+!$%&/()=<>.,-*^#";
    for (int i = 0; i < simbolos.length(); i++) {
        char s = simbolos.charAt(i);
        if (texto.indexOf(s) != -1) {
            throw new NotValidCharacterException();
        }
    }
}
public static void verificarEspacios(String texto) throws NotValidSpaceException {
	if (texto.contains(" ")) {
		throw new NotValidSpaceException();
	}
}	
public static void verificarRangoNumeroEntero(int numero) throws OutOfRangeException {
	if (numero < Integer.MIN_VALUE || numero > Integer.MAX_VALUE) {
		throw new OutOfRangeException();
	}
}
public static void verificarRangoNumeroLargo(long numero) throws OutOfRangeException {
	if (numero < Long.MIN_VALUE || numero > Long.MAX_VALUE) {
		throw new OutOfRangeException();
	}
}
public static void verificarRangoNumeroCorto(short numero) throws OutOfRangeException {
	if (numero < Short.MIN_VALUE || numero > Short.MAX_VALUE) {
		throw new OutOfRangeException();
	}
}

}