/**
 * 
 */
package com.crs.flipkart.business;

import com.crs.flipkart.bean.Admin;
import com.crs.flipkart.bean.Student;

/**
 * @author devanshugarg
 *
 */

public class UserService implements UserInterface {
	
	@Override
	public boolean userLogin(String userId, String userPassword) {
		
		Student student = StudentService.student;
		Admin admin = AdminService.admin;
		
		if(userId.equals(student.getUserEmailId()) && userPassword.equals(student.getUserPassword())) {
				
			System.out.println("Successfully Logged In!");
			return true;
		}
		System.out.println("Login Unsuccessful!");
		return false;
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
