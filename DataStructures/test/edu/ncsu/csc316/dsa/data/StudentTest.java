package edu.ncsu.csc316.dsa.data;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class
 * 
 * @author Anisha Ponnapati
 *
 */
public class StudentTest {

	private Student sOne;
	private Student sTwo;
	private Student sThree;
	private Student sFour;
	private Student sFive;

	/**
	 * Setup before test
	 */
	@Before
	public void setUp() {
		sOne = new Student("OneFirst", "OneLast", 1, 1, 1.0, "oneUnityID");
		sTwo = new Student("TwoFirst", "TwoLast", 2, 2, 2.0, "twoUnityID");
		sThree = new Student("ThreeFirst", "ThreeLast", 3, 3, 3.0, "threeUnityID");
		sFour = new Student("FourFirst", "FourLast", 4, 4, 4.0, "fourUnityID");
		sFive = new Student("FiveFirst", "FiveLast", 5, 5, 5.0, "fiveUnityID");
	}

	/**
	 * Test
	 */
	@Test
	public void testSetFirst() {
		sOne.setFirst("newOne");
		assertEquals("newOne", sOne.getFirst());
	}

	/**
	 * Test
	 */
	@Test
	public void testSetLast() {
		sOne.setLast("newOne");
		assertEquals("newOne", sOne.getLast());
	}

	/**
	 * Test
	 */
	@Test
	public void testSetId() {
		sOne.setId(100);
		assertEquals(100, sOne.getId());
	}

	/**
	 * Test
	 */
	@Test
	public void testSetGpa() {
		sOne.setGpa(3.51);
		assertEquals(3.51, sOne.getGpa(), 0.001);
	}

	/**
	 * Test
	 */
	@Test
	public void testSetUnityID() {
		sOne.setUnityID("oneUnity");
		assertEquals("oneUnity", sOne.getUnityID());
	}

	/**
	 * Test
	 */
	@Test
	public void testCreditHours() {
		sOne.setCreditHours(15);
		assertEquals(15, sOne.getCreditHours());
	}

	/**
	 * Test
	 */
	@Test
	public void testHash() {
		assertNotEquals(sThree.hashCode(), sFive.hashCode());
	}

	/**
	 * Test
	 */
	@Test
	public void testEquals() {
		assertTrue(sOne.equals(sOne));
		assertFalse(sThree.equals(sFour));
	}

	/**
	 * Test
	 */
	@Test
	public void testToString() {
		assertEquals("5, FiveFirst FiveLast", sFive.toString());
	}

	/**
	 * Test
	 */
	@Test
	public void testCompareTo() {
		assertTrue(sOne.compareTo(sTwo) < 0);
		assertTrue(sTwo.compareTo(sOne) > 0);
		assertTrue(sOne.compareTo(sOne) == 0);
		assertTrue(sTwo.compareTo(sTwo) == 0);

		sThree.setLast("OneLast");
		sFour.setFirst("OneFirst");
		sFour.setLast("OneLast");

		assertTrue(sThree.compareTo(sOne) > 0);
		sThree.setFirst("OneFirst");
		assertTrue(sThree.compareTo(sFour) < 0);
		assertTrue(sFour.compareTo(sThree) > 0);
	}

}
