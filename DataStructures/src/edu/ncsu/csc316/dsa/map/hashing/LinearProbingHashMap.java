package edu.ncsu.csc316.dsa.map.hashing;

import edu.ncsu.csc316.dsa.list.List;
import edu.ncsu.csc316.dsa.list.SinglyLinkedList;

/**
 * Linear Probing Hash Map
 * 
 * @author Anisha Ponnapati
 *
 * @param <K>
 * @param <V>
 */
public class LinearProbingHashMap<K, V> extends AbstractHashMap<K, V> {

	// This time, our array is an array of TableEntry objects
	private TableEntry<K, V>[] table;
	private int size;

	/**
	 * Constructor
	 */
	public LinearProbingHashMap() {
		this(AbstractHashMap.DEFAULT_CAPACITY, false);
	}

	/**
	 * Constructor
	 * 
	 * @param isTesting isTesting
	 */
	public LinearProbingHashMap(boolean isTesting) {
		this(AbstractHashMap.DEFAULT_CAPACITY, isTesting);
	}

	/**
	 * Constructor
	 * 
	 * @param capacity Capacity
	 */
	public LinearProbingHashMap(int capacity) {
		this(capacity, false);
	}

	/**
	 * Constructor
	 * 
	 * @param capacity  Capacity
	 * @param isTesting isTesting
	 */
	public LinearProbingHashMap(int capacity, boolean isTesting) {
		super(capacity, isTesting);
		size = 0;
	}

	@Override
	public Iterable<Entry<K, V>> entrySet() {
		List<Entry<K, V>> list = new SinglyLinkedList<Entry<K, V>>();
		for (int i = 0; i < table.length; i++) {
			if (!isAvailable(i)) {
				list.addLast(table[i]);
			}
		}

		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void createTable(int capacity) {
		table = (TableEntry<K, V>[]) new TableEntry[capacity];
		size = 0;
	}

	// Helper method to determine whether a bucket has an entry or not
	private boolean isAvailable(int index) {
		return (table[index] == null || table[index].isDeleted());
	}

	// Helper method to find the bucket for an entry;
	// If the entry *is* in the map, returns the index of the bucket
	// If the entry is *not* in the map, returns -(a + 1) to indicate
	// that the entry should be added at index a
	private int findBucket(int index, K key) {
		int avail = -1;
		int j = index;

		do {
			if (isAvailable(j)) {
				if (avail == -1) {
					avail = j;
				}

				if (table[j] == null) {
					return -(avail + 1);
				}
			} else if (table[j].getKey().equals(key)) {
				return j;
			}

			j = (j + 1) % capacity();
		} while (j != index);

		return -(avail + 1);
	}

	@Override
	public V bucketGet(int hash, K key) {
		int index = findBucket(hash, key);
		if (index < 0) {
			return null;
		}

		return table[index].getValue();
	}

	@Override
	public V bucketPut(int hash, K key, V value) {
		int index = findBucket(hash, key);

		if (index >= 0) {
			return table[index].setValue(value);
		}

		table[-(index + 1)] = new TableEntry<>(key, value);
		size++;
		return null;
	}
	
	@Override
	public V bucketRemove(int hash, K key) {
		int index = findBucket(hash, key);

		if (index < 0) {
			return null;
		}

		V answer = table[index].getValue();
		table[index] = null;
		size--;
		return answer;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	protected int capacity() {
		return table.length;
	}

	/**
	 * Inner class Table Entry
	 * 
	 * @author Anisha Ponnapati
	 *
	 * @param <K>
	 * @param <V>
	 */
	private static class TableEntry<K, V> extends MapEntry<K, V> {

		private boolean isDeleted;

		/**
		 * Constructor
		 * 
		 * @param key   Key
		 * @param value Value
		 */
		public TableEntry(K key, V value) {
			super(key, value);
			setDeleted(false);
		}

		/**
		 * Is deleted
		 * 
		 * @return boolean
		 */
		public boolean isDeleted() {
			return isDeleted;
		}

		/**
		 * set deleted
		 * 
		 * @param deleted deleted
		 */
		public void setDeleted(boolean deleted) {
			isDeleted = deleted;
		}
	}
}