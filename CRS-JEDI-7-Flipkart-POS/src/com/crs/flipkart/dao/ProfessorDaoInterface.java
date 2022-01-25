package com.crs.flipkart.dao;

import java.util.Vector;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.EnrolledStudent;

public interface ProfessorDaoInterface {

	/**
	 * 
	 * @param studentId
	 * @param courseCode
	 * @param grade
	 */
	void addGrade(String studentId, String courseCode, String grade);

	/**
	 * 
	 * @param professorId
	 * @return
	 */
	Vector<EnrolledStudent> getEnrolledStudents(String professorId);

	/**
	 * 
	 * @param professorId
	 * @return
	 */
	Vector<Course> getCoursesByProfessor(String professorId);

	/**
	 * 
	 * @param professorId
	 * @return
	 */
	String getProfessorById(String professorId);

}