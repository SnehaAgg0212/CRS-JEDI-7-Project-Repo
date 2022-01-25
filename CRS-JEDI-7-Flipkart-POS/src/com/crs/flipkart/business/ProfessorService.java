/**
 * 
 */
package com.crs.flipkart.business;

import java.util.Vector;

import com.crs.flipkart.bean.*;
import com.crs.flipkart.dao.ProfessorDaoInterface;
import com.crs.flipkart.dao.ProfessorDaoOperation;
/**
 * @author devanshugarg
 *
 */
public class ProfessorService implements ProfessorInterface {

	ProfessorDaoInterface professorDaoOperation = new ProfessorDaoOperation();
	
	@Override
	public boolean addGrade(String studentId, String courseCode, String grade) {
		
		try {
			professorDaoOperation.addGrade(studentId, courseCode, grade);
		} catch (Exception e) {
			throw e;
		}
		return true;
	}
	
	@Override
	public Vector<EnrolledStudent> viewEnrolledStudents(String professorId) {
		
		Vector<EnrolledStudent> enrolledStudents = new Vector<>();
		
		try {
			enrolledStudents = professorDaoOperation.getEnrolledStudents(professorId);
		} catch (Exception e) {
			throw e;
		}
		return enrolledStudents;
	}

	@Override
	public Vector<Course> viewCourses(String professorId) {
	
		Vector<Course> coursesOffered = new Vector<>();
		
		try {
			coursesOffered = professorDaoOperation.getCoursesByProfessor(professorId);
		} catch (Exception e) {
			throw e;
		}
		return coursesOffered;
	}
	
	@Override
	public String getProfessorById(String professorId)
	{
	
		return professorDaoOperation.getProfessorById(professorId);
	}
}
