package com.crs.flipkart.business;

public interface UserInterface {


	/**
	 * @param userEmailId
	 * @param newPassword
	 */
	void updatePassword(String userEmailId, String newPassword);

	/**
	 * @param userId
	 * @return
	 */
	String getRoleOfUser(int userId);

	/**
	 * @param emailId
	 * @param password
	 * @return
	 */
	boolean validateUser(String emailId, String password);

}