package edu.ncsu.csc316.dsa.map;

import java.util.Iterator;
import edu.ncsu.csc316.dsa.list.ArrayBasedList;

/**
 * Unordered Array Map
 * 
 * @author Anisha Ponnapati
 *
 * @param <K>
 * @param <V>
 */
public class UnorderedArrayMap<K, V> extends AbstractMap<K, V> {

	// Use the adapter pattern to delegate to our existing
	// array-based list implementation
	private ArrayBasedList<Entry<K, V>> list;
	
	/**
	 * Constructor
	 */
	public UnorderedArrayMap() {
		this.list = new ArrayBasedList<Entry<K, V>>();
	}

	// LookUp is a core behavior of all maps
	// This lookup should perform a sequential search
	// and return the index where the entry
	// is located. If the entry is not in the map, return -1
	private int lookUp(K key) {
		int position = 0;

		Iterator<Entry<K, V>> it = list.iterator();

		while (it.hasNext()) {
			if (it.next().getKey() == key) {
				return position;
			}
			position++;
		}
		return -1;
	}

	@Override
	public V get(K key) {
		int index = lookUp(key);

		if (index == -1) {
			return null;
		}
		V e = list.get(index).getValue();
		transpose(index);
		return e;
	}

	@Override
	public V put(K key, V value) {
		int index = lookUp(key);

		if (index == -1) {
			list.addFirst(new MapEntry<K, V>(key, value));
			return null;
		}
		V element = list.get(index).getValue();
		list.set(index, new MapEntry<K, V>(key, value));
		transpose(index);
		return element;
	}

	@Override
	public V remove(K key) {
		int index = lookUp(key);
		if (index == -1) {
			return null;
		}

		return list.remove(index).getValue();
	}

	@Override
	public int size() {
		return list.size();
	}

	private V transpose(int index) {
		if (index < 0) {
			return null;
		}
		if (index == 0) {
			return list.get(index).getValue();
		}
		K key = list.get(index).getKey();
		V element = list.get(index).getValue();
		list.remove(index);
		list.add(index - 1, new MapEntry<K, V>(key, element));
		return element;
	}

	@Override
	public Iterable<Entry<K, V>> entrySet() {
		return list;
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