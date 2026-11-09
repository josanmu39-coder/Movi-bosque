package co.edu.co.unbosque.model;

public class Transporte {
	
		private String ruta;
		private int capacidadActual;
		private int capacidadMaxima;
		private String horaLlegada;
		private String horaSalida;
		private short numeroParadas;
		private String parada;
		
		public Transporte(String ruta, int capacidadActual, int capacidadMaxima, String horaLlegada, String horaSalida,
				short numeroParadas, String parada) {
			this.ruta = ruta;
			this.capacidadActual = capacidadActual;
			this.capacidadMaxima = capacidadMaxima;
			this.horaLlegada = horaLlegada;
			this.horaSalida = horaSalida;
			this.numeroParadas = numeroParadas;
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

		public short getNumeroParadas() {
			return numeroParadas;
		}

		public void setNumeroParadas(short numeroParadas) {
			this.numeroParadas = numeroParadas;
		}

		public String getParada() {
			return parada;
		}

		public void setParada(String parada) {
			this.parada = parada;
		}
		
		
	}


