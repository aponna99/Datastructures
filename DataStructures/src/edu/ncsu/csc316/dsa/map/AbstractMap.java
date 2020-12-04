package edu.ncsu.csc316.dsa.map;

import java.util.Iterator;

/**
 * Abstract Map class
 * 
 * @author Anisha Ponnapati
 *
 * @param <K>
 * @param <V>
 */
public abstract class AbstractMap<K, V> implements Map<K, V> {

	/**
	 * Inner class for map entry
	 * 
	 * @author Anisha Ponnapati
	 *
	 * @param <K>
	 * @param <V>
	 */
	protected static class MapEntry<K, V> implements Entry<K, V> {

		private K key;
		private V value;

		/**
		 * Constructor for map entry
		 * 
		 * @param key   Key
		 * @param value Value
		 */
		public MapEntry(K key, V value) {
			setKey(key);
			setValue(value);
		}

		@Override
		public K getKey() {
			return key;
		}

		@Override
		public V getValue() {
			return value;
		}

		/**
		 * Sets the key
		 * 
		 * @param key Key
		 */
		public void setKey(K key) {
			this.key = key;
		}

		@Override
		public V setValue(V value) {
			V original = this.value;
			this.value = value;
			return original;
		}
	}

	/**
	 * Key iterator class
	 * 
	 * @author Anisha Ponnapati
	 *
	 */
	protected class KeyIterator implements Iterator<K> {

		private Iterator<Entry<K, V>> it;

		/**
		 * Key Iterator
		 * 
		 * @param iterator iterator
		 */
		public KeyIterator(Iterator<Entry<K, V>> iterator) {
			it = iterator;
		}

		@Override
		public boolean hasNext() {
			return it.hasNext();
		}

		@Override
		public K next() {
			return it.next().getKey();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException("The remove operation is not supported yet.");
		}
	}

	/**
	 * Value Iterator
	 * 
	 * @author Anisha Ponnapati
	 *
	 */
	protected class ValueIterator implements Iterator<V> {

		private Iterator<Entry<K, V>> it;

		/**
		 * Constructor
		 * 
		 * @param iterator An iterator object
		 */
		public ValueIterator(Iterator<Entry<K, V>> iterator) {
			it = iterator;
		}

		@Override
		public boolean hasNext() {
			return it.hasNext();
		}

		@Override
		public V next() {
			return it.next().getValue();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException("The remove operation is not supported yet.");
		}
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public Iterator<K> iterator() {
		return new KeyIterator(entrySet().iterator());
	}

	@Override
	public Iterable<V> values() {
		return new ValueIterable();
	}

	/**
	 * Value Iterable
	 * 
	 * @author Anisha Ponnapati
	 *
	 */
	private class ValueIterable implements Iterable<V> {
		@Override
		public Iterator<V> iterator() {
			return new ValueIterator(entrySet().iterator());
		}
	}

}
