package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Reserva;

public class ReservaDAO implements DAO<Reserva> {
	
	private ArrayList<Reserva> listaReservas;

	public ReservaDAO() {
		listaReservas = new ArrayList<>();
	}

	public ArrayList<Reserva> getListaReservas() {
		return listaReservas;
	}


	public void setListaReservas(ArrayList<Reserva> listaReservas) {
		this.listaReservas = listaReservas;
	}


	@Override
	public void crear(Reserva nueva) {
		listaReservas.add(nueva);
	}

	@Override
	public boolean eliminar(int index) {
		if (index < 0 || index >= listaReservas.size()) {
			return false;
		} else {
			listaReservas.get(index).cancelar(); 
			return true;
		}
	}

	@Override
	public boolean actualizar(int index, Reserva datoActualizado) {
		if (index < 0 || index >= listaReservas.size()) {
			return false;
		} else {
			listaReservas.set(index, datoActualizado);
			return true;
		}
		
	}

	@Override
	public String mostrar() {
		String datos = "";
		int posicion = 0;
		for (Reserva reserva : listaReservas) {
			datos += posicion + " " + reserva.toString() + "\n";
			posicion++;
		}
		return datos;
	}

	@Override
	public String mostrar(int index) {
		return listaReservas.get(index).toString();
	}
	
	public String mostrarReservasPorTipo(String tipo) {
        String datos = "";
        for (Reserva reserva : listaReservas) {
            if (reserva.getPersona().getTipo().equalsIgnoreCase(tipo)) {
                datos += reserva.toString() + "\n";
            }
        }
        if (datos.isEmpty()) {
            return "No hay reservas de " + tipo;
        } else {
            return datos;
        }
    }

	@Override
	public ArrayList<Reserva> mostrarTodo() {
		return listaReservas;
	}

}
