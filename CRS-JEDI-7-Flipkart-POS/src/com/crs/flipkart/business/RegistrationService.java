/**
 * 
 */
package com.crs.flipkart.business;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Vector;

import org.apache.log4j.Logger;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.GradeCard;
import com.crs.flipkart.dao.RegistrationDaoInterface;
import com.crs.flipkart.dao.RegistrationDaoOperation;
import com.flipkart.exceptions.CourseLimitExceededException;
import com.flipkart.exceptions.CourseNotFoundException;
import com.flipkart.exceptions.SeatsNotAvailableException;

/**
 * @author devanshugarg
 *
 */
public class RegistrationService implements RegistrationInterface {
	
	private static volatile RegistrationService instance = null;
	private static Logger logger = Logger.getLogger(RegistrationService.class);
	
	/**
	 * Default Constructor
	 */
	private RegistrationService() {
		
	}
	
	/**
	 * Method to make RegistrationService Singleton
	 */
	public static RegistrationService getInstance() {
		
		if(instance == null) {
			
			synchronized(RegistrationService.class) {
				
				instance = new RegistrationService();
			}
		}
		return instance;
	}
	
	RegistrationDaoInterface registrationDaoOperation = RegistrationDaoOperation.getInstance();

	@Override
	public boolean addCourse(int courseId,int studentId, Vector<Course> availableCourses) throws CourseLimitExceededException, SeatsNotAvailableException, SQLException {
		
		if(registrationDaoOperation.totalRegisteredCourses(studentId) >= 6) {
 			throw new CourseLimitExceededException(6);
 			
 		}else if(!registrationDaoOperation.isSeatAvailable(courseId)) {
 			throw new SeatsNotAvailableException();
 			
 		}
 		return registrationDaoOperation.addCourse(studentId, courseId);
	}
	
	@Override
	public boolean dropCourse(int courseId, int studentId, Vector<Course> registeredCourseList) throws SQLException, CourseNotFoundException {
		if(!registrationDaoOperation.checkCourse(courseId, studentId)) {
			throw new CourseNotFoundException(courseId);
		}
		return registrationDaoOperation.dropCourse(studentId, courseId);
	}
		
	@Override
	public boolean getRegistrationStatus(int studentId) {
		
		return registrationDaoOperation.getRegistrationStatus(studentId);
	}
	
	@Override
	public int totalRegisteredCourses(int studentId) throws SQLException {
		
		return registrationDaoOperation.totalRegisteredCourses(studentId);
	}
	
	@Override
	public void setRegistrationStatus(int studentId) {

	}
	
	@Override
	public Vector<Course> viewRegisteredCourses(int studentId) throws SQLException{
		
		return registrationDaoOperation.viewRegisteredCourses(studentId);
	}
	
	@Override
	public Vector<GradeCard> viewGradeCard(int studentId, int semesterId) {
		
		return registrationDaoOperation.viewGradeCard(studentId, semesterId);
	}
	
	@Override
	public Vector<Course> viewCourses(int studentId) throws SQLException{
		
		return registrationDaoOperation.viewCourses(studentId);
	}
	
	@Override
	public boolean getPaymentStatus(int studentId) {
		
		return registrationDaoOperation.getPaymentStatus(studentId);
	}
	
	@Override
	public void setPaymentStatus(int studentId, int invoiceId, double amount) {
		
		registrationDaoOperation.setPaymentStatus(studentId, invoiceId, amount);
	}

	@Override
	public double calculateFee(int studentId) {

		double fee = registrationDaoOperation.calculateFee(studentId);
 		return fee;	
	}
	
	@Override
	public void paymentByCard(int studentId, int invoiceId, String cardType, String cardNumber,
 			String cardHolderName, int cvv, String bankName, Date expiryDate) {
		
		registrationDaoOperation.paymentByCard(studentId, invoiceId, cardType, cardNumber, cardHolderName, cvv, bankName, expiryDate);
	}
	
	@Override
	public void paymentByCheque(int studentId, int invoiceId, int chequeNo, String bankAccountHolderName,
 			String bankAccountNumber, String ifsc, String bankName, String bankBranchName, Date chequeDate) {

		registrationDaoOperation.paymentByCheque(studentId, invoiceId, chequeNo, bankAccountHolderName, bankAccountNumber, ifsc, bankName, bankBranchName, chequeDate);
 	}
	
	@Override
	public void paymentByNetBanking(int studentId, int invoiceId, String bankAccountHolderName, String bankName) {

		registrationDaoOperation.paymentByNetBanking(studentId, invoiceId, bankAccountHolderName, bankName);
 	}
	
	@Override
	public boolean isGenerated(int studentId) {

 		return registrationDaoOperation.isGenerated(studentId);
 	}
}
