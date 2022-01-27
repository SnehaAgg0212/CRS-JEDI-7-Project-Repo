package com.crs.flipkart.business;

import com.crs.flipkart.constants.NotificationTypeConstant;

public interface NotificationInterface {

	/**
	 * @param type
	 * @param studentId
	 * @param modeOfPayment
	 * @param amount
	 */
	void sendPaymentNotification(NotificationTypeConstant type, int studentId, int modeOfPayment, double amount);

	/**
	 * @param notificationId
	 * @return
	 */
	String getReferenceId(int notificationId);

	/**
	 * @param type
	 * @param studentId
	 */
	void sendApprovalNotification(NotificationTypeConstant type, int studentId);

	/**
	 * 
	 * @param type
	 * @param studentId
	 */
	void sendRegistrationNotification(NotificationTypeConstant type, int studentId);

}