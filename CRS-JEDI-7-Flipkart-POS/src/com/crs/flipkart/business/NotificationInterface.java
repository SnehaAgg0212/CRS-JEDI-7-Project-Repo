package com.crs.flipkart.business;

import com.crs.flipkart.constants.NotificationTypeConstant;

public interface NotificationInterface {

	/**
	 * @param type
	 * @param studentId
	 * @param modeOfPayment
	 * @param amount
	 */
	void sendPaymentNotification(String type, int studentId, String modeOfPayment, double amount,int referenceId);

	/**
	 * @param notificationId
	 * @return
	 */
//	String getReferenceId(int notificationId);

	/**
	 * @param type
	 * @param studentId
	 */
//	void sendApprovalNotification(String type, int studentId);

	/**
	 * 
	 * @param type
	 * @param studentId
	 */
	void sendRegistrationNotification(String type, int studentId);

}