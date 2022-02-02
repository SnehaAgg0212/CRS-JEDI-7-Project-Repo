package com.crs.flipkart.dao;

import java.util.Vector;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.GradeCard;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.bean.User;
import com.crs.flipkart.exceptions.CourseAlreadyExistsException;
import com.crs.flipkart.exceptions.CourseNotDeletedException;
import com.crs.flipkart.exceptions.CourseNotFoundException;
import com.crs.flipkart.exceptions.ProfessorNotAddedException;
import com.crs.flipkart.exceptions.ProfessorNotDeletedException;
import com.crs.flipkart.exceptions.ProfessorNotFoundException;
import com.crs.flipkart.exceptions.StudentNotFoundForApprovalException;
import com.crs.flipkart.exceptions.UserIdAlreadyInUseException;
import com.crs.flipkart.exceptions.UserNotAddedException;

public interface AdminDaoInterface {

	/**
	 * Add Professor
	 * @param professor
	 * @throws ProfessorNotAddedException 
	 * @throws UserIdAlreadyInUseException 
	 */
	void addProfessor(Professor professor) throws UserIdAlreadyInUseException, ProfessorNotAddedException;

	/**
	 * View Professor
	 * @return
	 */
	Vector<Professor> viewProfessor();

	/**
	 * Delete Professor
	 * @param professorId
	 * @throws ProfessorNotDeletedException 
	 * @throws ProfessorNotFoundException 
	 */
	void deleteProfessor(int professorId) throws ProfessorNotFoundException, ProfessorNotDeletedException;

	/**
	 * Approve Student Registration
	 * @param studentId
	 * @throws StudentNotFoundForApprovalException 
	 */
	void approveStudentRegistration(int studentId) throws StudentNotFoundForApprovalException;

	/**
	 * Add Course
	 * @param course
	 * @throws CourseAlreadyExistsException 
	 */
	void addCourse(Course course) throws CourseAlreadyExistsException;

	/**
	 * View Course
	 * @return
	 */
	Vector<Course> viewCourse();

	/**
	 * Delete Course
	 * @param courseId
	 * @throws CourseNotDeletedException 
	 * @throws CourseNotFoundException 
	 */
	void deleteCourse(int courseId) throws CourseNotFoundException, CourseNotDeletedException;

	/**
	 * Add User
	 * @param user
	 * @throws UserIdAlreadyInUseException 
	 * @throws UserNotAddedException 
	 */
	void addUser(User user) throws UserNotAddedException, UserIdAlreadyInUseException;

	/**
	 * Set Is Generate Grade
	 * @param studentId
	 */
	void setIsGenerateGrade(int studentId);

	/**
	 * View Pending Admissions
	 * @return
	 */
	Vector<Student> viewPendingAdmissions();

	/**
	 * Generate Grade Card
	 * @param studentId
	 * @param semesterId
	 * @return
	 */
	Vector<GradeCard> generateGradeCard(int studentId);

}