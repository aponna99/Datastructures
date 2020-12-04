package edu.ncsu.csc316.dsa.sorter;

import java.util.Comparator;
import java.util.Random;

/**
 * Quick sorter
 * 
 * @author Anisha Ponnapati
 *
 * @param <E>
 */
public class QuickSorter<E extends Comparable<E>> extends AbstractComparisonSorter<E> {

	/**
	 * First element selector
	 */
	public static final PivotSelector FIRST_ELEMENT_SELECTOR = new FirstElementSelector();
	/**
	 * Last element selector
	 */
	public static final PivotSelector LAST_ELEMENT_SELECTOR = new LastElementSelector();
	/**
	 * Middle element selector
	 */
	public static final PivotSelector MIDDLE_ELEMENT_SELECTOR = new MiddleElementSelector();
	/**
	 * Random element selector
	 */
	public static final PivotSelector RANDOM_ELEMENT_SELECTOR = new RandomElementSelector();

	private PivotSelector selector;

	/**
	 * Constructor with comparator and selector
	 * 
	 * @param comparator comparator
	 * @param selector   selector
	 */
	public QuickSorter(Comparator<E> comparator, PivotSelector selector) {
		super(comparator);
		setSelector(selector);
	}

	/**
	 * Constructor with comparator
	 * 
	 * @param comparator comparator
	 */
	public QuickSorter(Comparator<E> comparator) {
		this(comparator, null);
	}

	/**
	 * Constructor with selector
	 * 
	 * @param selector selector
	 */
	public QuickSorter(PivotSelector selector) {
		this(null, selector);
	}

	/**
	 * Default constructor
	 */
	public QuickSorter() {
		this(null, null);
	}

	private void setSelector(PivotSelector selector) {
		if (selector == null) {
			selector = new RandomElementSelector();
		}
		this.selector = selector;
	}

	/**
	 * Interface to select pivot
	 * 
	 * @author Anisha Ponnapati
	 *
	 */
	private interface PivotSelector {
		/**
		 * Returns the index of the selected pivot element
		 * 
		 * @param low  - the lowest index to consider
		 * @param high - the highest index to consider
		 * @return the index of the selected pivot element
		 */
		int selectPivot(int low, int high);
	}

	/**
	 * Uses Random Element as pivot
	 * 
	 * @author Anisha Ponnapati
	 *
	 */
	public static class RandomElementSelector implements PivotSelector {

		@Override
		public int selectPivot(int low, int high) {
			Random rand = new Random();
			int n;
			do {
				n = rand.nextInt(high);
			} while (n < low);
			return n;
		}
	}

	/**
	 * Uses First Element as pivot
	 * 
	 * @author Anisha Ponnapati
	 *
	 */
	public static class FirstElementSelector implements PivotSelector {

		@Override
		public int selectPivot(int low, int high) {
			return low;
		}
	}

	/**
	 * Uses Middle Element as pivot
	 * 
	 * @author Anisha Ponnapati
	 *
	 */
	public static class MiddleElementSelector implements PivotSelector {

		@Override
		public int selectPivot(int low, int high) {
			return (low + high) / 2;
		}
	}

	/**
	 * Uses Last Element as pivot
	 * 
	 * @author Anisha Ponnapati
	 *
	 */
	public static class LastElementSelector implements PivotSelector {

		@Override
		public int selectPivot(int low, int high) {
			return high;
		}
	}

	@Override
	public void sort(E[] list) {
		quickSort(list, 0, list.length - 1);

	}

	private void quickSort(E[] t, int low, int high) {

		if (low < high) {
			int pivotLocation = partition(t, low, high);
			quickSort(t, low, pivotLocation - 1);
			quickSort(t, pivotLocation + 1, high);
		}
	}

	private int partition(E[] t, int low, int high) {
		int pivotindex = selector.selectPivot(low, high);

		swap(t, pivotindex, high);
		return partitionHelper(t, low, high);
	}

	private int partitionHelper(E[] t, int low, int high) {
		E pivot = t[high];
		int index = low;
		for (int j = low; j < high; j++) {
			if (compare(t[j], pivot) <= 0) {
				swap(t, index, j);
				index = index + 1;
			}
		}

		swap(t, index, high);
		return index;
	}

	private void swap(E[] t, int low, int high) {
		E temp = t[low];
		t[low] = t[high];
		t[high] = temp;
	}
}