package edu.ncsu.csc316.dsa.stack;

import java.util.EmptyStackException;

import edu.ncsu.csc316.dsa.list.SinglyLinkedList;

/**
 * Linked Stack
 * 
 * @author Anisha Ponnapati
 *
 * @param <E>
 */
public class LinkedStack<E> extends AbstractStack<E> {

	private SinglyLinkedList<E> list;

	/**
	 * Constructor
	 */
	public LinkedStack() {
		list = new SinglyLinkedList<E>();
	}

	@Override
	public void push(E value) {
		list.addFirst(value);
	}

	@Override
	public E pop() {
		if (list.isEmpty()) {
			throw new EmptyStackException();
		}
		return list.removeFirst();
	}

	@Override
	public E top() {
		if (list.isEmpty()) {
			throw new EmptyStackException();
		}
		return list.first();
	}

	@Override
	public int size() {
		return list.size();
	}

}