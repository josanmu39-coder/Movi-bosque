package co.edu.unbosque.controller;

import co.edu.unbosque.model.persistence.*;
import co.edu.unbosque.model.*;
import co.edu.unbosque.view.Ventana;

public class Controller {

	private Ventana ventana;
	private AdministrativoDAO ADAO;
	private EstudianteDAO EDAO;
	private BusDAO BDAO;
	private DocenteDAO DDAO;
	private TrenDAO TDAO;
	private ReservaDAO RDAO;
	private Persona usuarioActual;

	public Controller() {

		ADAO = new AdministrativoDAO();
		EDAO = new EstudianteDAO();
		BDAO = new BusDAO();
		DDAO = new DocenteDAO();
		TDAO = new TrenDAO();
		RDAO = new ReservaDAO();
		ventana = new Ventana(this);
		ventana.setVisible(true);
	}

	public void agregarAdministrativo(String nombre, String tipoDoc, String numDoc, String facultad, short edad,
			long telefono, String correo, int anioExperiencia) {
		Administrativo a = new Administrativo(nombre, tipoDoc, numDoc, facultad, edad, telefono, correo,
				anioExperiencia);
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

	public void reservarTren(String horario) {
		Tren tren = new Tren("Ruta Universidad", 0, 100, "18:00", horario, (short) 5, "Campus");
		TDAO.crear(tren);
		if (usuarioActual != null) {
			usuarioActual.agregarReserva("Tren a las " + horario);
			Reserva r = new Reserva("R" + (RDAO.getListaReservas().size() + 1), usuarioActual, tren, horario, true);
			RDAO.crear(r);
		}
	}

	public void reservarBus(String horario) {
		Bus bus = new Bus("Ruta Universidad", 0, 40, "18:00", horario, (short) 3, "Campus");
		BDAO.crear(bus);
		if (usuarioActual != null) {
			usuarioActual.agregarReserva("Bus a las " + horario);
			Reserva r = new Reserva("R" + (RDAO.getListaReservas().size() + 1), usuarioActual, bus, horario, true);
			RDAO.crear(r);
		}
	}

	public Estudiante agregarEstudiante(String nombre, String tipoDoc, String numDoc, String facultad, short edad,
			long telefono, String correo, String semestre) {
		Estudiante e = new Estudiante(nombre, tipoDoc, numDoc, facultad, edad, telefono, correo, semestre);
		EDAO.crear(e);
		return e;
	}

	public String mostrarEstudiantes() {
		return EDAO.mostrar();
	}

	public String mostrarDocentes() {
		return DDAO.mostrar();
	}

	public String mostrarAdministrativos() {
		return ADAO.mostrar();
	}

	public AdministrativoDAO getADAO() {
		return ADAO;
	}

	public EstudianteDAO getEDAO() {
		return EDAO;
	}

	public DocenteDAO getDDAO() {
		return DDAO;
	}
}