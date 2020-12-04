package edu.ncsu.csc316.dsa.list.positional;

import edu.ncsu.csc316.dsa.Position;

/**
 * Positional List interface
 * 
 * @author Anisha Ponnapati
 *
 * @param <E>
 */
public interface PositionalList<E> extends Iterable<E> {

	/**
	 * Adds after given position.
	 * 
	 * @param p     position
	 * @param value value
	 * @return position.
	 */
	Position<E> addAfter(Position<E> p, E value);

	/**
	 * Adds before given position.
	 * 
	 * @param p     position
	 * @param value value
	 * @return position.
	 */
	Position<E> addBefore(Position<E> p, E value);

	/**
	 * Adds in the beginning
	 * 
	 * @param value value
	 * @return the added position
	 */
	Position<E> addFirst(E value);

	/**
	 * Adds in the end
	 * 
	 * @param value value
	 * @return the added position
	 */
	Position<E> addLast(E value);

	/**
	 * position after a given position.
	 * 
	 * @param p the position
	 * @return the position after
	 */
	Position<E> after(Position<E> p);

	/**
	 * position before a given position.
	 * 
	 * @param p the position
	 * @return the position before
	 */
	Position<E> before(Position<E> p);

	/**
	 * Returns first element
	 * 
	 * @return the first element
	 */
	Position<E> first();

	/**
	 * Checks if the list is empty.
	 * 
	 * @return boolean
	 */
	boolean isEmpty();

	/**
	 * Returns last element
	 * 
	 * @return the last element
	 */
	Position<E> last();

	/**
	 * Iterable
	 * 
	 * @return the list
	 */
	Iterable<Position<E>> positions();

	/**
	 * Remove a given position.
	 * 
	 * @param p the position
	 * @return element
	 */
	E remove(Position<E> p);

	/**
	 * Set the element of a given position.
	 * 
	 * @param p     the position to set at
	 * @param value the value to set
	 * @return the replaced element
	 */
	E set(Position<E> p, E value);

	/**
	 * Returns the size of the list.
	 * 
	 * @return size
	 */
	int size();
}
