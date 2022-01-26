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
	public void updatePassword (String  userEmailId, String newPassword) {
		 if(userDaoInterface.updatePassword (userEmailId, newPassword)) {
			 System.out.println("Password successfully updated");
		 }
		 else {
			 System.out.println("Wrong password");
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
