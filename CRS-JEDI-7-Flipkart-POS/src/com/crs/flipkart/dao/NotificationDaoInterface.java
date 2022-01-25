package com.crs.flipkart.dao;

import java.util.UUID;

public interface NotificationDaoInterface {

	/**
	 * 
	 * @param type
	 * @param studentId
	 * @param modeOfPayment
	 * @param amount
	 * @return
	 */
	int sendPaymentNotification(String type, int studentId, String modeOfPayment, double amount);

	/**
	 * 
	 * @param type
	 * @param studentId
	 * @return
	 */
	int sendRegistrationNotification(String type, int studentId);

	/**
	 * 
	 * @param type
	 * @param studentId
	 * @return
	 */
	int sendApprovalNotification(String type, int studentId);

	/**
	 * 
	 * @param studentId
	 * @param modeOfPayment
	 * @param amount
	 * @return
	 */
	UUID addPayment(int studentId, String modeOfPayment, double amount);

	/**
	 * 
	 * @param notificationId
	 * @return
	 */
	int getReferenceId(int notificationId);

}