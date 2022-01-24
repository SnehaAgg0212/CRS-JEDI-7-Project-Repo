package com.crs.flipkart.business;

import java.util.Vector;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Professor;

/**
 * @author devanshugarg
 *
 */
public interface AdminInterface {

	Vector<Professor> viewProfessor();
	
	boolean approveStudentRegistration(int studentId);

//	void GenerateGradeCard(int studentId, String studentName, int semesterId);

	Vector<Course> viewCourse();

	void addProfessor(Professor professor);

	void deleteProfessor(int professorId);

	void addCourse(Course course);

	void deleteCourse(int courseId);

	void assignCourseToProfessor(int courseId, int professorId);

}