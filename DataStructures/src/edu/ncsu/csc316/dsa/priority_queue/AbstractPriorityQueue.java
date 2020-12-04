package edu.ncsu.csc316.dsa.priority_queue;

import java.util.Comparator;

/**
 * Abstract Priority Queue Class
 * 
 * @author Anisha Ponnapati
 *
 * @param <K>
 * @param <V>
 */
public abstract class AbstractPriorityQueue<K extends Comparable<K>, V> implements PriorityQueue<K, V> {

	private Comparator<K> comparator;

	/**
	 * AbstractPriorityQueue
	 * 
	 * @param c Comparator
	 */
	public AbstractPriorityQueue(Comparator<K> c) {
		setComparator(c);
	}

	/**
	 * Sets comparator
	 * 
	 * @param c Comparator
	 */
	private void setComparator(Comparator<K> c) {
		if (c == null) {
			c = new NaturalOrder();
		}
		comparator = c;
	}

	/**
	 * Inner class Natural Order
	 * 
	 * @author Anisha Ponnapati
	 *
	 */
	public class NaturalOrder implements Comparator<K> {
		/**
		 * Compare
		 * 
		 * @param first  first key
		 * @param second second key
		 * @return Integer value of the Comparison
		 */
		public int compare(K first, K second) {
			return ((Comparable<K>) first).compareTo(second);
		}
	}

	/**
	 * Compares data
	 * 
	 * @param data1 Data
	 * @param data2 Data
	 * @return Integer value of the Comparison
	 */
	public int compare(K data1, K data2) {
		return comparator.compare(data1, data2);
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	// Make sure you import PriorityQueue.Entry and NOT Map.Entry!
	/**
	 * PQEntry
	 * 
	 * @author Anisha Ponnapati
	 *
	 * @param <K>
	 * @param <V>
	 */
	public static class PQEntry<K, V> implements Entry<K, V> {

		private K key;
		private V value;

		/**
		 * Constructor
		 * 
		 * @param key   Key
		 * @param value Value
		 */
		public PQEntry(K key, V value) {
			setKey(key);
			setValue(value);
		}

		/**
		 * Sets key
		 * 
		 * @param key Key
		 */
		public void setKey(K key) {
			this.key = key;
		}

		/**
		 * Sets value
		 * 
		 * @param value Value
		 */
		public void setValue(V value) {
			this.value = value;
		}

		@Override
		public K getKey() {
			return key;
		}

		@Override
		public V getValue() {
			return value;
		}
	}

	// factory method for constructing a new priority queue entry object
	/**
	 * Create Entries
	 * 
	 * @param key   Key
	 * @param value Value
	 * @return Entry
	 */
	protected Entry<K, V> createEntry(K key, V value) {
		return new PQEntry<K, V>(key, value);
	}
}
