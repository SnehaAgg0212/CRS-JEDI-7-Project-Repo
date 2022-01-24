package com.crs.flipkart.business;

public interface NotificationInterface {

	void sendPaymentNotification(String type, int studentId, String modeOfPayment, double amount);

	String getReferenceId(int notificationId);

	void sendRegistrationNotification(String type, int studentId);

	void sendApprovalNotification(String type, int studentId);

}