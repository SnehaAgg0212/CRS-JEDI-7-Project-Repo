package com.crs.flipkart.business;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Vector;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.GradeCard;

public interface RegistrationInterface {

	/**
	 * @param courseId
	 * @param studentId
	 * @param availableCourses
	 * @return
	 */
	boolean addCourse(int courseId, int studentId, Vector<Course> availableCourses);

	/**
	 * @param courseId
	 * @param studentId
	 * @param registeredCourseList
	 * @return
	 */
	boolean dropCourse(int courseId, int studentId, Vector<Course> registeredCourseList);

	/**
	 * @param studentId
	 * @return
	 */
	boolean getRegistrationStatus(int studentId) throws SQLException;

	/**
	 * @param studentId
	 */
	void setRegistrationStatus(int studentId);

	/**
	 * @param studentId
	 * @return
	 */
	Vector<Course> viewRegisteredCourses(int studentId);

	/**
	 * @param studentId
	 * @return
	 */
	Vector<Course> viewCourses(int studentId);

	/**
	 * @param studentId
	 * @return
	 */
	boolean getPaymentStatus(int studentId) throws SQLException;

	/**
	 * @param studentId
	 * @return
	 */
	double calculateFee(int studentId) throws SQLException;

	/**
	 * @param studentId
	 * @param semesterId
	 * @return
	 */
	Vector<GradeCard> viewGradeCard(int studentId, int semesterId) throws SQLException;

	/**
	 * @param studentId
	 * @param invoiceId
	 * @param amount
	 */
	void setPaymentStatus(int studentId, int invoiceId, double amount) throws SQLException;

	/**
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
	 * @param studentId
	 * @param invoiceId
	 * @param bankAccountHolderName
	 * @param bankName
	 */
	void paymentByNetBanking(int studentId, int invoiceId, String bankAccountHolderName, String bankName) throws SQLException;

	/**
	 * @param studentId
	 * @return
	 */
	boolean isGenerated(int studentId) throws SQLException;

}