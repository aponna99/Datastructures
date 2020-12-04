package edu.ncsu.csc316.dsa.stack;

/**
 * Abstract stack class
 * 
 * @author Anisha Ponnapati
 *
 * @param <E>
 */
public abstract class AbstractStack<E> implements Stack<E> {
	@Override
	public boolean isEmpty() {
		return size() == 0;
	}
}