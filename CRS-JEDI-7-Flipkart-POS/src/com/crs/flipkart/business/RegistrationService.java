/**
 * 
 */
package com.crs.flipkart.business;

import java.util.Vector;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.GradeCard;

/**
 * @author devanshugarg
 *
 */
public class RegistrationService implements RegistrationInterface {

	@Override
	public boolean addCourse(int courseId,int studentId, Vector<Course> availableCourses) {
		
		return false;
	}
	
	@Override
	public boolean dropCourse(int courseId, int studentId, Vector<Course> registeredCourseList) {
		
		return false;
	}
		
	@Override
	public boolean getRegistrationStatus(int studentId) {
		
		return false;
	}
	
	@Override
	public void setRegistrationStatus(int studentId) {

	}
	
	@Override
	public Vector<Course> viewRegisteredCourses(int studentId){
		
		return null;
	}
	
	@Override
	public Vector<GradeCard> viewGradeCard(int studentId) {
		
		return null;
	}
	
	@Override
	public Vector<Course> viewCourses(int studentId){
		
		return null;
	}
	
	@Override
	public boolean getPaymentStatus(int studentId) {
		
		return false;
	}
	
	@Override
	public void setPaymentStatus(int studentId) {
		
	}

	@Override
	public double calculateFee(int studentId) {

		return 0;		
	}
}
