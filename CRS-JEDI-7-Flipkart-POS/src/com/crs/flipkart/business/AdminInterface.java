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
	 * @return
	 */
	Vector<Professor> viewProfessor();

	/**
	 * @return
	 */
	Vector<Course> viewCourse();

	/**
	 * @param professor
	 * @throws UserIdAlreadyInUseException 
	 * @throws ProfessorNotAddedException 
	 */
	void addProfessor(Professor professor) throws ProfessorNotAddedException, UserIdAlreadyInUseException;

	/**
	 * @param professorId
	 * @throws ProfessorNotDeletedException 
	 * @throws ProfessorNotFoundException 
	 */
	void deleteProfessor(int professorId) throws ProfessorNotFoundException, ProfessorNotDeletedException;

	/**
	 * @param course
	 * @throws CourseAlreadyExistsException 
	 */
	void addCourse(Course course) throws CourseAlreadyExistsException;

	/**
	 * @param courseId
	 * @throws CourseNotDeletedException 
	 * @throws CourseNotFoundException 
	 */
	void deleteCourse(int courseId) throws CourseNotFoundException, CourseNotDeletedException;

	/**
	 * @param studentId
	 * @param semesterId
	 */
	void generateGradeCard(int studentId, int semesterId);

	/**
	 * @param studentId
	 */
	void setIsGenerateGrade(int studentId);

	/**
	 * 
	 * @param studentId
	 * @param pendingStudents
	 * @throws StudentNotFoundForApprovalException 
	 */
	void approveStudentRegistration(int studentId, Vector<Student> pendingStudents) throws StudentNotFoundForApprovalException;

	/**
	 * 
	 * @return
	 */
	Vector<Student> viewPendingAdmissions();

}