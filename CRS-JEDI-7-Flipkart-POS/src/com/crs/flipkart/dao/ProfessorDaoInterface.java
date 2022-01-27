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
	boolean addGrade(int studentId, int courseId, double gpa, int semesterId);

	/**
	 * 
	 * @param professorId
	 * @param courseSelectedId
	 * @return
	 */
	boolean addCourse(int professorId, int courseSelectedId);

	/**
	 * 
	 * @param professorId
	 * @return
	 */
	boolean checkSelectedCourse(int professorId);

	/**
	 * 
	 * @param professorId
	 * @return
	 */
	Vector<EnrolledStudent> getEnrolledStudents(int professorId);

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
	Vector<Course> getCoursesByProfessor(int professorId);

	/**
	 * 
	 * @param professorId
	 * @return
	 */
	String getProfessorById(int professorId);

}