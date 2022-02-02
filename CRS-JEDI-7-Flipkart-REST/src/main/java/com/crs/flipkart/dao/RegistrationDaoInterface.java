package com.crs.flipkart.dao;

import java.sql.SQLException;
import java.util.Vector;

import com.crs.flipkart.bean.CardPayment;
import com.crs.flipkart.bean.Cheque;
import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.GradeCard;
import com.crs.flipkart.bean.NetBanking;

public interface RegistrationDaoInterface {

	/**
	 * Calculate Fee
	 * @param studentId
	 * @return
	 * @throws SQLException 
	 */
	double calculateFee(int studentId) throws SQLException;

	/**
	 * Get Registration Status
	 * @param studentId
	 * @return
	 * @throws SQLException 
	 */
	boolean getRegistrationStatus(int studentId) throws SQLException;

	/**
	 * Get Payment Status
	 * @param studentId
	 * @return
	 * @throws SQLException 
	 */
	boolean getPaymentStatus(int studentId) throws SQLException;

	/**
	 * Set Payment Status
	 * @param studentId
	 * @param invoiceId
	 * @param amount
	 * @throws SQLException 
	 */
	void setPaymentStatus(int studentId, int invoiceId, double amount) throws SQLException;

	/**
	 * Is Generated
	 * @param studentId
	 * @return
	 * @throws SQLException 
	 */
	boolean isGenerated(int studentId) throws SQLException;
	
	/**
	 * Add Course
	 * @param studentId
	 * @param courseId
	 * @return
	 * @throws SQLException 
	 */
	boolean addCourse(int studentId, int courseId) throws SQLException;

	/**
	 * Semester Registration
	 * @param semester
	 * @param studentId
	 * @return
	 * @throws SQLException 
	 */
	boolean semesterRegistration(int semester, int studentId) throws SQLException;

	/**
	 * Add Semester
	 * @param semester
	 * @param studentId
	 * @return
	 * @throws SQLException 
	 */
	boolean addSemester(int semester, int studentId) throws SQLException;

	/**
	 * Drop Course
	 * @param studentId
	 * @param courseId
	 * @return
	 * @throws SQLException 
	 */
	boolean dropCourse(int studentId, int courseId) throws SQLException;

	/**
	 * Is Seat Available
	 * @param courseId
	 * @return
	 * @throws SQLException 
	 */
	boolean isSeatAvailable(int courseId) throws SQLException;

	/**
	 * Total Registered Courses
	 * @param studentId
	 * @return
	 * @throws SQLException 
	 */
	int totalRegisteredCourses(int studentId) throws SQLException;

	/**
	 * View Courses
	 * @param studentId
	 * @return
	 * @throws SQLException 
	 */
	Vector<Course> viewCourses(int studentId) throws SQLException;

	/**
	 * View Registered Courses
	 * @param studentId
	 * @return
	 * @throws SQLException 
	 */
	Vector<Course> viewRegisteredCourses(int studentId) throws SQLException;

	/**
	 * Is Registered
	 * @param courseCode
	 * @param studentId
	 * @return
	 * @throws SQLException
	 */
	boolean isRegistered(int courseId, int studentId) throws SQLException;

	/**
	 * Is Semester Registered
	 * @param courseId
	 * @param studentId
	 * @return
	 * @throws SQLException
	 */
	boolean isSemesterRegistered(int studentId) throws SQLException;

	/**
	 * Payment by Card
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
	void paymentByCard(CardPayment card) throws SQLException;

	/**
	 * Payment by Cheque
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
	void paymentByCheque(Cheque cheque) throws SQLException;

	/**
	 * Payment by NetBanking
	 * @param studentId
	 * @param invoiceId
	 * @param bankAccountHolderName
	 * @param bankName
	 * @throws SQLException
	 */
	void paymentByNetBanking(NetBanking netBanking) throws SQLException;

	/**
	 * View Grade Card
	 * @param studentId
	 * @param semesterId
	 * @return
	 * @throws SQLException
	 */
	Vector<GradeCard> viewGradeCard(int studentId) throws SQLException;

}