/**
 * 
 */
package com.crs.flipkart.business;

/**
 * @author devanshugarg
 *
 */
public class NotificationService implements NotificationInterface {

	@Override
	public void sendPaymentNotification(String type, int studentId, String modeOfPayment, double amount) {
		
	}
	
    @Override
	public String getReferenceId(int notificationId) {
		
    	return null;
	}
    
    @Override
	public void sendRegistrationNotification(String type, int studentId){

    }

    @Override
	public void sendApprovalNotification(String type, int studentId){

    }
}
