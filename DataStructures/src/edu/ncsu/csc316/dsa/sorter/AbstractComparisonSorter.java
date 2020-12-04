/**
 * 
 */
package edu.ncsu.csc316.dsa.sorter;

import java.util.Comparator;

/**
 * Abstract class for similarities between sorter classes
 * 
 * @author Anisha Ponnapati
 * 
 * @param <E>
 */
public abstract class AbstractComparisonSorter<E extends Comparable<E>> implements Sorter<E> {

	private Comparator<E> comparator;

	/**
	 * Constructor
	 * 
	 * @param comparator Comparator
	 */
	public AbstractComparisonSorter(Comparator<E> comparator) {
		setComparator(comparator);
	}

	private void setComparator(Comparator<E> comparator) {
		if (comparator == null) {
			comparator = new NaturalOrder();
		}
		this.comparator = comparator;
	}

	/**
	 * Natural Order
	 * 
	 * @author Anisha Ponnapati
	 * 
	 */
	private class NaturalOrder implements Comparator<E> {
		/**
		 * Compares two elements
		 * 
		 * @param first  Element one
		 * @param second Element two
		 * 
		 * @return integer
		 */
		public int compare(E first, E second) {
			return ((Comparable<E>) first).compareTo(second);
		}
	}

	/**
	 * Compares two elements
	 * 
	 * @param data1 Element one
	 * @param data2 Element two
	 * 
	 * @return integer
	 */
	public int compare(E data1, E data2) {
		return comparator.compare(data1, data2);
	}
}
