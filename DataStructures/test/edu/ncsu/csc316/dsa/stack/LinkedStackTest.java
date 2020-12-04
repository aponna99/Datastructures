package edu.ncsu.csc316.dsa.stack;

import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.Before;
import org.junit.Test;

/**
 * Linked stack test
 * 
 * @author Anisha Ponnapati
 *
 */
public class LinkedStackTest {

	private Stack<String> stack;

	/**
	 * Before
	 */
	@Before
	public void setUp() {
		stack = new LinkedStack<String>();
	}

	/**
	 * Test
	 */
	@Test
	public void testPush() {
		assertEquals(0, stack.size());
		assertTrue(stack.isEmpty());

		try {
			stack.pop();
			fail("EmptyStackException should have been thrown.");
		} catch (Exception e) {
			assertTrue(e instanceof EmptyStackException);
		}

		stack.push("one");
		assertEquals(1, stack.size());
		assertFalse(stack.isEmpty());

		stack.push("two");
		stack.push("three");
		stack.push("four");
		stack.push("five");
		stack.push("six");
		assertEquals(6, stack.size());

		assertEquals("six", stack.pop());
		assertEquals(5, stack.size());

		assertEquals("five", stack.top());
	}

}
