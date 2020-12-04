package edu.ncsu.csc316.dsa.list.positional;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.ncsu.csc316.dsa.Position;

/**
 * Positional Linked List
 * 
 * @author Anisha Ponnapati
 *
 * @param <E>
 */
public class PositionalLinkedList<E> implements PositionalList<E> {

	private PositionalNode<E> front;
	private PositionalNode<E> tail;
	private int size;

	/**
	 * Constructor
	 */
	public PositionalLinkedList() {
		front = new PositionalNode<E>(null);
		tail = new PositionalNode<E>(null, null, front);
		front.setNext(tail);
		size = 0;
	}

	@Override
	public Iterator<E> iterator() {
		return new ElementIterator(front.getNext());
	}

	@Override
	public Position<E> addAfter(Position<E> p, E value) {
		return addBetween(value, validate(p).next, validate(p));

	}

	@Override
	public Position<E> addBefore(Position<E> p, E value) {
		return addBetween(value, validate(p), validate(p).previous);
	}

	@Override
	public Position<E> addFirst(E value) {
		return addBetween(value, front.next, front);
	}

	@Override
	public Position<E> addLast(E value) {
		return addBetween(value, tail, tail.previous);
	}

	@Override
	public Position<E> after(Position<E> p) {
		PositionalNode<E> pp = validate(p);

		if (pp.next.getElement() == null) {
			throw new NoSuchElementException();

		} else {
			return pp.next;
		}
	}

	@Override
	public Position<E> before(Position<E> p) {
		PositionalNode<E> pp = validate(p);

		if (pp.previous.getElement() == null) {
			throw new NoSuchElementException();
		} else {
			return pp.previous;
		}
	}

	@Override
	public Position<E> first() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}

		return front.next;
	}

	@Override
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}

		return false;
	}

	@Override
	public Position<E> last() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}

		return tail.previous;
	}

	@Override
	public Iterable<Position<E>> positions() {
		return new PositionIterable();
	}

	@Override
	public E remove(Position<E> p) {
		PositionalNode<E> pp = validate(p);
		E temp = pp.element;

		pp.previous.next = pp.next;
		pp.next.previous = pp.previous;
		size--;
		return temp;
	}

	@Override
	public E set(Position<E> p, E value) {
		E temp = validate(p).element;
		validate(p).setElement(value);

		return temp;
	}

	@Override
	public int size() {
		return size;
	}

	private PositionalNode<E> validate(Position<E> p) {
		if (p instanceof PositionalNode) {
			return (PositionalNode<E>) p;
		}
		throw new IllegalArgumentException("Position is not a valid positional list node.");
	}

	private Position<E> addBetween(E value, PositionalNode<E> next, PositionalNode<E> prev) {
		PositionalNode<E> temp = new PositionalNode<E>(value, next, prev);
		prev.next = temp;
		next.previous = temp;
		size++;
		return temp;
	}

	/**
	 * Positional Node
	 * 
	 * @author Anisha Ponnapti
	 *
	 * @param <E>
	 */
	private static class PositionalNode<E> implements Position<E> {

		private E element;
		private PositionalNode<E> next;
		private PositionalNode<E> previous;

		/**
		 * Constructor
		 * 
		 * @param value Value
		 */
		public PositionalNode(E value) {
			this(value, null);
		}

		/**
		 * Constructor
		 * 
		 * @param value Value
		 * @param next  next
		 */
		public PositionalNode(E value, PositionalNode<E> next) {
			this(value, next, null);
		}

		/**
		 * Constructor
		 * 
		 * @param value Value
		 * @param next  next
		 * @param prev  previous node
		 */
		public PositionalNode(E value, PositionalNode<E> next, PositionalNode<E> prev) {
			setElement(value);
			setNext(next);
			setPrevious(prev);
		}

		/**
		 * Sets node to previous
		 * 
		 * @param prev Previous
		 */
		public void setPrevious(PositionalNode<E> prev) {
			previous = prev;
		}

		/**
		 * Gets previous
		 * 
		 * @return Node
		 */
		@SuppressWarnings("unused")
		public PositionalNode<E> getPrevious() {
			return previous;
		}

		/**
		 * Sets next
		 * 
		 * @param next next
		 */
		public void setNext(PositionalNode<E> next) {
			this.next = next;
		}

		/**
		 * Get next
		 * 
		 * @return next node
		 */
		public PositionalNode<E> getNext() {
			return next;
		}

		@Override
		public E getElement() {
			return element;
		}

		/**
		 * Sets element
		 * 
		 * @param element element
		 */
		public void setElement(E element) {
			this.element = element;
		}
	}

	/**
	 * Position Iterator
	 * 
	 * @author Anisha Ponnapati
	 *
	 */
	private class PositionIterator implements Iterator<Position<E>> {

		private Position<E> current;
		private boolean removeOK;

		/**
		 * Constructor
		 * 
		 * @param start start
		 */
		public PositionIterator(PositionalNode<E> start) {
			current = start;
			removeOK = false;
		}

		@Override
		public boolean hasNext() {
			return current.getElement() != null;
		}

		@Override
		public Position<E> next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			Position<E> temp = current;
			removeOK = true;
			current = validate(current).next;
			return temp;

		}

		@Override
		public void remove() {
			if (!removeOK) {
				throw new IllegalStateException();
			}
			PositionalLinkedList.this.remove(validate(current).previous);
			removeOK = false;

		}
	}

	/**
	 * Element Iterator
	 * 
	 * @author Anisha Ponnapati
	 *
	 */
	private class ElementIterator implements Iterator<E> {

		private Iterator<Position<E>> it;

		/**
		 * Constructor
		 * 
		 * @param start start
		 */
		public ElementIterator(PositionalNode<E> start) {
			it = new PositionIterator(start);
		}

		@Override
		public boolean hasNext() {
			return it.hasNext();
		}

		@Override
		public E next() {
			return it.next().getElement();
		}

		@Override
		public void remove() {
			it.remove();
		}
	}

	/**
	 * Position Iterable
	 * 
	 * @author Anisha Ponnapati
	 *
	 */
	private class PositionIterable implements Iterable<Position<E>> {

		@Override
		public Iterator<Position<E>> iterator() {
			return new PositionIterator(front.getNext());
		}
	}
}