package com.crs.flipkart.business;

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
	Vector<GradeCard> viewGradeCard(int studentId);

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
	void setPaymentStatus(int studentId);

	/**
	 * @param studentId
	 * @return
	 */
	double calculateFee(int studentId);

}