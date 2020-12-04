package edu.ncsu.csc316.dsa.disjoint_set;

import edu.ncsu.csc316.dsa.Position;
import edu.ncsu.csc316.dsa.map.Map;
import edu.ncsu.csc316.dsa.map.hashing.LinearProbingHashMap;

/**
 * Up tree disjoin set forest
 * 
 * @author Anisha Ponnapati
 *
 * @param <E>
 */
public class UpTreeDisjointSetForest<E> implements DisjointSetForest<E> {

	// We need a secondary map to quickly locate an entry within the forest of
	// up-trees
	// NOTE: The textbook implementation does not include this
	// functionality; instead, the textbook implementation leaves
	// the responsibility of tracking positions to the client in a
	// separate map structure
	private Map<E, UpTreeNode<E>> map;

	/**
	 * Constructor
	 */
	public UpTreeDisjointSetForest() {
		// Use an efficient map!
		map = new LinearProbingHashMap<E, UpTreeNode<E>>();
	}

	@Override
	public Position<E> makeSet(E value) {
		UpTreeNode<E> n = new UpTreeNode<E>(value);
		map.put(value, n);
		return n;
	}

	@Override
	public Position<E> find(E value) {
		UpTreeNode<E> n = map.get(value);
		return findHelper(n);
	}

	private UpTreeNode<E> findHelper(UpTreeNode<E> current) {
		if (current != current.getParent()) {
			current.setParent(findHelper(current.getParent()));
		}
		return current.getParent();
	}

	@Override
	public void union(Position<E> s, Position<E> t) {
		// Instead of trusting the client to give us the roots
		// of two up-trees, we will verify by finding the root
		// of the up-tree that contains the element in positions s and t
		UpTreeNode<E> a = validate(find(s.getElement()));
		UpTreeNode<E> b = validate(find(t.getElement()));

		if (a.getCount() > b.getCount()) {
			a.setCount(a.getCount() + b.getCount());
			b.setParent(a);
		} else {
			b.setCount(a.getCount() + b.getCount());
			a.setParent(b);
		}
	}

	private UpTreeNode<E> validate(Position<E> p) {
		if (!(p instanceof UpTreeNode)) {
			throw new IllegalArgumentException("Position is not a valid up tree node.");
		}
		return (UpTreeNode<E>) p;
	}

	/**
	 * Inner class
	 * 
	 * @author Anisha Ponnapati
	 *
	 * @param <E>
	 */
	private static class UpTreeNode<E> implements Position<E> {

		private E element;
		private UpTreeNode<E> parent;
		private int count;

		/**
		 * Up tree node
		 * 
		 * @param element Element
		 */
		public UpTreeNode(E element) {
			setElement(element);
			setParent(this);
			setCount(1);
		}

		/**
		 * Sets element
		 * 
		 * @param element Element
		 */
		public void setElement(E element) {
			this.element = element;
		}

		@Override
		public E getElement() {
			return element;
		}

		/**
		 * Sets the parent
		 * 
		 * @param parent Parent
		 */
		public void setParent(UpTreeNode<E> parent) {
			this.parent = parent;
		}

		/**
		 * Gets the parent
		 * 
		 * @return Parent
		 */
		public UpTreeNode<E> getParent() {
			return parent;
		}

		/**
		 * Set Count
		 * 
		 * @param count Count
		 */
		public void setCount(int count) {
			this.count = count;
		}

		/**
		 * Gets Count
		 * 
		 * @return Count Value
		 */
		public int getCount() {
			return count;
		}
	}
}