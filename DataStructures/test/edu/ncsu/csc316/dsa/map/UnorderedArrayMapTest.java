package edu.ncsu.csc316.dsa.map;

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
public class UnorderedArrayMapTest {

	private Map<Integer, String> map;

	/**
	 * Set up
	 */
	@Before
	public void setUp() {
		map = new UnorderedArrayMap<Integer, String>();
	}

	/**
	 * Test
	 */
	@Test
	public void testPut() {
		assertEquals(0, map.size());
		assertTrue(map.isEmpty());
		assertNull(map.put(3, "string3"));
		assertEquals("UnorderedArrayMap[3]", map.toString());
		assertEquals(1, map.size());

	}

	/**
	 * Test
	 */
	@Test
	public void testGet() {
		assertTrue(map.isEmpty());
		assertNull(map.put(3, "string3"));
		assertNull(map.put(5, "string5"));
		assertNull(map.put(2, "string2"));
		assertNull(map.put(4, "string4"));
		assertNull(map.put(1, "string1"));
		assertFalse(map.isEmpty());
		assertEquals("UnorderedArrayMap[1, 4, 2, 5, 3]", map.toString());

		assertEquals("string1", map.get(1));
		assertEquals("UnorderedArrayMap[1, 4, 2, 5, 3]", map.toString());

		assertNull(map.get(0));
		assertEquals("string3", map.get(3));
	}

	/**
	 * Test
	 */
	@Test
	public void testRemove() {
		assertTrue(map.isEmpty());
		assertNull(map.put(3, "string3"));
		assertNull(map.put(5, "string5"));
		assertNull(map.put(2, "string2"));
		assertNull(map.put(4, "string4"));
		assertNull(map.put(1, "string1"));
		assertFalse(map.isEmpty());
		assertEquals("UnorderedArrayMap[1, 4, 2, 5, 3]", map.toString());

		assertNull(map.remove(0));
		assertEquals(5, map.size());
		assertFalse(map.isEmpty());
		assertEquals("UnorderedArrayMap[1, 4, 2, 5, 3]", map.toString());

		assertEquals(map.remove(5), "string5");
		assertEquals(map.remove(3), "string3");
		assertEquals(map.remove(2), "string2");
		assertEquals(map.remove(1), "string1");
		assertEquals(map.remove(4), "string4");
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

		Integer entry = it.next();
		assertEquals(1, (int) (entry));

		entry = it.next();
		assertEquals(4, (int) (entry));

		entry = it.next();
		assertEquals(2, (int) (entry));

		entry = it.next();
		assertEquals(5, (int) (entry));

		entry = it.next();
		assertEquals(3, (int) (entry));

		assertFalse(it.hasNext());
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

		Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
		assertTrue(it.hasNext());
		Map.Entry<Integer, String> entry = it.next();
		assertEquals(1, (int) (entry.getKey()));
		assertEquals("string1", (String) (entry.getValue()));

		entry = it.next();

		entry = it.next();

		entry = it.next();

		entry = it.next();

		assertFalse(it.hasNext());
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

		Iterator<String> it = map.values().iterator();
		assertTrue(it.hasNext());

		String entry = it.next();
		assertEquals("string1", (String) (entry));

		entry = it.next();

		entry = it.next();

		entry = it.next();

		entry = it.next();

		assertFalse(it.hasNext());
	}
}
