package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import co.edu.unbosque.model.Tren;

public class TrenDAO implements DAO<Tren>{

	ArrayList<Tren> listaTren;
	
	public TrenDAO() {
		listaTren = new ArrayList<>();
	}

	@Override
	public void crear(Tren nuevoDato) {
		listaTren.add(nuevoDato);
	}

	@Override
	public boolean eliminar(int index) {
		if(index<0||index<=listaTren.size()) {
			return false;
		}else {
			listaTren.remove(index);
			return true;
		}
	}

	@Override
	public boolean actualizar(int index, Tren datoActualizado) {
		if(index<0||index<=listaTren.size()) {
			return false;
		}else {
			listaTren.set(index, datoActualizado);
			return true;
		}
	}

	@Override
	public String mostrar() {
		String datos="";
		int posicion=0;
		for (Tren p : listaTren) {
			datos+=posicion+" ";
			datos+=p.toString()+"\n";
		}
		return datos;
	}

	@Override
	public String mostrar(int index) {
		return listaTren.get(index).toString();
	}

	@Override
	public ArrayList<Tren> mostrarTodo() {
		return listaTren;
	}
}
