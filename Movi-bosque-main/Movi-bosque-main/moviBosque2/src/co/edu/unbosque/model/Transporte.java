package co.edu.unbosque.model;

public abstract class Transporte {
	private String ruta;
	private int capacidadActual;
	private int capacidadMaxima;
	private String horaLlegada;
	private String horaSalida;
	private short numeroParada;
	private String parada;
	

	/*
	private long numeroPutas;
	private final long numeroDeTrans=100;
	private boolean vaAHaberPartido;
	*/
	
	//private String diasHabilesReserva;
	
	
	public Transporte( ) {
		
	}

	public Transporte(String ruta, int capacidadActual, int capacidadMaxima, String horaLlegada, String horaSalida,
			short numeroParadas, String parada) {
		this.ruta = ruta;
		this.capacidadActual = capacidadActual;
		this.capacidadMaxima = capacidadMaxima;
		this.horaLlegada = horaLlegada;
		this.horaSalida = horaSalida;
		this.numeroParada = numeroParada;
		this.parada = parada;
	}
	
	

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public int getCapacidadActual() {
		return capacidadActual;
	}

	public void setCapacidadActual(int capacidadActual) {
		this.capacidadActual = capacidadActual;
	}

	public int getCapacidadMaxima() {
		return capacidadMaxima;
	}

	public void setCapacidadMaxima(int capacidadMaxima) {
		this.capacidadMaxima = capacidadMaxima;
	}

	public String getHoraLlegada() {
		return horaLlegada;
	}

	public void setHoraLlegada(String horaLlegada) {
		this.horaLlegada = horaLlegada;
	}

	public String getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}

	public short getNumeroParads() {
		return numeroParada;
	}

	public void setNumeroParada(short numeroParada) {
		this.numeroParada = numeroParada;
	}

	public String getParada() {
		return parada;
	}

	public void setParada(String parada) {
		this.parada = parada;
	}
	
	
}