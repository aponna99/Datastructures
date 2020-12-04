package edu.ncsu.csc316.dsa.list;

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * Singly Linked List
 * 
 * @author Anisha Ponnapati
 *
 * @param <E>
 */
public class SinglyLinkedList<E> extends AbstractList<E> {

	private LinkedListNode<E> front;
	private LinkedListNode<E> tail;

	private int size;

	/**
	 * Constructor
	 */
	public SinglyLinkedList() {
		front = new LinkedListNode<E>(null);
		tail = null;
		size = 0;
	}

	@Override
	public void add(int index, E value) {
		checkIndexForAdd(index);

		LinkedListNode<E> head = front;
		for (int i = 0; i < index; i++) {
			head = head.getNext();
		}

		if (head.getNext() == null) {
			head.next = new LinkedListNode<E>(value);
			tail = head.next;
		} else {
			head.setNext(new LinkedListNode<E>(value, head.getNext()));

		}

		size++;
	}

	@Override
	public E get(int index) {
		checkIndex(index);
		LinkedListNode<E> head = front.next;

		for (int i = 0; i < index; i++) {
			head = head.next;
		}
		return head.data;
	}

	@Override
	public E remove(int index) {
		checkIndex(index);
		E temp;
		LinkedListNode<E> head = front;
		for (int i = 0; i < index; i++) {
			head = head.next;
		}

		temp = head.next.data;
		head.next = head.next.next;

		if (head.next == null) {
			tail = head.next;
		}
		size--;

		return temp;
	}

	@Override
	public E set(int index, E value) {
		checkIndex(index);
		LinkedListNode<E> head = front;
		for (int i = 0; i < index; i++) {
			head = head.next;
		}

		E element = head.next.data;
		head.getNext().setElement(value);
		return element;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public E last() {
		return tail.getElement();
	}

	@Override
	public void addLast(E value) {
		LinkedListNode<E> newTail = new LinkedListNode<E>(value);
		if (isEmpty()) {
			front = newTail;
		}

		if (tail != null) {
			tail.setNext(newTail);
			tail = newTail;
			size++;

		} else {
			super.addLast(value);
		}

	}

	@Override
	public Iterator<E> iterator() {
		return new ElementIterator(front.getNext());
	}

	/**
	 * Linked list node
	 * 
	 * @author Anisha Ponnapati
	 *
	 * @param <E>
	 */
	private static class LinkedListNode<E> {

		private E data;
		private LinkedListNode<E> next;

		/**
		 * Constructor
		 * 
		 * @param data Data
		 */
		public LinkedListNode(E data) {
			this.data = data;
			this.next = null;
		}

		/**
		 * Constructor with next
		 * 
		 * @param data data
		 * @param next next
		 */
		public LinkedListNode(E data, LinkedListNode<E> next) {
			this.data = data;
			this.next = next;
		}

		/**
		 * Gets next
		 * 
		 * @return Node
		 */
		public LinkedListNode<E> getNext() {
			return next;
		}

		/**
		 * Gets element
		 * 
		 * @return Element
		 */
		public E getElement() {
			return data;
		}

		/**
		 * Sets next
		 * 
		 * @param next Next
		 */
		public void setNext(LinkedListNode<E> next) {
			this.next = next;
		}

		/**
		 * Sets element
		 * 
		 * @param data Data
		 */
		public void setElement(E data) {
			this.data = data;
		}
	}

	/**
	 * Iterator class
	 * 
	 * @author Anisha Ponnapati
	 *
	 */
	private class ElementIterator implements Iterator<E> {

		private LinkedListNode<E> current;
		private LinkedListNode<E> previous;
		private LinkedListNode<E> previousPrevious;
		private boolean removeOK;

		/**
		 * Constructor
		 * 
		 * @param start Beginning
		 */
		public ElementIterator(LinkedListNode<E> start) {
			current = start;
			previous = front;
			previousPrevious = front;
			removeOK = false;
		}

		/**
		 * Checks if has next
		 * 
		 * @return boolean
		 */
		public boolean hasNext() {

			return current != null;
		}

		/**
		 * Next element
		 * 
		 * @return Element
		 */
		public E next() {
			if (!hasNext())
				throw new NoSuchElementException();

			E temp = current.data;
			previousPrevious = previous;
			previous = current;
			current = current.next;

			removeOK = true;

			return temp;
		}

		/**
		 * Remove
		 */
		public void remove() {
			if (!removeOK) {
				throw new IllegalStateException();
			}

			previousPrevious.next = current;
			previous = previousPrevious;

			removeOK = false;
			size--;
		}
	}
}