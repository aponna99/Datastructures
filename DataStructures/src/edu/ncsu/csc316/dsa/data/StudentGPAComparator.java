package edu.ncsu.csc316.dsa.data;

import java.util.Comparator;

/**
 * Comparator for comparing Students based on GPA
 * 
 * @author Dr. King
 * @author Anisha Ponnapati
 */
public class StudentGPAComparator implements Comparator<Student> {

	/**
	 * Compares students based on GPA in descending order
	 * 
	 * @param one Student one
	 * @param two Student two
	 */
	@Override
	public int compare(Student one, Student two) {
		if (one.getGpa() < two.getGpa()) {
			return 1;
		} else if (one.getGpa() > two.getGpa()) {
			return -1;
		} else {
			return 0;
		}
	}

}
