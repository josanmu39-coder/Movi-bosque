package co.edu.unbosque.model;

public abstract class Persona implements CapacidadPersona{
	private String nombre;
	private String tipoDocumento;
	private String numeroDocumento;
	private String facultad;
	private short edad;
	private long numeroTelefonico;
	private String correoInstitucional;
	
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

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", tipoDocumento=" + tipoDocumento + ", numeroDocumento=" + numeroDocumento
				+ ", facultad=" + facultad + ", edad=" + edad + ", numeroTelefonico=" + numeroTelefonico
				+ ", correoInstitucional=" + correoInstitucional + "]";
	}
	

}
