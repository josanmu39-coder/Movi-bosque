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
	private Persona usuarioActual;

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
	}

	public void agregarAdministrativo(String nombre, String tipoDoc, String numDoc, String facultad, short edad,
			long telefono, String correo, int anioExperiencia) {
		Administrativo a = new Administrativo(nombre, tipoDoc, numDoc, facultad, edad, telefono, correo, anioExperiencia);
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
			long telefono, String correo, String semestre) {
		Estudiante e = new Estudiante(nombre, tipoDoc, numDoc, facultad, edad, telefono, correo,semestre);
		EDAO.crear(e);
		return e;
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

	public void setADAO(AdministrativoDAO aDAO) {
		ADAO = aDAO;
	}

	public EstudianteDAO getEDAO() {
		return EDAO;
	}

	public void setEDAO(EstudianteDAO eDAO) {
		EDAO = eDAO;
	}

	public BusDAO getBDAO() {
		return BDAO;
	}

	public void setBDAO(BusDAO bDAO) {
		BDAO = bDAO;
	}

	public DocenteDAO getDDAO() {
		return DDAO;
	}

	public void setDDAO(DocenteDAO dDAO) {
		DDAO = dDAO;
	}

	public TrenDAO getTDAO() {
		return TDAO;
	}

	public void setTDAO(TrenDAO tDAO) {
		TDAO = tDAO;
	}
}