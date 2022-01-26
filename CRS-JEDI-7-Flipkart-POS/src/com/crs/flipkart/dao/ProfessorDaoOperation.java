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
		
		return false;
		
	}
	
	
	@Override
	public boolean addCourse(int professorId, int courseSelectedId) {
		// TODO Auto-generated method stub
		Connection connection=DBUtils.getConnection();
		try {
			String sql = SQLQueriesConstant.ADD_COURSE_TO_PROFESSOR;
			statement = connection.prepareStatement(sql);
			statement.setInt(1, courseSelectedId);
			statement.setInt(2, professorId);
			statement.executeUpdate();
			
			return true;
		}
		catch(SQLException e)
		{
			System.out.println("Error: "+e.getMessage());
		}
		
		return false;
		
	}
	
	public boolean checkSelectedCourse(int professorId) {
		
		try {
			String sql = SQLQueriesConstant.CHECK_SELECTED_COURSE;
			statement = connection.prepareStatement(sql);
			statement.setInt(1, professorId);
			
			ResultSet result = statement.executeQuery();
			if(result.next() && result.getInt("courseId") != 0) {
				return false;
			}
			return true;
		}
		catch(SQLException e)
		{
			System.out.println("Error: "+e.getMessage());
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
		
		return enrolledStudents;
		
	}
	
	@Override
	public Vector<Course> viewAvailableCourses() {
		// TODO Auto-generated method stub
		Connection connection=DBUtils.getConnection();
		Vector<Course> availableCourses = new Vector<Course>();
		try {
			String sql = SQLQueriesConstant.GET_AVAILABLE_COURSES;
			statement = connection.prepareStatement(sql);
			statement.executeQuery();
			
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				Course course = new Course();
				course.setCourseId(resultSet.getInt(1));
 				course.setCourseName(resultSet.getString(2));
 				course.setCourseDescription(resultSet.getString(3));
 				course.setCourseFee(resultSet.getDouble(4));
 				course.setCourseSeats(resultSet.getInt(5));
 				availableCourses.add(course);
			}
		}
		catch(SQLException e)
		{
			System.out.println("Couldn't find enrolled students"+e.getMessage());
		}
		
		return availableCourses;
		
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
		
		
		return prof_Name;
	}
}
