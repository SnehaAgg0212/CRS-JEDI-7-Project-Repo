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
	
	static ProfessorDaoInterface professorDaoOperation = new ProfessorDaoOperation();
	
	@Override
	public boolean addGrade(int studentId, int courseId, Double gpa, int semesterId) {
		
		try {
			professorDaoOperation.addGrade(studentId, courseId, gpa, semesterId);
		} catch (Exception e) {
			throw e;
		}
		return true;
	}
	
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
	
	@Override
	public String getProfessorById(int professorId)
	{
	
		return professorDaoOperation.getProfessorById(professorId);
	}
}
