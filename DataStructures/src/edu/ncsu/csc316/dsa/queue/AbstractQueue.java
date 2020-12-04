package edu.ncsu.csc316.dsa.queue;

/**
 * Abstract queue
 * 
 * @author Anisha Ponnapati
 *
 * @param <E>
 */
public abstract class AbstractQueue<E> implements Queue<E> {

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}
}
