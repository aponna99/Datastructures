package edu.ncsu.csc316.dsa.stack;

/**
 * Stack interface
 * 
 * @author Anisha Ponnapati
 *
 * @param <E>
 */
public interface Stack<E> {
	/**
	 * Adds element to top
	 * 
	 * @param value value
	 */
	void push(E value);

	/**
	 * Removes the element from top
	 * 
	 * @return value
	 */
	E pop();

	/**
	 * Gets top element
	 * 
	 * @return Element
	 */
	E top();

	/**
	 * Size of the Stack
	 * 
	 * @return Size
	 */
	int size();

	/**
	 * Checks if Stack is empty
	 * 
	 * @return True or False
	 */
	boolean isEmpty();
}
