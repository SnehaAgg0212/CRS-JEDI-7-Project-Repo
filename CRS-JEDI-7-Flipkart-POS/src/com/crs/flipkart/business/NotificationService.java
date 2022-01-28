/**
 * 
 */
package com.crs.flipkart.business;

import com.crs.flipkart.constants.NotificationTypeConstant;
import com.crs.flipkart.dao.NotificationDaoInterface;
import com.crs.flipkart.dao.NotificationDaoOperation;
import com.crs.flipkart.utils.Utils;

/**
 * @author devanshugarg
 *
 */
public class NotificationService implements NotificationInterface {
	NotificationDaoInterface notificationdao= new  NotificationDaoOperation();
	@Override
	
	public void sendPaymentNotification(String type, int studentId, String modeOfPayment, double amount,int referenceId) {
		// TODO Auto-generated method stub
		
		int notificationId= Utils.generateId();
		notificationdao.sendPaymentNotification(type, studentId, modeOfPayment, amount, referenceId,notificationId);
		switch(type)
		{
		case "Cash": 
			System.out.println("Mode of Payment: "+modeOfPayment );
			
			break;
		case "Cheque":
			System.out.println("Mode of Payment: "+modeOfPayment );
			break;
		case "Netbanking":
			System.out.println("Mode of Payment: "+modeOfPayment );
			break;
		default: break;
		}
		System.out.println("Invoice Id: "+referenceId);
		System.out.println("Amount: "+amount);
		System.out.println("Payment is Successful");
		
	}

	@Override
	public void sendRegistrationNotification(String type, int studentId) {
		// TODO Auto-generated method stub
		int notificationId= Utils.generateId();
		notificationdao.sendRegistrationNotification(type,studentId, notificationId);
		System.out.println("Registration is Successful");
		
	}

	
}
