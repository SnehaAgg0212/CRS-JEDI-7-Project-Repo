package com.crs.flipkart.business;

import java.util.List;
import java.util.Vector;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.EnrolledStudent;

public interface ProfessorInterface {

	/**
	 * @param studentId
	 * @param courseCode
	 * @param grade
	 * @return
	 */
	boolean addGrade(int studentId, int courseId, Double gpa, int semesterId);

	/**
	 * @param professorId
	 * @return
	 */
	Vector<EnrolledStudent> viewEnrolledStudents(int professorId);

	/**
	 * @param professorId
	 * @return
	 */
	List<Course> viewCourses(int professorId);

	/**
	 * @param professorId
	 * @return
	 */
	String getProfessorById(int professorId);

}