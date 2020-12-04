package edu.ncsu.csc316.dsa.sorter;

import java.util.Comparator;

/**
 * Bubble Sort
 * 
 * @author Anisha Ponnapati
 *
 * @param <E>
 */
public class BubbleSorter<E extends Comparable<E>> extends AbstractComparisonSorter<E> {

	/**
	 * Constructor
	 * 
	 * @param comparator Comparator
	 */
	public BubbleSorter(Comparator<E> comparator) {
		super(comparator);
	}

	/**
	 * Constructor
	 */
	public BubbleSorter() {
		this(null);
	}

	@Override
	public void sort(E[] list) {
		boolean r = true;

		while (r) {
			r = false;
			for (int i = 1; i < list.length; i++) {
				if (super.compare(list[i], list[i - 1]) < 0) {
					E x = list[i - 1];
					list[i - 1] = list[i];
					list[i] = x;
					r = true;
				}
			}
		}

	}

}