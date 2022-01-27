package com.crs.flipkart.business;

public interface UserInterface {

	/**
	 * @param userId
	 * @return
	 */
	String getRoleOfUser(String userEmailId);

	/**
	 * @param emailId
	 * @param password
	 * @return
	 */
	boolean validateUser(String emailId, String password);

	/**
	 * 
	 * @param userEmailId
	 * @param oldPassword
	 * @param newPassword
	 * @param confirmNewPassword
	 */
	void updatePassword(String userEmailId, String oldPassword, String newPassword, String confirmNewPassword);

	/**
	 * 
	 * @param userEmailId
	 * @return
	 */
	int getUserId(String userEmailId);

}