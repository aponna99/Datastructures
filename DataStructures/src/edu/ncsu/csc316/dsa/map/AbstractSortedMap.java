package edu.ncsu.csc316.dsa.map;

import java.util.Comparator;

/**
 * Abstract sorted map
 * 
 * @author Anisha Ponnapati
 *
 * @param <K>
 * @param <V>
 */
public abstract class AbstractSortedMap<K extends Comparable<K>, V> extends AbstractMap<K, V> {

	private Comparator<K> compare;

	/**
	 * Constructor
	 * 
	 * @param compare Compare
	 */
	public AbstractSortedMap(Comparator<K> compare) {
		if (compare == null) {
			this.compare = new NaturalOrder();
		} else {
			this.compare = compare;
		}
	}

	/**
	 * Compares
	 * 
	 * @param key1 First key
	 * @param key2 Second key
	 * 
	 * @return Integer value
	 */
	public int compare(K key1, K key2) {
		return compare.compare(key1, key2);
	}

	/**
	 * Natural Order
	 * 
	 * @author Anisha Ponnapati
	 *
	 */
	private class NaturalOrder implements Comparator<K> {
		/**
		 * Compares parameters
		 * 
		 * @param first  First key
		 * @param second Second key
		 * 
		 * @return Integer value
		 */
		public int compare(K first, K second) {
			return ((Comparable<K>) first).compareTo(second);
		}
	}
}
