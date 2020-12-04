package edu.ncsu.csc316.dsa.sorter;

import java.util.Comparator;

/**
 * InsertionSorter uses the insertion sort algorithm to sort data.
 * 
 * @author Dr. King
 * @author Anisha Ponnapati
 * 
 * @param <E>
 */
public class InsertionSorter<E extends Comparable<E>> extends AbstractComparisonSorter<E> {

	/**
	 * Constructor
	 */
	public InsertionSorter() {
		this(null);
	}

	/**
	 * Constructor
	 * 
	 * @param comparator Comparator
	 */
	public InsertionSorter(Comparator<E> comparator) {
		super(comparator);
	}

	@Override
	public void sort(E[] list) {
		E x;
		int j;

		for (int i = 1; i <= list.length - 1; i++) {
			x = list[i];
			j = i - 1;
			while (j >= 0 && super.compare(list[j], x) > 0) {
				list[j + 1] = list[j];
				j = j - 1;
			}

			list[j + 1] = x;
		}

	}

}