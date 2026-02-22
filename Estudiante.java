package co.edu.unbosque.model;

public class Estudiante extends Persona {

	private String carrera;
	private String horaPrimeraClase;
	private String horaUltimaClase;
	private String facultad;
	private int numSemestre;
	
	public Estudiante() {
		
	}

	public Estudiante(String carrera, String horaPrimeraClase, String horaUltimaClase, String facultad,
			int numSemestre) {
		super();
		this.carrera = carrera;
		this.horaPrimeraClase = horaPrimeraClase;
		this.horaUltimaClase = horaUltimaClase;
		this.facultad = facultad;
		this.numSemestre = numSemestre;
	}

	public Estudiante(String nombre, String tipoDocumento, String numeroDocumento, short edad, long numeroTelefonico,
			String correoInstitucional, String carrera, String horaPrimeraClase, String horaUltimaClase,
			String facultad, int numSemestre) {
		super(nombre, tipoDocumento, numeroDocumento, edad, numeroTelefonico, correoInstitucional);
		this.carrera = carrera;
		this.horaPrimeraClase = horaPrimeraClase;
		this.horaUltimaClase = horaUltimaClase;
		this.facultad = facultad;
		this.numSemestre = numSemestre;
	}

	public Estudiante(String nombre, String tipoDocumento, String numeroDocumento, short edad, long numeroTelefonico,
			String correoInstitucional) {
		super(nombre, tipoDocumento, numeroDocumento, edad, numeroTelefonico, correoInstitucional);
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public String getHoraPrimeraClase() {
		return horaPrimeraClase;
	}

	public void setHoraPrimeraClase(String horaPrimeraClase) {
		this.horaPrimeraClase = horaPrimeraClase;
	}

	public String getHoraUltimaClase() {
		return horaUltimaClase;
	}

	public void setHoraUltimaClase(String horaUltimaClase) {
		this.horaUltimaClase = horaUltimaClase;
	}

	public String getFacultad() {
		return facultad;
	}

	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}

	public int getNumSemestre() {
		return numSemestre;
	}

	public void setNumSemestre(int numSemestre) {
		this.numSemestre = numSemestre;
	}
	
	
	
	
	
	
}