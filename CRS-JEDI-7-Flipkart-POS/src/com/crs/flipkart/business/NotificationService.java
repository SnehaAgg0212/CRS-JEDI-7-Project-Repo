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
	private static Logger logger = Logger.getLogger(NotificationService.class);
	
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
