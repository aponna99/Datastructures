package edu.ncsu.csc316.dsa.tree;

import edu.ncsu.csc316.dsa.Position;

/**
 * General tree interface
 * 
 * @author Anisha Ponnapati
 *
 * @param <E>
 */
public interface GeneralTreeCollection<E> extends Tree<E>, Iterable<E> {
	/**
	 * Adds value to root
	 * 
	 * @param value Value
	 * @return Position
	 */
	Position<E> addRoot(E value);

	/**
	 * Adds value at the position
	 * 
	 * @param p     Position
	 * @param value Element
	 * @return Adds child
	 */
	Position<E> addChild(Position<E> p, E value);

	/**
	 * Removes position
	 * 
	 * @param p Position
	 * @return Element that was removed
	 */
	E remove(Position<E> p);

	/**
	 * Sets a value at the given position
	 * 
	 * @param p     position
	 * @param value value
	 * @return element was set
	 */
	E set(Position<E> p, E value);
}