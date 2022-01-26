package com.crs.flipkart.business;

import java.util.Vector;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Professor;

/**
 * @author devanshugarg
 *
 */
public interface AdminInterface {

	/**
	 * @return
	 */
	Vector<Professor> viewProfessor();
	
	/**
	 * @param studentId
	 */
	void approveStudentRegistration(int studentId);

	/**
	 * @return
	 */
	Vector<Course> viewCourse();

	/**
	 * @param professor
	 */
	void addProfessor(Professor professor);

	/**
	 * @param professorId
	 */
	void deleteProfessor(int professorId);

	/**
	 * @param course
	 */
	void addCourse(Course course);

	/**
	 * @param courseId
	 */
	void deleteCourse(int courseId);

//	/**
//	 * @param courseId
//	 * @param professorId
//	 */
//	void assignCourseToProfessor(int courseId, int professorId);

	/**
	 * @param studentId
	 * @param semesterId
	 */
	void generateGradeCard(int studentId, int semesterId);
	
	void setIsGenerateGrade(int studentId);

}