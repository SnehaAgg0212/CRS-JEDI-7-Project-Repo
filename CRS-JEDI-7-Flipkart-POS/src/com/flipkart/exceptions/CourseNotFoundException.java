/**
 * 
 */
package com.flipkart.exceptions;

/**
 * @author LENOVO
 *
 */
public class CourseNotFoundException extends Exception {
	private int courseId;
	
	public CourseNotFoundException(int courseId){	
		this.courseId = courseId;
	}
	
	/**
	 * Getter function for course id
	 * @return
	 */
	public int getCourseId(){
		return courseId;
	}
	
	/**
	 * Message returned when exception is thrown
	 */
	@Override
	public String getMessage() 
	{
		return "Course with courseCode: " + courseId + " not found.";
	}
}
