package edu.ncsu.csc316.dsa.priority_queue;

import java.util.Comparator;

import edu.ncsu.csc316.dsa.list.ArrayBasedList;

/**
 * HeapPriorityQueue Class
 * 
 * @author Anisha Ponnapati
 *
 * @param <K>
 * @param <V>
 */
public class HeapPriorityQueue<K extends Comparable<K>, V> extends AbstractPriorityQueue<K, V> {

	// Remember that heaps can be easily implemented using an internal array
	// representation
	// versus a linked representation.
	/**
	 * List variable
	 */
	protected ArrayBasedList<Entry<K, V>> list;

	/**
	 * Constructor
	 * 
	 * @param comparator Comparator
	 */
	public HeapPriorityQueue(Comparator<K> comparator) {
		super(comparator);
		list = new ArrayBasedList<Entry<K, V>>();
	}

	/**
	 * Constructor
	 */
	public HeapPriorityQueue() {
		this(null);
	}

	//////////////////////////////////////////
	// ADT Operations
	//////////////////////////////////////////

	@Override
	public Entry<K, V> insert(K key, V value) {
		Entry<K, V> temp = createEntry(key, value);
		list.addLast(temp);
		upHeap(list.size() - 1);
		return temp;
	}

	@Override
	public Entry<K, V> min() {
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public Entry<K, V> deleteMin() {
		if (list.isEmpty()) {
			return null;
		}

		Entry<K, V> ans = list.get(0);
		swap(0, list.size() - 1);
		list.remove(list.size() - 1);
		downHeap(0);
		return ans;
	}

	@Override
	public int size() {
		return list.size();
	}

	/**
	 * Upheap
	 * 
	 * @param index Index
	 */
	protected void upHeap(int index) {
		while (index > 0) {
			int p = parent(index);
			if (super.compare(list.get(index).getKey(), list.get(p).getKey()) >= 0) {
				break;
			}
			swap(index, p);
			index = p;
		}
	}

	/**
	 * Swaps two nodes
	 * 
	 * @param index1 Index 1
	 * @param index2 Index 2
	 */
	protected void swap(int index1, int index2) {
		Entry<K, V> temp = list.get(index1);
		list.set(index1, list.get(index2));
		list.set(index2, temp);
	}

	/**
	 * Downheap
	 * 
	 * @param index index value
	 */
	protected void downHeap(int index) {
		while (hasLeft(index)) {
			int left = left(index);
			int child = left;
			if (hasRight(index)) {
				int right = right(index);
				if (super.compare(list.get(left).getKey(), list.get(right).getKey()) > 0) {
					child = right;
				}
			}

			if (super.compare(list.get(child).getKey(), list.get(index).getKey()) >= 0) {
				break;
			}

			swap(index, child);
			index = child;
		}
	}

	//////////////////////////////////////////////////
	// Convenience methods to help abstract the math
	// involved in jumping to parent or children
	//////////////////////////////////////////////////
	/**
	 * Parent node
	 * 
	 * @param index parent index value
	 * @return Integer value
	 */
	protected int parent(int index) {
		return (index - 1) / 2;
	}

	/**
	 * Left node
	 * 
	 * @param index left index value
	 * @return Integer value
	 */
	protected int left(int index) {
		return 2 * index + 1;
	}

	/**
	 * Right node
	 * 
	 * @param index right index value
	 * @return Integer value
	 */
	protected int right(int index) {
		return 2 * index + 2;
	}

	/**
	 * Checks if there is a left node
	 * 
	 * @param index Index of left child
	 * @return true or false
	 */
	protected boolean hasLeft(int index) {
		return left(index) < list.size();
	}

	/**
	 * Checks if there is a right node
	 * 
	 * @param index Index of right child
	 * @return true or false
	 */
	protected boolean hasRight(int index) {
		return right(index) < list.size();
	}
}
