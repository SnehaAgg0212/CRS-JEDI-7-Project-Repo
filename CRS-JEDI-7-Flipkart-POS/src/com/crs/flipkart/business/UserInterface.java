package com.crs.flipkart.business;

public interface UserInterface {


	/**
	 * This function is for updating the user password
	 * @param userEmailId
	 * @param oldPassword
	 * @param newPassword
	 * @param confirmNewPassword
	 */
	void updatePassword(String userEmailId, String oldPassword, String newPassword, String confirmNewPassword);

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