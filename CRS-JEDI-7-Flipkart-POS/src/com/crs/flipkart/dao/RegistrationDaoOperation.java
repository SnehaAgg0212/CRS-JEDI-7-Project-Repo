/**
 * 
 */
package com.crs.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.GradeCard;
import com.crs.flipkart.constants.SQLQueriesConstant;
import com.crs.flipkart.utils.DBUtils;
import com.crs.flipkart.utils.Utils;

/**
 * @author devanshugarg
 *
 */
public class RegistrationDaoOperation implements RegistrationDaoInterface{
	
	private PreparedStatement statement = null;
	Connection connection = DBUtils.getConnection();
	
	@Override
	public boolean addCourse(int studentId, int courseId) {
		
		try {
			
			String sql = SQLQueriesConstant.ADD_COURSE;
			statement = connection.prepareStatement(sql);
			statement.setInt(1, studentId);
			statement.setInt(2, courseId);
			statement.executeUpdate();
			
			sql = SQLQueriesConstant.DECREMENT_SEAT;
			statement = connection.prepareStatement(sql);
			statement.setInt(1, courseId);
			statement.executeUpdate();
			return true;
			
		}catch(SQLException error) {
			System.out.println("Error: " + error.getMessage());
		}
		return false;
	}
	
	@Override
	public boolean semesterRegistration(int semester, int studentId) {
		
		try {
			
			String sql = SQLQueriesConstant.CHECK_STUDENT_AND_SEM;
			statement = connection.prepareStatement(sql);
			statement.setInt(1, studentId);
			statement.setInt(2, semester);
			
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				return true;
			}
					
		}catch(SQLException error) {
			System.out.println("Error: " + error.getMessage());
		}
		return false;
	}
	
	public boolean addSemester(int semester, int studentId) {
		
		try {
			
			String sql = SQLQueriesConstant.ADD_SEMESTER;
			statement = connection.prepareStatement(sql);
			statement.setInt(1, Utils.generateId());
			statement.setInt(2, studentId);
			statement.setInt(3, semester);
			statement.executeUpdate();
			return true;
			
		}catch(SQLException error) {
			System.out.println("Error: " + error.getMessage());
		}
		return false;
	}
	
	@Override
	public boolean dropCourse(int studentId, int courseId) {
		
		try {
			
			String sql = SQLQueriesConstant.DROP_COURSE;
			statement = connection.prepareStatement(sql);
			statement.setInt(1, studentId);
			statement.setInt(2, courseId);
			statement.executeUpdate();
			
			sql = SQLQueriesConstant.INCREMENT_SEAT;
			statement = connection.prepareStatement(sql);
			statement.setInt(1, courseId);
			statement.executeUpdate();
			return true;
			
		}catch(SQLException error) {
			System.out.println("Error: " + error.getMessage());
		}
		return false;
	}
	
	@Override
	public boolean isSeatAvailable(int courseId) {
		try {
			String sql = SQLQueriesConstant.AVAILABLE_SEATS;
			statement = connection.prepareStatement(sql);
			statement.setInt(1, courseId);
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				return (result.getInt("courseSeats") > 0);
			}
			
		}catch(SQLException error) {
			System.out.println("Error: " + error.getMessage());
		}
		return true;
	}
	
	@Override
	public int totalRegisteredCourses(int studentId) {
		int totalcourse = 0;
		try {
			String sql = SQLQueriesConstant.TOTAL_REGISTERED_COURSES;
			statement = connection.prepareStatement(sql);
			statement.setInt(1, studentId);
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				totalcourse++;
			}
			
			return totalcourse;
		}catch(SQLException error) {
			System.out.println("Error: " + error.getMessage());
		}
		return totalcourse;
	}
	
	
	@Override
	public Vector<Course> viewCourses(int studentId) {
		
		Vector<Course> availableCourses = new Vector<>();
		try {
			
			String sql = SQLQueriesConstant.VIEW_AVAILABLE_COURSES;
			statement = connection.prepareStatement(sql);
			statement.setInt(1, studentId);
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				Course course = new Course();
				course.setCourseId(result.getInt(1));
 				course.setCourseName(result.getString(2));
 				course.setCourseDescription(result.getString(3));
 				course.setCourseFee(result.getDouble(4));
 				course.setCourseSeats(result.getInt(5));
 				availableCourses.add(course);
			}
			
		}catch(SQLException error) {
			System.out.println("Error: " + error.getMessage());
		}
		
		
		return availableCourses;
	}
	
	
	@Override
	public Vector<Course> viewRegisteredCourses(int studentId) {
		
		Vector<Course> availableCourses = new Vector<>();
		try {
			
			String sql = SQLQueriesConstant.VIEW_REGISTERED_COURSES;
			statement = connection.prepareStatement(sql);
			statement.setInt(1, studentId);
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				Course course = new Course();
				course.setCourseId(result.getInt(1));
 				course.setCourseName(result.getString(2));
 				course.setCourseDescription(result.getString(3));
 				course.setCourseFee(result.getDouble(4));
 				course.setCourseSeats(result.getInt(5));
 				availableCourses.add(course);
			}
			
		}catch(SQLException error) {
			System.out.println("Error: " + error.getMessage());
		}
		
		
		return availableCourses;
	}
	
	

}
