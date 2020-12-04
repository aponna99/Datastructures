package edu.ncsu.csc316.dsa.map;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.data.Student;

/**
 * Test case
 * 
 * @author Anisha Ponnapati
 *
 */
public class SearchTableMapTest {

	private Map<Integer, String> map;
	private Map<Student, Integer> studentMap;

	/**
	 * Set up
	 */
	@Before
	public void setUp() {
		map = new SearchTableMap<Integer, String>();
		studentMap = new SearchTableMap<Student, Integer>();
	}

	/**
	 * Test
	 */
	@Test
	public void testPut() {
		assertEquals(0, map.size());
		assertTrue(map.isEmpty());
		assertNull(map.put(3, "string3"));
		assertEquals("SearchTableMap[3]", map.toString());
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
		assertEquals("SearchTableMap[1, 2, 3, 4, 5]", map.toString());

		assertEquals("string1", map.get(1));
		assertEquals("SearchTableMap[1, 2, 3, 4, 5]", map.toString());

		assertNull(map.get(0));
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
		assertEquals("SearchTableMap[1, 2, 3, 4, 5]", map.toString());

		assertNull(map.remove(0));
		assertEquals(5, map.size());
		assertFalse(map.isEmpty());
		assertEquals("SearchTableMap[1, 2, 3, 4, 5]", map.toString());

		assertEquals(map.remove(1), "string1");
		assertEquals(map.remove(2), "string2");
		assertEquals(map.remove(3), "string3");
		assertEquals(map.remove(4), "string4");
		assertEquals(map.remove(5), "string5");

		assertTrue(map.isEmpty());
	}

	/**
	 * Test
	 */
	@Test
	public void testStudentMap() {
		Student s1 = new Student("J", "K", 1, 0, 0, "jk");
		Student s2 = new Student("J", "S", 2, 0, 0, "js");
		Student s3 = new Student("S", "H", 3, 0, 0, "sh");
		Student s4 = new Student("J", "J", 4, 0, 0, "jj");
		Student s5 = new Student("L", "B", 5, 0, 0, "lb");

		studentMap.put(s1, 100);
		assertEquals(1, studentMap.size());

		studentMap.put(s4, 400);
		studentMap.put(s5, 500);
		studentMap.put(s3, 300);
		studentMap.put(s2, 200);

		assertEquals(5, studentMap.size());
		assertFalse(studentMap.isEmpty());

		assertEquals(100, (int) studentMap.get(s1));
		assertEquals(200, (int) studentMap.get(s2));
		assertEquals(300, (int) studentMap.get(s3));
		assertEquals(400, (int) studentMap.get(s4));
		assertEquals(500, (int) studentMap.get(s5));
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
		entry = it.next();
		entry = it.next();
		entry = it.next();

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
