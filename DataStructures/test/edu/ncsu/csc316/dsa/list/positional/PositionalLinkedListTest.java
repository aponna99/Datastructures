package edu.ncsu.csc316.dsa.list.positional;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.Position;

/**
 * Positional Linked List Test
 * 
 * @author Anisha Ponnapati
 *
 */
public class PositionalLinkedListTest {

	private PositionalList<String> list;

	/**
	 * Before
	 */
	@Before
	public void setUp() {
		list = new PositionalLinkedList<String>();
	}

	/**
	 * Test
	 */
	@Test
	public void testFirst() {
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());

		Position<String> first = list.addFirst("one");
		assertEquals(1, list.size());
		assertEquals(first, list.first());
		assertFalse(list.isEmpty());

		Position<String> last = list.addLast("ten");
		assertEquals(2, list.size());
		assertEquals(last, list.last());

		try {
			list.before(first);
			fail();
		} catch (Exception e) {
			assertTrue(e instanceof NoSuchElementException);
		}

		assertEquals(first, list.before(last));

		try {
			list.after(last);
			fail();
		} catch (Exception e) {
			assertTrue(e instanceof NoSuchElementException);
		}

		assertEquals(last, list.after(first));

		list.addBefore(first, "zero");
		list.addAfter(first, "middle");
		assertEquals(4, list.size());

		list.set(last, "lastL");
		assertEquals("lastL", last.getElement());

		assertEquals("lastL", list.remove(last));
	}

	/**
	 * Test
	 */
	@Test
	public void testIterator() {
		Iterator<String> it = list.iterator();

		try {
			it.remove();
		} catch (Exception e) {
			assertTrue(e instanceof IllegalStateException);
		}

		list.addFirst("one");
		list.addLast("two");
		list.addLast("three");

		it = list.iterator();

		assertTrue(it.hasNext());
		assertEquals("one", it.next());
		it.remove();
		assertEquals(2, list.size());
		assertEquals("two", it.next());
		assertEquals("three", it.next());
	}

	/**
	 * Test
	 */
	@Test
	public void testPositions() {
		assertEquals(0, list.size());
		Position<String> first = list.addFirst("one");
		Position<String> second = list.addLast("two");
		Position<String> third = list.addLast("three");
		assertEquals(3, list.size());

		Iterator<Position<String>> it = list.positions().iterator();
		assertTrue(it.hasNext());
		assertEquals(first, it.next());
		assertEquals(second, it.next());
		it.remove();
		assertEquals(2, list.size());
		assertEquals(third, it.next());
	}

}