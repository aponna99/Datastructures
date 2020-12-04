package edu.ncsu.csc316.dsa.map.hashing;

import java.util.Random;

import edu.ncsu.csc316.dsa.list.ArrayBasedList;
import edu.ncsu.csc316.dsa.list.List;
import edu.ncsu.csc316.dsa.map.AbstractMap;

/**
 * Abstract Hash Map Class
 * 
 * @author Anisha Ponnapati
 *
 * @param <K>
 * @param <V>
 */
public abstract class AbstractHashMap<K, V> extends AbstractMap<K, V> {

	// An initial capacity for the hash table
	/**
	 * Default Capacity
	 */
	protected static final int DEFAULT_CAPACITY = 17;

	// From our discussion in class, the expected number of probes
	// for separate chaining remains relatively the same no matter
	// what the load factor may be. However, for linear probing, to
	// reduce the chance of having large clusters, we will resize
	// when the load factor reaches 0.5
	/**
	 * Max load factor value
	 */
	private static final double MAX_LOAD_FACTOR = 0.5;
	/**
	 * Default prime value
	 */
	protected static final int DEFAULT_PRIME = 109345121;

	// Alpha and Beta values for MAD compression
	// This implementation uses a variation of the MAD method
	// where h(k) = ( (alpha * f(k) + beta) % prime) % capacity
	private long alpha;
	private long beta;

	// The prime number to use for compression strategy
	private int prime;

	// You can use the isTesting flag (set to true) to control
	// the testing environment and avoid random numbers when testing
	/**
	 * Constructor
	 * 
	 * @param capacity  Capacity
	 * @param isTesting isTesting
	 */
	public AbstractHashMap(int capacity, boolean isTesting) {
		if (isTesting) {
			alpha = 1;
			beta = 1;
			prime = 7;
		} else {
			Random rand = new Random();
			alpha = rand.nextInt(DEFAULT_PRIME - 1) + 1;
			beta = rand.nextInt(DEFAULT_PRIME);
			prime = DEFAULT_PRIME;
		}
		createTable(capacity);
	}

	private int compress(K key) {
		return (int) ((Math.abs(key.hashCode() * alpha + beta) % prime) % capacity());
	}

	@Override
	public V put(K key, V value) {
		V ret = bucketPut(compress(key), key, value);
		if ((double) size() / capacity() > MAX_LOAD_FACTOR) {
			resize(2 * capacity() + 1);
		}
		return ret;
	}

	@Override
	public V get(K key) {
		return bucketGet(compress(key), key);
	}

	@Override
	public V remove(K key) {
		return bucketRemove(compress(key), key);
	}

	private void resize(int newCapacity) {
		List<Entry<K, V>> list = new ArrayBasedList<Entry<K, V>>();
		for (Entry<K, V> entry : entrySet()) {
			list.addLast(entry);
		}
		createTable(newCapacity);
		for (Entry<K, V> entry : list) {
			put(entry.getKey(), entry.getValue());
		}
	}

	/**
	 * Capacity
	 * 
	 * @return Integer
	 */
	protected abstract int capacity();

	/**
	 * Create table
	 * 
	 * @param capacity Capacity
	 */
	protected abstract void createTable(int capacity);

	/**
	 * Get
	 * 
	 * @param hash Hash
	 * @param key  Key
	 * @return Value
	 */
	protected abstract V bucketGet(int hash, K key);

	/**
	 * Put
	 * 
	 * @param hash  Hash
	 * @param key   Key
	 * @param value Value
	 * @return Value
	 */
	protected abstract V bucketPut(int hash, K key, V value);

	/**
	 * Remove
	 * 
	 * @param hash Hash
	 * @param key  Key
	 * @return Value
	 */
	protected abstract V bucketRemove(int hash, K key);
}
