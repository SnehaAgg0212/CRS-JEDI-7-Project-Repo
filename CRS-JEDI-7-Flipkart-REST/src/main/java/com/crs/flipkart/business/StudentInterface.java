package com.crs.flipkart.business;

import java.sql.SQLException;

import com.crs.flipkart.bean.Student;
import com.crs.flipkart.exceptions.StudentNotRegisteredException;

public interface StudentInterface {

	/**
	 * Get Student Id
	 * @param userId
	 * @return
	 */
	int getStudentId(int userId);

	/**
	 * Is Approved
	 * @param studentId
	 * @return
	 */
	Boolean isApproved(int studentId);

	/**
	 * Is Generated
	 * @param studentId
	 * @return
	 */
	Boolean isGenerated(int studentId);

	/**
	 * Semester Registration
	 * @param semester
	 * @param studentId
	 * @return
	 * @throws SQLException
	 */
	boolean semesterRegistration(int semester, int studentId) throws SQLException;

	/**
	 * Register
	 * @param student
	 * @return
	 * @throws StudentNotRegisteredException 
	 */
	int register(Student student) throws StudentNotRegisteredException;

}