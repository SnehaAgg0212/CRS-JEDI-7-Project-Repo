/**
 * 
 */
package com.crs.flipkart.dao;

import com.crs.flipkart.bean.Student;

/**
 * @author iamshambhavi
 *
 */
public interface StudentDaoInterface {
	
	/**
	 * Add student to database
	 * @param student object with all fields populated
	 * @return boolean indicating if student is added
	 */
	public String addStudent(Student student);
	
	/**
	 * Retrieve Student Id from User Id
	 * @param userId
	 * @return Student Id
	 */
	public String getStudentId(String userId);
	
	/**
	 * Check if Student is approved
	 * @param studentId
	 * @return boolean indicating if student is approved
	 */
	public boolean isApproved(String studentId);
}
