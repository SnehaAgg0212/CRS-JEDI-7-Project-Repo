package com.crs.flipkart.business;

import java.util.*;

import com.crs.flipkart.bean.*;
import com.crs.flipkart.dao.ProfessorDaoInterface;
import com.crs.flipkart.dao.ProfessorDaoOperation;
/**
 * @author devanshugarg
 *
 */

public class ProfessorService implements ProfessorInterface {
	
	private static volatile ProfessorService instance = null;
	
	/**
	 * Default Constructor
	 */
	private ProfessorService() {
		
	}
	
	/**
	 * Method to make ProfessorService Singleton
	 */
	public static ProfessorService getInstance() {
		
		if(instance == null) {
			
			synchronized(ProfessorService.class) {
				
				instance = new ProfessorService();
			}
		}
		return instance;
	}
	
	ProfessorDaoInterface professorDaoOperation = ProfessorDaoOperation.getInstance();
	
	/**
	 * 
	 * @param studentId
	 * @param courseCode
	 * @param gpa
	 * @param semesterId
	 * @return
	 */
	@Override
	public boolean addGrade(int studentId, int courseCode, double gpa, int semesterId) {
		
		try {
			professorDaoOperation.addGrade(studentId, courseCode, gpa, semesterId);
		} catch (Exception e) {
			throw e;
		}
		return true;
	}
	
	/**
	 * 
	 * @param professorId
	 * @return
	 */
	@Override
	public Vector<EnrolledStudent> viewEnrolledStudents(int professorId) {

		Vector<EnrolledStudent> enrolledStudents = new Vector<>();
		
		try {
			enrolledStudents = professorDaoOperation.getEnrolledStudents(professorId);
		} catch (Exception e) {
			throw e;
		}
		return enrolledStudents;
	}
	
	/**
	 * 
	 * @param professorId
	 * @return
	 */
	@Override
	public Vector<Course> viewCourses(int professorId) {

		Vector<Course> coursesOffered = new Vector<>();
		
		try {
			coursesOffered = professorDaoOperation.getCoursesByProfessor(professorId);
		} catch (Exception e) {
			throw e;
		}
		return coursesOffered;
	}
	
	/**
	 * 
	 * @return
	 */
	@Override
	public Vector<Course> viewAvailableCourses() {

 		Vector<Course> availableCourses = new Vector<>();

 		try {
 			availableCourses = professorDaoOperation.viewAvailableCourses();
 		} catch (Exception e) {
 			throw e;
 		}
 		return availableCourses;
 	}
	
	/**
	 * 
	 * @param professorId
	 * @return
	 */
	@Override
	public String getProfessorById(int professorId) {
	
		return professorDaoOperation.getProfessorById(professorId);
	}
	
	/**
	 * 
	 * @param professorId
	 * @param courseSelectedId
	 * @return
	 */
	@Override
	public boolean addCourse(int professorId, int courseSelectedId) {

 		try {
 			if(!professorDaoOperation.checkSelectedCourse(professorId)) {
 				return false;
 			}
 			return professorDaoOperation.addCourse(professorId, courseSelectedId);
 		} catch (Exception e) {
 			throw e;
 		}
 	}
	
	/**
	 * 
	 * @param userId
	 * @return
	 */
	@Override
	public int getProfessorId(int userId) {
	
		return professorDaoOperation.getProfessorId(userId);
	}
}
