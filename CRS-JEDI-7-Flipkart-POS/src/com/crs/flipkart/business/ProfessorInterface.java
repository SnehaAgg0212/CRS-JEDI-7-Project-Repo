package com.crs.flipkart.business;

import java.util.Vector;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.EnrolledStudent;

public interface ProfessorInterface {

	void addGrade(String studentId, String courseCode, String grade);

	Vector<EnrolledStudent> viewEnrolledStudents(String professorId);

	Vector<Course> viewCourses(String professorId);

	String getProfessorById(String professorId);

}