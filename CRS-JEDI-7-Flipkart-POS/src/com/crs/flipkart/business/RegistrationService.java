/**
 * 
 */
package com.crs.flipkart.business;

import java.math.BigInteger;
import java.time.LocalDate;
import java.sql.Date;
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
	
	RegistrationDaoInterface registrationdao=new RegistrationDaoOperation();
	
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
		
		return registrationdao.getRegistrationStatus(studentId);
	}
	
	@Override
	public void setRegistrationStatus(int studentId) {

	}
	
	@Override
	public Vector<Course> viewRegisteredCourses(int studentId){
		
		return null;
	}
	
	@Override
	public Vector<GradeCard> viewGradeCard(int studentId,int semesterId) {
		
		return registrationdao.viewGradeCard(studentId,semesterId);
	}
	
	@Override
	public Vector<Course> viewCourses(int studentId){
		
		return null;
	}
	
	@Override
	public boolean getPaymentStatus(int studentId) {
		
		return registrationdao.getPaymentStatus(studentId);
	}
	
	@Override
	public void setPaymentStatus(int studentId,int invoiceId,double amount) {
		registrationdao.setPaymentStatus(studentId, invoiceId, amount);
	}

	@Override
	public double calculateFee(int studentId) {

		double fee=registrationdao.calculateFee(studentId);
		
		return fee;		
	}
	

	@Override
	public void paymentByCard(int studentId, int invoiceId, String cardType, String cardNumber,
			String cardHolderName, int cvv, String bankName, Date expiryDate) {
		// TODO Auto-generated method stub
		registrationdao.paymentByCard(studentId, invoiceId, cardType, cardNumber, cardHolderName, cvv, bankName, expiryDate);
		
	}

	@Override
	public void paymentByCheque(int studentId, int invoiceId, int chequeNo, String bankAccountHolderName,
			String bankAccountNumber, String ifsc, String bankName, String bankBranchName,Date chequeDate) {
		// TODO Auto-generated method stub
		
		registrationdao.paymentByCheque(studentId, invoiceId, chequeNo, bankAccountHolderName, bankAccountNumber, ifsc, bankName, bankBranchName,chequeDate);
	}

	@Override
	public void paymentByNetBanking(int studentId, int invoiceId, String bankAccountHolderName, String bankName) {
		// TODO Auto-generated method stub
		
		registrationdao.paymentByNetBanking(studentId, invoiceId, bankAccountHolderName, bankName);
	}
	
	public boolean isGenerated(int studentId) {
		
		return registrationdao.isGenerated(studentId);
	}

}
