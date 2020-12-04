package edu.ncsu.csc316.dsa.tree;

import edu.ncsu.csc316.dsa.Position;

/**
 * Tree interface
 * 
 * @author Anisha Ponnapati
 *
 * @param <E>
 */
public interface Tree<E> {

	/**
	 * Position of the root
	 * 
	 * @return Position
	 */
	Position<E> root();

	/**
	 * Position of the parent
	 * 
	 * @param p parent
	 * @return Position
	 */
	Position<E> parent(Position<E> p);

	/**
	 * Position of the children
	 * 
	 * @param p parent
	 * @return Position
	 */
	Iterable<Position<E>> children(Position<E> p);

	/**
	 * Number of children of the parent
	 * 
	 * @param p Parent
	 * @return Number of children
	 */
	int numChildren(Position<E> p);

	/**
	 * Checks if node is internal
	 * 
	 * @param p node
	 * @return Is it internal or not
	 */
	boolean isInternal(Position<E> p);

	/**
	 * Checks if node is leaf
	 * 
	 * @param p node
	 * @return Is it leaf or not
	 */
	boolean isLeaf(Position<E> p);

	/**
	 * Checks if node is the root
	 * 
	 * @param p node
	 * @return Is it the root or not
	 */
	boolean isRoot(Position<E> p);

	/**
	 * Size of the tree
	 * 
	 * @return Size
	 */
	int size();

	/**
	 * Checks if tree is empty
	 * 
	 * @return Boolean value
	 */
	boolean isEmpty();

	/**
	 * Pre order tree
	 * 
	 * @return Iterable
	 */
	Iterable<Position<E>> preOrder();

	/**
	 * Post order tree
	 * 
	 * @return Iterable
	 */
	Iterable<Position<E>> postOrder();

	/**
	 * Level order tree
	 * 
	 * @return Iterable
	 */
	Iterable<Position<E>> levelOrder();
}