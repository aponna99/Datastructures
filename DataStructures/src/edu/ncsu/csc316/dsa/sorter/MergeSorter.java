package edu.ncsu.csc316.dsa.sorter;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Merge sorter
 * 
 * @author Anisha Ponnapati
 *
 * @param <E>
 */
public class MergeSorter<E extends Comparable<E>> extends AbstractComparisonSorter<E> {

	/**
	 * Constructor for Merge Sort
	 * 
	 * @param comparator Comparator
	 */
	public MergeSorter(Comparator<E> comparator) {
		super(comparator);
	}

	/**
	 * Default constructor
	 */
	public MergeSorter() {
		this(null);
	}

	@Override
	public void sort(E[] list) {
		int n = list.length;
		if (n < 2) {
			return;
		}

		int mid = n / 2;
		E[] left = Arrays.copyOfRange(list, 0, mid);
		E[] right = Arrays.copyOfRange(list, mid, n);
		sort(left);
		sort(right);
		merge(left, right, list);

	}

	private void merge(E[] left, E[] right, E[] t) {
		int n = t.length;

		int leftindex = 0;
		int rightindex = 0;

		while (leftindex + rightindex < n) {
			if ((rightindex == right.length)
					|| (leftindex < left.length && compare(left[leftindex], right[rightindex]) < 0)) {
				t[leftindex + rightindex] = left[leftindex];
				leftindex = leftindex + 1;
			} else {
				t[leftindex + rightindex] = right[rightindex];
				rightindex = rightindex + 1;
			}
		}

	}
}