package edu.ncsu.csc316.dsa.set;

/**
 * Set interface
 * 
 * @author Anisha Ponnapati
 *
 * @param <E>
 */
public interface Set<E> extends Iterable<E> {
	/**
	 * Add element
	 * 
	 * @param value Value
	 */
	void add(E value);

	/**
	 * Contains
	 * 
	 * @param value Value
	 * @return true or false
	 */
	boolean contains(E value);

	/**
	 * Removes element
	 * 
	 * @param value Value
	 * @return Element
	 */
	E remove(E value);

	/**
	 * Checks if set is empty
	 * 
	 * @return true or false
	 */
	boolean isEmpty();

	/**
	 * Size of set
	 * 
	 * @return Size
	 */
	int size();

	/**
	 * Adds all
	 * 
	 * @param other Other set
	 */
	void addAll(Set<E> other);

	/**
	 * Retains all
	 * 
	 * @param other Different set
	 */
	void retainAll(Set<E> other);

	/**
	 * Removes all
	 * 
	 * @param other Diff set
	 */
	void removeAll(Set<E> other);
}