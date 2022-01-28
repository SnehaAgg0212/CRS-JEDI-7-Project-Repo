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
	 * @throws SQLException 
	 */
	double calculateFee(int studentId) throws SQLException;

	/**
	 * 
	 * @param studentId
	 * @return
	 * @throws SQLException 
	 */
	boolean getRegistrationStatus(int studentId) throws SQLException;

	/**
	 * 
	 * @param studentId
	 * @return
	 * @throws SQLException 
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
	 * @throws SQLException 
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
	 * @throws SQLException 
	 */
	void paymentByCheque(int studentId, int invoiceId, int chequeNo, String bankAccountHolderName,
			String bankAccountNumber, String ifsc, String bankName, String bankBranchName, Date chequeDate) throws SQLException;

	/**
	 * 
	 * @param studentId
	 * @param invoiceId
	 * @param bankAccountHolderName
	 * @param bankName
	 * @throws SQLException 
	 */
	void paymentByNetBanking(int studentId, int invoiceId, String bankAccountHolderName, String bankName) throws SQLException;

	/**
	 * 
	 * @param studentId
	 * @param invoiceId
	 * @param amount
	 * @throws SQLException 
	 */
	void setPaymentStatus(int studentId, int invoiceId, double amount) throws SQLException;

	/**
	 * 
	 * @param studentId
	 * @return
	 * @throws SQLException 
	 */
	boolean isGenerated(int studentId) throws SQLException;

	/**
	 * 
	 * @param studentId
	 * @param semesterId
	 * @return
	 * @throws SQLException 
	 */
	Vector<GradeCard> viewGradeCard(int studentId, int semesterId) throws SQLException;

	/**
	 * 
	 * @param studentId
	 * @param courseId
	 * @return
	 * @throws SQLException 
	 */
	boolean addCourse(int studentId, int courseId) throws SQLException;

	/**
	 * 
	 * @param semester
	 * @param studentId
	 * @return
	 * @throws SQLException 
	 */
	boolean semesterRegistration(int semester, int studentId) throws SQLException;

	/**
	 * 
	 * @param semester
	 * @param studentId
	 * @return
	 * @throws SQLException 
	 */
	boolean addSemester(int semester, int studentId) throws SQLException;

	/**
	 * 
	 * @param studentId
	 * @param courseId
	 * @return
	 * @throws SQLException 
	 */
	boolean dropCourse(int studentId, int courseId) throws SQLException;

	/**
	 * 
	 * @param courseId
	 * @return
	 * @throws SQLException 
	 */
	boolean isSeatAvailable(int courseId) throws SQLException;

	/**
	 * 
	 * @param studentId
	 * @return
	 * @throws SQLException 
	 */
	int totalRegisteredCourses(int studentId) throws SQLException;

	/**
	 * 
	 * @param studentId
	 * @return
	 * @throws SQLException 
	 */
	Vector<Course> viewCourses(int studentId) throws SQLException;

	/**
	 * 
	 * @param studentId
	 * @return
	 * @throws SQLException 
	 */
	Vector<Course> viewRegisteredCourses(int studentId) throws SQLException;

	/**
	 * 
	 * @param courseCode
	 * @param studentId
	 * @return
	 * @throws SQLException
	 */
	boolean isRegistered(String courseCode, String studentId) throws SQLException;

	/**
	 * 
	 * @param courseId
	 * @param studentId
	 * @return
	 * @throws SQLException
	 */
	boolean checkCourse(int courseId, int studentId) throws SQLException;

}