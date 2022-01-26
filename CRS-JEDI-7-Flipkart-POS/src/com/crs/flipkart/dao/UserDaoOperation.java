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
     
	private PreparedStatement statement = null;
	Connection connection = DBUtils.getConnection();
	
	public boolean verifyCredentials(String userEmailId, String password) {
		try {
			 statement = connection.prepareStatement(SQLQueriesConstant.VERIFY_CREDENTIALS);
			 statement.setString(1,userEmailId);
			 ResultSet resultSet = statement.executeQuery();
			 if(!resultSet.next()) {
				 return false;
			 }
			 else if(password.equals(resultSet.getString("userPassword"))) {
				 return true;
			 }
			 return false;
		}
		catch(SQLException ex) {
			System.out.println("Error occured: " + ex.getMessage());
		}
		return false;
		
	}
	public boolean updatePassword(String userEmailId, String newPassword){
		try {
			statement = connection.prepareStatement(SQLQueriesConstant.UPDATE_PASSWORD);
			statement.setString(1, newPassword);
			statement.setString(2, userEmailId);
			
			int row = statement.executeUpdate();
			if(row==1)
				return true;
			else
				return false;
		}
		catch(SQLException e)
		{
			System.out.println("Error occured: "+ e.getMessage());
		}
		return false;
	}
	public String getRole(int  userId) {
		try {
			
			statement = connection.prepareStatement(SQLQueriesConstant.GET_ROLE);
			statement.setInt(1, userId);
			ResultSet rs = statement.executeQuery();
			
			if(rs.next())
			{
				return rs.getString("role");
			}	
		}
		catch(Exception e)
		{
			System.out.println("Error Occured: "+e.getMessage());
		}
		return null;
	}
	
}
