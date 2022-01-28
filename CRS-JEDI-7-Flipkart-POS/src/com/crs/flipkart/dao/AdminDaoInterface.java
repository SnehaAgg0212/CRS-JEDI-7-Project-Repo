package com.crs.flipkart.dao;

import java.util.Vector;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.GradeCard;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.bean.User;
import com.crs.flipkart.exceptions.StudentNotFoundForApprovalException;

public interface AdminDaoInterface {

	/**
	 * 
	 * @param professor
	 */
	void addProfessor(Professor professor);

	/**
	 * 
	 * @return
	 */
	Vector<Professor> viewProfessor();

	/**
	 * 
	 * @param professorId
	 */
	void deleteProfessor(int professorId);

	/**
	 * 
	 * @param studentId
	 */
	void approveStudentRegistration(int studentId) throws StudentNotFoundForApprovalException;

	/**
	 * 
	 * @param studentId
	 * @param semesterId
	 * @return
	 */
	Vector<GradeCard> generateGradeCard(int studentId, int semesterId);

	/**
	 * 
	 * @param course
	 */
	void addCourse(Course course);

	/**
	 * 
	 * @return
	 */
	Vector<Course> viewCourse();

	/**
	 * 
	 * @param courseId
	 */
	void deleteCourse(int courseId);

	/**
	 * 
	 * @param user
	 */
	void addUser(User user);

	/**
	 * 
	 * @param studentId
	 */
	void setIsGenerateGrade(int studentId);

	/**
	 * 
	 * @return
	 */
	Vector<Student> viewPendingAdmissions();

}