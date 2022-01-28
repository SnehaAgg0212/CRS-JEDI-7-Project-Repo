package com.crs.flipkart.dao;

import java.util.UUID;

import com.crs.flipkart.constants.NotificationTypeConstant;

public interface NotificationDaoInterface {

	/**
	 * @param type
	 * @param studentId
	 * @param modeOfPayment
	 * @param amount
	 */
	void sendPaymentNotification(String type, int studentId, String modeOfPayment, double amount,int referenceId,int notificationId);

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
	void sendRegistrationNotification(String type, int studentId,int notificationId);

}
//	int sendPaymentNotification(NotificationTypeConstant type, int studentId, int modeOfPayment, double amount);
//
//	/**
//	 * 
//	 * @param type
//	 * @param studentId
//	 * @return
//	 */
//	int sendRegistrationNotification(NotificationTypeConstant type, int studentId);
//
//	/**
//	 * 
//	 * @param type
//	 * @param studentId
//	 * @return
//	 */
//	int sendApprovalNotification(NotificationTypeConstant type, int studentId);
//
//	/**
//	 * 
//	 * @param studentId
//	 * @param modeOfPayment
//	 * @param amount
//	 * @return
//	 */
//	UUID addPayment(int studentId, int modeOfPayment, double amount);
//
//	/**
//	 * 
//	 * @param notificationId
//	 * @return
//	 */
//	int getReferenceId(int notificationId);
//
//}