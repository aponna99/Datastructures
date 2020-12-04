package edu.ncsu.csc316.dsa.tree;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.Position;

/**
 * Test class
 * 
 * @author Anisha Ponnapati
 *
 */
public class GeneralTreeTest {

	private GeneralTree<String> tree;
	private GeneralTree<String> emptyTree;

	private Position<String> one;
	private Position<String> two;
	private Position<String> three;
	private Position<String> four;
	private Position<String> five;
	private Position<String> six;
	private Position<String> seven;
	private Position<String> eight;
	private Position<String> nine;
	private Position<String> ten;

	/**
	 * Inner class
	 * 
	 * @author Anisha Ponnapati
	 *
	 * @param <E>
	 */
	private class InvalidPosition<E> implements Position<E> {

		@Override
		public E getElement() {
			return null;
		}

	}

	/**
	 * Set up before testing
	 */
	@Before
	public void setUp() {
		tree = new GeneralTree<String>();
		emptyTree = new GeneralTree<String>();
	}

	/**
	 * Helper method to construct a sample tree
	 *
	 * One -> Two -> Six -> Five -> Ten -> Seven -> Three -> Four -> Eight -> Nine
	 *
	 * Or, visually: one / \ two three / | \ | six five ten four | / \ seven eight
	 * nine
	 */
	private void createTree() {
		one = tree.addRoot("one");
		two = tree.addChild(one, "two");
		three = tree.addChild(one, "three");
		six = tree.addChild(two, "six");
		five = tree.addChild(two, "five");
		ten = tree.addChild(two, "ten");
		seven = tree.addChild(ten, "seven");
		four = tree.addChild(three, "four");
		eight = tree.addChild(four, "eight");
		nine = tree.addChild(four, "nine");
	}

	/**
	 * Test
	 */
	@Test
	public void testSet() {
		createTree();
		assertEquals("one", tree.set(one, "ONE"));

		try {
			tree.set(new InvalidPosition<String>(), "invalid");
			fail();
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}

		Position<String> x = new InvalidPosition<String>();
		assertNull(x.getElement());
	}

	/**
	 * Test
	 */
	@Test
	public void testSize() {
		assertTrue(tree.isEmpty());
		createTree();
		assertEquals(10, tree.size());
		assertFalse(tree.isEmpty());

		assertEquals(2, tree.numChildren(one));
	}

	/**
	 * Test
	 */
	@Test
	public void testNumChildren() {
		createTree();
		assertTrue(tree.isRoot(one));
		assertFalse(tree.isRoot(two));
	}

	/**
	 * Test
	 */
	@Test
	public void isRoot() {
		createTree();
		assertTrue(tree.isRoot(one));
		assertFalse(tree.isRoot(two));

	}

	/**
	 * Test
	 */
	@Test
	public void testIsEmpty() {
		assertTrue(emptyTree.isEmpty());

		createTree();
		assertFalse(tree.isEmpty());
	}

	/**
	 * Test
	 */
	@Test
	public void testPreOrder() {
		createTree();
		Iterator<Position<String>> pre = tree.preOrder().iterator();
		assertEquals(one, pre.next());
	}

	/**
	 * Test
	 */
	@Test
	public void testIterator() {
		createTree();
		Iterator<String> pre = tree.iterator();
		assertEquals("one", pre.next());

		assertTrue(pre.hasNext());

		try {
			pre.remove();
			fail();
		} catch (UnsupportedOperationException e) {
			assertEquals("The remove operation is not supported yet.", e.getMessage());
		}
	}

	/**
	 * Test
	 */
	@Test
	public void testPostOrder() {
		createTree();
		Iterator<Position<String>> post = tree.postOrder().iterator();
		assertTrue(post.hasNext());
	}

	/**
	 * Test
	 */
	@Test
	public void testLevelOrder() {
		createTree();
		Iterator<Position<String>> level = tree.levelOrder().iterator();
		assertTrue(level.hasNext());
	}

	/**
	 * Test
	 */
	@Test
	public void testAddChild() {
		assertTrue(tree.isEmpty());
		Position<String> x = tree.addRoot("one");
		assertEquals(1, tree.size());
		assertNull(tree.parent(x));
		assertEquals("GeneralTree[\none\n]", tree.toString());
	}

	/**
	 * Test
	 */
	@Test
	public void testRemove() {
		createTree();
		assertEquals(10, tree.size());
		assertEquals(2, tree.numChildren(four));
		tree.remove(nine);
		assertEquals("GeneralTree[\none\n two\n  six\n  five\n  ten\n   seven\n three\n  four\n   eight\n]",
				tree.toString());
		assertEquals(9, tree.size());
		assertEquals(1, tree.numChildren(four));

		tree.remove(eight);
		tree.remove(seven);
		tree.remove(six);
		tree.remove(five);
		tree.remove(four);
		tree.remove(three);
		tree.remove(two);
		assertTrue(tree.isRoot(one));
		tree.remove(one);
	}

	/**
	 * Test
	 */
	@Test
	public void testEmptyTree() {
		Tree<String> bTree = new GeneralTree<String>();
		assertTrue(bTree.isEmpty());
	}

}