package com.crs.flipkart.exceptions;

@SuppressWarnings("serial")
public class OldPasswordNotValidException extends Exception{
	
	private int userId;

	/**
	 * @param userId
	 */
	public OldPasswordNotValidException(int userId) {
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
	 * Message returned when exception is thrown
	 */
	@Override
	public String getMessage() {
		return "Old Password is not valid";
	}
}
