package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Bus;

public class BusDAO implements DAO <Bus>{
	private ArrayList<Bus> listaBus;
	public BusDAO() {
		listaBus = new ArrayList<>();
	}

	@Override
	public void crear(Bus nuevoDato) {
		listaBus.add(nuevoDato);
	}

	@Override
	public boolean eliminar(int index) {
		if (index < 0 || index >= listaBus.size()) {
			return false;
		} else {
			listaBus.remove(index);
			return true;
		}
	}

	@Override
	public boolean actualizar(int index, Bus datoActualizado) {
		if (index < 0 || index >= listaBus.size()) {
			return false;
		} else {
			listaBus.set(index, datoActualizado);
			return true;
		}
	}

	@Override
	public String mostrar() {
		String datos = "";
		int posicion = 0;
		for (Bus b : listaBus) {
			datos += posicion + " ";
			datos += b.toString() + "\n";
			posicion++;
		}
		return datos;
	}

	@Override
	public String mostrar(int index) {	
		return listaBus.get(index).toString();
	}

	@Override
	public ArrayList<Bus> mostrarTodo() {
		return listaBus;
	}
}