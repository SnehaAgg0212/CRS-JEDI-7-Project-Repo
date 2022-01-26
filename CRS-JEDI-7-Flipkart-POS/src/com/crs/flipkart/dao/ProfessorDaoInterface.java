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
	boolean addGrade(int studentId, int courseId, Double gpa, int semesterId);

	/**
	 * 
	 * @param professorId
	 * @return
	 */
	Vector<EnrolledStudent> getEnrolledStudents(int professorId);

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

	boolean addCourse(int professorId, int courseSelectedId);

	Vector<Course> viewAvailableCourses();

	boolean checkSelectedCourse(int professorId);

}