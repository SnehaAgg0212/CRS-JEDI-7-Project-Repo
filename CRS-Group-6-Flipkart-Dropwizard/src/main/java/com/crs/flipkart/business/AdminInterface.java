package com.crs.flipkart.business;

import java.util.Vector;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.exceptions.CourseAlreadyExistsException;
import com.crs.flipkart.exceptions.CourseNotDeletedException;
import com.crs.flipkart.exceptions.CourseNotFoundException;
import com.crs.flipkart.exceptions.ProfessorNotAddedException;
import com.crs.flipkart.exceptions.ProfessorNotDeletedException;
import com.crs.flipkart.exceptions.ProfessorNotFoundException;
import com.crs.flipkart.exceptions.StudentNotFoundForApprovalException;
import com.crs.flipkart.exceptions.UserIdAlreadyInUseException;

/**
 * @author devanshugarg
 *
 */
public interface AdminInterface {

	/**
	 * View Professor
	 * @return
	 */
	Vector<Professor> viewProfessor();

	/**
	 * View Course
	 * @return
	 */
	Vector<Course> viewCourse();

	/**
	 * Add Professor
	 * @param professor
	 * @throws UserIdAlreadyInUseException 
	 * @throws ProfessorNotAddedException 
	 */
	void addProfessor(Professor professor) throws ProfessorNotAddedException, UserIdAlreadyInUseException;

	/**
	 * Delete Professor
	 * @param professorId
	 * @throws ProfessorNotDeletedException 
	 * @throws ProfessorNotFoundException 
	 */
	void deleteProfessor(int professorId) throws ProfessorNotFoundException, ProfessorNotDeletedException;

	/**
	 * Set Is Generate Grade
	 * @param studentId
	 */
	void setIsGenerateGrade(int studentId);

	/**
	 * Approve Student Registration
	 * @param studentId
	 * @param pendingStudents
	 * @throws StudentNotFoundForApprovalException 
	 */
	void approveStudentRegistration(int studentId, Vector<Student> pendingStudents) throws StudentNotFoundForApprovalException;

	/**
	 * View Pending Admissions
	 * @return
	 */
	Vector<Student> viewPendingAdmissions();

	/**
	 * Add Course
	 * @param course
	 * @param courseList
	 * @throws CourseAlreadyExistsException
	 */
	void addCourse(Course course, Vector<Course> courseList) throws CourseAlreadyExistsException;

	/**
	 * Delete Course
	 * @param courseId
	 * @param courseList
	 * @throws CourseNotFoundException
	 * @throws CourseNotDeletedException
	 */
	void deleteCourse(int courseId, Vector<Course> courseList) throws CourseNotFoundException, CourseNotDeletedException;
	
	/**
	 * Generate Grade Card
	 * @param studentId
	 */
	void generateGradeCard(int studentId);

}