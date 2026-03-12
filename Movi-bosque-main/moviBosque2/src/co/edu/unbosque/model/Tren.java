package co.edu.unbosque.model;

public class Tren extends Transporte{
	private int numeroVagones;
	private int numeroVagonesVIP;
	private boolean idaOVuelta;
	public Tren() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tren(String ruta, int capacidadActual, int capacidadMaxima, String horaLlegada, String horaSalida,
			short numeroParadas, String parada) {
		super(ruta, capacidadActual, capacidadMaxima, horaLlegada, horaSalida, numeroParadas, parada);
		// TODO Auto-generated constructor stub
	}
	public Tren(int numeroVagones, int numeroVagonesVIP, boolean idaOVuelta) {
		super();
		this.numeroVagones = numeroVagones;
		this.numeroVagonesVIP = numeroVagonesVIP;
		this.idaOVuelta = idaOVuelta;
	}
	public int getNumeroVagones() {
		return numeroVagones;
	}
	public void setNumeroVagones(int numeroVagones) {
		this.numeroVagones = numeroVagones;
	}
	public int getNumeroVagonesVIP() {
		return numeroVagonesVIP;
	}
	public void setNumeroVagonesVIP(int numeroVagonesVIP) {
		this.numeroVagonesVIP = numeroVagonesVIP;
	}
	public boolean isIdaOVuelta() {
		return idaOVuelta;
	}
	public void setIdaOVuelta(boolean idaOVuelta) {
		this.idaOVuelta = idaOVuelta;
	}
	
}
