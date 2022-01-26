package com.crs.flipkart.business;

import java.math.BigInteger;
import java.time.LocalDate;
import java.sql.Date;
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
	boolean getRegistrationStatus(int studentId);

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
	Vector<GradeCard> viewGradeCard(int studentId,int semesterId);

	/**
	 * @param studentId
	 * @return
	 */
	Vector<Course> viewCourses(int studentId);

	/**
	 * @param studentId
	 * @return
	 */
	boolean getPaymentStatus(int studentId);

	/**
	 * @param studentId
	 */
	void setPaymentStatus(int studentId,int invoiceId,double amount);

	/**
	 * @param studentId
	 * @return
	 */
	double calculateFee(int studentId);
	
	void paymentByCard(int studentId,int invoiceId,String cardType,String cardNumber,String cardHolderName,int cvv,String bankName,Date expiryDate);
	void paymentByCheque(int studentId,int invoiceId,int chequeNo,String bankAccountHolderName,String bankAccountNumber,String ifsc,String bankName,String bankBranchName,Date chequeDate);
	void paymentByNetBanking(int studentId,int invoiceId,String bankAccountHolderName,String bankName);

	boolean isGenerated(int studentId);
}