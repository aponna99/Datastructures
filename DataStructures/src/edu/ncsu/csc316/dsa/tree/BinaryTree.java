package edu.ncsu.csc316.dsa.tree;

import edu.ncsu.csc316.dsa.Position;

/**
 * Binary tree interface
 * 
 * @author Anisha Ponnapati
 *
 * @param <E>
 */
public interface BinaryTree<E> extends Tree<E> {
	/**
	 * Left of position
	 * 
	 * @param p Position
	 * @return Position
	 */
	Position<E> left(Position<E> p);

	/**
	 * Right of position
	 * 
	 * @param p Position
	 * @return Position
	 */
	Position<E> right(Position<E> p);

	/**
	 * Sibling of position
	 * 
	 * @param p Position
	 * @return Position
	 */
	Position<E> sibling(Position<E> p);

	/**
	 * In order traversal
	 * 
	 * @return Position
	 */
	Iterable<Position<E>> inOrder();
}
