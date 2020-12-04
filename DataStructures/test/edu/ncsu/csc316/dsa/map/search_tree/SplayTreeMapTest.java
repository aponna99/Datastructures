package edu.ncsu.csc316.dsa.map.search_tree;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class
 * 
 * @author Anisha Ponnapati
 *
 */
public class SplayTreeMapTest {

	private BinarySearchTreeMap<Integer, String> tree;
	private BinarySearchTreeMap<Integer, String> tree1;

	/**
	 * Set up before testing
	 */
	@Before
	public void setUp() {
		tree = new SplayTreeMap<Integer, String>();
		tree1 = new SplayTreeMap<Integer, String>();
	}

	/**
	 * Test
	 */
	@Test
	public void testPut() {
		assertEquals(0, tree.size());
		assertTrue(tree.isEmpty());

		assertNull(tree.put(3, "string3"));
		assertEquals(1, tree.size());
		assertEquals(3, (int) tree.root().getElement().getKey());
		assertNull(tree.left(tree.root()).getElement());

		assertEquals(0, tree1.size());
		assertTrue(tree1.isEmpty());
	}

	/**
	 * Test
	 */
	@Test
	public void testGet() {
		assertTrue(tree.isEmpty());
		assertNull(tree.put(0, "string0"));
		assertFalse(tree.isEmpty());

		assertEquals("string0", tree.get(0));
		assertEquals(null, tree.get(56));
		assertEquals(null, tree.get(1));
	}

	/**
	 * Test
	 */
	@Test
	public void testRemove() {
		assertTrue(tree.isEmpty());
		assertNull(tree.put(0, "0"));
		assertNull(tree.put(10, "10"));
		assertNull(tree.put(5, "5"));
		assertNull(tree.put(20, "20"));
		assertNull(tree.put(15, "15"));

		assertEquals(5, tree.size());
		assertFalse(tree.isEmpty());

		assertNull(tree.remove(6));
		assertEquals(5, tree.size());
		assertFalse(tree.isEmpty());

		assertEquals("0", tree.remove(0));
		assertEquals("5", tree.remove(5));
		assertEquals("15", tree.remove(15));
		assertEquals("10", tree.remove(10));
		assertEquals("20", tree.remove(20));

		assertNull(tree1.remove(0));
	}
}