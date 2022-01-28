/**
 * 
 */
package com.flipkart.exceptions;

/**
 * @author LENOVO
 *
 */
public class CourseLimitExceededException extends Exception{
	private int number;

	public CourseLimitExceededException(int number) {
		this.number = number;
	}
	
	public String getMessage() {
		return "You have already registered for " + number + " courses";
	}
	
}
