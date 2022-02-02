package com.crs.flipkart.dao;

import java.sql.SQLException;
import java.util.Vector;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.EnrolledStudent;

public interface ProfessorDaoInterface {

	/**
	 * Add Grade
	 * @param studentId
	 * @param courseCode
	 * @param grade
	 * @throws SQLException 
	 */
	boolean addGrade(int studentId, int courseId, double gpa) throws SQLException;

	/**
	 * Add Course
	 * @param professorId
	 * @param courseSelectedId
	 * @return
	 * @throws SQLException 
	 */
	boolean addCourse(int professorId, int courseSelectedId) throws SQLException;

	/**
	 * Check Selected Course
	 * @param professorId
	 * @return
	 * @throws SQLException 
	 */
	boolean checkSelectedCourse(int professorId) throws SQLException;

	/**
	 * Get Enrolled Students
	 * @param professorId
	 * @return
	 * @throws SQLException 
	 */
	Vector<EnrolledStudent> getEnrolledStudents(int professorId) throws SQLException;

	/**
	 * View Available Courses
	 * @return
	 * @throws SQLException 
	 */
	Vector<Course> viewAvailableCourses() throws SQLException;

	/**
	 * Get Courses by Professor
	 * @param professorId
	 * @return
	 * @throws SQLException 
	 */
	Vector<Course> getCoursesByProfessor(int professorId) throws SQLException;

	/**
	 * Get Professor by Id
	 * @param professorId
	 * @return
	 * @throws SQLException 
	 */
	String getProfessorById(int professorId) throws SQLException;

	/**
	 * Retrieve Professor Id from User Id
	 * @param userId
	 * @return
	 * @throws SQLException 
	 */
	int getProfessorId(int userId) throws SQLException;

	/**
	 * Check Course
	 * @param professorId
	 * @return
	 * @throws SQLException
	 */
	boolean checkCourse(int professorId) throws SQLException;

	/**
	 * Get Not Graded Students
	 * @param professorId
	 * @return
	 * @throws SQLException
	 */
	Vector<EnrolledStudent> getNotGradedStudents(int professorId) throws SQLException;

}