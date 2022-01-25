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
import com.crs.flipkart.constants.SQLQueriesConstant;

import java.util.Vector;

import com.crs.flipkart.utils.DBUtils;

/**
 * @author devanshugarg, iamshambhavi
 *
 */
public class AdminDaoOperation implements AdminDaoInterface {

	Connection connection = DBUtils.getConnection();
	private PreparedStatement statement = null;
	
	/**
	 * 
	 * @param professor
	 */
	@Override
	public void addProfessor(Professor professor) {
		
	}
	
	/**
	 * 
	 * @return
	 */
	@Override
	public Vector<Professor> viewProfessor() {
		
		return null;
	}
	
	/**
	 * 
	 * @param professorId
	 */
	@Override
	public void deleteProfessor(int professorId) {
		
	}
	
	/**
	 * 
	 * @param studentId
	 */
	@Override
	public void approveStudentRegistration(int studentId) {
		
		statement = null;
		String sql = SQLQueriesConstant.APPROVE_STUDENT_QUERY;
		
		try {
			
			statement = connection.prepareStatement(sql);
			statement.setInt(1, studentId);
			int row = statement.executeUpdate();
			
			System.out.println(row + " student registration approved.");
			
			if(row == 0) {
				System.out.println("Student with studentId: " + studentId + " not approved by admin.");
			} else {
				System.out.println("Student with studentId: " + studentId + " approved by admin.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
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
		
		return null;
	}
	
	/**
	 * 
	 * @param course
	 */
	@Override
	public void addCourse(Course course) {
		
	}
	
	/**
	 * 
	 * @return
	 */
	@Override
	public Vector<Course> viewCourse() {
		
		return null;
	}
	
	/**
	 * 
	 * @param courseId
	 */
	@Override
	public void deleteCourse(int courseId) {
		
	}
	
	/**
	 * 
	 * @param user
	 */
	@Override
	public void addUser(User user) {
		
		statement = null;
		String sql = SQLQueriesConstant.ADD_USER_QUERY;
		
		try {
			
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
			
			if(row == 0) {
				System.out.println("User with userId: " + user.getUserId() + " not added.");
			} else {
				System.out.println("User with userId: " + user.getUserId() + " added.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
