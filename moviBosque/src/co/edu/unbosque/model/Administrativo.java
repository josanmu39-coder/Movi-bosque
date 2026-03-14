package co.edu.unbosque.model;

public class Administrativo extends Persona{
	
	private int aniosDeExperiencia;
	
	public int getAniosDeExperiencia() {
		return aniosDeExperiencia;
	}
	public void setAniosDeExperiencia(int aniosDeExperiencia) {
		this.aniosDeExperiencia = aniosDeExperiencia;
	}
	
	public Administrativo() {
		
	}
	
	public Administrativo(int aniosDeExperiencia) {
		super();
		this.aniosDeExperiencia = aniosDeExperiencia;
	}
	
	public Administrativo(String nombre, String tipoDocumento, String numeroDocumento, String facultad, short edad,
			long numeroTelefonico, String correoInstitucional, int aniosDeExperiencia) {
		super(nombre, tipoDocumento, numeroDocumento, facultad, edad, numeroTelefonico, correoInstitucional);
		this.aniosDeExperiencia = aniosDeExperiencia;
	}
	@Override
	public String pagarViaje(String facultad,String semestre,int anosDeServicioUniversidad) {
		long montoAPagar=0;
		if (facultad.toLowerCase().contains("ingenieria")) {
			montoAPagar=1000;
		}else if(facultad.toLowerCase().contains("medicina")) {
			montoAPagar=20000;
		}else if(facultad.toLowerCase().contains("artes")) {
			return "Viaje pagado con aplausos exitosamente.";
		}else if(facultad.toLowerCase().contains("matematicas")){
			montoAPagar=-5000;
			return "Se le debe 3000 por este viaje";
		}else {
			montoAPagar=1000;
		}
		return "El monto a pagar es: "+(montoAPagar-500*anosDeServicioUniversidad);
	}
	@Override
	public String toString() {
	    return "Administrativo: " +
	           "Nombre=" + getNombre() + ", " +
	           "TipoDocumento=" + getTipoDocumento() + ", " +
	           "NumeroDocumento=" + getNumeroDocumento() + ", " +
	           "Facultad=" + getFacultad() + ", " +
	           "Edad=" + getEdad() + ", " +
	           "Telefono=" + getNumeroTelefonico() + ", " +
	           "Correo=" + getCorreoInstitucional() + ", " +
	           "AniosDeExperiencia=" + aniosDeExperiencia;
	}
}
