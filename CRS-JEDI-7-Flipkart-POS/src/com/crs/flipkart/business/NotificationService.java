/**
 * 
 */
package com.crs.flipkart.business;

import com.crs.flipkart.constants.NotificationTypeConstant;

/**
 * @author devanshugarg
 *
 */
public class NotificationService implements NotificationInterface {

	@Override
	public void sendPaymentNotification(NotificationTypeConstant type, int studentId, int modeOfPayment, double amount) {
		
	}
	
    @Override
	public String getReferenceId(int notificationId) {
		
    	return null;
	}
    
    @Override
	public void sendRegistrationNotification(NotificationTypeConstant type, int studentId){

    }

    @Override
	public void sendApprovalNotification(NotificationTypeConstant type, int studentId){

    }
}
