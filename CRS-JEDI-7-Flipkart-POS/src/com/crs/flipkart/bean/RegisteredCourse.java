/**
 * 
 */
package com.crs.flipkart.bean;

/**
 * @author devanshugarg
 *
 */
public class RegisteredCourse {

	private String courseId;
	private String courseName;
	private int studentId;
	
	/**
	 * Default Constructor
	 */
	public RegisteredCourse() {
		
	}

	/**
	 * @param courseId
	 * @param courseName
	 * @param studentId
	 */
	public RegisteredCourse(String courseId, String courseName, int studentId) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.studentId = studentId;
	}

	/**
	 * @return the courseId
	 */
	public String getCourseId() {
		return courseId;
	}

	/**
	 * @param courseId the courseId to set
	 */
	public void setCourseId(String courseId) {
		this.courseId = courseId;
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
