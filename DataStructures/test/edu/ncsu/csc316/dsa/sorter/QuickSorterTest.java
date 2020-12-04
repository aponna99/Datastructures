/**
 * 
 */
package edu.ncsu.csc316.dsa.sorter;

import static org.junit.Assert.*;

import java.util.Comparator;

import org.junit.Before;
import org.junit.Test;

/**
 * Quick sorter test
 * 
 * @author Anisha Ponnapati
 *
 */
public class QuickSorterTest {

	private Integer[] dataAscending = { 1, 2, 3, 4, 5 };
	private Integer[] dataDescending = { 5, 4, 3, 2, 1 };
	private Integer[] dataRandom = { 4, 1, 5, 3, 2 };

	private QuickSorter<Integer> asort;
	private QuickSorter<Integer> bsort;
	private QuickSorter<Integer> selsort;
	private QuickSorter<Integer> rsort;
	private QuickSorter<Integer> msort;
	private QuickSorter<Integer> lsort;

	@SuppressWarnings("rawtypes")
	private Comparator comp;

	/**
	 * Sets up before testing
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Before
	public void setUp() {
		asort = new QuickSorter();
		bsort = new QuickSorter(comp);
		selsort = new QuickSorter(QuickSorter.FIRST_ELEMENT_SELECTOR);
		msort = new QuickSorter(QuickSorter.MIDDLE_ELEMENT_SELECTOR);
		lsort = new QuickSorter(QuickSorter.LAST_ELEMENT_SELECTOR);
		rsort = new QuickSorter(QuickSorter.RANDOM_ELEMENT_SELECTOR);
	}

	/**
	 * Tests sort function
	 */
	@Test
	public void testSortIntegers() {
		asort.sort(dataAscending);
		assertEquals(Integer.valueOf(1), dataAscending[0]);
		assertEquals(Integer.valueOf(2), dataAscending[1]);
		assertEquals(Integer.valueOf(3), dataAscending[2]);
		assertEquals(Integer.valueOf(4), dataAscending[3]);
		assertEquals(Integer.valueOf(5), dataAscending[4]);

		bsort.sort(dataDescending);
		assertEquals(Integer.valueOf(1), dataDescending[0]);
		assertEquals(Integer.valueOf(2), dataDescending[1]);
		assertEquals(Integer.valueOf(3), dataDescending[2]);
		assertEquals(Integer.valueOf(4), dataDescending[3]);
		assertEquals(Integer.valueOf(5), dataDescending[4]);

		selsort.sort(dataRandom);
		assertEquals(Integer.valueOf(1), dataRandom[0]);
		assertEquals(Integer.valueOf(2), dataRandom[1]);
		assertEquals(Integer.valueOf(3), dataRandom[2]);
		assertEquals(Integer.valueOf(4), dataRandom[3]);
		assertEquals(Integer.valueOf(5), dataRandom[4]);

		msort.sort(dataRandom);
		assertEquals(Integer.valueOf(1), dataRandom[0]);
		assertEquals(Integer.valueOf(2), dataRandom[1]);
		assertEquals(Integer.valueOf(3), dataRandom[2]);
		assertEquals(Integer.valueOf(4), dataRandom[3]);
		assertEquals(Integer.valueOf(5), dataRandom[4]);

		lsort.sort(dataRandom);
		assertEquals(Integer.valueOf(1), dataRandom[0]);
		assertEquals(Integer.valueOf(2), dataRandom[1]);
		assertEquals(Integer.valueOf(3), dataRandom[2]);
		assertEquals(Integer.valueOf(4), dataRandom[3]);
		assertEquals(Integer.valueOf(5), dataRandom[4]);

		rsort.sort(dataRandom);
		assertEquals(Integer.valueOf(1), dataRandom[0]);
		assertEquals(Integer.valueOf(2), dataRandom[1]);
		assertEquals(Integer.valueOf(3), dataRandom[2]);
		assertEquals(Integer.valueOf(4), dataRandom[3]);
		assertEquals(Integer.valueOf(5), dataRandom[4]);
	}

}
