package edu.ncsu.csc316.dsa.set;

import java.util.Iterator;

import edu.ncsu.csc316.dsa.map.Map;
import edu.ncsu.csc316.dsa.map.search_tree.BinarySearchTreeMap;

// Remember that search trees are ordered, so our elements must be Comparable
/**
 * TreeSet
 * 
 * @author Anisha Ponnapati
 *
 * @param <E>
 */
public class TreeSet<E extends Comparable<E>> extends AbstractSet<E> {

	private Map<E, E> tree;

	/**
	 * Constructor
	 */
	public TreeSet() {
		tree = new BinarySearchTreeMap<E, E>();
	}

	@Override
	public Iterator<E> iterator() {
		return tree.iterator();
	}

	@Override
	public void add(E value) {
		tree.put(value, value);
	}

	@Override
	public boolean contains(E value) {
		if (tree.get(value) != null) {
			return true;
		}
		return false;
	}

	@Override
	public E remove(E value) {
		if (this.contains(value)) {
			return tree.remove(value);
		}
		return null;
	}

	@Override
	public int size() {
		return tree.size();
	}
}
