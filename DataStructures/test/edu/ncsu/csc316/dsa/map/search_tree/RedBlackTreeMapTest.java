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
public class RedBlackTreeMapTest {

	private BinarySearchTreeMap<Integer, String> tree;
	private BinarySearchTreeMap<Integer, String> tree1;

	/**
	 * Set up before test
	 */
	@Before
	public void setUp() {
		tree = new RedBlackTreeMap<Integer, String>();
		tree1 = new RedBlackTreeMap<Integer, String>(null);
	}

	/**
	 * Test
	 */
	@Test
	public void testPut() {
		assertEquals(0, tree.size());
		assertTrue(tree.isEmpty());
		assertTrue(tree1.isEmpty());

		assertNull(tree.put(4, "four"));
		assertEquals(1, tree.size());
		assertFalse(tree.isEmpty());
		assertEquals(4, (int) tree.root().getElement().getKey());

		assertNull(tree.put(7, "seven"));
		assertEquals(2, tree.size());
		assertEquals(4, (int) tree.root().getElement().getKey());
		assertEquals(7, (int) tree.right(tree.root()).getElement().getKey());

		assertNull(tree.put(12, "twelve"));
		assertEquals(3, tree.size());
		assertEquals(7, (int) tree.root().getElement().getKey());
		assertEquals(4, (int) tree.left(tree.root()).getElement().getKey());
		assertEquals(12, (int) tree.right(tree.root()).getElement().getKey());

		assertNull(tree.put(0, "0"));
		assertNull(tree.put(8, "8"));
		assertNull(tree.put(5, "5"));
		assertNull(tree.put(20, "20"));

		assertEquals("8", tree.remove(8));
		assertEquals("seven", tree.remove(7));
		assertEquals("four", tree.remove(4));
		assertEquals("twelve", tree.remove(12));
		assertEquals("5", tree.remove(5));

	}

}