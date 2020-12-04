package edu.ncsu.csc316.dsa.set;

import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class
 * 
 * @author Anisha Ponnapati
 *
 */
public class TreeSetTest {

	private Set<Integer> set;

	/**
	 * Set up before
	 */
	@Before
	public void setUp() {
		set = new TreeSet<Integer>();
	}

	/**
	 * Test
	 */
	@Test
	public void testAdd() {
		assertTrue(set.isEmpty());
		assertEquals(0, set.size());

		set.add(5);
		assertEquals(1, set.size());
		assertFalse(set.isEmpty());
	}

	/**
	 * Test
	 */
	@Test
	public void testContains() {
		assertTrue(set.isEmpty());
		assertEquals(0, set.size());
		set.add(5);
		set.add(10);
		set.add(15);
		set.add(20);
		set.add(25);
		assertEquals(5, set.size());

		assertTrue(set.contains(5));
		assertEquals(5, (int) set.remove(5));
		assertEquals(4, set.size());

	}

	/**
	 * Test
	 */
	@Test
	public void testRetainAll() {
		assertTrue(set.isEmpty());
		assertEquals(0, set.size());
		set.add(5);
		set.add(10);
		set.add(15);
		set.add(20);
		set.add(25);
		assertEquals(5, set.size());

		Set<Integer> other = new TreeSet<Integer>();
		other.add(10);
		other.add(20);
		other.add(30);

		set.retainAll(other);
		assertEquals(2, set.size());
		assertTrue(set.contains(10));
		assertTrue(set.contains(20));
	}

	/**
	 * Test
	 */
	@Test
	public void testRemoveAll() {
		assertTrue(set.isEmpty());
		assertEquals(0, set.size());
		set.add(5);
		set.add(10);
		set.add(15);
		set.add(20);
		set.add(25);
		assertEquals(5, set.size());

		Set<Integer> other = new TreeSet<Integer>();
		other.add(10);
		other.add(20);
		other.add(30);

		set.removeAll(other);
		assertEquals(3, set.size());
		assertTrue(set.contains(25));
	}

	/**
	 * Test
	 */
	@Test
	public void testAddAll() {
		assertTrue(set.isEmpty());
		assertEquals(0, set.size());
		set.add(5);
		set.add(10);
		set.add(15);
		set.add(20);
		set.add(25);
		assertEquals(5, set.size());

		Set<Integer> other = new TreeSet<Integer>();
		other.add(30);
		other.add(40);
		other.add(50);

		set.addAll(other);
		assertEquals(8, set.size());
	}

	/**
	 * Test
	 */
	@Test
	public void testIterator() {
		assertTrue(set.isEmpty());
		assertEquals(0, set.size());
		set.add(5);
		set.add(10);
		set.add(15);
		set.add(20);
		set.add(25);
		assertEquals(5, set.size());

		Iterator<Integer> it = set.iterator();
		assertTrue(it.hasNext());
	}
}
