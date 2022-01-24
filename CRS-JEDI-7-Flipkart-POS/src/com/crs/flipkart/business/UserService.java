/**
 * 
 */
package com.crs.flipkart.business;

import com.crs.flipkart.bean.Admin;
import com.crs.flipkart.utils.Utils.UserType;

/**
 * @author devanshugarg
 *
 */

public class UserService implements UserInterface {
	
	@Override
	public boolean userLogin(UserType userType, String userId, String userPassword) {
		
		switch(userType) {
		
		case ADMIN:
			Admin admin[] = AdminService.admin;
			
			for(int i = 0; i < admin.length; i++) {
				 
				if(userId.equals(admin[i].getUserEmailId()) && userPassword.equals(admin[i].getUserPassword())) {
					
					System.out.println("Successfully Logged In!");
					return true;
				}
			}
		default:
			System.out.println("Login Unsuccessful!");
			return false;
		}
	}
	
	@Override
	public boolean updatePassword (String userId, String newPassword) {
		
		return false;
	}
	
	@Override
	public String getRoleOfUser (String userId) {
		
		return null;
	}
	
	/**
	 * Method to verify User credentials
	 * @param emailId
	 * @param password
	 * @return
	 */
	@Override
	public boolean validateUser(String emailId, String password) {
		
		return false;
	}
}
