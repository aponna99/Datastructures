/**
 * 
 */
package edu.ncsu.csc316.dsa.sorter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.data.Student;

/**
 * MergeSorter Test
 * 
 * @author Anisha Ponnapati
 *
 */
public class MergeSorterTest {

	private Integer[] dataAscending = { 1, 2, 3, 4, 5 };
	private Integer[] dataDescending = { 5, 4, 3, 2, 1 };
	private Integer[] dataRandom = { 4, 1, 5, 3, 2 };
	private String[] ran = { "NC", "VT", "WA", "CA", "OH", "MN", "AL"};

	@SuppressWarnings("rawtypes")
	private MergeSorter integerSorter;

	/**
	 * Set up before testing
	 */
	@SuppressWarnings("rawtypes")
	@Before
	public void setUp() {
		integerSorter = new MergeSorter();
	}

	/**
	 * Tests integers
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testSortIntegers() {
		integerSorter.sort(ran);
		assertEquals(Integer.valueOf(1), dataAscending[0]);
		assertEquals(Integer.valueOf(2), dataAscending[1]);
		assertEquals(Integer.valueOf(3), dataAscending[2]);
		assertEquals(Integer.valueOf(4), dataAscending[3]);
		assertEquals(Integer.valueOf(5), dataAscending[4]);
		integerSorter.sort(dataAscending);
		assertEquals(Integer.valueOf(1), dataAscending[0]);
		assertEquals(Integer.valueOf(2), dataAscending[1]);
		assertEquals(Integer.valueOf(3), dataAscending[2]);
		assertEquals(Integer.valueOf(4), dataAscending[3]);
		assertEquals(Integer.valueOf(5), dataAscending[4]);

		integerSorter.sort(dataDescending);
		assertEquals(Integer.valueOf(1), dataDescending[0]);
		assertEquals(Integer.valueOf(2), dataDescending[1]);
		assertEquals(Integer.valueOf(3), dataDescending[2]);
		assertEquals(Integer.valueOf(4), dataDescending[3]);
		assertEquals(Integer.valueOf(5), dataDescending[4]);

		integerSorter.sort(dataRandom);
		assertEquals(Integer.valueOf(1), dataRandom[0]);
		assertEquals(Integer.valueOf(2), dataRandom[1]);
		assertEquals(Integer.valueOf(3), dataRandom[2]);
		assertEquals(Integer.valueOf(4), dataRandom[3]);
		assertEquals(Integer.valueOf(5), dataRandom[4]);
	}

	/**
	 * Tests students
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testSortStudent() {
		Student student1 = new Student("Anisha", "P", 200181956, 15, 3.0, "aponnap");
		Student student2 = new Student("Leisha", "Yee", 2, 15, 1.57, "yeel");
		Student student3 = new Student("Avery", "Fisk", 4, 17, 4.1, "fiska");
		Student student4 = new Student("Isaac", "Avila", 5, 12, 3.9, "avilai");
		Student student5 = new Student("Dolores", "Conti", 8, 13, 3.9, "contid");

		Student[] students = new Student[5];
		students[0] = student1;
		students[1] = student2;
		students[2] = student3;
		students[3] = student4;
		students[4] = student5;

		integerSorter.sort(students);

		assertEquals(students[0], student4);
		assertEquals(students[1], student5);
		assertEquals(students[2], student3);
		assertEquals(students[3], student1);
		assertEquals(students[4], student2);
	}

}
