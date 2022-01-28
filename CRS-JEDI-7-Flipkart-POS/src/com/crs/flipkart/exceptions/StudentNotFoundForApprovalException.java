/**
 * 
 */
package com.crs.flipkart.exceptions;

/**
 * @author iamshambhavi
 *
 */
public class StudentNotFoundForApprovalException extends Exception {
	
	private int studentId;
	
	public StudentNotFoundForApprovalException(int id) {
		
		studentId = id;
		
	}
	
	/**
	 * Getter function for studentId.
	 * @return studentId
	 */
	public int getStudentId() {
		
		return studentId;
		
	}
	
	/**
	 * Message returned when exception is thrown.
	 */
	public String getMessage() {
		
		return "StudentId: " + studentId + " not found.";
		
	}
}
