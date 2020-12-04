package edu.ncsu.csc316.dsa.priority_queue;

/**
 * APQ Interface
 * 
 * @author Anisha Ponnapati
 *
 * @param <K>
 * @param <V>
 */
public interface AdaptablePriorityQueue<K, V> extends PriorityQueue<K, V> {

	/**
	 * Remove
	 * 
	 * @param entry Entry
	 */
	void remove(Entry<K, V> entry);

	/**
	 * Replace Key
	 * 
	 * @param entry Entry
	 * @param key   Key to be used for replacing
	 */
	void replaceKey(Entry<K, V> entry, K key);

	/**
	 * Replaces value
	 * 
	 * @param entry Entry
	 * @param value Value to be used for replacing
	 */
	void replaceValue(Entry<K, V> entry, V value);
}
