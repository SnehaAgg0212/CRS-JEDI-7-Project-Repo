/**
 * 
 */
package com.crs.flipkart.business;

import java.util.Vector;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.GradeCard;
import com.crs.flipkart.dao.RegistrationDaoInterface;
import com.crs.flipkart.dao.RegistrationDaoOperation;

/**
 * @author devanshugarg
 *
 */
public class RegistrationService implements RegistrationInterface {
	
	RegistrationDaoInterface registrationDaoInterface = new RegistrationDaoOperation();

	@Override
	public boolean addCourse(int courseId,int studentId, Vector<Course> availableCourses) {
		
		if(registrationDaoInterface.totalRegisteredCourses(studentId) >= 6) {
			System.out.println("More than 6 courses are registered!");
			return false;
		}else if(!registrationDaoInterface.isSeatAvailable(courseId)) {
			System.out.println("No Seats available for this CourseId!");
			return false;
		}
		return registrationDaoInterface.addCourse(studentId, courseId);
	}
	
	@Override
	public boolean dropCourse(int courseId, int studentId, Vector<Course> registeredCourseList) {
		
		return registrationDaoInterface.dropCourse(studentId, courseId);
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
		
		return registrationDaoInterface.viewRegisteredCourses(studentId);
	}
	
	@Override
	public Vector<GradeCard> viewGradeCard(int studentId) {
		
		return null;
	}
	
	@Override
	public Vector<Course> viewCourses(int studentId){
		
		return registrationDaoInterface.viewCourses(studentId);
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
