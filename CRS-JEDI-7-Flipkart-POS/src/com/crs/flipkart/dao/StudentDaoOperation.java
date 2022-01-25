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
	 * Add student to database
	 * @param student object with all fields populated
	 * @return boolean indicating if student is added
	 */
	@Override
	public String addStudent(Student student) {
		statement = null;
		String studentId = null;
		try {
			String sql = SQLQueriesConstant.ADD_USER_QUERY;
			statement = connection.prepareStatement(sql);
			statement.setInt(1, student.getUserId());
			statement.setString(2, student.getUserName());
			statement.setString(3, student.getUserEmailId());
			statement.setString(4, student.getUserPassword());
			statement.setString(5, student.getRole());
			statement.setString(6, student.getPhoneNo());
			statement.setString(7, student.getGender());
			statement.setString(8, student.getAddress());
			
			int rows = statement.executeUpdate();
			if(rows == 1) {
				PreparedStatement studentStatement = null;
				String studentSqlQuery = SQLQueriesConstant.ADD_STUDENT_QUERY;
				studentStatement = connection.prepareStatement(studentSqlQuery, Statement.RETURN_GENERATED_KEYS);
				
				studentStatement.setInt(1, student.getUserId());;
				studentStatement.setString(2, student.getBranchName());
				studentStatement.setInt(3, student.getBatch());
				studentStatement.executeUpdate();
				
				ResultSet resultSet = studentStatement.getGeneratedKeys();
				if(resultSet.next()) {
					studentId = resultSet.getString(1);
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
	 * @return Student Id
	 */
	@Override
	public String getStudentId(String userId) {
		statement = null;
		
		try {

			String sql = SQLQueriesConstant.GET_STUDENT_ID;
			statement = connection.prepareStatement(sql);
			statement.setString(1, userId);
			
			ResultSet resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				return resultSet.getString("studentId");
			}
		} catch (SQLException e) {
			
			System.out.println("Error: " + e.getMessage());
		}
		return null;
	}

	/**
	 * Check if Student is approved
	 * @param studentId
	 * @return boolean indicating if student is approved
	 */
	@Override
	public boolean isApproved(String studentId) {
		
		statement = null;
		try {
			String sql = SQLQueriesConstant.IS_APPROVED;
			statement = connection.prepareStatement(sql);
			statement.setString(1, studentId);
		
			ResultSet resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				return resultSet.getBoolean("isApproved");
			}
	
		} catch (SQLException e) {
			
			System.out.println("Error: " + e.getMessage());
		}
		
		return false;
	}
	
}
