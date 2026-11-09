package co.edu.unbosque.model;

public class Tren extends Transporte{
	private short numeroVagones;
	private short numeroVagonesVIP;
	private String idaOVuelta;
	public Tren() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tren(String ruta, int capacidadActual, int capacidadMaxima, String horaLlegada, String horaSalida,
			short numeroParadas, String parada) {
		super(ruta, capacidadActual, capacidadMaxima, horaLlegada, horaSalida, numeroParadas, parada);
		// TODO Auto-generated constructor stub
	}
	public Tren(short numeroVagones, short numeroVagonesVIP, String idaOVuelta) {
		super();
		this.numeroVagones = numeroVagones;
		this.numeroVagonesVIP = numeroVagonesVIP;
		this.idaOVuelta = idaOVuelta;
	}
	
}
