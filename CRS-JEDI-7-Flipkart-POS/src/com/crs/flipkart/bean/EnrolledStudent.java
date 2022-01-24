/**
 * 
 */
package com.crs.flipkart.bean;

/**
 * @author devanshugarg
 *
 */
public class EnrolledStudent {

	private String courseCode;
	private String courseName;
	private int studentId;
	
	/**
	 * Default Constructor
	 */
	public EnrolledStudent() {
		
	}

	/**
	 * @param courseCode
	 * @param courseName
	 * @param studentId
	 */
	public EnrolledStudent(String courseCode, String courseName, int studentId) {
		super();
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.studentId = studentId;
	}

	/**
	 * @return the courseCode
	 */
	public String getCourseCode() {
		return courseCode;
	}

	/**
	 * @param courseCode the courseCode to set
	 */
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	/**
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	/**
	 * @return the studentId
	 */
	public int getStudentId() {
		return studentId;
	}

	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
}
