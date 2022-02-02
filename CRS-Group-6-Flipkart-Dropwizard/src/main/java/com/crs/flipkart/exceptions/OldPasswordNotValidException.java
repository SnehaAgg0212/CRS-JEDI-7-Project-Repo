package com.crs.flipkart.exceptions;

@SuppressWarnings("serial")
public class OldPasswordNotValidException extends Exception{
	
	private String userId;

	/**
	 * @param userId
	 */
	public OldPasswordNotValidException(String userId) {
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
		return "Old Password is not valid";
	}
}
