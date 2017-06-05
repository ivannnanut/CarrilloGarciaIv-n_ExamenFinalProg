package Models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


import Exceptions.ElementoIncorrectoException;

public class ListaOrdenada<T> extends ArrayList<T> {

	Comparator<T> comparador;
	
	public ListaOrdenada(Comparator<T> comparador){
		super();
		this.comparador=comparador;
	}



	public ListaOrdenada() {
		
	}


/**
 * Trata de añadir un elemento
 * @param elemento
 * @return true o false dependiendo de si se puede añadir el elemento
 */
	public boolean aniadir(T elemento) {
		if (elemento == null) {
			
				throw new ElementoIncorrectoException("Elemento no válido");
				} else {
			if (super.add(elemento)) {
				reverse();
				return true;
			}
		}
		return false;
	}

	
	/**
	 * Trata de borrar un elemento
	 * @param elemento
	 * @return true o false dependiendo si se puede borrar el elemento
	 */
	public boolean borrar(T elemento) {
		if(elemento == null){
			throw new ElementoIncorrectoException("Elemento no válido");
		}
		else{
			if(super.remove(elemento)){
				reverse();
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Cambia el orden de la vista de la salida
	 */
	public void reverse() {
		Collections.sort(this, comparador);
	}

}
