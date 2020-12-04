package edu.ncsu.csc316.dsa.map.hashing;

import edu.ncsu.csc316.dsa.list.List;
import edu.ncsu.csc316.dsa.list.SinglyLinkedList;
import edu.ncsu.csc316.dsa.map.Map;
import edu.ncsu.csc316.dsa.map.SkipListMap;

/**
 * Separate Chaining Hash Map
 * 
 * @author Anisha Ponnapati
 *
 * @param <K>
 * @param <V>
 */
public class SeparateChainingHashMap<K extends Comparable<K>, V> extends AbstractHashMap<K, V> {

	private SkipListMap<K, V>[] table;
	private int size;

	/**
	 * Default Constructor
	 */
	public SeparateChainingHashMap() {
		this(AbstractHashMap.DEFAULT_CAPACITY, false);
	}

	/**
	 * Constructor with boolean
	 * 
	 * @param isTesting isTesting
	 */
	public SeparateChainingHashMap(boolean isTesting) {
		this(AbstractHashMap.DEFAULT_CAPACITY, isTesting);
	}

	/**
	 * Constructor with capacity
	 * 
	 * @param capacity Capacity
	 */
	public SeparateChainingHashMap(int capacity) {
		this(capacity, false);
	}

	/**
	 * Constructor with capacity and boolean testing
	 * 
	 * @param capacity  Capacity
	 * @param isTesting isTesting
	 */
	public SeparateChainingHashMap(int capacity, boolean isTesting) {
		super(capacity, isTesting);
		size = 0;
	}

	@Override
	public Iterable<Entry<K, V>> entrySet() {
		List<Entry<K, V>> list = new SinglyLinkedList<Entry<K, V>>();
		for (int i = 0; i < table.length; i++) {
			if (table[i] != null) {
				// Each bucket contains a map, so include
				// all entries in the entrySet for the map
				// at the current bucket
				for (Entry<K, V> entry : table[i].entrySet()) {
					list.addLast(entry);
				}
			}
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void createTable(int capacity) {
		// Example -- change this to whatever map you'd like
		table = new SkipListMap[capacity];
		size = 0;
	}

	@Override
	public V bucketGet(int hash, K key) {
		// Get the bucket at the specified index in the hash table
		Map<K, V> bucket = table[hash];
		// If there is no map in the bucket, then the entry does not exist
		if (bucket == null) {
			return null;
		}
		// Otherwise, delegate to the existing map's get method to return the value
		return bucket.get(key);
	}

	@Override
	public V bucketPut(int hash, K key, V value) {
		SkipListMap<K, V> bucket = table[hash];

		if (bucket == null) {
			table[hash] = new SkipListMap<>();
			bucket = table[hash];
		}

		int old = bucket.size();
		V result = bucket.put(key, value);
		size += (bucket.size() - old);
		return result;
	}

	@Override
	public V bucketRemove(int hash, K key) {
		Map<K, V> bucket = table[hash];

		if (bucket == null) {
			return null;
		}

		int old = bucket.size();
		V result = bucket.remove(key);
		size -= old - bucket.size();
		return result;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	protected int capacity() {
		return table.length;
	}
}
