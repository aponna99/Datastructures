package edu.ncsu.csc316.dsa.map.search_tree;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.Position;
import edu.ncsu.csc316.dsa.map.Map.Entry;

/**
 * Test class
 * 
 * @author Anisha Ponnapati
 *
 */
public class BinarySearchTreeMapTest {

	BinarySearchTreeMap<Integer, String> tree;
	BinarySearchTreeMap<Integer, String> nulltree;

	/**
	 * Set up before test
	 */
	@Before
	public void setUp() {
		tree = new BinarySearchTreeMap<Integer, String>();
		nulltree = new BinarySearchTreeMap<Integer, String>(null);
	}

	/**
	 * Test
	 */
	@Test
	public void testPut() {
		assertEquals(0, tree.size());
		assertTrue(tree.isEmpty());
		tree.put(1, "one");
		assertEquals(1, tree.size());
		assertFalse(tree.isEmpty());
		assertEquals(1, (int) tree.root().getElement().getKey());
	}

	/**
	 * Test
	 */
	@Test
	public void testGet() {
		tree.put(1, "one");
		assertEquals(1, tree.size());

		tree.put(5, "5");
		tree.put(10, "10");
		tree.put(15, "15");
		tree.put(20, "20");

		assertEquals("15", tree.get(15));

		assertNull(tree.remove(11));
		assertEquals(5, tree.size());

		assertEquals("one", tree.remove(1));
		assertEquals(4, tree.size());

		tree.put(0, "0");

		// InOrder Iterator
		Iterator<Position<Entry<Integer, String>>> inOrderIt = tree.inOrder().iterator();

		assertTrue(inOrderIt.hasNext());
		assertEquals("0", inOrderIt.next().getElement().getValue());
		assertTrue(inOrderIt.hasNext());
		// assertNull(inOrderIt.next().getElement());

		assertTrue(inOrderIt.hasNext());
		assertEquals("5", inOrderIt.next().getElement().getValue());
		// assertNull(inOrderIt.next().getElement());

		assertTrue(inOrderIt.hasNext());
		assertEquals("10", inOrderIt.next().getElement().getValue());
		// assertNull(inOrderIt.next().getElement());

		assertTrue(inOrderIt.hasNext());
		assertEquals("15", inOrderIt.next().getElement().getValue());
		// assertNull(inOrderIt.next().getElement());

		assertTrue(inOrderIt.hasNext());
		assertEquals("20", inOrderIt.next().getElement().getValue());
		assertFalse(inOrderIt.hasNext());
		// assertNull(inOrderIt.next().getElement());

		assertFalse(inOrderIt.hasNext());

		// PreOrder Iterator
		Iterator<Position<Entry<Integer, String>>> preOrderIt = tree.preOrder().iterator();

		assertTrue(preOrderIt.hasNext());

		assertEquals("5", preOrderIt.next().getElement().getValue());
		assertTrue(preOrderIt.hasNext());
		// assertNull(preOrderIt.next().getElement());

		assertTrue(preOrderIt.hasNext());
		assertEquals("0", preOrderIt.next().getElement().getValue());
		assertNull(preOrderIt.next().getElement());
		assertNull(preOrderIt.next().getElement());
		assertEquals("10", preOrderIt.next().getElement().getValue());
		assertTrue(preOrderIt.hasNext());
		// assertNull(preOrderIt.next().getElement());

		assertTrue(preOrderIt.hasNext());
		assertNull(preOrderIt.next().getElement());
		assertEquals("15", preOrderIt.next().getElement().getValue());
		assertNull(preOrderIt.next().getElement());

		assertEquals("20", preOrderIt.next().getElement().getValue());
		assertTrue(preOrderIt.hasNext());
		// assertNull(preOrderIt.next().getElement());

		Iterator<Position<Entry<Integer, String>>> postOrderIt = tree.postOrder().iterator();

		assertTrue(postOrderIt.hasNext());
		assertNull(postOrderIt.next().getElement());

		assertTrue(postOrderIt.hasNext());
		assertNull(postOrderIt.next().getElement());

		assertTrue(postOrderIt.hasNext());
		// assertNull(postOrderIt.next().getElement());

		assertTrue(postOrderIt.hasNext());
		// assertNull(postOrderIt.next().getElement());

		assertTrue(postOrderIt.hasNext());
		// assertNull(postOrderIt.next().getElement());

		assertTrue(postOrderIt.hasNext());
		// assertNull(postOrderIt.next().getElement());

		assertEquals("0", postOrderIt.next().getElement().getValue());
		assertTrue(postOrderIt.hasNext());

		assertTrue(postOrderIt.hasNext());
		assertNull(postOrderIt.next().getElement());
		assertNull(postOrderIt.next().getElement());
		assertNull(postOrderIt.next().getElement());
		assertNull(postOrderIt.next().getElement());
		assertEquals("20", postOrderIt.next().getElement().getValue());

		assertEquals("15", postOrderIt.next().getElement().getValue());
		assertTrue(postOrderIt.hasNext());

		assertTrue(postOrderIt.hasNext());
		assertEquals("10", postOrderIt.next().getElement().getValue());

		assertEquals("5", postOrderIt.next().getElement().getValue());
		assertFalse(postOrderIt.hasNext());

		tree.remove(0);

		Iterator<Position<Entry<Integer, String>>> levelOrderIt = tree.levelOrder().iterator();

		assertTrue(levelOrderIt.hasNext());
		assertEquals("5", levelOrderIt.next().getElement().getValue());

		assertTrue(levelOrderIt.hasNext());
		assertNull(levelOrderIt.next().getElement());

		assertTrue(levelOrderIt.hasNext());
		assertEquals("10", levelOrderIt.next().getElement().getValue());

		assertTrue(levelOrderIt.hasNext());
		assertNull(levelOrderIt.next().getElement());

		assertTrue(levelOrderIt.hasNext());
		assertEquals("15", levelOrderIt.next().getElement().getValue());

		assertTrue(levelOrderIt.hasNext());
		assertNull(levelOrderIt.next().getElement());

		assertTrue(levelOrderIt.hasNext());
		assertEquals("20", levelOrderIt.next().getElement().getValue());

		assertTrue(levelOrderIt.hasNext());
		assertNull(levelOrderIt.next().getElement());

		assertTrue(levelOrderIt.hasNext());
		assertNull(levelOrderIt.next().getElement());

		assertFalse(levelOrderIt.hasNext());

		Iterator<Position<Entry<Integer, String>>> it = tree.children(tree.root()).iterator();
		assertEquals(2, tree.numChildren(tree.root()));

		assertTrue(it.hasNext());
		assertNull(it.next().getElement());

		assertTrue(it.hasNext());
		assertEquals("10", it.next().getElement().getValue());

		assertFalse(it.hasNext());

		Iterator<Entry<Integer, String>> es = tree.entrySet().iterator();
		assertTrue(es.hasNext());
		assertTrue(es.hasNext());
	}
}