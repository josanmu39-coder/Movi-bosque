
	package co.edu.unbosque.model;

	public class Reserva {
		private String numReserva;
		private Estudiante estudiante;
		private Transporte transporte;
		private String fecha;
		private boolean estaActiva;
		
		public Reserva(String numReserva, Estudiante estudiante, Transporte transporte, String fecha, boolean esActiva) {
			super();
			this.numReserva = numReserva;
			this.estudiante = estudiante;
			this.transporte = transporte;
			this.fecha = fecha;
			this.estaActiva = true;
		}
		

		public String getNumReserva() {
			return numReserva;
		}

		public void setNumReserva(String numReserva) {
			this.numReserva = numReserva;
		}

		public Estudiante getEstudiante() {
			return estudiante;
		}

		public void setEstudiante(Estudiante estudiante) {
			this.estudiante = estudiante;
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
			return "Reserva [numReserva=" + numReserva + ", estudiante=" + estudiante + ", transporte=" + transporte
					+ ", fecha=" + fecha + ", estaActiva=" + estaActiva + "]";
		}

	}


