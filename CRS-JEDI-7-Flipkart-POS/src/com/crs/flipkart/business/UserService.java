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

public class UserService {
	
	public boolean userLogin(UserType userType, String userId, String userPassword) {
		
		switch(userType) {
		case ADMIN:
			Admin admin[] = AdminService.admin;
			
			for(int i=0; i<admin.length; i++) {
				if(userId.equals(admin[i].getUserEmailId()) && userPassword.equals(admin[i].getUserPassword())) {
					System.out.println("Successfully loggin");
					return true;
				}
			}
			

			System.out.println("Unsuccessful");
			return false;
		}
		return false;
	}
}
