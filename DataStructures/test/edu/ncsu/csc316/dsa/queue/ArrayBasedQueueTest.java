package edu.ncsu.csc316.dsa.queue;

import static org.junit.Assert.*;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

/**
 * Array based queue test
 * 
 * @author Anisha Ponnapati
 *
 */
public class ArrayBasedQueueTest {

	private Queue<String> queue;

	/**
	 * Before
	 */
	@Before
	public void setUp() {
		queue = new ArrayBasedQueue<String>();
	}

	/**
	 * Test
	 */
	@Test
	public void testEnqueue() {
		assertEquals(0, queue.size());
		assertTrue(queue.isEmpty());

		queue.enqueue("one");
		assertEquals(1, queue.size());
		assertFalse(queue.isEmpty());

		assertEquals("one", queue.front());
		
		queue.enqueue("onee");
		queue.enqueue("two");
		queue.enqueue("three");
		queue.enqueue("four");
		queue.enqueue("five");
		queue.enqueue("six");
		queue.enqueue("seven");
		queue.enqueue("eight");
		queue.enqueue("nine");
		queue.enqueue("ten");
		queue.enqueue("eleven");
		queue.enqueue("tweleve");
	}

	/**
	 * Test
	 */
	@Test
	public void testDequeue() {
		assertEquals(0, queue.size());
		queue.enqueue("one");
		queue.enqueue("two");
		queue.enqueue("three");
		queue.enqueue("four");
		queue.enqueue("five");
		queue.enqueue("six");
		assertEquals(6, queue.size());

		assertEquals("one", queue.dequeue());
		assertEquals(5, queue.size());

		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();

		try {
			queue.dequeue();
			fail();
		} catch (Exception e) {
			assertTrue(e instanceof NoSuchElementException);
		}
	}

}
