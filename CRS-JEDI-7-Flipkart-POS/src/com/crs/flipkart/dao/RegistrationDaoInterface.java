package com.crs.flipkart.dao;

import java.sql.Date;
import java.util.Vector;

import com.crs.flipkart.bean.GradeCard;

public interface RegistrationDaoInterface {

	/**
	 * 
	 * @param studentId
	 * @return
	 */
	double calculateFee(int studentId);

	/**
	 * 
	 * @param studentId
	 * @return
	 */
	boolean getRegistrationStatus(int studentId);

	/**
	 * 
	 * @param studentId
	 * @return
	 */
	boolean getPaymentStatus(int studentId);

	/**
	 * 
	 * @param studentId
	 * @param invoiceId
	 * @param cardType
	 * @param cardNumber
	 * @param cardHolderName
	 * @param cvv
	 * @param bankName
	 * @param expiryDate
	 */
	void paymentByCard(int studentId, int invoiceId, String cardType, String cardNumber, String cardHolderName, int cvv,
			String bankName, Date expiryDate);

	/**
	 * 
	 * @param studentId
	 * @param invoiceId
	 * @param chequeNo
	 * @param bankAccountHolderName
	 * @param bankAccountNumber
	 * @param ifsc
	 * @param bankName
	 * @param bankBranchName
	 * @param chequeDate
	 */
	void paymentByCheque(int studentId, int invoiceId, int chequeNo, String bankAccountHolderName,
			String bankAccountNumber, String ifsc, String bankName, String bankBranchName, Date chequeDate);

	/**
	 * 
	 * @param studentId
	 * @param invoiceId
	 * @param bankAccountHolderName
	 * @param bankName
	 */
	void paymentByNetBanking(int studentId, int invoiceId, String bankAccountHolderName, String bankName);

	/**
	 * 
	 * @param studentId
	 * @param invoiceId
	 * @param amount
	 */
	void setPaymentStatus(int studentId, int invoiceId, double amount);

	/**
	 * 
	 * @param studentId
	 * @return
	 */
	boolean isGenerated(int studentId);

	/**
	 * 
	 * @param studentId
	 * @param semesterId
	 * @return
	 */
	Vector<GradeCard> viewGradeCard(int studentId, int semesterId);

}