package co.edu.unbosque.model;

public class Bus extends Transporte {

	private int codigoBus;
	private String empresaTransportadora;
	private String tipoServicio;
	private String categoria;
	private boolean estaDisponible;
	private String conductorAsignado;
	private boolean requiereReserva;
	
	public Bus() {
	}
	
	public Bus(int codigoBus, String empresaTransportadora, String tipoServicio, String categoria,
			boolean estaDisponible, String conductorAsignado, boolean requiereReserva) {
		super();
		this.codigoBus = codigoBus;
		this.empresaTransportadora = empresaTransportadora;
		this.tipoServicio = tipoServicio;
		this.categoria = categoria;
		this.estaDisponible = estaDisponible;
		this.conductorAsignado = conductorAsignado;
		this.requiereReserva = requiereReserva;
	}
	
	public Bus(String ruta, int capacidadActual, int capacidadMaxima, String horaLlegada, String horaSalida,
			short numeroParadas, String parada, int codigoBus, String empresaTransportadora, String tipoServicio,
			String categoria, boolean estaDisponible, String conductorAsignado, boolean requiereReserva) {
		super(ruta, capacidadActual, capacidadMaxima, horaLlegada, horaSalida, numeroParadas, parada);
		this.codigoBus = codigoBus;
		this.empresaTransportadora = empresaTransportadora;
		this.tipoServicio = tipoServicio;
		this.categoria = categoria;
		this.estaDisponible = estaDisponible;
		this.conductorAsignado = conductorAsignado;
		this.requiereReserva = requiereReserva;
	}

	public Bus(String ruta, int capacidadActual, int capacidadMaxima, String horaLlegada, String horaSalida,
			short numeroParadas, String parada) {
		super(ruta, capacidadActual, capacidadMaxima, horaLlegada, horaSalida, numeroParadas, parada);
	}

	public int getCodigoBus() {
		return codigoBus;
	}

	public void setCodigoBus(int codigoBus) {
		this.codigoBus = codigoBus;
	}

	public String getEmpresaTransportadora() {
		return empresaTransportadora;
	}

	public void setEmpresaTransportadora(String empresaTransportadora) {
		this.empresaTransportadora = empresaTransportadora;
	}

	public String getTipoServicio() {
		return tipoServicio;
	}

	public void setTipoServicio(String tipoServicio) {
		this.tipoServicio = tipoServicio;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public boolean isEstaDisponible() {
		return estaDisponible;
	}

	public void setEstaDisponible(boolean estaDisponible) {
		this.estaDisponible = estaDisponible;
	}

	public String getConductorAsignado() {
		return conductorAsignado;
	}

	public void setConductorAsignado(String conductorAsignado) {
		this.conductorAsignado = conductorAsignado;
	}

	public boolean isRequiereReserva() {
		return requiereReserva;
	}

	public void setRequiereReserva(boolean requiereReserva) {
		this.requiereReserva = requiereReserva;
	}

	@Override
	public String toString() {
		return "Bus [codigoBus=" + codigoBus + ", empresaTransportadora=" + empresaTransportadora + ", tipoServicio="
				+ tipoServicio + ", categoria=" + categoria + ", estaDisponible=" + estaDisponible
				+ ", conductorAsignado=" + conductorAsignado + ", requiereReserva=" + requiereReserva + "]";
	}

	
}