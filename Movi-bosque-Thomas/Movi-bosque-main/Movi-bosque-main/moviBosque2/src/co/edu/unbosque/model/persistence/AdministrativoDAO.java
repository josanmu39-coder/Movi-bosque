package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Administrativo;

public class AdministrativoDAO implements DAO<Administrativo>{
	private ArrayList<Administrativo>listaAdministrativo;
	public AdministrativoDAO() {
		listaAdministrativo = new ArrayList<>();
	}
	@Override
	public void crear(Administrativo nuevoDato) {
		listaAdministrativo.add(nuevoDato);
	}
	@Override
	public boolean eliminar(int index) {	
		if (index < 0 || index <= listaAdministrativo.size()) {
			return false;
		} else {
			listaAdministrativo.remove(index);
			return true;
		}
	}
	@Override
	public boolean actualizar(int index, Administrativo datoActualizado) {
		if (index < 0 || index <= listaAdministrativo.size()) {
			return false;
		} else {
			listaAdministrativo.set(index, datoActualizado);
			return true;
		}
	}
	@Override
	public String mostrar() {
		String datos = "";
		int posicion = 0;
		for (Administrativo a : listaAdministrativo) {
			datos += posicion + " ";
			datos += a.toString() + "\n";
			posicion++;
		}
		return datos;
	}
	@Override
	public String mostrar(int index) {
		return listaAdministrativo.get(index).toString();
	}
	@Override
	public ArrayList<Administrativo> mostrarTodo() {
		return listaAdministrativo;
	}
}