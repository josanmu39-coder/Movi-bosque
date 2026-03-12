package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import co.edu.unbosque.model.Tren;

public class TrenDAO implements DAO<Tren>{

	ArrayList<Tren> listaTrenes;
	
	public TrenDAO() {
		listaTrenes = new ArrayList<>();
	}

	@Override
	public void crear(Tren nuevoDato) {
		listaTrenes.add(nuevoDato);
	}

	@Override
	public boolean eliminar(int index) {
		if(index<0||index<=listaTrenes.size()) {
			return false;
		}else {
			listaTrenes.remove(index);
			return true;
		}
	}

	@Override
	public boolean actualizar(int index, Tren datoActualizado) {
		if(index<0||index<=listaTrenes.size()) {
			return false;
		}else {
			listaTrenes.set(index, datoActualizado);
			return true;
		}
	}

	@Override
	public String mostrar() {
		String datos="";
		int posicion=0;
		for (Tren p : listaTrenes) {
			datos+=posicion+" ";
			datos+=p.toString()+"\n";
			posicion++;
		}
		return datos;
	}

	@Override
	public String mostrar(int index) {
		return listaTrenes.get(index).toString();
	}

	@Override
	public ArrayList<Tren> mostrarTodo() {
		return listaTrenes;
	}
}
