/**
 * 
 */
package com.crs.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.crs.flipkart.constants.SQLQueriesConstant;
import com.crs.flipkart.utils.DBUtils;

/**
 * @author devanshugarg
 *
 */
public class UserDaoOperation implements UserDaoInterface {

	Connection connection = DBUtils.getConnection();
	private PreparedStatement statement = null;
	
	/**
	 * Default Constructor
	 */
	public UserDaoOperation() {
		
	}
	
	/**
	 * 
	 * @param userEmailId
	 * @param password
	 * @return
	 */
	@Override
	public boolean verifyCredentials(String userEmailId, String password) {
		
		statement = null;
		
 		try {
 			String sql = SQLQueriesConstant.VERIFY_CREDENTIALS;
 			statement = connection.prepareStatement(sql);
 			statement.setString(1,userEmailId);
 			ResultSet resultSet = statement.executeQuery();
 			if(!resultSet.next()) {
 				return false;
 			}
 			else if(password.equals(resultSet.getString("userPassword"))) {
 				return true;
 			}
 		} catch(SQLException e) {
 			System.out.println("Error: " + e.getMessage());
 		}
 		return false;
 	}
	
	/**
	 * 
	 * @param userEmailId
	 * @param newPassword
	 * @return
	 */
 	@Override
	public boolean updatePassword(String userEmailId, String newPassword){
 		
 		statement = null;
 		
 		try {
 			String sql = SQLQueriesConstant.UPDATE_PASSWORD;
 			statement = connection.prepareStatement(sql);
 			statement.setString(1, newPassword);
 			statement.setString(2, userEmailId);
 			int row = statement.executeUpdate();
 			if(row == 1) {
 				return true;
 			}
 		} catch(SQLException e) {
 			System.out.println("Error: "+ e.getMessage());
 		}
 		return false;
 	}
 	
 	/**
 	 * 
 	 * @param userId
 	 * @return
 	 */
 	@Override
	public String getRole(String userEmailId) {
 		
 		statement = null;
 		String role = "";
 		
 		try {
 			String sql = SQLQueriesConstant.GET_ROLE;
 			statement = connection.prepareStatement(sql);
 			statement.setString(1, userEmailId);
 			ResultSet resultSet = statement.executeQuery();
 			if(resultSet.next()) {
 				role = resultSet.getString("role");
 			}	
 		} catch(Exception e) {
 			System.out.println("Error: " + e.getMessage());
 		}
 		return role;
 	}
 	
 	/**
 	 * 
 	 * @param userEmailId
 	 * @return
 	 */
 	@Override
 	public int getUserId(String userEmailId) {
 		
 		statement = null;
 		int userId = 0;
 		
 		try {
 			String sql = SQLQueriesConstant.GET_USER_ID;
 			statement = connection.prepareStatement(sql);
 			statement.setString(1, userEmailId);
 			ResultSet resultSet = statement.executeQuery();
 			if(resultSet.next()) {
 				userId = resultSet.getInt("userId");
 			}
 		} catch (SQLException e) {
 			System.out.println("Error: " + e.getMessage());
 		}
 		return userId;
 	}
}
