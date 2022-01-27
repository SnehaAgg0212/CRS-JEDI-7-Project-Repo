/**
 * 
 */
package com.crs.flipkart.business;

import com.crs.flipkart.bean.Admin;
import com.crs.flipkart.dao.UserDaoInterface;
import com.crs.flipkart.dao.UserDaoOperation;

/**
 * @author devanshugarg
 *
 */

public class UserService implements UserInterface {
	UserDaoInterface userDaoInterface= new UserDaoOperation();
	
	
	@Override
	public void updatePassword (String userEmailId, String oldPassword, String newPassword,String confirmNewPassword){
		 if(!newPassword.equals(confirmNewPassword)) {
			 System.out.println(newPassword + " " + confirmNewPassword);
			 System.out.println("New password and Confirm new Password are different!!");
			 return;
		 }
		 
		 if(!validateUser(userEmailId,oldPassword)) {
			 System.out.println("Either emailId or password is wrong, try again!!");
			 return;
		 }
		 
		 if(userDaoInterface.updatePassword (userEmailId, newPassword)) {
			 System.out.println("Password successfully updated!!");
		 }
		 else {
			 System.out.println("Error occured!");
		 }
	}
	
	@Override
	public String getRoleOfUser (int userId) {
		return userDaoInterface.getRole(userId);
	}
	
	@Override
	public boolean validateUser(String emailId, String password) {
		return userDaoInterface.verifyCredentials(emailId, password);
	}
}
