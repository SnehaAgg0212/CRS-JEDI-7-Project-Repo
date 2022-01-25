package com.crs.flipkart.business;

import java.util.*;
import com.crs.flipkart.bean.*;
import com.crs.flipkart.dao.ProfessorDaoOperation;



public class ProfessorService implements ProfessorInterface {
	ProfessorDaoOperation prof=new ProfessorDaoOperation();
	

	@Override
	public boolean addGrade(String studentId,String courseCode,String grade) {
		
		try
		{
			prof.addGrade(studentId, courseCode, grade);
		}
		catch(Exception ex)
		{
			System.out.println("No Grades Alloted");
		}
		return true;
		
	}
	
	@Override
	public Vector<EnrolledStudent> viewEnrolledStudents(String professorId) {
		List<EnrolledStudent> enrolledStudents=new ArrayList<EnrolledStudent>();
		try
		{
			enrolledStudents=prof.getEnrolledStudents(professorId);
		}
		catch(Exception ex)
		{
			throw ex;
		}
		return (Vector<EnrolledStudent>) enrolledStudents;
	}
		
	@Override
	public List<Course> viewCourses(String professorId) {
		List<Course> coursesOffered=new ArrayList<Course>();
		try
		{
			coursesOffered=prof.getCoursesByProfessor(professorId);
		}
		catch(Exception ex)
		{
			throw ex;
		}
		return coursesOffered;
	}

	
	
	@Override
	public String getProfessorById(String professorId)
	{
	
		return prof.getProfessorById(professorId);
	}
}
