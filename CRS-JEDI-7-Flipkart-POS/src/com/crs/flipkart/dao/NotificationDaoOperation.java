/**
 * 
 */
package com.crs.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import com.crs.flipkart.constants.NotificationTypeConstant;
import com.crs.flipkart.constants.SQLQueriesConstant;
import com.crs.flipkart.utils.DBUtils;

/**
 * @author devanshugarg
 *
 */
public class NotificationDaoOperation implements NotificationDaoInterface {

	Connection connection = DBUtils.getConnection();
	private PreparedStatement statement = null;
	
	/**
	 * Default Constructor
	 */
	
	public NotificationDaoOperation()
	{

	}
	

	@Override
	public void sendPaymentNotification(String type, int studentId, String modeOfPayment, double amount,
			int referenceId, int notificationId) {
		// TODO Auto-generated method stub
		statement=null;
		String notificationContent="Mode Of Payment is "+modeOfPayment+ "\n" + "Payment is Successful"; 
		try {
			String sql = SQLQueriesConstant.ADD_PAYMENT_NOTIFICATION;
			statement = connection.prepareStatement(sql);
			statement.setInt(1, notificationId);
			statement.setInt(2, studentId);
			statement.setString(3,"Payment");
			statement.setInt(4, referenceId);
			statement.setString(5, notificationContent);
		    statement.executeUpdate();
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
		}
		
	}


	@Override
	public void sendRegistrationNotification(String type, int studentId,int notificationId) {
		// TODO Auto-generated method stub
		statement=null;
		String notificationContent="Registration is Successful"; 
		try {
			String sql = SQLQueriesConstant.ADD_REGISTRATION_NOTIFICATION;
			statement = connection.prepareStatement(sql);
			statement.setInt(1, notificationId);
			statement.setInt(2, studentId);
			statement.setString(3,"Registration");
			statement.setString(4, notificationContent);
		    statement.executeUpdate();
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
		}
		
	}
}
