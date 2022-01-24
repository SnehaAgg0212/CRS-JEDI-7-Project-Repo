package com.crs.flipkart.business;

import com.crs.flipkart.utils.Utils.UserType;

public interface UserInterface {

	/**
	 * @param userType
	 * @param userId
	 * @param userPassword
	 * @return
	 */
	boolean userLogin(UserType userType, String userId, String userPassword);

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

}