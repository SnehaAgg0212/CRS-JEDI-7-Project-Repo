package com.crs.flipkart.business;

import java.util.Vector;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.GradeCard;

public interface RegistrationInterface {

	boolean addCourse(int courseId, int studentId, Vector<Course> availableCourses);

	boolean dropCourse(int courseId, int studentId, Vector<Course> registeredCourseList);

	boolean getRegistrationStatus(int studentId);

	void setRegistrationStatus(int studentId);

	Vector<Course> viewRegisteredCourses(int studentId);

	Vector<GradeCard> viewGradeCard(int studentId);

	Vector<Course> viewCourses(int studentId);

	boolean getPaymentStatus(int studentId);

	void setPaymentStatus(int studentId);

	double calculateFee(int studentId);

}