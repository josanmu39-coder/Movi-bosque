package co.edu.unbosque.model;

public class Docente extends Persona {

	public Docente() {
		
	}
	public Docente(String nombre, String tipoDocumento, String numeroDocumento, String facultad, short edad,
			long numeroTelefonico, String correoInstitucional) {
		super(nombre, tipoDocumento, numeroDocumento, facultad, edad, numeroTelefonico, correoInstitucional);
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
		return "El monto a pagar es: "+(montoAPagar-50);
	}
	public String pagarViaje(String facultad, String Semestre) {
		return "no aplica porque los docentes no tienen semestres";
	}
	@Override
	public String toString() {
		return "Docente [getNombre()=" + getNombre() + ", getTipoDocumento()=" + getTipoDocumento()
				+ ", getNumeroDocumento()=" + getNumeroDocumento() + ", getEdad()=" + getEdad()
				+ ", getNumeroTelefonico()=" + getNumeroTelefonico() + ", getCorreoInstitucional()="
				+ getCorreoInstitucional() + ", getFacultad()=" + getFacultad() + ", mostrarReservas()="
				+ mostrarReservas() + ", toString()=" + super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}
	@Override
	public String getTipo() {
		return "docente";
	}
}
