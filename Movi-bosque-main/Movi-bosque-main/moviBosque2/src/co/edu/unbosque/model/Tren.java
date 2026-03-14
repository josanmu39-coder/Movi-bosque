package co.edu.unbosque.model;

public class Tren extends Transporte{
	private int numeroVagon;
	private int numeroVagonVip;
	private boolean idaYVuelta;
	
	
	public Tren() {
	

	}
	public Tren(String ruta, int capacidadActual, int capacidadMaxima, String horaLlegada, String horaSalida,
			short numeroParadas, String parada) {
		super(ruta, capacidadActual, capacidadMaxima, horaLlegada, horaSalida, numeroParadas, parada);
		// TODO Auto-generated constructor stub
	}
	
	public Tren(int numeroVagon, int numeroVagonVip, boolean idaYVuelta) {
		super();
		this.numeroVagon = numeroVagon;
		this.numeroVagonVip = numeroVagonVip;
		this.idaYVuelta = idaYVuelta;
	}
	
	public int getNumeroVagon() {
		return numeroVagon;
	}
	public void setNumeroVagon(int numeroVagon) {
		this.numeroVagon = numeroVagon;
	}
	public int getNumeroVagonVip() {
		return numeroVagonVip;
	}
	public void setNumeroVagonVip(int numeroVagonVip) {
		this.numeroVagonVip = numeroVagonVip;
	}
	public boolean isIdaYVuelta() {
		return idaYVuelta;
	}
	public void setIdaYVuelta(boolean idaYVuelta) {
		this.idaYVuelta = idaYVuelta;
	}
	@Override
	public String toString() {
		return "Tren [numeroVagon=" + numeroVagon + ", numeroVagonVip=" + numeroVagonVip + ", idaYVuelta=" + idaYVuelta
				+ "]";
	}
	
	
	
	
}
