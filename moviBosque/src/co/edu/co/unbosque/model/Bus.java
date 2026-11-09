package co.edu.co.unbosque.model;

public class Bus extends Transporte {

    private String codigoBus;
    private String empresaTransportadora;
    private String tipoServicio;
    private String categoria;
    private boolean accesibilidad;
    private String conductorAsignado;
    private boolean requiereReserva;

    public Bus(String ruta, int capacidadActual, int capacidadMaxima,
               String horaLlegada, String horaSalida,
               short numeroParadas, String parada,
               String codigoBus, String tipoServicio) {

        super(ruta, capacidadActual, capacidadMaxima,
              horaLlegada, horaSalida, numeroParadas, parada);

        this.codigoBus = codigoBus;
        this.tipoServicio = tipoServicio;
        this.empresaTransportadora = "Por asignar";
        this.categoria = "Convencional";
        this.accesibilidad = false;
        this.conductorAsignado = "Por asignar";
        this.requiereReserva = true;
    }

    public String getCodigoBus() {
        return codigoBus;
    }

    public void setCodigoBus(String codigoBus) {
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

    public boolean isAccesibilidad() {
        return accesibilidad;
    }

    public void setAccesibilidad(boolean accesibilidad) {
        this.accesibilidad = accesibilidad;
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
        return "Bus [Codigo=" + codigoBus +
               ", Tipo=" + tipoServicio +
               ", Ruta=" + getRuta() +
               ", CapacidadMaxima=" + getCapacidadMaxima() + "]";
    }
}

