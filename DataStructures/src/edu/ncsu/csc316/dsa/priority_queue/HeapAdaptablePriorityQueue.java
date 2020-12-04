package edu.ncsu.csc316.dsa.priority_queue;

import java.util.Comparator;

/**
 * HeapAdaptablePriorityQueue
 * 
 * @author Anisha Ponnapati
 *
 * @param <K>
 * @param <V>
 */
public class HeapAdaptablePriorityQueue<K extends Comparable<K>, V> extends HeapPriorityQueue<K, V>
		implements AdaptablePriorityQueue<K, V> {

	// Adaptable PQ Entries must be location-aware so that the
	// performance of replaceKey, replaceValue, and remove are O(log n)
	/**
	 * Inner Class
	 * 
	 * @author Anisha Ponnapati
	 *
	 * @param <K>
	 * @param <V>
	 */
	public static class AdaptablePQEntry<K, V> extends PQEntry<K, V> {

		private int index;

		/**
		 * Constructor
		 * 
		 * @param key   Key
		 * @param value Value
		 * @param index Index
		 */
		public AdaptablePQEntry(K key, V value, int index) {
			super(key, value);
			setIndex(index);
		}

		/**
		 * Gets index
		 * 
		 * @return index
		 */
		public int getIndex() {
			return index;
		}

		/**
		 * Sets index
		 * 
		 * @param index index
		 */
		public void setIndex(int index) {
			this.index = index;
		}
	}

	/**
	 * Constructor with a comparator
	 * 
	 * @param c Comparator
	 */
	public HeapAdaptablePriorityQueue(Comparator<K> c) {
		super(c);
	}

	/**
	 * Constructor
	 */
	public HeapAdaptablePriorityQueue() {
		this(null);
	}

	// Factory method for creating a new adaptable PQ entry
	@Override
	protected AdaptablePQEntry<K, V> createEntry(K key, V value) {
		// A new adaptable PQ Entry added to the heap will be at index size()
		AdaptablePQEntry<K, V> temp = new AdaptablePQEntry<K, V>(key, value, size());
		return temp;
	}

	// Make sure the entry is a valid Adaptable PQ Entry and is located within the
	// heap structure
	private AdaptablePQEntry<K, V> validate(Entry<K, V> entry) {
		if (!(entry instanceof AdaptablePQEntry)) {
			throw new IllegalArgumentException("Entry is not a valid adaptable priority queue entry.");
		}
		AdaptablePQEntry<K, V> temp = (AdaptablePQEntry<K, V>) entry;
		if (temp.getIndex() >= list.size() || list.get(temp.getIndex()) != temp) {
			throw new IllegalArgumentException("Invalid Adaptable PQ Entry.");
		}
		return temp;
	}

	@Override
	public void swap(int index1, int index2) {
		// Delegate to the super class swap method
		super.swap(index1, index2);
		// But then update the index of each entry so that they remain location-aware
		((AdaptablePQEntry<K, V>) list.get(index1)).setIndex(index1);
		((AdaptablePQEntry<K, V>) list.get(index2)).setIndex(index2);
	}

	@Override
	public void remove(Entry<K, V> entry) {
		AdaptablePQEntry<K, V> temp = validate(entry);
		int j = temp.getIndex();
		if (j == list.size() - 1) {
			list.remove(list.size() - 1);
		} else {
			swap(j, list.size() - 1);
			list.remove(list.size() - 1);
			bubble(j);
		}
	}

	private void bubble(int index) {
		if (index > 0 && compare(list.get(index).getKey(), list.get(parent(index)).getKey()) < 0) {
			upHeap(index);
		} else {
			downHeap(index);
		}
	}

	@Override
	public void replaceKey(Entry<K, V> entry, K key) {
		AdaptablePQEntry<K, V> temp = validate(entry);
		temp.setKey(key);
		bubble(temp.getIndex());
	}

	@Override
	public void replaceValue(Entry<K, V> entry, V value) {
		AdaptablePQEntry<K, V> temp = validate(entry);
		temp.setValue(value);
	}
}
