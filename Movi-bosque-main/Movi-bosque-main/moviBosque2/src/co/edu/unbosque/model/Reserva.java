package co.edu.unbosque.model;

public class Reserva {
	private String numReserva;
	private Persona persona;
	private Transporte transporte;
	private String fecha;
	private boolean estaActiva;

	public Reserva(String numReserva, Persona persona, Transporte transporte, String fecha, boolean esActiva) {
		super();
		this.numReserva = numReserva;
		this.persona = persona;
		this.transporte = transporte;
		this.fecha = fecha;
		this.estaActiva = true;
	}

	public void cancelar() {
	    this.estaActiva = false;
	}
	
	public String getNumReserva() {
		return numReserva;
	}

	public void setNumReserva(String numReserva) {
		this.numReserva = numReserva;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setEstudiante(Persona persona) {
		this.persona = persona;
	}

	public Transporte getTransporte() {
		return transporte;
	}

	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public boolean isEstaActiva() {
		return estaActiva;
	}

	public void setEstaActiva(boolean estaActiva) {
		this.estaActiva = estaActiva;
	}

	@Override
	public String toString() {
		return "Reserva [numReserva=" + numReserva + ", estudiante=" + persona + ", transporte=" + transporte
				+ ", fecha=" + fecha + ", estaActiva=" + estaActiva + "]";
	}

}
