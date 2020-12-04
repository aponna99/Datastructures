package edu.ncsu.csc316.dsa.sorter;

/**
 * Interface that defines the sorting behavior
 * 
 * @author Dr. King
 * @author Anisha Ponnapati
 * 
 * @param <E>
 */
public interface Sorter<E> {

	/**
	 * Sorts everything in the list
	 * 
	 * @param list List of elements
	 */
	public void sort(E[] list);
}
