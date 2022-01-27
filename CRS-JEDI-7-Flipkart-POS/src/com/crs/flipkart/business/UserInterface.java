package com.crs.flipkart.business;

public interface UserInterface {

	/**
	 * @param userId
	 * @return
	 */
	String getRoleOfUser(String userId);

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

	int getUserId(String userEmailId);

}