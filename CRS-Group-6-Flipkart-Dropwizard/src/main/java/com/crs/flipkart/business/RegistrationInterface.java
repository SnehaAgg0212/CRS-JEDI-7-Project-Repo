package com.crs.flipkart.business;

import java.sql.SQLException;
import java.util.Vector;

import com.crs.flipkart.bean.CardPayment;
import com.crs.flipkart.bean.Cheque;
import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.GradeCard;
import com.crs.flipkart.bean.NetBanking;
import com.crs.flipkart.exceptions.CourseAlreadyRegisteredException;
import com.crs.flipkart.exceptions.CourseLimitExceededException;
import com.crs.flipkart.exceptions.CourseNotFoundException;
import com.crs.flipkart.exceptions.SeatNotAvailableException;

public interface RegistrationInterface {

	/**
	 * Add Course
	 * @param courseId
	 * @param studentId
	 * @param availableCourses
	 * @return
	 * @throws SQLException 
	 * @throws SeatNotAvailableException 
	 * @throws CourseLimitExceededException 
	 * @throws CourseNotFoundException 
	 */
	boolean addCourse(int courseId, int studentId, Vector<Course> availableCourses) throws SQLException, CourseLimitExceededException, SeatNotAvailableException, CourseAlreadyRegisteredException, CourseNotFoundException;

	/**
	 * Drop Course
	 * @param courseId
	 * @param studentId
	 * @param registeredCourseList
	 * @return
	 * @throws SQLException 
	 * @throws CourseNotFoundException 
	 */
	boolean dropCourse(int courseId, int studentId, Vector<Course> registeredCourseList) throws SQLException, CourseNotFoundException;

	/**
	 * Get Registration Status
	 * @param studentId
	 * @return
	 * @throws SQLException 
	 */
	boolean getRegistrationStatus(int studentId) throws SQLException;

	/**
	 * Set Registration Status
	 * @param studentId
	 * @throws SQLException 
	 */
	void setRegistrationStatus(int studentId) throws SQLException;

	/**
	 * View Registrated Courses
	 * @param studentId
	 * @return
	 * @throws SQLException 
	 */
	Vector<Course> viewRegisteredCourses(int studentId) throws SQLException;

	/**
	 * View Course
	 * @param studentId
	 * @return
	 * @throws SQLException 
	 */
	Vector<Course> viewCourses(int studentId) throws SQLException;

	/**
	 * Get Payment Status
	 * @param studentId
	 * @return
	 * @throws SQLException 
	 */
	boolean getPaymentStatus(int studentId) throws SQLException;

	/**
	 * Calculate Fee
	 * @param studentId
	 * @return
	 * @throws SQLException 
	 */
	double calculateFee(int studentId) throws SQLException;

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
	 * Total Registered Courses
	 * @param studentId
	 * @return
	 * @throws SQLException
	 */
	int totalRegisteredCourses(int studentId) throws SQLException;

	/**
	 * Is Semester Registered
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
	 * Paymeny by Cheque
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
	 * Payment by Net Banking
	 * @param studentId
	 * @param invoiceId
	 * @param bankAccountHolderName
	 * @param bankName
	 * @throws SQLException 
	 */
	void paymentByNetBanking(NetBanking netBanking) throws SQLException;

	/**
	 * View GradeCard
	 * @param studentId
	 * @return
	 * @throws SQLException 
	 */
	Vector<GradeCard> viewGradeCard(int studentId) throws SQLException;

}