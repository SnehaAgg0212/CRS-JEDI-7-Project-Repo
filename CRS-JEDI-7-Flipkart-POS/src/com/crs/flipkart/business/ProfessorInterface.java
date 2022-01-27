package com.crs.flipkart.business;

import java.util.Vector;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.EnrolledStudent;

public interface ProfessorInterface {

	/**
	 * 
	 * @param studentId
	 * @param courseCode
	 * @param gpa
	 * @param semesterId
	 * @return
	 */
	boolean addGrade(int studentId, int courseCode, double gpa, int semesterId);

	/**
	 * 
	 * @param professorId
	 * @return
	 */
	Vector<EnrolledStudent> viewEnrolledStudents(int professorId);

	/**
	 * 
	 * @param professorId
	 * @return
	 */
	Vector<Course> viewCourses(int professorId);

	/**
	 * 
	 * @return
	 */
	Vector<Course> viewAvailableCourses();

	/**
	 * 
	 * @param professorId
	 * @return
	 */
	String getProfessorById(int professorId);

	/**
	 * 
	 * @param professorId
	 * @param courseSelectedId
	 * @return
	 */
	boolean addCourse(int professorId, int courseSelectedId);

}