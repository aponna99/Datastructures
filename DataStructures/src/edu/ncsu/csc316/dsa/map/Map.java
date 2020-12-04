package edu.ncsu.csc316.dsa.map;

/**
 * Map interface
 * 
 * @author Anisha Ponnapati
 *
 * @param <K>
 * @param <V>
 */
public interface Map<K, V> extends Iterable<K> {

	/**
	 * Entry set
	 * 
	 * @return Entry element
	 */
	Iterable<Entry<K, V>> entrySet();

	/**
	 * Gets the value
	 * 
	 * @param key Key to search up
	 * @return Value associated with the key
	 */
	V get(K key);

	/**
	 * Checks if map is empty
	 * 
	 * @return True or false
	 */
	boolean isEmpty();

	/**
	 * Places a map entry
	 * 
	 * @param key   Key
	 * @param value Value
	 * @return V
	 */
	V put(K key, V value);

	/**
	 * Removes value
	 * 
	 * @param key Key
	 * @return Value that was removed
	 */
	V remove(K key);

	/**
	 * Size of map
	 * 
	 * @return size
	 */
	int size();

	/**
	 * All the values
	 * 
	 * @return values
	 */
	Iterable<V> values();

	/**
	 * Inner interface of Entry
	 * 
	 * @author Anisha Ponnapati
	 *
	 * @param <K>
	 * @param <V>
	 */
	interface Entry<K, V> {
		/**
		 * Gets key
		 * 
		 * @return Key
		 */
		K getKey();

		/**
		 * Get value
		 * 
		 * @return value
		 */
		V getValue();

		/**
		 * Sets value
		 * 
		 * @param value value
		 * @return value
		 */
		V setValue(V value);
	}
}