package com.crs.flipkart.business;

import java.sql.SQLException;
import java.util.Vector;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.EnrolledStudent;
import com.crs.flipkart.exceptions.CourseNotFoundException;

public interface ProfessorInterface {

	/**
	 * Add Grade
	 * @param studentId
	 * @param courseCode
	 * @param gpa
	 * @param semesterId
	 * @return
	 * @throws SQLException 
	 */
	boolean addGrade(int studentId, int courseCode, double gpa) throws SQLException;

	/**
	 * View Enrolled Students
	 * @param professorId
	 * @return
	 * @throws SQLException 
	 */
	Vector<EnrolledStudent> viewEnrolledStudents(int professorId) throws SQLException;

	/**
	 * View Course
	 * @param professorId
	 * @return
	 * @throws SQLException 
	 */
	Vector<Course> viewCourses(int professorId) throws SQLException;

	/**
	 * View AvailableCourses
	 * @return
	 * @throws SQLException 
	 */
	Vector<Course> viewAvailableCourses() throws SQLException;

	/**
	 * Get Professor by Id
	 * @param professorId
	 * @return
	 * @throws SQLException 
	 */
	String getProfessorById(int professorId) throws SQLException;

	/**
	 * Add Course
	 * @param professorId
	 * @param courseSelectedId
	 * @return
	 * @throws SQLException 
	 * @throws CourseNotFoundException 
	 */
	boolean addCourse(int professorId, int courseSelectedId) throws SQLException, CourseNotFoundException;

	/**
	 * Get Professor Id
	 * @param userId
	 * @return
	 * @throws SQLException 
	 */
	int getProfessorId(int userId) throws SQLException;

	/**
	 * Get Not Graded Students
	 * @param professorId
	 * @return
	 * @throws SQLException
	 */
	Vector<EnrolledStudent> getNotGradedStudents(int professorId) throws SQLException;

}