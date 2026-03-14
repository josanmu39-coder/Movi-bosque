package co.edu.unbosque.controller;
import co.edu.unbosque.model.persistence.*;
import co.edu.unbosque.model.*;
import co.edu.unbosque.view.PanelFondo;
import co.edu.unbosque.view.Ventana;

public class Controller {
	

	private Ventana ventana;
	private AdministrativoDAO ADAO;
	private EstudianteDAO EDAO;
	private BusDAO BDAO;
	private DocenteDAO DDAO;
	private TrenDAO TDAO;
	private Persona usuarioActual;
	private Bus bus1;
	private Bus bus2;
	private Bus bus3;
	private Bus bus4;
	private Tren tren1;
	private Tren tren2;
	private Tren tren3;
	private Tren tren4;

	
	
	

	public Controller() {

		ADAO = new AdministrativoDAO();
		EDAO = new EstudianteDAO();
		BDAO = new BusDAO();
		DDAO = new DocenteDAO();
		TDAO = new TrenDAO();
		ventana = new Ventana(this);
		ventana.setVisible(true);
		BDAO = new BusDAO();
		TDAO = new TrenDAO();
		bus1 = new Bus( 6712, "El sol", "claisco", "transporte publico",true,"thomas bernal",true);
		bus2 = new Bus( 5681, "Cotrasvilla", "Premium", "transporte privado",true,"ilia topuria",true);
		bus3 = new Bus( 3451, "Bolivariano", "claisco", "transporte privado",true,"Leonel Messi",true);
		bus4 = new Bus( 1207, "El sol", "claisco", "",true,"Pepa pig",true);
		tren1 = new Tren(7,6,true);
		tren2 = new Tren(6,3,true);
		tren3 = new Tren(9,4,true);
		tren4 = new Tren(7,2,true);
	
 
		
	
	}
	
	
	public void agregarAdministrativo(String nombre, String tipoDoc, String numDoc, String facultad, short edad,
			long telefono, String correo) {
		Administrativo a = new Administrativo(nombre, tipoDoc, numDoc, facultad, edad, telefono, correo);
		ADAO.crear(a);
	}
	
	public void agregarDocente(String nombre, String tipoDoc, String numDoc, String facultad, short edad, long telefono,
			String correo) {
		Docente d = new Docente(nombre, tipoDoc, numDoc, facultad, edad, telefono, correo);
		DDAO.crear(d);
	}

	public void iniciarSesion(Persona persona) {
		usuarioActual = persona;
	}

	public Persona getUsuarioActual() {
		return usuarioActual;
	}

	public void reservarBus(String horario) {
		Bus bus = new Bus("Ruta Universidad", 0, 40, "18:00", horario, (short) 3, "Campus");
		BDAO.crear(bus);
		if (usuarioActual != null) {
			usuarioActual.agregarReserva("Bus a las " + horario);
		}
	}

	public Estudiante agregarEstudiante(String nombre, String tipoDoc, String numDoc, String facultad, short edad,
			long telefono, String correo) {
		Estudiante e = new Estudiante(nombre, tipoDoc, numDoc, facultad, edad, telefono, correo);
		EDAO.crear(e);
		return e;
	}

	public void agregarDocente() {

	}

	public void reservarTren(String horario) {
		Tren tren = new Tren("Ruta Universidad", 0, 100, "18:00", horario, (short) 5, "Campus");
		TDAO.crear(tren);
		if (usuarioActual != null) {
			usuarioActual.agregarReserva("Tren a las " + horario);
		}
	}

	public String mostrarReservasBus() {
		return BDAO.mostrar();

	}

	public String mostrarReservasTren() {
		return TDAO.mostrar();
	}
	

}