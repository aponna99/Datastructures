package edu.ncsu.csc316.dsa.tree;

import java.util.Iterator;

import edu.ncsu.csc316.dsa.Position;

/**
 * Abstract Tree
 * 
 * @author Anisha Ponnapati
 *
 * @param <E>
 */
public abstract class AbstractTree<E> implements Tree<E> {

	@Override
	public boolean isInternal(Position<E> p) {
		return numChildren(p) > 0;
	}

	@Override
	public boolean isLeaf(Position<E> p) {
		return numChildren(p) == 0;
	}

	@Override
	public boolean isRoot(Position<E> p) {
		return p == root();
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	/**
	 * Abstract Node
	 * 
	 * @author Anisha Ponnapati
	 *
	 * @param <E>
	 */
	protected abstract static class AbstractNode<E> implements Position<E> {

		private E element;

		/**
		 * Constructor
		 * 
		 * @param element Element
		 */
		public AbstractNode(E element) {
			setElement(element);
		}

		@Override
		public E getElement() {
			return element;
		}

		/**
		 * Sets element
		 * 
		 * @param element Element
		 */
		public void setElement(E element) {
			this.element = element;
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(this.getClass().getSimpleName() + "[\n");
		toStringHelper(sb, "", root());
		sb.append("]");
		return sb.toString();
	}

	private void toStringHelper(StringBuilder sb, String indent, Position<E> root) {
		if (root == null) {
			return;
		}
		sb.append(indent).append(root.getElement()).append("\n");
		for (Position<E> child : children(root)) {
			toStringHelper(sb, indent + " ", child);
		}
	}

	/**
	 * Element Iterator
	 * 
	 * @author Anisha Ponnapati
	 *
	 */
	protected class ElementIterator implements Iterator<E> {
		private Iterator<Position<E>> it;

		/**
		 * Element Iterator
		 * 
		 * @param iterator Iterator
		 */
		public ElementIterator(Iterator<Position<E>> iterator) {
			it = iterator;
		}

		@Override
		public boolean hasNext() {
			return it.hasNext();
		}

		@Override
		public E next() {
			return it.next().getElement();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException("The remove operation is not supported yet.");
		}
	}
}