package co.edu.unbosque.model;

public class Persona{
	private String nombre;
	private String tipoDocumento;
	private String numeroDocumento;
	private short edad;
	private long numeroTelefonico;
	private String correoInstitucional;
	
	public Persona() {
	}
	
	public Persona(String nombre, String tipoDocumento, String numeroDocumento, short edad, long numeroTelefonico,
			String correoInstitucional) {
		super();
		this.nombre = nombre;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.edad = edad;
		this.numeroTelefonico = numeroTelefonico;
		this.correoInstitucional = correoInstitucional;
	}
	
	

}
