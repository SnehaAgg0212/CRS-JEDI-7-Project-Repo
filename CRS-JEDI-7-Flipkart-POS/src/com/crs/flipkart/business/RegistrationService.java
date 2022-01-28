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
	public boolean addCourse(int courseId,int studentId, Vector<Course> availableCourses) {
		
		if(registrationDaoOperation.totalRegisteredCourses(studentId) >= 6) {
 			logger.info("More than 6 courses are registered!");
 			return false;
 		}else if(!registrationDaoOperation.isSeatAvailable(courseId)) {
 			logger.info("No Seats available for this CourseId!");
 			return false;
 		}
 		return registrationDaoOperation.addCourse(studentId, courseId);
	}
	
	@Override
	public boolean dropCourse(int courseId, int studentId, Vector<Course> registeredCourseList) {
		
		return registrationDaoOperation.dropCourse(studentId, courseId);
	}
		
	@Override
	public boolean getRegistrationStatus(int studentId) throws SQLException {
		
		return registrationDaoOperation.getRegistrationStatus(studentId);
	}
	
	@Override
	public void setRegistrationStatus(int studentId) {

	}
	
	@Override
	public Vector<Course> viewRegisteredCourses(int studentId){
		
		return registrationDaoOperation.viewRegisteredCourses(studentId);
	}
	
	@Override
	public Vector<GradeCard> viewGradeCard(int studentId, int semesterId) throws SQLException{
		
		return registrationDaoOperation.viewGradeCard(studentId, semesterId);
	}
	
	@Override
	public Vector<Course> viewCourses(int studentId){
		
		return registrationDaoOperation.viewCourses(studentId);
	}
	
	@Override
	public boolean getPaymentStatus(int studentId) throws SQLException {
		
		return registrationDaoOperation.getPaymentStatus(studentId);
	}
	
	@Override
	public void setPaymentStatus(int studentId, int invoiceId, double amount) throws SQLException{
		
		registrationDaoOperation.setPaymentStatus(studentId, invoiceId, amount);
	}

	@Override
	public double calculateFee(int studentId) throws SQLException {

		double fee = registrationDaoOperation.calculateFee(studentId);
 		return fee;	
	}
	
	@Override
	public void paymentByCard(int studentId, int invoiceId, String cardType, String cardNumber,
 			String cardHolderName, int cvv, String bankName, Date expiryDate) throws SQLException{
		
		registrationDaoOperation.paymentByCard(studentId, invoiceId, cardType, cardNumber, cardHolderName, cvv, bankName, expiryDate);
	}
	
	@Override
	public void paymentByCheque(int studentId, int invoiceId, int chequeNo, String bankAccountHolderName,
 			String bankAccountNumber, String ifsc, String bankName, String bankBranchName, Date chequeDate) throws SQLException{

		registrationDaoOperation.paymentByCheque(studentId, invoiceId, chequeNo, bankAccountHolderName, bankAccountNumber, ifsc, bankName, bankBranchName, chequeDate);
 	}
	
	@Override
	public void paymentByNetBanking(int studentId, int invoiceId, String bankAccountHolderName, String bankName) throws SQLException{

		registrationDaoOperation.paymentByNetBanking(studentId, invoiceId, bankAccountHolderName, bankName);
 	}
	
	@Override
	public boolean isGenerated(int studentId) throws SQLException{

 		return registrationDaoOperation.isGenerated(studentId);
 	}
}
