package edu.ncsu.csc316.dsa.map;

import java.util.Comparator;
import java.util.Iterator;

import edu.ncsu.csc316.dsa.list.ArrayBasedList;

/**
 * Search table map
 * 
 * @author Anisha Ponnapati
 *
 * @param <K>
 * @param <V>
 */
public class SearchTableMap<K extends Comparable<K>, V> extends AbstractSortedMap<K, V> {

	private ArrayBasedList<Entry<K, V>> list;

	/**
	 * Constructor
	 */
	public SearchTableMap() {
		this(null);
	}

	/**
	 * Constructor
	 * 
	 * @param compare comparator
	 */
	public SearchTableMap(Comparator<K> compare) {
		super(compare);
		list = new ArrayBasedList<Entry<K, V>>();
	}

	private int lookUp(K key) {
		return binarySearchHelper(0, list.size() - 1, key);
	}

	private int binarySearchHelper(int min, int max, K key) {
		if (min > max) {
			return -1 * (min + 1);
		}
		int mid = (max + min) / 2;
		if (list.get(mid).getKey() == key) {
			return mid;
		} else if (super.compare(list.get(mid).getKey(), key) > 0) {
			return binarySearchHelper(min, mid - 1, key);
		} else {
			return binarySearchHelper(mid + 1, max, key);
		}
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public V get(K key) {
		int index = lookUp(key);
		if (index < 0) {
			return null;
		}

		return list.get(index).getValue();
	}

	@Override
	public Iterable<Entry<K, V>> entrySet() {
		ArrayBasedList<Entry<K, V>> set = new ArrayBasedList<Entry<K, V>>();
		for (Entry<K, V> m : list) {
			set.addLast(m);
		}
		return set;
	}

	@Override
	public V put(K key, V value) {
		int index = lookUp(key);
		V element = null;
		if (index >= 0) {
			element = list.get(index).getValue();
			list.get(index).setValue(value);
		} else if (list.size() == 0) {
			list.addFirst(new MapEntry<K, V>(key, value));
		} else {
			if (index < 0) {
				index = index * -1;
				index--;
			}
			list.add(index, new MapEntry<K, V>(key, value));
		}
		return element;
	}

	@Override
	public V remove(K key) {
		int index = lookUp(key);

		if (index < 0) {
			return null;
		}

		return list.remove(index).getValue();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(this.getClass().getSimpleName() + "[");
		Iterator<Entry<K, V>> it = list.iterator();
		while (it.hasNext()) {
			sb.append(it.next().getKey());
			if (it.hasNext()) {
				sb.append(", ");
			}
		}
		sb.append("]");
		return sb.toString();
	}
}
