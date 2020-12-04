package edu.ncsu.csc316.dsa.sorter;

import edu.ncsu.csc316.dsa.data.Identifiable;

/**
 * RadixSorter uses the radix sort algorithm to sort data
 * 
 * @author Dr. King
 * @author Anisha Ponnapati
 *
 * @param <E> the generic type of data to sort
 */
public class RadixSorter<E extends Identifiable> implements Sorter<E> {

	/**
	 * Radix Sorter
	 * 
	 * @param list List of elements
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void sort(E[] list) {
		int k = 0;
		for (int i = 0; i < list.length; i++) {
			k = Math.max(k, list[i].getId());
		}

		double x = Math.ceil(Math.log(k + 1) / Math.log(10));

		int p = 1;

		for (int j = 1; j <= x; j++) {
			int[] b = new int[10];
			for (int i = 0; i < list.length; i++) {
				b[(list[i].getId() / p) % 10] = b[(list[i].getId() / p) % 10] + 1;
			}

			for (int i = 1; i <= 9; i++) {
				b[i] = b[i - 1] + b[i];
			}

			E[] f = (E[]) (new Identifiable[list.length]);

			for (int i = list.length - 1; i >= 0; i--) {
				f[b[(list[i].getId() / p) % 10] - 1] = list[i];
				b[(list[i].getId() / p) % 10] = b[(list[i].getId() / p) % 10] - 1;
			}

			for (int i = 0; i < list.length; i++) {
				list[i] = f[i];
			}

			p = p * 10;
		}
	}

}
