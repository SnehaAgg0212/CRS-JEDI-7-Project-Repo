package com.crs.flipkart.business;

import com.crs.flipkart.bean.Student;
import com.crs.flipkart.constants.GenderConstant;

public interface StudentInterface {

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

	/**
	 * @param semester
	 * @param studentId
	 * @return
	 */
	boolean semesterRegistration(int semester, int studentId);

	void register(Student student);

}