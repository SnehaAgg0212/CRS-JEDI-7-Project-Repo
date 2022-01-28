/**
 * 
 */
package com.flipkart.exceptions;

/**
 * @author LENOVO
 *
 */
public class SeatsNotAvailableException extends Exception{
	
	private String courseId;

	/**
	 * Constructor
	 * @param courseCode
	 * @return 
	 */
	public void SeatNotAvailableException(String courseId)
	{	
		this.courseId = courseId;
	}


	/**
	 * Message returned when exception is thrown
	 */
	@Override
	public String getMessage() {
		return  "Seats are not available in " + courseId;
	}
	
}
