/**
 * 
 */
package com.crs.flipkart.dao;

import java.util.Vector;

import org.apache.log4j.Logger;

import java.sql.Date;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.GradeCard;
import com.crs.flipkart.constants.SQLQueriesConstant;
import com.crs.flipkart.utils.DBUtils;
import com.crs.flipkart.utils.Utils;

/**
 * @author devanshugarg
 *
 */
public class RegistrationDaoOperation implements RegistrationDaoInterface {

	private static volatile RegistrationDaoOperation instance = null;
	private static Logger logger = Logger.getLogger(RegistrationDaoOperation.class);
	Connection connection = DBUtils.getConnection();
	private PreparedStatement statement = null;
	
	/**
	 * Default Constructor
	 */
	private RegistrationDaoOperation() {
		
	}
	
	/**
	 * Method to make RegistrationDaoOperation Singleton
	 * @return
	 */
	public static RegistrationDaoOperation getInstance() {
		
		if(instance == null) {
			
			synchronized(RegistrationDaoOperation.class){
				
				instance = new RegistrationDaoOperation();
			}
		}
		return instance;
	}
	
	/**
	 * 
	 * @param studentId
	 * @return
	 */
	@Override
	public double calculateFee(int studentId)throws SQLException {

		statement = null;
		double fee = 0.0;

		try {
			String sql = SQLQueriesConstant.GET_REGISTERED_COURSE_FEE;
			statement = connection.prepareStatement(sql);
			statement.setInt(1, studentId);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				fee += resultSet.getDouble("courseFee");
			}
		} catch(SQLException e) {
			logger.error(e.getMessage());
		}
		return fee;
	}

	/**
	 * 
	 * @param studentId
	 * @return
	 */
	@Override
	public boolean getRegistrationStatus(int studentId) throws SQLException {
		
		statement = null;

		try {
			String sql = SQLQueriesConstant.IS_APPROVED;
			statement = connection.prepareStatement(sql);
			statement.setInt(1, studentId);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next() && resultSet.getInt("isApproved") == 1) {
				return true;
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());	
		}
		return false;
	}

	/**
	 * 
	 * @param studentId
	 * @return
	 */
	@Override
	public boolean getPaymentStatus(int studentId) throws SQLException {
		
		statement = null;

		try {
			String sql = SQLQueriesConstant.PAYMENT_STATUS;
			statement = connection.prepareStatement(sql);
			statement.setInt(1, studentId);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next() && resultSet.getInt("status") == 1) {
				return true;
			}
		} catch(SQLException e) {
			logger.error(e.getMessage());	
		}
		return false;
	}

	/**
	 * 
	 * @param studentId
	 * @param invoiceId
	 * @param cardType
	 * @param cardNumber
	 * @param cardHolderName
	 * @param cvv
	 * @param bankName
	 * @param expiryDate
	 */
	@Override
	public void paymentByCard(int studentId, int invoiceId, String cardType, String cardNumber, String cardHolderName, int cvv, String bankName, Date expiryDate) throws SQLException 
	{

		statement = null;

		try {
			String sql = SQLQueriesConstant.PAYMENT_CARD;
			statement = connection.prepareStatement(sql);
			statement.setInt(1, invoiceId);
			statement.setString(2, cardType);
			statement.setString(3, cardNumber);
			statement.setString(4, cardHolderName);
			statement.setInt(5, cvv);
			statement.setString(6, bankName);
			statement.setDate(7,expiryDate);
			statement.executeUpdate();
		} catch(SQLException e) {
			logger.error(e.getMessage());	
		}
	}

	/**
	 * 
	 * @param studentId
	 * @param invoiceId
	 * @param chequeNo
	 * @param bankAccountHolderName
	 * @param bankAccountNumber
	 * @param ifsc
	 * @param bankName
	 * @param bankBranchName
	 * @param chequeDate
	 */
	@Override
	public void paymentByCheque(int studentId, int invoiceId, int chequeNo, String bankAccountHolderName, String bankAccountNumber, String ifsc, String bankName, String bankBranchName, Date chequeDate) throws SQLException {

		statement = null;

		try {
			String sql = SQLQueriesConstant.PAYMENT_CHEQUE;
			statement = connection.prepareStatement(sql);
			statement.setInt(1, invoiceId);
			statement.setInt(2, chequeNo);
			statement.setString(3, bankAccountHolderName);
			statement.setString(4, bankAccountNumber);
			statement.setString(5, ifsc);
			statement.setString(6, bankName);
			statement.setString(7,bankBranchName);
			statement.setDate(8,chequeDate);
			statement.executeUpdate();
		} catch(SQLException e) {
			logger.error(e.getMessage());	
		}
	}
 
	/**
	 * 
	 * @param studentId
	 * @param invoiceId
	 * @param bankAccountHolderName
	 * @param bankName
	 */
	@Override
	public void paymentByNetBanking(int studentId, int invoiceId, String bankAccountHolderName, String bankName) throws SQLException {
		
		statement = null;
		
		try {
			String sql = SQLQueriesConstant.PAYMENT_NETBANKING;
			statement = connection.prepareStatement(sql);
			statement.setString(1, bankName);
			statement.setString(2, bankAccountHolderName);
			statement.setInt(3, invoiceId);
			statement.executeUpdate();
		} catch(SQLException e) {
			logger.error(e.getMessage());	
		}
	}

	/**
	 * 
	 * @param studentId
	 * @param invoiceId
	 * @param amount
	 */
	@Override
	public void setPaymentStatus(int studentId, int invoiceId, double amount) throws SQLException {
		
		statement = null;
		
		try {
			String sql = SQLQueriesConstant.ADD_PAYMENT;
			statement = connection.prepareStatement(sql);
			statement.setInt(1, invoiceId);
			statement.setInt(2, studentId);
			statement.setDouble(3, amount);
			statement.setBoolean(4, true);
			statement.executeUpdate();
		} catch(SQLException e) {
			logger.error(e.getMessage());	
		}
	}

	/**
	 * 
	 * @param studentId
	 * @return
	 */
	@Override
	public boolean isGenerated(int studentId) throws SQLException {

		statement = null;

		try {
			String sql = SQLQueriesConstant.IS_GENERATED;
			statement = connection.prepareStatement(sql);
			statement.setInt(1, studentId);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next() && resultSet.getInt("isGenerated") == 1) {
				return true;
			}
		} catch(SQLException e) {
			logger.error(e.getMessage());				
		}
		return false;
	}

	/**
	 * 
	 * @param studentId
	 * @param semesterId
	 * @return
	 */
	@Override
	public Vector<GradeCard> viewGradeCard(int studentId,int semesterId) throws SQLException {

		Vector<GradeCard> grades = new Vector<>();

		statement = null;

		try {
			String sql = SQLQueriesConstant.VIEW_COURSES_GRADE;
			statement = connection.prepareStatement(sql);
			statement.setInt(1, studentId);
			statement.setInt(2, semesterId);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				GradeCard gradeCard = new GradeCard();
				gradeCard.setCourseId(resultSet.getInt("courseId"));
				gradeCard.setSemesterId(semesterId);
				gradeCard.setGpa(resultSet.getDouble("gpa"));
				gradeCard.setStudentId(studentId);
				grades.add(gradeCard);				
			}
		} catch(SQLException e) {
			logger.error(e.getMessage());				
		}
		return grades;
	}
	
	/**
	 * 
	 * @param studentId
	 * @param courseId
	 * @return
	 */
	@Override
	public boolean addCourse(int studentId, int courseId) {

		statement = null;
		
 		try {
 			String sql = SQLQueriesConstant.ADD_COURSE;
 			statement = connection.prepareStatement(sql);
 			statement.setInt(1, studentId);
 			statement.setInt(2, courseId);
 			statement.executeUpdate();

 			sql = SQLQueriesConstant.DECREMENT_SEAT;
 			statement = connection.prepareStatement(sql);
 			statement.setInt(1, courseId);
 			statement.executeUpdate();
 			return true;
 		} catch(SQLException e) {
 			logger.error("Error: " + e.getMessage());
 		}
 		return false;
 	}
	
	/**
	 * 
	 * @param semester
	 * @param studentId
	 * @return
	 */
	@Override
	public boolean semesterRegistration(int semester, int studentId) {

		statement = null;
		
 		try {
 			String sql = SQLQueriesConstant.CHECK_STUDENT_AND_SEM;
 			statement = connection.prepareStatement(sql);
 			statement.setInt(1, studentId);
 			statement.setInt(2, semester);
 			ResultSet resultSet = statement.executeQuery();
 			while(resultSet.next()) {
 				return true;
 			}
 		} catch(SQLException e) {
 			logger.error("Error: " + e.getMessage());
 		}
 		return false;
 	}
	
	/**
	 * 
	 * @param semester
	 * @param studentId
	 * @return
	 */
	@Override
	public boolean addSemester(int semester, int studentId) {

		statement = null;
		
 		try {
 			String sql = SQLQueriesConstant.ADD_SEMESTER;
 			statement = connection.prepareStatement(sql);
 			statement.setInt(1, Utils.generateId());
 			statement.setInt(2, studentId);
 			statement.setInt(3, semester);
 			statement.executeUpdate();
 			return true;
 		} catch(SQLException e) {
 			logger.error("Error: " + e.getMessage());
 		}
 		return false;
 	}
	
	/**
	 * 
	 * @param studentId
	 * @param courseId
	 * @return
	 */
	@Override
	public boolean dropCourse(int studentId, int courseId) {

		statement = null;
		
 		try {
 			String sql = SQLQueriesConstant.DROP_COURSE;
 			statement = connection.prepareStatement(sql);
 			statement.setInt(1, studentId);
 			statement.setInt(2, courseId);
 			statement.executeUpdate();

 			sql = SQLQueriesConstant.INCREMENT_SEAT;
 			statement = connection.prepareStatement(sql);
 			statement.setInt(1, courseId);
 			statement.executeUpdate();
 			return true;
 		} catch(SQLException e) {
 			logger.error("Error: " + e.getMessage());
 		}
 		return false;
 	}
	
	/**
	 * 
	 * @param courseId
	 * @return
	 */
	@Override
	public boolean isSeatAvailable(int courseId) {
		
		statement = null;
		
 		try {
 			String sql = SQLQueriesConstant.AVAILABLE_SEATS;
 			statement = connection.prepareStatement(sql);
 			statement.setInt(1, courseId);
 			ResultSet resultSet = statement.executeQuery();
 			while(resultSet.next()) {
 				return resultSet.getInt("courseSeats") > 0;
 			}
 		} catch(SQLException e) {
 			logger.error("Error: " + e.getMessage());
 		}
 		return true;
 	}
	
	/**
	 * 
	 * @param studentId
	 * @return
	 */
	@Override
	public int totalRegisteredCourses(int studentId) {
		
 		int totalcourse = 0;
 		statement = null;
 		
 		try {
 			String sql = SQLQueriesConstant.TOTAL_REGISTERED_COURSES;
 			statement = connection.prepareStatement(sql);
 			statement.setInt(1, studentId);
 			ResultSet resultSet = statement.executeQuery();
 			while(resultSet.next()) {
 				totalcourse++;
 			}
 			return totalcourse;
 		} catch(SQLException e) {
 			logger.error("Error: " + e.getMessage());
 		}
 		return totalcourse;
 	}
	
	/**
	 * 
	 * @param studentId
	 * @return
	 */
	@Override
	public Vector<Course> viewCourses(int studentId) {

 		Vector<Course> availableCourses = new Vector<>();
 		statement = null;
 		
 		try {
 			String sql = SQLQueriesConstant.VIEW_AVAILABLE_COURSES;
 			statement = connection.prepareStatement(sql);
 			statement.setInt(1, studentId);
 			ResultSet resultSet = statement.executeQuery();
 			while(resultSet.next()) {
 				Course course = new Course();
 				course.setCourseId(resultSet.getInt(1));
  				course.setCourseName(resultSet.getString(2));
  				course.setCourseDescription(resultSet.getString(3));
  				course.setCourseFee(resultSet.getDouble(4));
  				course.setCourseSeats(resultSet.getInt(5));
  				availableCourses.add(course);
 			}
 		} catch(SQLException e) {
 			logger.error("Error: " + e.getMessage());
 		}
 		return availableCourses;
 	}
	
	/**
	 * 
	 * @param studentId
	 * @return
	 */
	@Override
	public Vector<Course> viewRegisteredCourses(int studentId) {

 		Vector<Course> availableCourses = new Vector<>();
 		statement = null;
 		
 		try {
 			String sql = SQLQueriesConstant.VIEW_REGISTERED_COURSES;
 			statement = connection.prepareStatement(sql);
 			statement.setInt(1, studentId);
 			ResultSet resultSet = statement.executeQuery();
 			while(resultSet.next()) {
 				Course course = new Course();
 				course.setCourseId(resultSet.getInt(1));
  				course.setCourseName(resultSet.getString(2));
  				course.setCourseDescription(resultSet.getString(3));
  				course.setCourseFee(resultSet.getDouble(4));
  				course.setCourseSeats(resultSet.getInt(5));
  				availableCourses.add(course);
 			}
 		} catch(SQLException e) {
 			logger.error("Error: " + e.getMessage());
 		}
 		return availableCourses;
 	}
}
