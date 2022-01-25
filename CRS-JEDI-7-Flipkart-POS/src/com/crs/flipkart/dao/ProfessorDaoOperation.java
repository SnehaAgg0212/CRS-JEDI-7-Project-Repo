/**
 * 
 */
package com.crs.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.EnrolledStudent;
import com.crs.flipkart.utils.DBUtils;

/**
 * @author devanshugarg
 *
 */
public class ProfessorDaoOperation {

	Connection connection = DBUtils.getConnection();
	
	/**
	 * Default Constructor
	 */
	public ProfessorDaoOperation()
	{

	}

	public void addGrade(String studentId, String courseCode, String grade) {
		// TODO Auto-generated method stub
		
	}

	public List<EnrolledStudent> getEnrolledStudents(String professorId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Course> getCoursesByProfessor(String professorId) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getProfessorById(String professorId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
