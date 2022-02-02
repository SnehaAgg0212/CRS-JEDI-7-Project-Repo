package com.crs.flipkart.dao;

import com.crs.flipkart.exceptions.UserNotFoundException;

public interface UserDaoInterface {

	/**
	 * Verify Credentials
	 * @param userEmailId
	 * @param password
	 * @return
	 * @throws UserNotFoundException 
	 */
	boolean verifyCredentials(String userEmailId, String password) throws UserNotFoundException;

	/**
	 * Update Password
	 * @param userEmailId
	 * @param newPassword
	 * @return
	 */
	boolean updatePassword(String userEmailId, String newPassword);

	/**
	 * Get Role
	 * @param userId
	 * @return
	 */
	String getRole(String userEmailId);

	/**
	 * Get User Id
	 * @param userEmailId
	 * @return
	 */
	int getUserId(String userEmailId);

}