package com.crs.flipkart.business;

import com.crs.flipkart.constants.NotificationTypeConstant;

public interface NotificationInterface {

	/**
	 * @param type
	 * @param studentId
	 * @param modeOfPayment
	 * @param amount
	 * @return
	 */
	int sendPaymentNotification(NotificationTypeConstant type, int studentId, int modeOfPayment, double amount, int referenceId);

	/**
	 * @param type
	 * @param studentId
	 * @return
	 */
	int sendApprovalNotification(NotificationTypeConstant type, int studentId);

	/**
	 * 
	 * @param type
	 * @param studentId
	 * @return
	 */
	int sendRegistrationNotification(NotificationTypeConstant type, int studentId);

}