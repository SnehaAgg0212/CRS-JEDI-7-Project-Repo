/**
 * 
 */
package com.crs.flipkart.dao;

import java.util.Vector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.EnrolledStudent;
import com.crs.flipkart.utils.DBUtils;
import com.crs.flipkart.constants.SQLQueriesConstant;
import com.crs.flipkart.bean.EnrolledStudent;
/**
 * @author devanshugarg
 *
 */
public class ProfessorDaoOperation implements ProfessorDaoInterface {
	private PreparedStatement statement = null;
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
	public boolean addGrade(int studentId, int courseId, Double gpa, int semesterId) {
		// TODO Auto-generated method stub
		Connection connection=DBUtils.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(SQLQueriesConstant.ADD_GRADE);
			
			statement.setDouble(1, gpa);
			statement.setInt(2, courseId);
			statement.setInt(3, studentId);
			statement.setInt(4, semesterId);

			
			int row = statement.executeUpdate();
			
			if(row==1)
				return true;
			else
				return false;
		}
		catch(SQLException e)
		{
			System.out.println("Error: "+e.getMessage());
		}
		finally
		{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
		
	}

	/**
	 * 
	 * @param professorId
	 * @return
	 */
	@Override
	public Vector<EnrolledStudent> getEnrolledStudents(int professorId) {
		// TODO Auto-generated method stub
		Connection connection=DBUtils.getConnection();
		Vector<EnrolledStudent> enrolledStudents=new Vector<EnrolledStudent>();
		try {
			PreparedStatement statement = connection.prepareStatement(SQLQueriesConstant.GET_ENROLLED_STUDENTS);
			statement.setInt(1, professorId);
			
			ResultSet results = statement.executeQuery();
			while(results.next())
			{
				//public EnrolledStudent(int courseId, String courseName, int studentId) 
				enrolledStudents.add(new EnrolledStudent(results.getInt("CId"),results.getString("courseName"),results.getInt("studentId")));
			}
		}
		catch(SQLException e)
		{
			System.out.println("Couldn't find enrolled students"+e.getMessage());
		}
		finally
		{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return enrolledStudents;
		
	}

	/**
	 * 
	 * @param professorId
	 * @return
	 */
	@Override
	public Vector<Course> getCoursesByProfessor(int professorId) {
		// TODO Auto-generated method stub
		Connection connection=DBUtils.getConnection();
		Vector<Course> courseList=new Vector<Course>();
		try {
			PreparedStatement statement = connection.prepareStatement(SQLQueriesConstant.GET_COURSES);
			
			statement.setInt(1, professorId);
			
			ResultSet results=statement.executeQuery();
			while(results.next())
			{
				courseList.add(new Course(results.getInt("courseId"),results.getString("courseName"),results.getInt("courseSeats")));
			}
		}
		catch(SQLException e)
		{
			System.out.println("Error: "+e.getMessage());
		}
		finally
		{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return courseList;
	}

	/**
	 * 
	 * @param professorId
	 * @return
	 */
	@Override
	public String getProfessorById(int professorId) {
		// TODO Auto-generated method stub
		String prof_Name = null;
		Connection connection=DBUtils.getConnection();
		try 
		{
			PreparedStatement statement = connection.prepareStatement(SQLQueriesConstant.GET_PROF_NAME);
			
			statement.setInt(1, professorId);
			ResultSet rs = statement.executeQuery();
			rs.next();
			
			prof_Name = rs.getString(1);
			
		}
		catch(SQLException e)
		{
			System.out.println("Error: "+ e.getMessage());
		}
		finally
		{
			try 
			{
				connection.close();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
		return prof_Name;
	}
}
