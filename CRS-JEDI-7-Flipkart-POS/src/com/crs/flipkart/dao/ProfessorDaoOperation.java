/**
 * 
 */
package com.crs.flipkart.dao;

import java.util.Vector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.EnrolledStudent;
import com.crs.flipkart.utils.DBUtils;

/**
 * @author devanshugarg
 *
 */
public class ProfessorDaoOperation implements ProfessorDaoInterface {

	Connection connection = DBUtils.getConnection();
	
	/**
	 * Default Constructor
	 */
	public ProfessorDaoOperation()
	{

	}
	
	/**
	 * 
	 * @param studentId
	 * @param courseCode
	 * @param grade
	 */
	@Override
	public void addGrade(String studentId, String courseCode, String grade) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 
	 * @param professorId
	 * @return
	 */
	@Override
	public Vector<EnrolledStudent> getEnrolledStudents(String professorId) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 * @param professorId
	 * @return
	 */
	@Override
	public Vector<Course> getCoursesByProfessor(String professorId) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 * @param professorId
	 * @return
	 */
	@Override
	public String getProfessorById(String professorId) {
		// TODO Auto-generated method stub
		return null;
	}
}
