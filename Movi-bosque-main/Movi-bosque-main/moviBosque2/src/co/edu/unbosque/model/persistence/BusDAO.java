package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Bus;

public class BusDAO implements DAO <Bus>{

	private ArrayList<Bus> listaBuses;

	public BusDAO() {
		listaBuses = new ArrayList<>();
	}

	@Override
	public void crear(Bus nuevoDato) {
		listaBuses.add(nuevoDato);
	}

	@Override
	public boolean eliminar(int index) {
		if (index < 0 || index >= listaBuses.size()) {
			return false;
		} else {
			listaBuses.remove(index);
			return true;
		}
	}

	@Override
	public boolean actualizar(int index, Bus datoActualizado) {
		if (index < 0 || index >= listaBuses.size()) {
			return false;
		} else {
			listaBuses.set(index, datoActualizado);
			return true;
		}
	}

	@Override
	public String mostrar() {
		String datos = "";
		int posicion = 0;
		for (Bus b : listaBuses) {
			datos += posicion + " ";
			datos += b.toString() + "\n";
			posicion++;
		}
		return datos;
	}

	@Override
	public String mostrar(int index) {	
		return listaBuses.get(index).toString();
	}

	@Override
	public ArrayList<Bus> mostrarTodo() {
		return listaBuses;
	}
}