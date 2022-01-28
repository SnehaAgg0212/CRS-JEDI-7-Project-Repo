/**
 * 
 */
package com.crs.flipkart.exceptions;

/**
 * @author iamshambhavi
 *
 */
public class StudentNotRegisteredException extends Exception {
	
	private String studentName;
	
	public StudentNotRegisteredException(String studentName) {
		
		this.studentName=studentName;
		
	}
	
	/**
	  * getter function for studentName
	  * @return studentName
	  */
	public String getStudentName() {
		
		return studentName;
		
	}
}
