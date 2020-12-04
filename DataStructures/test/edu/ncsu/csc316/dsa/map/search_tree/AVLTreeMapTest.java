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
public class AVLTreeMapTest {

	private BinarySearchTreeMap<Integer, String> tree;
	private BinarySearchTreeMap<Integer, String> tree1;

	/**
	 * Set up before testing
	 */
	@Before
	public void setUp() {
		tree = new AVLTreeMap<Integer, String>();
		tree1 = new AVLTreeMap<Integer, String>(null);

	}

	/**
	 * Test
	 */
	@Test
	public void testPut() {
		assertEquals(0, tree.size());
		assertTrue(tree.isEmpty());
		assertTrue(tree1.isEmpty());

		assertNull(tree.put(5, "string5"));
		assertEquals(1, tree.size());
		assertEquals(5, (int) tree.root().getElement().getKey());
		assertNull(tree.left(tree.root()).getElement());

		assertNull(tree.put(10, "string10"));
		assertEquals(5, (int) tree.root().getElement().getKey());
		assertNull(tree.left(tree.root()).getElement());
		assertEquals(10, (int) tree.right(tree.root()).getElement().getKey());
		assertNull(tree.left(tree.right(tree.root())).getElement());
		assertNull(tree.right(tree.right(tree.root())).getElement());
		assertEquals(2, tree.size());

	}

	/**
	 * Test
	 */
	@Test
	public void testGet() {
		assertTrue(tree.isEmpty());
		assertNull(tree.put(3, "string3"));
		assertFalse(tree.isEmpty());

		assertEquals("string3", tree.get(3));
		assertEquals(null, tree.get(6));
		assertEquals(null, tree.get(0));

	}

	/**
	 * Test
	 */
	@Test
	public void testRemove() {
		assertTrue(tree.isEmpty());
		assertNull(tree.put(1, "one"));
		assertNull(tree.put(2, "two"));
		assertNull(tree.put(3, "three"));
		assertNull(tree.put(4, "four"));
		assertNull(tree.put(5, "five"));
		assertNull(tree.put(6, "six"));
		assertNull(tree.put(7, "seven"));
		assertEquals(7, tree.size());
		assertFalse(tree.isEmpty());

		assertNull(tree.remove(0));
		assertEquals(7, tree.size());
		assertFalse(tree.isEmpty());
		assertEquals(4, (int) tree.root().getElement().getKey());
		assertEquals(2, (int) tree.left(tree.root()).getElement().getKey());
		assertEquals(1, (int) tree.left(tree.left(tree.root())).getElement().getKey());
		assertEquals(3, (int) tree.right(tree.left(tree.root())).getElement().getKey());
		assertEquals(6, (int) tree.right(tree.root()).getElement().getKey());
		assertEquals(5, (int) tree.left(tree.right(tree.root())).getElement().getKey());
		assertEquals(7, (int) tree.right(tree.right(tree.root())).getElement().getKey());

		assertEquals("six", tree.remove(6));
		assertEquals("seven", tree.remove(7));
		assertEquals("five", tree.remove(5));
		assertEquals("four", tree.remove(4));
		assertEquals("three", tree.remove(3));
		assertEquals("two", tree.remove(2));
		assertEquals("one", tree.remove(1));

	}
}
