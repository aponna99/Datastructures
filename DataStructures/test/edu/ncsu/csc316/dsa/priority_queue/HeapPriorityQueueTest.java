package edu.ncsu.csc316.dsa.priority_queue;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.data.Student;
import edu.ncsu.csc316.dsa.data.StudentIDComparator;

/**
 * Test class
 * 
 * @author Anisha Ponnapati
 *
 */
public class HeapPriorityQueueTest {

	private PriorityQueue<Integer, String> heap;

	/**
	 * Set up before testing
	 */
	@Before
	public void setUp() {
		heap = new HeapPriorityQueue<Integer, String>();
	}

	/**
	 * Test
	 */
	@Test
	public void testInsert() {
		assertTrue(heap.isEmpty());
		assertTrue(heap.size() == 0);

		heap.insert(8, "8");
		assertEquals(1, heap.size());
		assertFalse(heap.isEmpty());
		assertEquals(8, (int) heap.min().getKey());
		
		heap.insert(6, "6");
		heap.insert(12, "12");
		heap.insert(9, "9");
		heap.insert(1, "1");
		heap.insert(69, "69");

		assertEquals("1", heap.min().getValue());
		assertEquals("1", heap.deleteMin().getValue());
		assertEquals(5, heap.size());

		assertEquals("6", heap.min().getValue());
		assertEquals("6", heap.deleteMin().getValue());
		assertEquals(4, heap.size());

		assertEquals("8", heap.min().getValue());
		assertEquals("8", heap.deleteMin().getValue());
		assertEquals(3, heap.size());

		assertEquals("9", heap.min().getValue());
		assertEquals("9", heap.deleteMin().getValue());
		assertEquals(2, heap.size());

		assertEquals("12", heap.min().getValue());
		assertEquals("12", heap.deleteMin().getValue());
		assertEquals(1, heap.size());
	}

	/**
	 * Test
	 */
	@Test
	public void testMin() {
		assertTrue(heap.isEmpty());
		assertTrue(heap.size() == 0);

		assertNull(heap.min());

		heap.insert(8, "eight");
		assertEquals(1, heap.size());
		assertFalse(heap.isEmpty());
		assertEquals(8, (int) heap.min().getKey());

		assertEquals("eight", heap.min().getValue());

		heap.deleteMin();
		assertEquals(0, heap.size());
	}

	/**
	 * Test
	 */
	@Test
	public void testStudentHeap() {
		PriorityQueue<Student, String> sHeap = new HeapPriorityQueue<Student, String>(new StudentIDComparator());
		Student s1 = new Student("J", "K", 1, 1, 1, "jk1");
		Student s2 = new Student("J", "S", 2, 1, 2, "js2");
		Student s3 = new Student("S", "H", 3, 1, 3, "sh3");
		Student s4 = new Student("J", "J", 4, 1, 4, "jj4");
		Student s5 = new Student("L", "B", 5, 1, 5, "lb5");

		assertTrue(sHeap.isEmpty());
		assertEquals(0, sHeap.size());

		sHeap.insert(s1, s1.getUnityID());
		sHeap.insert(s2, s2.getUnityID());
		sHeap.insert(s3, s3.getUnityID());
		sHeap.insert(s4, s4.getUnityID());
		sHeap.insert(s5, s5.getUnityID());

		assertFalse(sHeap.isEmpty());
		assertEquals(5, sHeap.size());
	}
}