/**
 * 
 */
package com.crs.flipkart.dao;

/**
 * @author shubham
 *
 */
public interface UserDaoInterface {
	/**
	 * 
	 * @param userEmailId
	 * @param password
	 * @return
	 */
	boolean verifyCredentials(String userEmailId, String password);
	/**
	 * 
	 * @param userEmailId
	 * @param newPassword
	 * @return
	 */
	boolean updatePassword(String userEmailId, String newPassword);
	/**
	 * 
	 * @param userId
	 * @return
	 */
	String getRole(int userId);

}
