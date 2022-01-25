/**
 * 
 */
package com.crs.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.Professor;
import com.crs.flipkart.bean.RegisteredCourse;
import com.crs.flipkart.bean.User;

import java.util.Vector;

/**
 * @author devanshugarg
 *
 */
public class AdminDaoOperation {

	public void addProfessor(Professor professor) {
		
	}
	
	public Vector<Professor> viewProfessor() {
		
		return null;
	}
	
	public void deleteProfessor(int professorId) {
		
	}
	
	public void approveStudentRegistration(int studentId) {
		
	}
	
	public Vector<RegisteredCourse> generateGradeCard(int studentId, int semesterId) {
		
		return null;
	}
	
	public void addCourse(Course course) {
		
	}
	
	public Vector<Course> viewCourse() {
		
		return null;
	}
	
	public void deleteCourse(int courseId) {
		
	}
	
	public void addUser(User user) {
		
	}
}
