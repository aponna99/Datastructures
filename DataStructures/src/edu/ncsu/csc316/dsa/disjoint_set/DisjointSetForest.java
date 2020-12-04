package edu.ncsu.csc316.dsa.disjoint_set;

import edu.ncsu.csc316.dsa.Position;

/**
 * DSF Interface
 * 
 * @author Anisha Ponnapati
 *
 * @param <E>
 */
public interface DisjointSetForest<E> {

	/**
	 * Makes the set
	 * 
	 * @param value Value
	 * @return Position
	 */
	Position<E> makeSet(E value);

	/**
	 * Finds element
	 * 
	 * @param value Value
	 * @return Position
	 */
	Position<E> find(E value);

	/**
	 * Union Method
	 * 
	 * @param s S
	 * @param t T
	 */
	void union(Position<E> s, Position<E> t);

}