package com.crs.flipkart.business;

public interface StudentInterface {

	String register(String userName, String userEmailId, String userPassword, int userId, String phoneNo, String gender,
			String address, String branch, int batch);

	String getStudentId(String userId);

	Boolean isApproved(String studentId);

}