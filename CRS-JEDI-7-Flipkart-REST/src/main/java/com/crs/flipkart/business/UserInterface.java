package com.crs.flipkart.business;

import com.crs.flipkart.exceptions.ConfirmPasswordException;
import com.crs.flipkart.exceptions.OldPasswordNotValidException;
import com.crs.flipkart.exceptions.UserNotFoundException;

public interface UserInterface {

	/**
	 * Get Role of User
	 * @param userId
	 * @return
	 */
	String getRoleOfUser(String userEmailId);

	/**
	 * Validate User
	 * @param emailId
	 * @param password
	 * @return
	 * @throws UserNotFoundException 
	 */
	boolean validateUser(String emailId, String password) throws UserNotFoundException;

	/**
	 * Update Password
	 * @param userEmailId
	 * @param oldPassword
	 * @param newPassword
	 * @param confirmNewPassword
	 * @return 
	 * @throws UserNotFoundException 
	 * @throws ConfirmPasswordException 
	 * @throws OldPasswordNotValidException 
	 */
	void updatePassword(String userEmailId, String oldPassword, String newPassword, String confirmNewPassword) throws UserNotFoundException, OldPasswordNotValidException, ConfirmPasswordException;

	/**
	 * Get User Id
	 * @param userEmailId
	 * @return
	 */
	int getUserId(String userEmailId);

}