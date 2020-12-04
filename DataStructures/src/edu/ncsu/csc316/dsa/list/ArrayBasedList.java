package edu.ncsu.csc316.dsa.list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Array based list
 * 
 * @author Ansiha Ponnapati
 *
 * @param <E>
 */
public class ArrayBasedList<E> extends AbstractList<E> {

	private final static int DEFAULT_CAPACITY = 10;
	private E[] data;

	private int size;

	/**
	 * Constructor
	 */
	public ArrayBasedList() {
		this(DEFAULT_CAPACITY);
	}

	/**
	 * Constructor
	 * 
	 * @param capacity Capacity of list
	 */
	@SuppressWarnings("unchecked")
	public ArrayBasedList(int capacity) {
		data = (E[]) (new Object[capacity]);
		size = 0;
	}

	@Override
	public void add(int index, E value) {
		checkIndexForAdd(index);
		ensureCapacity(size + 1);

		for (int i = size; i > index; --i)
			data[i] = data[i - 1];

		data[index] = value;
		size++;
	}

	@Override
	public E get(int index) {
		checkIndex(index);

		return data[index];
	}

	@Override
	public E remove(int index) {
		if (index >= size) {
			throw new IndexOutOfBoundsException();
		}

		E temp = data[index];
		for (int i = index; i < size - 1; i++) {
			data[i] = data[i + 1];
		}

		data[--size] = null;
		return temp;
	}

	@Override
	public E set(int index, E value) {
		checkIndex(index);

		E temp = data[index];
		data[index] = value;
		return temp;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Iterator<E> iterator() {
		return new ElementIterator();
	}

	private void ensureCapacity(int minCapacity) {
		int oldCapacity = data.length;
		if (minCapacity > oldCapacity) {
			int newCapacity = (oldCapacity * 2) + 1;
			if (newCapacity < minCapacity) {
				newCapacity = minCapacity;
			}
			data = Arrays.copyOf(data, newCapacity);
		}
	}

	/**
	 * Iterator class
	 * 
	 * @author Anisha Ponnapati
	 *
	 */
	private class ElementIterator implements Iterator<E> {
		private int position;
		private boolean removeOK;

		/**
		 * Constructor
		 */
		public ElementIterator() {
			position = 0;
			removeOK = false;
		}

		/**
		 * Checks if there is a next element
		 * 
		 * @return boolean
		 */
		public boolean hasNext() {
			return position < size;
		}

		/**
		 * Gets next element
		 * 
		 * @return Element
		 */
		public E next() {
			if (!hasNext())
				throw new NoSuchElementException();

			removeOK = true;
			return data[position++];
		}

		/**
		 * Removes
		 */
		public void remove() {
			if (!removeOK) {
				throw new IllegalStateException();
			}

			ArrayBasedList.this.remove(position - 1);
			position--;
			removeOK = false;
		}
	}
}