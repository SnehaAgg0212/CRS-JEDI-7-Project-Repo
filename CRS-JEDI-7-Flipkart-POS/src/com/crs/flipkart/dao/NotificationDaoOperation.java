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
	
	/**
	 * 
	 * @param type
	 * @param studentId
	 * @param modeOfPayment
	 * @param amount
	 * @return
	 */
	@Override
	public int sendPaymentNotification(NotificationTypeConstant type, int studentId, int modeOfPayment, double amount) {
		
		int notificationId = 0;
		return notificationId;
	}
	
	/**
	 * 
	 * @param type
	 * @param studentId
	 * @return
	 */
	@Override
	public int sendRegistrationNotification(NotificationTypeConstant type, int studentId) {
		
		int notificationId = 0;
		return notificationId;
	}
	
	/**
	 * 
	 * @param type
	 * @param studentId
	 * @return
	 */
	@Override
	public int sendApprovalNotification(NotificationTypeConstant type, int studentId) {
		
		int notificationId = 0;
		return notificationId;
	}
	
	/**
	 * 
	 * @param studentId
	 * @param modeOfPayment
	 * @param amount
	 * @return
	 */
	@Override
	public UUID addPayment(int studentId, int modeOfPayment, double amount) {
		
		UUID referenceId;
		referenceId = UUID.randomUUID();
		return referenceId;
	}
	
	/**
	 * 
	 * @param notificationId
	 * @return
	 */
	@Override
	public int getReferenceId(int notificationId) {
		
		return 0;
	}
}
