/**
 * 
 */
package com.crs.flipkart.business;

import org.apache.log4j.Logger;

import com.crs.flipkart.constants.NotificationTypeConstant;
import com.crs.flipkart.dao.NotificationDaoInterface;
import com.crs.flipkart.dao.NotificationDaoOperation;

/**
 * @author devanshugarg
 *
 */
public class NotificationService implements NotificationInterface {
	
	private static volatile NotificationService instance = null;
	
	/**
	 * Default Constructor
	 */
	private NotificationService() {
		
	}
	
	/**
	 * Method to make NotificationService Singleton
	 */
	public static NotificationService getInstance() {
		
		if(instance == null) {
			
			synchronized(NotificationService.class) {
				
				instance = new NotificationService();
			}
		}
		return instance;
	}
	
	NotificationDaoInterface notificationDaoOperation = NotificationDaoOperation.getInstance();

	@Override
	public int sendPaymentNotification(NotificationTypeConstant type, int studentId, int modeOfPayment, double amount, int referenceId) {
		
		return notificationDaoOperation.sendPaymentNotification(type, studentId, referenceId, amount, modeOfPayment);
	}
    
    @Override
	public int sendRegistrationNotification(NotificationTypeConstant type, int studentId){

    	return notificationDaoOperation.sendRegistrationNotification(type, studentId);
    }

    @Override
	public int sendApprovalNotification(NotificationTypeConstant type, int studentId){

    	return notificationDaoOperation.sendApprovalNotification(type, studentId);
    }
}
