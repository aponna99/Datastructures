package edu.ncsu.csc316.dsa.list;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class
 * 
 * @author Anisha Ponnapati
 *
 */
public class ArrayBasedListTest {

	private List<String> list;

	/**
	 * Set up before testing
	 */
	@Before
	public void setUp() {
		list = new ArrayBasedList<String>();
	}

	/**
	 * Test
	 */
	@Test
	public void testAddIndex() {
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());

		try {
			list.removeFirst();
		} catch (Exception e) {
			assertTrue(e instanceof IndexOutOfBoundsException);
		}

		try {
			list.removeLast();
		} catch (Exception e) {
			assertTrue(e instanceof IndexOutOfBoundsException);
		}

		try {
			list.remove(0);
		} catch (Exception e) {
			assertTrue(e instanceof IndexOutOfBoundsException);
		}

		list.add(0, "zero");
		assertEquals(1, list.size());
		assertEquals("zero", list.get(0));
		assertFalse(list.isEmpty());

		list.add(1, "one");
		assertEquals(2, list.size());
		assertEquals("one", list.get(1));

		list.add(2, "two");
		assertEquals(3, list.size());
		assertEquals("two", list.get(2));

		list.add(3, "three");
		assertEquals(4, list.size());
		assertEquals("three", list.get(3));

		list.add(4, "four");
		assertEquals(5, list.size());
		assertEquals("four", list.get(4));

		list.add(5, "five");
		assertEquals(6, list.size());
		assertEquals("five", list.get(5));

		list.add(6, "six");
		assertEquals(7, list.size());
		assertEquals("six", list.get(6));

		list.add(7, "seven");
		assertEquals(8, list.size());
		assertEquals("seven", list.get(7));

		list.add(8, "eight");
		assertEquals(9, list.size());
		assertEquals("eight", list.get(8));

		list.add(9, "nine");
		assertEquals(10, list.size());
		assertEquals("nine", list.get(9));

		list.add(10, "ten");
		assertEquals(11, list.size());
		assertEquals("ten", list.get(10));

		// Add Last
		list.addLast("addLast");
		assertEquals(12, list.size());
		assertEquals("addLast", list.last());

		// Remove Last
		list.removeLast();
		assertEquals("ten", list.last());
		assertEquals(11, list.size());

		// Add First
		list.addFirst("addFirst");
		assertEquals(12, list.size());
		assertEquals("addFirst", list.first());

		// Remove First
		list.removeFirst();
		assertEquals("zero", list.first());
		assertEquals(11, list.size());

		// Remove Index
		list.remove(1);
		assertEquals("two", list.get(1));

		// Set
		list.set(5, "setMethod");
		assertEquals("setMethod", list.get(5));

		try {
			list.add(15, "fifteen");
		} catch (Exception e) {
			assertTrue(e instanceof IndexOutOfBoundsException);
		}

		try {
			list.remove(15);
		} catch (Exception e) {
			assertTrue(e instanceof IndexOutOfBoundsException);
		}
	}

	/**
	 * Test
	 */
	@Test
	public void testIterator() {
		// Start with an empty list
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());

		// Create an iterator for the empty list
		Iterator<String> it = list.iterator();

		// Try different operations to make sure they work
		// as expected for an empty list (at this point)
		try {
			it.remove();
		} catch (Exception e) {
			assertTrue(e instanceof IllegalStateException);
		}
		assertFalse(it.hasNext());

		// Now add an element
		list.addLast("one");

		// Use accessor methods to check that the list is correct
		assertEquals(1, list.size());
		assertFalse(list.isEmpty());
		assertEquals("one", list.get(0));

		// Create an iterator for the list that has 1 element
		it = list.iterator();

		// Try different iterator operations to make sure they work
		// as expected for a list that contains 1 element (at this point)
		assertTrue(it.hasNext());
		assertEquals("one", it.next());
		assertFalse(it.hasNext());
		try {
			it.next();
		} catch (Exception e) {
			assertTrue(e instanceof NoSuchElementException);
		}

		it.remove();
	}
}