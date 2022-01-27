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
			 System.out.println("New password and Confirm new Password are different!!");
			 return;
		 }

		 if(!validateUser(userEmailId,oldPassword)) {
			 System.out.println("Either emailId or password is wrong, try again!!");
			 return;
		 }

		 if(userDaoOperation.updatePassword(userEmailId, newPassword)) {
			 System.out.println("Password successfully updated!!");
		 } else {
			 System.out.println("Error occured!");
		 }
	}
	
	@Override
	public String getRoleOfUser(String userId) {
		
		return userDaoOperation.getRole(userId);
	}
	
	@Override
	public int getUserId(String userEmailId) {
		
		return userDaoOperation.getUserId(userEmailId);
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
}
