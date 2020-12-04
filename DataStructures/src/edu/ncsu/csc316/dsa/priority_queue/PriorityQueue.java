package edu.ncsu.csc316.dsa.priority_queue;

/**
 * Priority Queue Class
 * 
 * @author Anisha Ponnapati
 *
 * @param <K>
 * @param <V>
 */
public interface PriorityQueue<K, V> {

	/**
	 * Inner class interface
	 * 
	 * @author Anisha Ponnapati
	 *
	 * @param <K>
	 * @param <V>
	 */
	interface Entry<K, V> {
		/**
		 * Gets the Key
		 * 
		 * @return Key
		 */
		K getKey();

		/**
		 * Gets the value
		 * 
		 * @return Value
		 */
		V getValue();
	}

	/**
	 * Inserts Entry
	 * 
	 * @param key   Key
	 * @param value Value
	 * @return Entry
	 */
	Entry<K, V> insert(K key, V value);

	/**
	 * Minimum Entry
	 * 
	 * @return Entry
	 */
	Entry<K, V> min();

	/**
	 * Delete Minimum Entry
	 * 
	 * @return Entry
	 */
	Entry<K, V> deleteMin();

	/**
	 * Size of Queue
	 * 
	 * @return Size
	 */
	int size();

	/**
	 * Checks if PQ is empty
	 * 
	 * @return True or False
	 */
	boolean isEmpty();
}