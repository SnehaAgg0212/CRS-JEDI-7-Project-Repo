/**
 *
 */
package com.crs.flipkart.business;

import java.util.Scanner;
import java.util.Vector;

import org.apache.log4j.Logger;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.GradeCard;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.dao.AdminDaoInterface;
import com.crs.flipkart.dao.AdminDaoOperation;
import com.crs.flipkart.exceptions.CourseAlreadyExistsException;
import com.crs.flipkart.exceptions.CourseNotDeletedException;
import com.crs.flipkart.exceptions.CourseNotFoundException;
import com.crs.flipkart.exceptions.ProfessorNotAddedException;
import com.crs.flipkart.exceptions.ProfessorNotDeletedException;
import com.crs.flipkart.exceptions.ProfessorNotFoundException;
import com.crs.flipkart.exceptions.StudentNotFoundForApprovalException;
import com.crs.flipkart.exceptions.UserIdAlreadyInUseException;
import com.crs.flipkart.utils.Utils;
import com.crs.flipkart.validator.AdminValidator;

/**
 * @author LENOVO
 *
 */
public class AdminService implements AdminInterface {
	
	private static volatile AdminService instance = null;
	private static Logger logger = Logger.getLogger(AdminService.class);
	
	/**
	 * Default Constructor
	 */
	private AdminService() {
		
	}
	
	/**
	 * Method to make AdminService Singleton
	 */
	public static AdminService getInstance() {
		
		if(instance == null) {
			
			synchronized(AdminService.class) {
				
				instance = new AdminService();
			}
		}
		return instance;
	}
	
	AdminDaoInterface adminDaoOperation = AdminDaoOperation.getInstance();
	
	Scanner sc = new Scanner(System.in);

    @Override
	public void addProfessor(Professor professor) throws ProfessorNotAddedException, UserIdAlreadyInUseException {

    	int profId = Utils.generateId();
    	int userId = Utils.generateId();
    	
	    professor.setProfessorId(profId);
	    professor.setUserId(userId);

	    try {
	    	adminDaoOperation.addProfessor(professor);
	    } catch (ProfessorNotAddedException e) {
	    	throw e;
	    } catch (UserIdAlreadyInUseException e) {
	    	throw e;
	    }
    }

	@Override
	public Vector<Professor> viewProfessor() {

	    return adminDaoOperation.viewProfessor();
	}

	@Override
	public void deleteProfessor(int professorId) throws ProfessorNotFoundException, ProfessorNotDeletedException {

		try {
			adminDaoOperation.deleteProfessor(professorId);
		} catch (ProfessorNotFoundException e) {
			throw e;
		} catch (ProfessorNotDeletedException e) {
			throw e;
		}
	}

	@Override
	public void approveStudentRegistration(int studentId, Vector<Student> pendingStudents) throws StudentNotFoundForApprovalException {
		
		if (!AdminValidator.isValidUnapprovedStudent(studentId, pendingStudents)) {
			throw new StudentNotFoundForApprovalException(studentId);
		}
 		
 		try {
 			adminDaoOperation.approveStudentRegistration(studentId);
 		} catch (StudentNotFoundForApprovalException e) {
 			throw e;
 		}
	}

	@Override
	public void generateGradeCard(int studentId)
	{
		Vector<GradeCard> grades = new Vector<>();
		
		grades = adminDaoOperation.generateGradeCard(studentId);
		
		if (grades.isEmpty()) {
			logger.info("You haven't registered for any course.");
			return;
		}
		
		double overallgpa = 0.0;
		
		for(GradeCard course_grade : grades) {
			
			logger.info("CourseId: " + course_grade.getCourseId() + " GPA: " + course_grade.getGpa());
			
			overallgpa += course_grade.getGpa();
		}
		
		overallgpa /= (double)grades.size();
		
		logger.info("Overall GPA: " + overallgpa);

	}

	@Override
	public void addCourse(Course course, Vector<Course> courseList) throws CourseAlreadyExistsException {

		if (!AdminValidator.isValidNewCourse(course, courseList)) {
			logger.error("Course with Course Code: " + course.getCourseId() + " is already present in Catalog.");
			throw new CourseAlreadyExistsException(course.getCourseId());
		}
		
		try {
			adminDaoOperation.addCourse(course);
		} catch (CourseAlreadyExistsException e) {
			throw e;
		}
	}

	@Override
	public Vector<Course> viewCourse() {

	    return adminDaoOperation.viewCourse();
	}

	@Override
	public void deleteCourse(int courseId, Vector<Course> courseList) throws CourseNotFoundException, CourseNotDeletedException {
		
		if (!AdminValidator.isValidDropCourse(courseId, courseList)) {
			logger.error("Course with Course Code: " + courseId + " is not present in Catalog.");
			throw new CourseNotFoundException(courseId);
		}
		
		try {
			adminDaoOperation.deleteCourse(courseId);
		} catch (CourseNotFoundException e) {
			throw e;
		} catch (CourseNotDeletedException e) {
			throw e;
		}
	}
	
	@Override
	public void setIsGenerateGrade(int studentId) {
		
 		adminDaoOperation.setIsGenerateGrade(studentId);
 	}
	
	/**
	 * 
	 * @return
	 */
	@Override
	public Vector<Student> viewPendingAdmissions() {
		
 		return adminDaoOperation.viewPendingAdmissions();
 	}
}

