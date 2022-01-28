package com.crs.flipkart.dao;

import com.crs.flipkart.constants.NotificationTypeConstant;

public interface NotificationDaoInterface {

	/**
	 * 
	 * @param type
	 * @param studentId
	 * @return
	 */
	int sendRegistrationNotification(NotificationTypeConstant type, int studentId);

	/**
	 * 
	 * @param type
	 * @param studentId
	 * @return
	 */
	int sendApprovalNotification(NotificationTypeConstant type, int studentId);

	/**
	 * 
	 * @param type
	 * @param studentId
	 * @param modeOfPayment
	 * @param amount
	 * @return
	 */
	int sendPaymentNotification(NotificationTypeConstant type, int studentId, int referenceId, double amount, int modeOfPayment);

}