package edu.ncsu.csc316.dsa.list;

/**
 * List interface
 * 
 * @author Anisha Ponnapati
 *
 * @param <E>
 */
public interface List<E> extends Iterable<E> {
	/**
	 * Adds value to index
	 * 
	 * @param index Index
	 * @param value Value
	 */
	void add(int index, E value);

	/**
	 * Adds value to the beginning of list
	 * 
	 * @param value Value
	 */
	void addFirst(E value);

	/**
	 * Adds value to end of list
	 * 
	 * @param value Value
	 */
	void addLast(E value);

	/**
	 * Gets the first element of the list
	 * 
	 * @return Element
	 */
	E first();

	/**
	 * Gets element at index
	 * 
	 * @param index Index
	 * @return Element
	 */
	E get(int index);

	/**
	 * Checks is list is empty or not
	 * 
	 * @return boolean
	 */
	boolean isEmpty();

	/**
	 * Gets last element of the list
	 * 
	 * @return Element
	 */
	E last();

	/**
	 * Removes value at index
	 * 
	 * @param index Index
	 * @return Element
	 */
	E remove(int index);

	/**
	 * Removes first of list
	 * 
	 * @return Element
	 */
	E removeFirst();

	/**
	 * Removes last of list
	 * 
	 * @return Element
	 */
	E removeLast();

	/**
	 * Sets the value at index
	 * 
	 * @param index Index
	 * @param value Value
	 * @return Element that was set
	 */
	E set(int index, E value);

	/**
	 * Gets the size of list
	 * 
	 * @return size
	 */
	int size();
}