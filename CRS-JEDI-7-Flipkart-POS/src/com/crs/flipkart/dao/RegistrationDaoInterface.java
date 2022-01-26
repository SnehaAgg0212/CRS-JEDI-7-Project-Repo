/**
 * 
 */
package com.crs.flipkart.dao;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Vector;

import com.crs.flipkart.bean.GradeCard;

import java.sql.Date;

/**
 * @author HP
 *
 */
public interface RegistrationDaoInterface {
	
	 boolean getPaymentStatus(int studentId);
	
	 void setPaymentStatus(int studentId,int invoiceId,double amount);
	
	 double calculateFee(int studentId);
	
	 boolean getRegistrationStatus(int studentId);
	
	 void paymentByCard(int studentId,int invoiceId,String cardType,String cardNumber,String cardHolderName,int cvv,String bankName,Date expiryDate);
	
	 void paymentByCheque(int studentId,int invoiceId,int chequeNo,String bankAccountHolderName,String bankAccountNumber,String ifsc,String bankName,String bankBranchName,Date chequeDate);

	 void paymentByNetBanking(int studentId,int invoiceId,String bankAccountHolderName,String bankName);
	 
	 boolean isGenerated(int studentId);
	 
	 Vector<GradeCard> viewGradeCard(int studentId,int semesterId);


}
