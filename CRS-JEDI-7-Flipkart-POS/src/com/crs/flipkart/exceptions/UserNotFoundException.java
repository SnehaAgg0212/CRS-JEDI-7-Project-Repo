/**
 * 
 */
package com.crs.flipkart.exceptions;

/**
 * @author devanshugarg
 *
 */
@SuppressWarnings("serial")
public class UserNotFoundException extends Exception {
	
	private int userId;

	/**
	 * @param userId
	 */
	public UserNotFoundException(int userId) {
		this.userId = userId;
	}

	/**
	 * Getter Method
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	
	/**
	 * Message returned when Exception is thrown
	 */
	@Override
	public String getMessage() {
		return "User with User Id: " + userId + " not found.";
	}
}
