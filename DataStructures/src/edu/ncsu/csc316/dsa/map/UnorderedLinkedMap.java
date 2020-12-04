package edu.ncsu.csc316.dsa.map;

import java.util.Iterator;

import edu.ncsu.csc316.dsa.Position;
import edu.ncsu.csc316.dsa.list.positional.PositionalLinkedList;
import edu.ncsu.csc316.dsa.list.positional.PositionalList;

/**
 * Unordered Linked Map
 * 
 * @author Anisha Ponnapati
 *
 * @param <K>
 * @param <V>
 */
public class UnorderedLinkedMap<K, V> extends AbstractMap<K, V> {

	private PositionalList<Entry<K, V>> list;

	/**
	 * Constructor
	 */
	public UnorderedLinkedMap() {
		this.list = new PositionalLinkedList<Entry<K, V>>();
	}

	private Position<Entry<K, V>> lookUp(K key) {
		Iterable<Position<Entry<K, V>>> ib = list.positions();
		Iterator<Position<Entry<K, V>>> it = ib.iterator();

		if (list.isEmpty()) {
			return null;
		}

		Position<Entry<K, V>> temp;

		while (it.hasNext()) {
			temp = (Position<Entry<K, V>>) it.next();
			if (temp.getElement().getKey() == key) {
				return temp;
			}
		}
		return null;
	}

	@Override
	public V get(K key) {
		Position<Entry<K, V>> p = lookUp(key);
		if (p == null) {
			return null;
		}
		moveToFront(p);
		V element = list.first().getElement().getValue();
		return element;
	}

	private void moveToFront(Position<Entry<K, V>> position) {
		list.addFirst(list.remove(position));
	}

	@Override
	public V put(K key, V value) {
		Position<Entry<K, V>> p = lookUp(key);

		if (p == null) {
			list.addFirst(new MapEntry<K, V>(key, value));
			return null;
		}
		moveToFront(p);
		V element = list.first().getElement().getValue();
		list.set(p, new MapEntry<K, V>(key, value));
		return element;
	}

	@Override
	public V remove(K key) {
		Position<Entry<K, V>> p = lookUp(key);

		if (p == null || p.getElement().getKey() != key) {
			return null;
		}

		list.remove(p);
		return p.getElement().getValue();
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public Iterable<Entry<K, V>> entrySet() {
		PositionalList<Entry<K, V>> set = new PositionalLinkedList<Entry<K, V>>();
		for (Entry<K, V> m : list) {
			set.addLast(m);
		}
		return set;
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
