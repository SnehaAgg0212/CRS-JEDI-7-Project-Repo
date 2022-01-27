/**
 * 
 */
package com.crs.flipkart.business;

import com.crs.flipkart.dao.UserDaoInterface;
import com.crs.flipkart.dao.UserDaoOperation;

/**
 * @author devanshugarg
 *
 */

public class UserService implements UserInterface {
	
	UserDaoInterface userDaoOperation = new UserDaoOperation();
	
	@Override
	public void updatePassword(String userEmailId, String oldPassword, String newPassword,String confirmNewPassword){
		
		 if(!newPassword.equals(confirmNewPassword)) {
			 System.out.println(newPassword + " " + confirmNewPassword);
			 System.out.println("New password and Confirm New Password are different!!");
			 return;
		 }

		 if(!validateUser(userEmailId,oldPassword)) {
			 System.out.println("Either EmailId or Password is wrong, try again!!");
			 return;
		 }

		 if(userDaoOperation.updatePassword(userEmailId, newPassword)) {
			 System.out.println("Password updated successfully!");
		 } else {
			 System.out.println("Something went wrong, please try again!");
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
