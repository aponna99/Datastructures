package edu.ncsu.csc316.dsa.tree;

import edu.ncsu.csc316.dsa.Position;

/**
 * Binary Tree Collection interface
 * 
 * @author Anisha Ponnapati
 *
 * @param <E>
 */
public interface BinaryTreeCollection<E> extends BinaryTree<E>, Iterable<E> {
	/**
	 * Add values to root
	 * 
	 * @param value Value
	 * @return Position
	 */
	Position<E> addRoot(E value);

	/**
	 * Add element to the left
	 * 
	 * @param p     Position
	 * @param value Value
	 * @return Position
	 */
	Position<E> addLeft(Position<E> p, E value);

	/**
	 * Add element to the right
	 * 
	 * @param p     Position
	 * @param value Value
	 * @return Position
	 */
	Position<E> addRight(Position<E> p, E value);

	/**
	 * Removes position
	 * 
	 * @param p Position
	 * @return Element
	 */
	E remove(Position<E> p);

	/**
	 * Sets value in the position
	 * 
	 * @param p     Position
	 * @param value Value
	 * @return Element
	 */
	E set(Position<E> p, E value);
}
