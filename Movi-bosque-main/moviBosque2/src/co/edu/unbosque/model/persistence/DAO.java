package co.edu.unbosque.model.persistence;

	import java.util.ArrayList;

	public interface DAO <E>{
		
	   //Un genérico es un dato de Java comodín, es decir, se puede convertir en cualquier cosa que se le diga
		public void crear(E nuevoDato);
		public boolean eliminar(int index);
		public boolean actualizar(int index, E datoActualizado);
		public String mostrar();
		public String mostrar(int index);
		public ArrayList<E> mostrarTodo();
		
		//El polimorfismo es la capacidad de una funcion de adecuarse a lógica
		//polimorfismo de sobrecarga: Funciones que se llaman igual pero la cantidad de atributos es diferente
		
	}


