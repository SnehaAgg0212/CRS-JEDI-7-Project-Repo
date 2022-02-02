package com.crs.flipkart.dao;

import java.sql.SQLException;

import com.crs.flipkart.constants.NotificationTypeConstant;

public interface NotificationDaoInterface {

	/**
	 * Send Registration Notification
	 * @param type
	 * @param studentId
	 * @return
	 * @throws SQLException 
	 */
	int sendRegistrationNotification(NotificationTypeConstant type, int studentId) throws SQLException;

	/**
	 * Send Approval Notification
	 * @param type
	 * @param studentId
	 * @return
	 * @throws SQLException 
	 */
	int sendApprovalNotification(NotificationTypeConstant type, int studentId) throws SQLException;

	/**
	 * Send Payment Notification
	 * @param type
	 * @param studentId
	 * @param modeOfPayment
	 * @param amount
	 * @return
	 * @throws SQLException 
	 */
	int sendPaymentNotification(NotificationTypeConstant type, int studentId, int referenceId, double amount, int modeOfPayment) throws SQLException;

}