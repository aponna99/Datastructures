package edu.ncsu.csc316.dsa.queue;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Array based queue
 * 
 * @author Anisha Ponnapati
 *
 * @param <E>
 */
public class ArrayBasedQueue<E> extends AbstractQueue<E> {

	private E[] data;
	private int front;
	private int rear;
	private int size;

	private static final int DEFAULT_CAPACITY = 10;

	/**
	 * Constructor
	 * 
	 * @param initialCapacity Capacity
	 */
	@SuppressWarnings("unchecked")
	public ArrayBasedQueue(int initialCapacity) {
		data = (E[]) (new Object[initialCapacity]);
		size = 0;
		front = 0;
		rear = 0;
	}

	/**
	 * Constructor
	 */
	public ArrayBasedQueue() {
		this(DEFAULT_CAPACITY);
	}

	@Override
	public void enqueue(E value) {
		if (size == data.length) {
			ensureCapacity(size + 1);
		}

		data[rear] = value;
		rear = (rear + 1) % data.length;
		size++;

	}

	@Override
	public E dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}

		E answer = data[front];
		data[front] = null;
		front = (front + 1) % data.length;
		size--;

		return answer;
	}

	@Override
	public E front() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}

		return data[front];
	}

	@Override
	public int size() {
		return size;
	}

	private void ensureCapacity(int size) {
		int cap = data.length;
		int capC;
		if (size > cap) {
			capC = (cap * 2) + 1;
			if (capC < size) {
				capC = size;
			}
			data = Arrays.copyOf(data, capC);
		}
	}
}
