package com.crs.flipkart.business;

public interface UserInterface {

	/**
	 * @param userId
	 * @param userPassword
	 * @return
	 */
	boolean userLogin(String userId, String userPassword);

	/**
	 * @param userId
	 * @param newPassword
	 * @return
	 */
	boolean updatePassword(String userId, String newPassword);

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

}