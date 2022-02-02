/**
 * 
 */
package com.crs.flipkart.exceptions;

/**
 * @author HP
 *
 */
@SuppressWarnings("serial")
public class ConfirmPasswordException extends Exception{
	
	private String userId;

	/**
	 * @param userId
	 */
	public ConfirmPasswordException(String userId) {
		this.userId = userId;
	}

	/**
	 * Getter Method
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * Message returned when exception is thrown
	 */
	@Override
	public String getMessage() {
		return "Confirm Password and New Password are not similar";
	}
}
