package co.edu.unbosque.model;

import java.util.ArrayList;

public abstract class Persona implements CapacidadPersona{
	private String nombre;
	private String tipoDocumento;
	private String numeroDocumento;
	private String facultad;
	private short edad;
	private long numeroTelefonico;
	private String correoInstitucional;
	private ArrayList<String> reservas = new ArrayList<>();
	
	public Persona() {
		
	}

	public Persona(String nombre, String tipoDocumento, String numeroDocumento, String facultad, short edad,
			long numeroTelefonico, String correoInstitucional) {
		super();
		this.nombre = nombre;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.facultad = facultad;
		this.edad = edad;
		this.numeroTelefonico = numeroTelefonico;
		this.correoInstitucional = correoInstitucional;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public short getEdad() {
		return edad;
	}

	public void setEdad(short edad) {
		this.edad = edad;
	}

	public long getNumeroTelefonico() {
		return numeroTelefonico;
	}

	public void setNumeroTelefonico(long numeroTelefonico) {
		this.numeroTelefonico = numeroTelefonico;
	}

	public String getCorreoInstitucional() {
		return correoInstitucional;
	}

	public void setCorreoInstitucional(String correoInstitucional) {
		this.correoInstitucional = correoInstitucional;
	}

	public String getFacultad() {
		return facultad;
	}

	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}
	
	public void agregarReserva(String reserva) {
	    reservas.add(reserva);
	}
	public String mostrarReservas() {

	    String datos = "";

	    for(String r : reservas) {
	        datos += r + "\n";
	    }

	    return datos;
	}

	@Override
	public String toString() {
		return "nombre=" + nombre + ", tipoDocumento=" + tipoDocumento + ", numeroDocumento=" + numeroDocumento
				+ ", facultad=" + facultad + ", edad=" + edad + ", numeroTelefonico=" + numeroTelefonico
				+ ", correoInstitucional=" + correoInstitucional + "]";
	}
	

}
