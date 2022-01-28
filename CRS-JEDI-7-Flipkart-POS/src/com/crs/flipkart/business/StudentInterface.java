package com.crs.flipkart.business;

import com.crs.flipkart.bean.Student;
import com.crs.flipkart.exceptions.StudentNotRegisteredException;

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

	/**
	 * 
	 * @param student
	 * @return
	 */
	int register(Student student) throws StudentNotRegisteredException;

}