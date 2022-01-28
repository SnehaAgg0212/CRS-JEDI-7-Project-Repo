/**
 * 
 */
package com.crs.flipkart.business;

import org.apache.log4j.Logger;

import com.crs.flipkart.dao.UserDaoInterface;
import com.crs.flipkart.dao.UserDaoOperation;

/**
 * @author devanshugarg
 *
 */

public class UserService implements UserInterface {
	
	private static volatile UserService instance = null;
	private static Logger logger = Logger.getLogger(UserService.class);
	
	/**
	 * Default Constructor
	 */
	private UserService() {
		
	}
	
	/**
	 * Method to make UserService Singleton
	 */
	public static UserService getInstance() {
		
		if(instance == null) {
			
			synchronized(UserService.class) {
				
				instance = new UserService();
			}
		}
		return instance;
	}
	
	UserDaoInterface userDaoOperation = UserDaoOperation.getInstance();
	
	@Override
	public void updatePassword(String userEmailId, String oldPassword, String newPassword,String confirmNewPassword){
		
		 if(!newPassword.equals(confirmNewPassword)) {
			 logger.info(newPassword + " " + confirmNewPassword);
			 logger.info("New password and Confirm New Password are different!!");
			 return;
		 }

		 if(!validateUser(userEmailId,oldPassword)) {
			 logger.info("Either EmailId or Password is wrong, try again!!");
			 return;
		 }

		 if(userDaoOperation.updatePassword(userEmailId, newPassword)) {
			 logger.info("Password updated successfully!");
		 } else {
			 logger.info("Something went wrong, please try again!");
		 }
	}
	
	@Override
	public String getRoleOfUser(String userEmailId) {
		
		return userDaoOperation.getRole(userEmailId);
	}
	
	/**
	 * Method to verify User credentials
	 * @param emailId
	 * @param password
	 * @return
	 */
	@Override
	public boolean validateUser(String emailId, String password) {
		
		return userDaoOperation.verifyCredentials(emailId, password);
	}
	
	/**
	 * 
	 * @param userEmailId
	 * @return
	 */
	@Override
	public int getUserId(String userEmailId) {
		
		return userDaoOperation.getUserId(userEmailId);
	}
}
