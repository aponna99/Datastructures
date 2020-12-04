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
public class LinkedBinaryTreeTest {

	private LinkedBinaryTree<String> tree;
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
		tree = new LinkedBinaryTree<String>();

		try {
			tree.set(new InvalidPosition<String>(), "invalid");
			fail();
		} catch (Exception e) {
			//
		}

		Position<String> a = new InvalidPosition<String>();
		assertNull(a.getElement());
	}

	/**
	 * Sample tree to help with testing
	 *
	 * One -> Two -> Six -> Ten -> Seven -> Five -> Three -> Four -> Eight -> Nine
	 * 
	 * Or, visually: one / \ two three / \ / six ten four / \ / \ seven five eight
	 * nine
	 */
	private void createTree() {
		one = tree.addRoot("one");
		two = tree.addLeft(one, "two");
		three = tree.addRight(one, "three");
		six = tree.addLeft(two, "six");
		ten = tree.addRight(two, "ten");
		four = tree.addLeft(three, "four");
		seven = tree.addLeft(ten, "seven");
		five = tree.addRight(ten, "five");
		eight = tree.addLeft(four, "eight");
		nine = tree.addRight(four, "nine");
	}

	/**
	 * Test
	 */
	@Test
	public void testSet() {
		createTree();
		assertEquals("one", tree.set(one, "one"));
	}

	/**
	 * Test
	 */
	@Test
	public void testSize() {
		assertTrue(tree.isEmpty());
		createTree();
		assertFalse(tree.isEmpty());
		assertEquals(10, tree.size());

		assertEquals(1, tree.numChildren(three));
	}

	/**
	 * Test
	 */
	@Test
	public void testSibling() {
		assertTrue(tree.isEmpty());
		Position<String> x = tree.addRoot("one");

		assertNull(tree.sibling(x));
	}

	/**
	 * Test
	 */
	@Test
	public void testIsInternal() {
		assertTrue(tree.isEmpty());
		Position<String> x = tree.addRoot("one");

		assertFalse(tree.isInternal(x));
	}

	/**
	 * Test
	 */
	@Test
	public void isLeaf() {
		assertTrue(tree.isEmpty());
		Position<String> x = tree.addRoot("one");

		assertTrue(tree.isLeaf(x));
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
	public void testPreOrder() {
		createTree();
		Iterator<Position<String>> pre = tree.preOrder().iterator();
		assertEquals(one, pre.next());
	}

	/**
	 * Test
	 */
	@Test
	public void testPostOrder() {
		createTree();
		Iterator<Position<String>> pre = tree.postOrder().iterator();
		assertEquals(six.getElement().toString(), pre.next().getElement().toString());
	}

	/**
	 * Test
	 */
	@Test
	public void testInOrder() {
		createTree();
		Iterator<Position<String>> pre = tree.inOrder().iterator();
		assertTrue(pre.hasNext());
	}

	/**
	 * Test
	 */
	@Test
	public void testLevelOrder() {
		createTree();
		Iterator<Position<String>> pre = tree.levelOrder().iterator();
		assertEquals(one.getElement().toString(), pre.next().getElement().toString());
	}

	/**
	 * Test
	 */
	@Test
	public void testAddChildren() {
		assertTrue(tree.isEmpty());
		Position<String> x = tree.addRoot("one");
		assertEquals(1, tree.size());
		assertNull(tree.parent(x));
		assertEquals("LinkedBinaryTree[\none\n]", tree.toString());
	}

	/**
	 * Test
	 */
	@Test
	public void testRemove() {
		createTree();
		assertEquals(10, tree.size());
		assertEquals(2, tree.numChildren(four));

		try {
			tree.remove(four);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("The node has two children", e.getMessage());
		}

		tree.remove(nine);
		assertEquals("LinkedBinaryTree[\none\n two\n  six\n  ten\n   seven\n   five\n three\n  four\n   eight\n]",
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

		tree.setRoot(nine);
		assertTrue(tree.isRoot(nine));
	}
}
