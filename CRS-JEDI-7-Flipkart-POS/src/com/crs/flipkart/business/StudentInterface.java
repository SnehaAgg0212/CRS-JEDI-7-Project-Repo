package com.crs.flipkart.business;

import com.crs.flipkart.constants.GenderConstant;

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
	int register(String userName, String userEmailId, String userPassword, int userId, String phoneNo, GenderConstant gender,
			String address, String branch, int batch);

	/**
	 * @param userId
	 * @return
	 */
	int getStudentId(int userId);

	/**
	 * @param studentId
	 * @return
	 */
	Boolean isApproved(int studentId);

	/**
	 * @param studentId
	 * @return
	 */
	Boolean isGenerated(int studentId);

}