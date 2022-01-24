package com.crs.flipkart.business;

import com.crs.flipkart.utils.Utils.UserType;

public interface UserInterface {

	boolean userLogin(UserType userType, String userId, String userPassword);

	boolean updatePassword(String userId, String newPassword);

	String getRoleOfUser(String userId);

}