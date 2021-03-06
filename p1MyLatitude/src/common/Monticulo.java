/**
 * @author Pablo Lanaspa e Ismael Rodriguez
 * 
 * Clase que implementa un monticulo o heap para la ejecucion mas eficiente de la
 * aplicacion.
 */
package common;

import java.util.PriorityQueue;

public class Monticulo <T extends Placeable> extends PriorityQueue <T> 
			implements InterfazCercanos<T> {

	private int capacidad; 	// Capacidad maxima del vector
	private int num; 		// Numero de elementos almacenados actualmente

	public Monticulo(T ref, int capacidad) {
		super(capacidad,new ComparadorPlaceables(ref));
		this.capacidad = capacidad;
		num=0;
	}
	
	@Override
	public boolean add(T e){
	
		if (num<capacidad) {
			num++;
			return super.add(e);
		}
		else{
			if (this.comparator().compare(e, this.element()) > 0){
				//Lo anade
				this.remove();
				return super.add(e);
			}
			else return false;
		}
	}
	
	

}
