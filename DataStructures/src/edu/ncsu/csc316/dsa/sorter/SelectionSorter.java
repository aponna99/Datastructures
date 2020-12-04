package edu.ncsu.csc316.dsa.sorter;

import java.util.Comparator;

/**
 * SelectionSorter uses the selection sort algorithm to sort data
 * 
 * @author Dr. King
 * @author Anisha Ponnapati
 * 
 * @param <E> the generic type of data to sort
 */
public class SelectionSorter<E extends Comparable<E>> extends AbstractComparisonSorter<E> {

	/**
	 * Constructor
	 */
	public SelectionSorter() {
		this(null);
	}

	/**
	 * Constructor
	 * 
	 * @param comparator Comparator
	 */
	public SelectionSorter(Comparator<E> comparator) {
		super(comparator);
	}

	/**
	 * Sorts data
	 * 
	 * @param data List of elements
	 */
	public void sort(E[] data) {
		int min;
		for (int i = 0; i < data.length; i++) {
			min = i;
			for (int j = i + 1; j < data.length; j++) {
				if (super.compare(data[j], data[min]) < 0) {
					min = j;
				}
			}
			if (i != min) {
				E x = data[i];
				data[i] = data[min];
				data[min] = x;
			}
		}
	}
}
