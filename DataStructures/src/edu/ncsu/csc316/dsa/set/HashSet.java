package edu.ncsu.csc316.dsa.set;

import java.util.Iterator;

import edu.ncsu.csc316.dsa.map.Map;
import edu.ncsu.csc316.dsa.map.hashing.LinearProbingHashMap;

// Since our hash map uses linear probing, the entries are not ordered.
// As a result, we do not restrict our hash set to use Comparable elements.
// This also gives you an option if you need a set to manage elements
//     that are *NOT* Comparable (versus a TreeSet)
/**
 * HashSet
 * 
 * @author Anisha Ponnapati
 *
 * @param <E>
 */
public class HashSet<E> extends AbstractSet<E> {

	private Map<E, E> map;

	// This constructor will use our "production version" of our hash map
	// meaning random values for alpha and beta will be used
	/**
	 * Constructor
	 */
	public HashSet() {
		this(false);
	}

	// If isTesting is true, this constructor will use our "development version" of
	// our hash map
	// meaning alpha=1, beta=1, and prime=7
	/**
	 * HashSet Constructor
	 * 
	 * @param isTesting True or false
	 */
	public HashSet(boolean isTesting) {
		map = new LinearProbingHashMap<E, E>(isTesting);
	}

	@Override
	public Iterator<E> iterator() {
		return map.iterator();
	}

	@Override
	public void add(E value) {
		map.put(value, value);
	}

	@Override
	public boolean contains(E value) {
		if (map.get(value) != null) {
			return true;
		}

		return false;
	}

	@Override
	public E remove(E value) {
		return map.remove(value);
	}

	/**
	 * Size
	 * 
	 * @return Integer Value
	 */
	public int size() {
		return map.size();
	}
}
