package com.crs.flipkart.business;

import java.util.Vector;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.EnrolledStudent;

public interface ProfessorInterface {

	/**
	 * @param studentId
	 * @param courseCode
	 * @param grade
	 */
	void addGrade(String studentId, String courseCode, String grade);

	/**
	 * @param professorId
	 * @return
	 */
	Vector<EnrolledStudent> viewEnrolledStudents(String professorId);

	/**
	 * @param professorId
	 * @return
	 */
	Vector<Course> viewCourses(String professorId);

	/**
	 * @param professorId
	 * @return
	 */
	String getProfessorById(String professorId);

}