package edu.ncsu.csc316.dsa.map.hashing;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.map.Map;

/**
 * Test class
 * 
 * @author Anisha Ponnapati
 *
 */
public class LinearProbingHashMapTest {

	private Map<Integer, String> map;
	@SuppressWarnings("unused")
	private Map<Integer, String> map1;
	@SuppressWarnings("unused")
	private Map<Integer, String> map2;
	@SuppressWarnings("unused")
	private Map<Integer, String> map3;

	/**
	 * Set up before test
	 */
	@Before
	public void setUp() {
		// Use the "true" flag to indicate we are testing.
		// Remember that (when testing) alpha = 1, beta = 1, and prime = 7
		// based on our AbstractHashMap constructor.
		// That means you can draw the hash table by hand
		// if you use integer keys, since Integer.hashCode() = the integer value, itself
		// Finally, apply compression. For example:
		// for key = 1: h(1) = ( (1 * 1 + 1) % 7) % 7 = 2
		// for key = 2: h(2) = ( (1 * 2 + 1) % 7) % 7 = 3
		// for key = 3: h(3) = ( (1 * 3 + 1) % 7) % 7 = 4
		// for key = 4: h(4) = ( (1 * 4 + 1) % 7) % 7 = 5
		// for key = 5: h(5) = ( (1 * 5 + 1) % 7) % 7 = 6
		// for key = 6: h(6) = ( (1 * 6 + 1) % 7) % 7 = 0
		// etc.
		map = new LinearProbingHashMap<Integer, String>(7, true);
		map1 = new LinearProbingHashMap<Integer, String>(false);
		map2 = new LinearProbingHashMap<Integer, String>(7);
		map3 = new LinearProbingHashMap<Integer, String>();
	}

	/**
	 * Test
	 */
	@Test
	public void testPut() {
		assertEquals(0, map.size());
		assertTrue(map.isEmpty());
		assertNull(map.put(3, "string3"));
		assertEquals(1, map.size());
		assertFalse(map.isEmpty());

		// Since our entrySet method returns the entries in the table
		// from left to right, we can use the entrySet to check
		// that our values are in the correct order in the hash table.
		// Alternatively, you could implement a toString() method if you
		// want to check that the exact index of each entry is correct
		Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
		assertEquals(3, (int) it.next().getKey()); // should be index 4

		assertNull(map.put(4, "string4"));
		assertEquals(2, map.size());
		assertFalse(map.isEmpty());
		it = map.entrySet().iterator();
		assertEquals(3, (int) it.next().getKey()); // should be index 4
		assertEquals(4, (int) it.next().getKey()); // should be index 5
	}

	/**
	 * Test
	 */
	@Test
	public void testIterator() {
		assertNull(map.put(3, "string3"));
		assertNull(map.put(5, "string5"));
		assertNull(map.put(2, "string2"));
		assertNull(map.put(4, "string4"));
		assertNull(map.put(1, "string1"));

		Iterator<Integer> it = map.iterator();
		assertTrue(it.hasNext());

		assertEquals("string1", map.get(1));
		assertEquals("string1", map.remove(1));
	}

	/**
	 * Test
	 */
	@Test
	public void testEntrySet() {
		assertNull(map.put(3, "string3"));
		assertNull(map.put(5, "string5"));
		assertNull(map.put(2, "string2"));
		assertNull(map.put(4, "string4"));
		assertNull(map.put(1, "string1"));
		assertNull(map.put(6, "string6"));

		Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
		assertTrue(it.hasNext());
		assertEquals(6, (int) it.next().getKey()); // should be index 0
	}

	/**
	 * Test
	 */
	@Test
	public void testValues() {
		assertNull(map.put(3, "string3"));
		assertNull(map.put(5, "string5"));
		assertNull(map.put(2, "string2"));
		assertNull(map.put(4, "string4"));
		assertNull(map.put(1, "string1"));
		assertNull(map.put(6, "string6"));

		Iterator<String> it = map.values().iterator();
		assertTrue(it.hasNext());
	}
}