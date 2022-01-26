package com.crs.flipkart.business;

public interface StudentInterface {

	/**
	 * @param userName
	 * @param userEmailId
	 * @param userPassword
	 * @param userId
	 * @param phoneNo
	 * @param gender
	 * @param address
	 * @param branch
	 * @param batch
	 * @return
	 */
	String register(String userName, String userEmailId, String userPassword, int userId, String phoneNo, String gender,
			String address, String branch, int batch);

	/**
	 * @param userId
	 * @return
	 */
	String getStudentId(String userId);

	/**
	 * @param studentId
	 * @return
	 */
	Boolean isApproved(String studentId);

	boolean semesterRegistration(int semester, int studentId);

}