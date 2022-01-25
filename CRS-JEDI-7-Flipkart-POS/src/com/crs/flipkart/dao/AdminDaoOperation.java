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
import com.crs.flipkart.bean.Student;
import com.crs.flipkart.bean.User;

import com.crs.flipkart.constants.SQLQueriesConstant;

import java.util.Vector;

import com.crs.flipkart.utils.DBUtils;

/**
 * @author devanshugarg, iamshambhavi, JainamSanghvi91
 *
 */
public class AdminDaoOperation implements AdminDaoInterface {
	
	private PreparedStatement statement = null;
	Connection connection = DBUtils.getConnection();
	
	/**
	 * Default Constructor
	 */
	public AdminDaoOperation() {
		
	}
	
	/**
	 * 
	 * @param user
	 */
	@Override
	public void addUser(User user) {
		
		statement = null;
		
		try {
			String sql = SQLQueriesConstant.ADD_USER_QUERY;
			statement = connection.prepareStatement(sql);
			statement.setInt(1, user.getUserId());
			statement.setString(2, user.getUserName());
			statement.setString(3, user.getUserEmailId());
			statement.setString(4, user.getUserPassword());
			statement.setString(5, user.getRole());
			statement.setString(6, user.getPhoneNo());
			statement.setString(7, user.getGender());
			statement.setString(8, user.getAddress());
			int row = statement.executeUpdate();
			System.out.println(row + " user added.");
			if (row == 0) {
				System.out.println("User with User Id " + user.getUserId() + " not added.");
			} else {
				System.out.println("User with User Id " + user.getUserId() + " added.");
			}
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	/**
	 * 
	 * @param professor
	 */
	@Override
	public void addProfessor(Professor professor) {
		
		this.addUser(professor);
		
		statement = null;
		
		try {
			String sql = SQLQueriesConstant.ADD_PROFESSOR_QUERY;
			statement = connection.prepareStatement(sql);
			statement.setInt(1, professor.getUserId());
			statement.setInt(2, professor.getProfessorId());
			statement.setString(3, professor.getDepartment());
			statement.setString(4, professor.getDesignation());
			int row = statement.executeUpdate();
			System.out.println(row + " professor added.");
			if (row == 0) {
				System.out.println("Professor with Professor Id " + professor.getProfessorId() + " already exists.");
			} else {
				System.out.println("Professor with Professor Id " + professor.getProfessorId() + " added.");
			}
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	/**
	 * 
	 * @return
	 */
	@Override
	public Vector<Professor> viewProfessor() {
		
		statement = null;
		
		Vector<Professor> professorList = new Vector<>();
		
		try {
			String sql = SQLQueriesConstant.VIEW_PROFESSOR_QUERY;
			statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Professor professor = new Professor();
				professor.setProfessorId(resultSet.getInt(1));
				professor.setUserName(resultSet.getString(2));
				professor.setGender(resultSet.getString(3));
				professor.setDepartment(resultSet.getString(4));
				professor.setDesignation(resultSet.getString(5));
				professorList.add(professor);
			}
			System.out.println("Total Number of Professors in the Institute: " + professorList.size());
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return professorList;
	}
	
	/**
	 * 
	 * @param professorId
	 */
	@Override
	public void deleteProfessor(int professorId) {
	
		statement = null;
		
		try {
			String sql = SQLQueriesConstant.DELETE_PROFESSOR_QUERY;
			statement = connection.prepareStatement(sql);
			statement.setInt(1, professorId);
			int row = statement.executeUpdate();
			System.out.println(row + " professor deleted.");
			if (row == 0) {
				System.out.println("Professor with Professor Id " + professorId + " does not exists.");
			} else {
				System.out.println("Professor with Professor Id " + professorId + " deleted.");
			}
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	/**
	 * 
	 * @param studentId
	 */
	@Override
	public void approveStudentRegistration(int studentId) {
		
		statement = null;
		
		try {
			String sql = SQLQueriesConstant.APPROVE_STUDENT_QUERY;
			statement = connection.prepareStatement(sql);
			statement.setInt(1, studentId);
			int row = statement.executeUpdate();
			System.out.println(row + "student approved.");
			if (row == 0) {
				System.out.println("Student with Student Id " + studentId + " does not exists.");
			} else {
				System.out.println("Student with Student Id " + studentId + " is approved.");
			}
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	/**
	 * 
	 * @param studentId
	 * @param semesterId
	 * @return
	 */
	@Override
	public Vector<RegisteredCourse> generateGradeCard(int studentId, int semesterId) {
		
		statement = null;
		return null;
	}
	
	/**
	 * 
	 * @param course
	 */
	@Override
	public void addCourse(Course course) {
		
		statement = null;
		
		try {
			String sql = SQLQueriesConstant.ADD_COURSE_QUERY;
			statement = connection.prepareStatement(sql);
			statement.setInt(1, course.getCourseId());
 			statement.setString(2, course.getCourseName());
 			statement.setString(3, course.getCourseDescription());
 			statement.setDouble(4, course.getCourseFee());
 			statement.setInt(5, course.getCourseSeats());
			int row = statement.executeUpdate();
			System.out.println(row + " course added.");
			if (row == 0) {
				System.out.println("Course with Course Code " + course.getCourseId() + " already exists.");
			} else {
				System.out.println("Course with Course Code " + course.getCourseId() + " added.");
			}
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	/**
	 * 
	 * @return
	 */
	@Override
	public Vector<Course> viewCourse() {
		
		statement = null;
		
		Vector<Course> courseList = new Vector<>();
		
		try {
			String sql = SQLQueriesConstant.VIEW_COURSE_QUERY;
			statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Course course = new Course();
				course.setCourseId(resultSet.getInt(1));
 				course.setCourseName(resultSet.getString(2));
 				course.setCourseDescription(resultSet.getString(3));
 				course.setCourseFee(resultSet.getDouble(4));
 				course.setCourseSeats(resultSet.getInt(5));
				courseList.add(course);
			}
			System.out.println("Total Number of Courses: " + courseList.size());
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return courseList;
	}
	
	/**
	 * 
	 * @param courseId
	 */
	@Override
	public void deleteCourse(int courseId) {
	
		statement = null;
		
		try {
			String sql = SQLQueriesConstant.DELETE_COURSE_QUERY;
			statement = connection.prepareStatement(sql);
			statement.setInt(1, courseId);
			int row = statement.executeUpdate();
			System.out.println(row + " course deleted.");
			if (row == 0) {
				System.out.println("Course with Course Id " + courseId + " does not exists.");
			} else {
				System.out.println("Course with Course Id " + courseId + " deleted.");
			}
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
}
