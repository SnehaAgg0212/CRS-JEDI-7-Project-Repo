/**
 * 
 */
package com.crs.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.crs.flipkart.bean.Student;
import com.crs.flipkart.constants.SQLQueriesConstant;
import com.crs.flipkart.utils.DBUtils;

/**
 * @author devanshugarg, iamshambhavi
 *
 */
public class StudentDaoOperation implements StudentDaoInterface {

	Connection connection = DBUtils.getConnection();
 	private PreparedStatement statement = null;
 	
 	/**
	 * Default Constructor
	 */
	public StudentDaoOperation()
	{

	}
	
	/**
	 * Add Student to Database
	 * @param student
	 * @return
	 */
	@Override
	public int addStudent(Student student) {
		
		statement = null;
		int studentId = 0;
		
		try {
			String sql = SQLQueriesConstant.ADD_USER_QUERY;
 			statement = connection.prepareStatement(sql);
 			statement.setInt(1, student.getUserId());
 			statement.setString(2, student.getUserName());
 			statement.setString(3, student.getUserEmailId());
 			statement.setString(4, student.getUserPassword());
 			statement.setString(5, student.getRole().toString());
 			statement.setString(6, student.getPhoneNo());
 			statement.setString(7, student.getGender().toString());
 			statement.setString(8, student.getAddress());
 			int row = statement.executeUpdate();
 			if (row == 1) {
 				PreparedStatement studentStatement = null;
 				String studentSql = SQLQueriesConstant.ADD_STUDENT_QUERY;
 				studentStatement = connection.prepareStatement(studentSql, Statement.RETURN_GENERATED_KEYS);
 				studentStatement.setInt(1, student.getUserId());
 				studentStatement.setString(2, student.getBranchName());
 				studentStatement.setInt(3, student.getBatch());
 				studentStatement.setInt(4, student.getStudentId());
 				studentStatement.executeUpdate();
 				ResultSet resultSet = studentStatement.getGeneratedKeys();
 				if(resultSet.next()) {
 					studentId = resultSet.getInt(1);
 				}
 			}
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return studentId;
	}
	
	/**
	 * Retrieve Student Id from User Id
	 * @param userId
	 * @return
	 */
	@Override
	public int getStudentId(int userId) {
		
		statement = null;
		int studentId = 0;
		
		try {
			String sql = SQLQueriesConstant.GET_STUDENT_ID;
 			statement = connection.prepareStatement(sql);
 			statement.setInt(1, userId);
 			ResultSet resultSet = statement.executeQuery();
 			if(resultSet.next()) {
 				studentId = resultSet.getInt(1);
 			}
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return studentId;
	}
	
	/**
	 * Check if Student is Approved or not
	 * @param studentId
	 * @return
	 */
	@Override
	public boolean isApproved(int studentId) {
		
		statement = null;
		
		try {
			String sql = SQLQueriesConstant.IS_APPROVED;
 			statement = connection.prepareStatement(sql);
 			statement.setInt(1, studentId);
 			ResultSet resultSet = statement.executeQuery();
 			if(resultSet.next()) {
 				return resultSet.getBoolean(1);
 			}
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return false;
	}
}
