package edu.ncsu.csc316.dsa.disjoint_set;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.Position;

/**
 * Test class
 * 
 * @author Anisha Ponnapati
 *
 */
public class UpTreeDisjointSetForestTest {

	private DisjointSetForest<String> set;

	/**
	 * Set up before testing
	 */
	@Before
	public void setUp() {
		set = new UpTreeDisjointSetForest<>();
	}

	/**
	 * Test
	 */
	@Test
	public void testMakeSet() {
		Position<String> one = set.makeSet("one");
		assertEquals("one", one.getElement());
		Position<String> two = set.makeSet("two");
		assertEquals("two", two.getElement());

	}

	/**
	 * Test
	 */
	@Test
	public void testUnionFind() {
		Position<String> one = set.makeSet("one");
		Position<String> two = set.makeSet("two");
		Position<String> three = set.makeSet("three");
		Position<String> four = set.makeSet("four");
		Position<String> five = set.makeSet("five");
		Position<String> six = set.makeSet("six");
		Position<String> seven = set.makeSet("seven");
		Position<String> eight = set.makeSet("eight");
		Position<String> nine = set.makeSet("nine");
		Position<String> ten = set.makeSet("ten");

		assertEquals(one, set.find("one"));
		assertEquals(two, set.find("two"));
		assertEquals(three, set.find("three"));

		set.union(four, ten);

		assertEquals("ten", set.find("ten").getElement());

		assertEquals(five, set.find("five"));
		assertEquals(six, set.find("six"));
		assertEquals(seven, set.find("seven"));
		assertEquals(eight, set.find("eight"));
		assertEquals(nine, set.find("nine"));
	}
}
