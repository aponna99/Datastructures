package edu.ncsu.csc316.dsa.data;

import java.util.Objects;

/**
 * A student is comparable and identifiable. Students have a first name, last
 * name, id number, number of credit hours, gpa, and unityID.
 * 
 * @author Dr. King
 * @author Anisha Ponnapati
 */
public class Student implements Comparable<Student>, Identifiable {

	/** First name of Student */
	private String first;
	/** Last name of Student */
	private String last;
	/** ID of Student */
	private int id;
	/** Credit hours of a Student */
	private int creditHours;
	/** GPA of a Student */
	private double gpa;
	/** Unity ID of a Student */
	private String unityID;

	@Override
	public int compareTo(Student o) {
		if (this.equals(o)) {
			return 0;
		}

		if (!this.last.equals(o.last)) {
			return this.last.compareTo(o.last);
		} else if (!this.first.equals(o.first)) {
			return this.first.compareTo(o.first);
		} else if (this.id < o.id) {
			return -1;
		} else if (this.id > o.id) {
			return 1;
		}

		return 0;
	}

	/**
	 * Student Constructor
	 * 
	 * @param first   First name
	 * @param last    last name
	 * @param id      ID
	 * @param credit  Number of credit hours
	 * @param gpa     GPA
	 * @param unityid Unity ID
	 */
	public Student(String first, String last, int id, int credit, double gpa, String unityid) {
		setFirst(first);
		setLast(last);
		setId(id);
		setCreditHours(credit);
		setGpa(gpa);
		setUnityID(unityid);
	}

	/**
	 * Gets the first name of Student
	 * 
	 * @return first name
	 */
	public String getFirst() {
		return first;
	}

	/**
	 * Sets the first name of the student
	 * 
	 * @param first first name
	 */
	public void setFirst(String first) {
		this.first = first;
	}

	/**
	 * Gets the last name of the student
	 * 
	 * @return last name
	 */
	public String getLast() {
		return last;
	}

	/**
	 * Sets the last name of the student
	 * 
	 * @param last last name
	 */
	public void setLast(String last) {
		this.last = last;
	}

	/**
	 * Gets the numerical id of the student
	 * 
	 * @return student id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id of the student
	 * 
	 * @param id student id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Get the credit hours
	 * 
	 * @return credit hours
	 */
	public int getCreditHours() {
		return creditHours;
	}

	/**
	 * Sets the credit hours
	 * 
	 * @param hours credit hours
	 */
	public void setCreditHours(int hours) {
		this.creditHours = hours;
	}

	/**
	 * Gets the GPA of the student
	 * 
	 * @return student GPA
	 */
	public double getGpa() {
		return gpa;
	}

	/**
	 * Sets the GPA of student
	 * 
	 * @param gpa student GPA
	 */
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	/**
	 * Gets the unity id of the student
	 * 
	 * @return unity id
	 */
	public String getUnityID() {
		return unityID;
	}

	/**
	 * Sets the unity id of the student
	 * 
	 * @param unity unity id of the student
	 */
	public void setUnityID(String unity) {
		this.unityID = unity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(creditHours, first, gpa, id, last, unityID);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o == null) {
			return false;
		} else if (!(o instanceof Student)) {
			return false;
		}

		Student other = (Student) o;
		if (Objects.equals(first, other.first) && Objects.equals(last, other.last) && this.id == other.id) {
			return true;
		}

		return false;
	}

	/**
	 * To String: Student ID, FirstName LastName
	 * 
	 * @return the string representation of a student
	 */
	public String toString() {
		return id + ", " + first + " " + last;
	}
}
