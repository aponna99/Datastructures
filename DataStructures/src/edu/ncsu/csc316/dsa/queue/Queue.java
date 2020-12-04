package edu.ncsu.csc316.dsa.queue;

/**
 * Queue interface
 * 
 * @author Anisha Ponnapati
 *
 * @param <E>
 */
public interface Queue<E> {

	/**
	 * Adds element
	 * 
	 * @param value value
	 */
	void enqueue(E value);

	/**
	 * Removes the element
	 * 
	 * @return Element
	 */
	E dequeue();

	/**
	 * Gets the element
	 * 
	 * @return Element
	 */
	E front();

	/**
	 * Size of the list
	 * 
	 * @return Size
	 */
	int size();

	/**
	 * Checks if list is empty
	 * 
	 * @return True or False
	 */
	boolean isEmpty();
}