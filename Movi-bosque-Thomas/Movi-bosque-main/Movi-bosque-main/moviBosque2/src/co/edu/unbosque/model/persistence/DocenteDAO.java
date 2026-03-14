package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Docente;

public class DocenteDAO implements DAO <Docente>{
	private ArrayList<Docente> listaDocente;

	public DocenteDAO() {
		listaDocente = new ArrayList<>();
	}

	@Override
	public void crear(Docente nuevoDato) {
		listaDocente.add(nuevoDato);
	}

	@Override
	public boolean eliminar(int index) {
		
		if (index < 0 || index <= listaDocente.size()) {
			return false;
		} else {
			listaDocente.remove(index);
			return true;
		}
	}

	@Override
	public boolean actualizar(int index, Docente datoActualizado) {
		if (index < 0 || index <= listaDocente.size()) {
			return false;
		} else {
			listaDocente.set(index, datoActualizado);
			return true;
		}
	}

	@Override
	public String mostrar() {
		String datos = "";
		int posicion = 0;
		for (Docente p: listaDocente) {
			datos += posicion + " ";
			datos += p.toString() + "\n";
		}
		return datos;
	}

	@Override
	public String mostrar(int index) {
		return listaDocente.get(index).toString();
	}

	@Override
	public ArrayList<Docente> mostrarTodo() {
		return listaDocente;
	}
}