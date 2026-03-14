package co.edu.unbosque.model;

public class Estudiante extends Persona {
	
	private String semestre;

	public Estudiante() {
		
	}
	public Estudiante(String nombre, String tipoDocumento, String numeroDocumento, String facultad, short edad,
			long numeroTelefonico, String correoInstitucional) {
		super(nombre, tipoDocumento, numeroDocumento, facultad, edad, numeroTelefonico, correoInstitucional);
	}

	public Estudiante(String nombre, String tipoDocumento, String numeroDocumento, String facultad, short edad,
			long numeroTelefonico, String correoInstitucional, String semestre) {
		super(nombre, tipoDocumento, numeroDocumento, facultad, edad, numeroTelefonico, correoInstitucional);
		this.semestre = semestre;
	}
	public String getSemestre() {
		return semestre;
	}
	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	
	
	public Estudiante(String semestre) {
		super();
		this.semestre = semestre;
	}
	@Override
	public String pagarViaje(String facultad,String semestre,int anosDeServicioUniversidad) {
		long montoAPagar=0;
		if (facultad.toLowerCase().contains("ingenieria")) {
			montoAPagar=1000;
				if(semestre.toLowerCase().contains("segundo")) {
					montoAPagar=3000;
				}else if(semestre.toLowerCase().contains("segundo")) {
				montoAPagar=6000;
				}else if(semestre.toLowerCase().contains("tercero")) {
				montoAPagar=9000;
				}else if(semestre.toLowerCase().contains("cuarto")) {
				montoAPagar=12000;
				}else if(semestre.toLowerCase().contains("quinto")) {
				montoAPagar=15000;
				}else if(semestre.toLowerCase().contains("sexto")) {
				montoAPagar=18000;
				}else if(semestre.toLowerCase().contains("septimo")) {
				montoAPagar=21000;
				}else if(semestre.toLowerCase().contains("octavo")) {
				montoAPagar=24000;
				}else if(semestre.toLowerCase().contains("noveno")) {
				montoAPagar=27000;
				}else if(semestre.toLowerCase().contains("decimo")) {
				montoAPagar=30000;
				}
			
		}else if(facultad.toLowerCase().contains("medicina")) {
			montoAPagar=20000;
			    if(semestre.toLowerCase().contains("segundo")) {
				montoAPagar=23000;
				}else if(semestre.toLowerCase().contains("segundo")) {
					montoAPagar=26000;
				}else if(semestre.toLowerCase().contains("tercero")) {
					montoAPagar=29000;
				}else if(semestre.toLowerCase().contains("cuarto")) {
					montoAPagar=32000;
				}else if(semestre.toLowerCase().contains("quinto")) {
					montoAPagar=35000;
				}else if(semestre.toLowerCase().contains("sexto")) {
					montoAPagar=38000;
				}else if(semestre.toLowerCase().contains("septimo")) {
					montoAPagar=41000;
				}else if(semestre.toLowerCase().contains("octavo")) {
					montoAPagar=44000;
				}else if(semestre.toLowerCase().contains("noveno")) {
					montoAPagar=47000;
				}else if(semestre.toLowerCase().contains("decimo")) {
					montoAPagar=50000;
				}
		}else if(facultad.toLowerCase().contains("artes")) {
			return "Viaje pagado con aplausos exitosamente.";
		}else if(facultad.toLowerCase().contains("matematicas")){
			montoAPagar=-5000;
			return "Se le debe 3000 por este viaje";
		}else {
			montoAPagar=1000;
		}
		return "El monto a pagar es: "+montoAPagar;
		
	}
	@Override
	public String toString() {
	    return "Estudiante: " +
	           "Nombre=" + getNombre() + ", " +
	           "TipoDocumento=" + getTipoDocumento() + ", " +
	           "NumeroDocumento=" + getNumeroDocumento() + ", " +
	           "Facultad=" + getFacultad() + ", " +
	           "Edad=" + getEdad() + ", " +
	           "Telefono=" + getNumeroTelefonico() + ", " +
	           "Correo=" + getCorreoInstitucional() + ", " +
	           "Semestre=" + semestre;
	}
		
	public String getTipo() {
		return "estudiante";

	}
