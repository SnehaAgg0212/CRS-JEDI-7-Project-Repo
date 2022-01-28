package com.crs.flipkart.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Vector;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.GradeCard;

public interface RegistrationDaoInterface {

	/**
	 * 
	 * @param studentId
	 * @return
	 */
	double calculateFee(int studentId) throws SQLException;

	/**
	 * 
	 * @param studentId
	 * @return
	 */
	boolean getRegistrationStatus(int studentId) throws SQLException;

	/**
	 * 
	 * @param studentId
	 * @return
	 */
	boolean getPaymentStatus(int studentId) throws SQLException;

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
			String bankName, Date expiryDate) throws SQLException;

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
			String bankAccountNumber, String ifsc, String bankName, String bankBranchName, Date chequeDate) throws SQLException;

	/**
	 * 
	 * @param studentId
	 * @param invoiceId
	 * @param bankAccountHolderName
	 * @param bankName
	 */
	void paymentByNetBanking(int studentId, int invoiceId, String bankAccountHolderName, String bankName) throws SQLException;

	/**
	 * 
	 * @param studentId
	 * @param invoiceId
	 * @param amount
	 */
	void setPaymentStatus(int studentId, int invoiceId, double amount) throws SQLException;

	/**
	 * 
	 * @param studentId
	 * @return
	 */
	boolean isGenerated(int studentId) throws SQLException;

	/**
	 * 
	 * @param studentId
	 * @param semesterId
	 * @return
	 */
	Vector<GradeCard> viewGradeCard(int studentId, int semesterId) throws SQLException;

	/**
	 * 
	 * @param studentId
	 * @param courseId
	 * @return
	 */
	boolean addCourse(int studentId, int courseId);

	/**
	 * 
	 * @param semester
	 * @param studentId
	 * @return
	 */
	boolean semesterRegistration(int semester, int studentId);

	/**
	 * 
	 * @param semester
	 * @param studentId
	 * @return
	 */
	boolean addSemester(int semester, int studentId);

	/**
	 * 
	 * @param studentId
	 * @param courseId
	 * @return
	 */
	boolean dropCourse(int studentId, int courseId);

	/**
	 * 
	 * @param courseId
	 * @return
	 */
	boolean isSeatAvailable(int courseId);

	/**
	 * 
	 * @param studentId
	 * @return
	 */
	int totalRegisteredCourses(int studentId);

	/**
	 * 
	 * @param studentId
	 * @return
	 */
	Vector<Course> viewCourses(int studentId);

	/**
	 * 
	 * @param studentId
	 * @return
	 */
	Vector<Course> viewRegisteredCourses(int studentId);

}