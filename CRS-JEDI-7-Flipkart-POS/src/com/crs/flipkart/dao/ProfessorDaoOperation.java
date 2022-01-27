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
import com.crs.flipkart.constants.SQLQueriesConstant;
import com.crs.flipkart.utils.DBUtils;

/**
 * @author devanshugarg
 *
 */
public class ProfessorDaoOperation implements ProfessorDaoInterface {

	Connection connection = DBUtils.getConnection();
	private PreparedStatement statement = null;
	
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
	public boolean addGrade(int studentId, int courseId, double gpa, int semesterId) {
		// TODO Auto-generated method stub
		
		statement = null;
		
		try {
			String sql = SQLQueriesConstant.ADD_GRADE;
 			statement = connection.prepareStatement(sql);
 			statement.setDouble(1, gpa);
 			statement.setInt(2, courseId);
 			statement.setInt(3, studentId);
 			statement.setInt(4, semesterId);
 			int row = statement.executeUpdate();
 			if (row == 1) {
 				return true;
 			}
 		} catch(SQLException e) {
 			System.out.println("Error: " + e.getMessage());
 		}
 		return false;
	}
	
	/**
	 * 
	 * @param professorId
	 * @param courseSelectedId
	 * @return
	 */
	@Override
	public boolean addCourse(int professorId, int courseSelectedId) {
 		// TODO Auto-generated method stub
		
		statement = null;
		
 		try {
 			String sql = SQLQueriesConstant.ADD_COURSE_TO_PROFESSOR;
 			statement = connection.prepareStatement(sql);
 			statement.setInt(1, courseSelectedId);
 			statement.setInt(2, professorId);
 			int row = statement.executeUpdate();
 			if (row == 1) {
 				return true;
 			}
 		} catch(SQLException e) {
 			System.out.println("Error: " + e.getMessage());
 		}
 		return false;
 	}

	/**
	 * 
	 * @param professorId
	 * @return
	 */
	@Override
	public boolean checkSelectedCourse(int professorId) {

 		try {
 			String sql = SQLQueriesConstant.CHECK_SELECTED_COURSE;
 			statement = connection.prepareStatement(sql);
 			statement.setInt(1, professorId);
 			ResultSet resultSet = statement.executeQuery();
 			if(resultSet.next() && resultSet.getInt("courseId") != 0) {
 				return false;
 			}
 			return true;
 		} catch(SQLException e) {
 			System.out.println("Error: " + e.getMessage());
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
		
		statement = null;
		Vector<EnrolledStudent> enrolledStudents = new Vector<>();
		
 		try {
 			String sql = SQLQueriesConstant.GET_ENROLLED_STUDENTS;
 			statement = connection.prepareStatement(sql);
 			statement.setInt(1, professorId);
 			ResultSet resultSet = statement.executeQuery();
 			while(resultSet.next()) {
 				EnrolledStudent enrolledStudent = new EnrolledStudent();
 				enrolledStudent.setCourseId(resultSet.getInt("courseId"));
 				enrolledStudent.setCourseName(resultSet.getString("courseName"));
 				enrolledStudent.setStudentId(resultSet.getInt("studentId"));
 				enrolledStudents.add(enrolledStudent);
 			}
 		} catch(SQLException e) {
 			System.out.println("Couldn't find Enrolled Students: " + e.getMessage());
 		}
 		return enrolledStudents;
	}
	
	/**
	 * 
	 * @return
	 */
	@Override
	public Vector<Course> viewAvailableCourses() {
 		// TODO Auto-generated method stub
		
 		statement = null;
 		Vector<Course> availableCourses = new Vector<>();
 		
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
 		} catch(SQLException e) {
 			System.out.println("Error: " + e.getMessage());
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
		
		statement = null;
		Vector<Course> courseList=new Vector<>();
		
 		try {
 			String sql = SQLQueriesConstant.GET_COURSES;
 			statement = connection.prepareStatement(sql);
 			statement.setInt(1, professorId);
 			ResultSet resultSet = statement.executeQuery();
 			while(resultSet.next()) {
 				Course course = new Course();
 				course.setCourseId(resultSet.getInt("courseId"));
 				course.setCourseName(resultSet.getString("courseName"));
 				course.setCourseSeats(resultSet.getInt("courseSeats"));
 				courseList.add(course);
 			}
 		} catch(SQLException e) {
 			System.out.println("Error: " + e.getMessage());
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
		
		String professorName = null;
		statement = null;
		
 		try {
 			String sql = SQLQueriesConstant.GET_PROF_NAME;
 			statement = connection.prepareStatement(sql);
 			statement.setInt(1, professorId);
 			ResultSet resultSet = statement.executeQuery();
 			while(resultSet.next()) {
 				professorName = resultSet.getString(1);
 			}
 		} catch(SQLException e) {
 			System.out.println("Error: " + e.getMessage());
 		}
 		return professorName;
	}
}
