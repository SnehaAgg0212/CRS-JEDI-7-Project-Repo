/**
 * 
 */
package com.crs.flipkart.application;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Vector;
import java.util.Scanner;

import com.crs.flipkart.bean.CardPayment;
import com.crs.flipkart.bean.Cheque;
import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.GradeCard;
import com.crs.flipkart.bean.NetBanking;
import com.crs.flipkart.business.NotificationInterface;
import com.crs.flipkart.business.NotificationService;
import com.crs.flipkart.business.RegistrationInterface;
import com.crs.flipkart.business.RegistrationService;
import com.crs.flipkart.business.StudentInterface;
import com.crs.flipkart.business.StudentService;
import com.crs.flipkart.constants.NotificationTypeConstant;
import com.crs.flipkart.exceptions.CourseLimitExceededException;
import com.crs.flipkart.exceptions.CourseNotFoundException;
import com.crs.flipkart.exceptions.SeatNotAvailableException;
import com.crs.flipkart.utils.Utils;

/**
 * @author devanshugarg
 *
 */
public class CRSStudentMenu {

	static Scanner sc = new Scanner(System.in);
	static RegistrationInterface registrationInterface = RegistrationService.getInstance();
	static StudentInterface studentInterface = StudentService.getInstance();
	static NotificationInterface notificationInterface = NotificationService.getInstance();
 	static double fee;
 	static int invoiceId;
	
	/**
	 * Method to Create Main Menu
	 */
	public static void createStudentMenu(int studentId) throws CourseLimitExceededException, SeatNotAvailableException, SQLException, CourseNotFoundException
	{
		
		while(CRSApplicationMenu.loggedin) {
			
	        System.out.println("#------------------------Welcome to Course Registration System------------------------#");
	        
	        System.out.println("***********************************************************************************");
	        System.out.println("********************************* Student Menu ************************************");
	        System.out.println("***********************************************************************************");
	        
	        System.out.println("1. Semester Registration");
			System.out.println("2. Add Course");
			System.out.println("3. Drop Course");
			System.out.println("4. View Course");
			System.out.println("5. View Registered Courses");
			System.out.println("6. View Grade Card");
			System.out.println("7. Make Payment");
			System.out.println("8. Exit");
	        
	        System.out.println("***********************************************************************************");
	        
	        System.out.print("Enter User Input: ");
	        
	        int choice = sc.nextInt();
			
			switch(choice) {
			
			case 1: 
				registerCourses(studentId);
				break;
			case 2:
				addCourse(studentId);
				break;
			case 3:
				dropCourse(studentId);
				break;
			case 4:
				viewAvailableCourse(studentId);
				break;
			case 5:
				viewRegisteredCourse(studentId);
				break;
			case 6:
				viewGradeCard(studentId);
				break;
			case 7:
				makePayment(studentId);
				break;
			case 8:
				CRSApplicationMenu.loggedin = false;
				return;
			default:
				System.out.println("Invalid Input !");
			}
		}
	}

	/**
	 * Course Registration
	 * @param studentId
	 * @throws SQLException 
	 * @throws SeatsNotAvailableException 
	 * @throws CourseLimitExceededException 
	 * @throws CourseNotFoundException 
	 */
	private static void registerCourses(int studentId) throws CourseLimitExceededException, SeatNotAvailableException, SQLException, CourseNotFoundException {
		// TODO Auto-generated method stub
	
		int semester = 5;
 		
 		boolean check = studentInterface.semesterRegistration(semester, studentId);
 		if(check) {
 			int totalCourses = registrationInterface.totalRegisteredCourses(studentId);
 			if(totalCourses == 0)
 				totalCourses = 1;
 			while(totalCourses < 7) {
 				
 				Vector<Course> courseList = viewAvailableCourse(studentId);
 				if(courseList == null) {
 					return;
 				}

 				System.out.println("Enter Course Id " + totalCourses + ": ");
 				int courseId = sc.nextInt();
 				try {
 					boolean checkstatus = registrationInterface.addCourse(courseId, studentId, courseList);
 	 				if(checkstatus) {
 	 					System.out.println("Course registration of " + courseId + " done successfully.");
 	 					totalCourses++;
 	 				} else {
 	 					System.out.println("Course registration of " + courseId + " is already done.");
 	 				}
 				}catch(SQLException se) {
 		 			System.out.println("Error : " + se);
 		 			return;
 		 		}catch(CourseLimitExceededException se) {
 		 			System.out.println("Error : " + se);
 		 			return;
 		 		}catch(SeatNotAvailableException se) {
 		 			System.out.println("Error : " + se);
 		 			return;
 		 		}
 				
 			}

 			System.out.println();
 			System.out.println("Registration Successful");
 			System.out.println();
 		}else {
 			System.out.println("You have already registered for this Semester");
 			System.out.println();
 		}
}

	/**
	 * Add Course
	 * @param studentId
	 * @throws SQLException 
	 * @throws SeatsNotAvailableException 
	 * @throws CourseLimitExceededException 
	 * @throws CourseNotFoundException 
	 */
	private static void addCourse(int studentId) throws CourseLimitExceededException, SeatNotAvailableException, SQLException, CourseNotFoundException {
		// TODO Auto-generated method stub
		
		
		boolean checkStatus = false;
		try {
			checkStatus = registrationInterface.isSemesterRegistered(studentId);
		}catch(SQLException se){
			System.out.println("Error : " + se);
		}
		
		if(checkStatus) {
			Vector<Course> availableCourse = viewAvailableCourse(studentId);
			if(availableCourse == null) {
				return;
			}
		
			System.out.println("Enter the CourseID to ADD: ");
			int courseId = sc.nextInt();
			try {
				boolean checkstatus = registrationInterface.addCourse(courseId, studentId, availableCourse);
		 		if(checkstatus) {
		 			System.out.println("Course registration of " + courseId + " done successfully.");
		 		} else {
		 			System.out.println("Course registration of " + courseId + " is already done.");
		 		}
			}catch(SQLException se) {
		 			System.out.println("Error : " + se);
		 			return;
		 		}catch(CourseLimitExceededException se) {
		 			System.out.println("Error : " + se);
		 			return;
		 		}catch(SeatNotAvailableException se) {
		 			System.out.println("Error : " + se);
		 			return;
		 		}
		}else {
			System.out.println("Semester Registration is still Pending!!");
			System.out.println();
		}
	}

	/**
	 * Drop Course
	 * @param studentId
	 * @throws CourseNotFoundException 
	 * @throws SQLException 
	 */
	private static void dropCourse(int studentId) throws SQLException, CourseNotFoundException {
		// TODO Auto-generated method stub
		
		boolean checkStatus = false;
		try {
			checkStatus = registrationInterface.isSemesterRegistered(studentId);
		}catch(SQLException se){
			System.out.println("Error : " + se);
		}
		
		if(checkStatus) {
			Vector<Course> availableCourse = viewRegisteredCourse(studentId);
	 		if(availableCourse == null) {
	 			return;
	 		}

	 		System.out.println("Enter the CourseID to DROP: ");
	 		int courseId = sc.nextInt();
	 		
	 		try {
	 			registrationInterface.dropCourse(courseId, studentId, availableCourse);
	 			System.out.println("Course Deletion of " + courseId + " done successfully.");
	 		}catch(CourseNotFoundException error) {
	 			System.out.println("Error : " + error);
	 		}catch(SQLException se) {
	 			System.out.println("Error : " + se);
	 		}
		}else {
			System.out.println("Semester Registration is still Pending!!");
			System.out.println();
		}

		
		
	}

	/**
	 * View Course
	 * @param studentId
	 * @throws SQLException 
	 */
	private static Vector<Course> viewAvailableCourse(int studentId) throws SQLException {
		// TODO Auto-generated method stub
		
		boolean checkStatus = false;
		try {
			checkStatus = registrationInterface.isSemesterRegistered(studentId);
		}catch(SQLException se){
			System.out.println("Error : " + se);
		}
		Vector<Course> availableCourses = null;
		if(checkStatus) {
			
			
			try {
				availableCourses = registrationInterface.viewCourses(studentId);
			}catch(SQLException se) {
				System.out.println("Error : " + se);
			}
			 
			if(availableCourses.isEmpty()) {
	 			System.out.println("No Courses are available right now!");
	 			return null;
	 		}

	 		System.out.println(String.format("%-20s %-20s %-45s %-20s %-20s", "COURSE ID", "COURSE NAME", "COURSE DESCRIPTION", "COURSE FEES", "SEATS"));
	 		System.out.println();
	 		
	 		availableCourses.forEach((course) -> {
	 			System.out.println(String.format("%-20s %-20s %-45s %-20s %-20s", course.getCourseId(), course.getCourseName(), course.getCourseDescription(), course.getCourseFee(), course.getCourseSeats()));
	 		});
	 		
	 		System.out.println();
		
			return availableCourses;
		}else {
			System.out.println("Semester Registration is still Pending!!");
			System.out.println();
		}
		
		return availableCourses;
	}

	/**
	 * View Registered Courses
	 * @param studentId
	 */
	private static Vector<Course> viewRegisteredCourse(int studentId) {
		// TODO Auto-generated method stub
		
		boolean checkStatus = false;
		try {
			checkStatus = registrationInterface.isSemesterRegistered(studentId);
		}catch(SQLException se){
			System.out.println("Error : " + se);
		}
		
		Vector<Course> registeredCourses = null;
				
		if(checkStatus) {
			try {
				registeredCourses = registrationInterface.viewRegisteredCourses(studentId);
			}catch(SQLException se){
				System.out.println("Error: " + se);
			}
			
			if(registeredCourses.isEmpty()) {
	 			System.out.println("No Courses are Registered!");
	 			return null;
	 		}

	 		System.out.println(String.format("%-20s %-20s %-45s %-20s", "COURSE ID", "COURSE NAME", "COURSE DESCRIPTION", "COURSE FEES"));
	 		System.out.println();
	 		
	 		registeredCourses.forEach((course) -> {
	 			System.out.println(String.format("%-20s %-20s %-45s %-20s", course.getCourseId(), course.getCourseName(), course.getCourseDescription(), course.getCourseFee()));
	 		});
	 		
	 		
	 		System.out.println();	
			
	 		return registeredCourses;
		}else {
			System.out.println("Semester Registration is still Pending!!");
			System.out.println();
		}
		
		return registeredCourses;
	}

	/**
	 * View Grade Card
	 * @param studentId
	 * @param semesterId
	 */
	private static void viewGradeCard(int studentId) {
		
		try {
			boolean isGenerated = registrationInterface.isGenerated(studentId);
	
			if(!isGenerated) {
	
				System.out.println("GradeCard is not generated yet.");
			}
			else {
	
				try {
					Vector<GradeCard> grades = registrationInterface.viewGradeCard(studentId);
		
					if(grades.isEmpty()) {
						System.out.println("You haven't registered for any course.");
						return;
					}
					
					double overallgpa = 0.0;
		
					for(GradeCard course_grade : grades) {
		
						System.out.println("Course Code: " + course_grade.getCourseId() + " GPA: " + course_grade.getGpa());
		
						overallgpa += course_grade.getGpa();
					}
		
					overallgpa /= (double)grades.size();
		
					System.out.println("Overall GPA: " + overallgpa);
				} catch (SQLException e) {
					System.out.println("Error: " + e.getMessage());
				}
			}
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	/**
	 * Make Payment
	 * @param studentId
	 */
	private static void makePayment(int studentId) {
		// TODO Auto-generated method stub
		try {
			fee = registrationInterface.calculateFee(studentId);
	
	 		int totalRegistered = registrationInterface.totalRegisteredCourses(studentId);
	 		if(totalRegistered != 6) {
	 			System.out.println("You have not registered for 6 courses!!");
	 			return;
	 		}
	 		boolean ispaid = false;
	 		int notificationId = 0;
	
	 		boolean checkStatus = false;
			try {
				checkStatus = registrationInterface.isSemesterRegistered(studentId);
			}catch(SQLException se){
				System.out.println("Error : " + se);
			}
			
	 		ispaid = registrationInterface.getPaymentStatus(studentId);
	
	 		if(!checkStatus) {
	 			System.out.println("You have not registered yet.");
	 		}
	 		else if(ispaid) {
	 			System.out.println("You have already paid the fees.");
	 		}
	 		else if(checkStatus && !ispaid) {
	 			System.out.println("Total Fees = " + fee);
	 			System.out.println("Want to continue Fee Payment(y/n): ");
	 			String ch = sc.next();
	
	 			if(ch.equals("y"))
	 			{
	 				System.out.println("Modes of Payment: ");
	 				System.out.println("1. Card");
	 				System.out.println("2. Cheque");
	 				System.out.println("3. NetBanking");
	
	 				System.out.println("Select Mode of Payment: ");
	 				int selected_mode = sc.nextInt();
	
	 				invoiceId = Utils.generateId();
	
	 				switch(selected_mode) {
	
	 				case 1:
	 					paymentByCard(studentId);
	 					notificationId = notificationInterface.sendPaymentNotification(NotificationTypeConstant.PAYMENT, studentId, selected_mode, fee, invoiceId);
	 					System.out.println("Notification Id: " + notificationId);
	 					System.out.println("Keep it safe for future references.");
	 					break;
	 				case 2:
	 					paymentByCheque(studentId);					
	 					notificationId = notificationInterface.sendPaymentNotification(NotificationTypeConstant.PAYMENT, studentId, selected_mode, fee, invoiceId);
	 					System.out.println("Notification Id: " + notificationId);
	 					System.out.println("Keep it safe for future references.");
	 					break;
	 				case 3:
	 					paymentByNetBanking(studentId);
	 					notificationId = notificationInterface.sendPaymentNotification(NotificationTypeConstant.PAYMENT, studentId, selected_mode, fee, invoiceId);
	 					System.out.println("Notification Id: " + notificationId);
	 					System.out.println("Keep it safe for future references.");
	 					break;
	 				default:
	 					System.out.println("Invalid Input!");
	 					break;
	 				}
	 			}
	 		}
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	private static void paymentByCard(int studentId) {
		// TODO Auto-generated method stub
		try {
			CardPayment card = new CardPayment();
			
	 		System.out.println("Enter Card Type: ");
	 		String cardType = sc.next();
	 		card.setCardType(cardType);
	 		
	 		System.out.println("Enter Card Number: ");
	 		String cardNumber = sc.next();
	 		card.setCardNumber(cardNumber);
	 		
	 		sc.nextLine();
	 		
	 		System.out.println("Enter Card Holder Name: ");
	 		String cardHolderName = sc.nextLine();
	 		card.setCardHolderName(cardHolderName);
	
	 		System.out.println("Enter CVV: ");
	 		int cvv = sc.nextInt();
	 		card.setCvv(cvv);
	 		
	 		sc.nextLine();
	 		
	 		System.out.println("Enter Bank Name: ");
	 		String bankName = sc.nextLine();
	 		card.setBankName(bankName);
	 
	 		System.out.println("Enter Expiry Date (yyyy-mm-dd): ");
	 		String date = sc.next();
	
	 		Date expiryDate = Date.valueOf(date);
	 		card.setExpiryDate(expiryDate);
	 		
	 		card.setInvoiceId(invoiceId);
	 		card.setStudentId(studentId);
	 		
	 		registrationInterface.paymentByCard(card);
	 		registrationInterface.setPaymentStatus(studentId, invoiceId, fee);
	 		
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	private static void paymentByCheque(int studentId) {
		// TODO Auto-generated method stub
		
		try {
			
			Cheque cheque = new Cheque();
			
	 		System.out.println("Enter Cheque Number: ");
	 		int chequeNo = sc.nextInt();
	 		cheque.setChequeNo(chequeNo);
	 		
	 		sc.nextLine();
	 		
	 		System.out.println("Enter Bank Account Holder Name: ");
	 		String bankAccountHolderName = sc.nextLine();
	 		cheque.setBankAccountHolderName(bankAccountHolderName);
	 		
	 		System.out.println("Enter Bank Account Number: ");
	 		String bankAccountNumber = sc.next();
	 		cheque.setBankAccountNumber(bankAccountNumber);
	
	 		System.out.println("Enter IFSC: ");
	 		String ifsc = sc.next();
	 		cheque.setIfsc(ifsc);
	 		
	 		sc.nextLine();
	
	 		System.out.println("Enter Bank Name: ");
	 		String bankName = sc.nextLine();
	 		cheque.setBankName(bankName);
	 		
	 		System.out.println("Enter Bank Branch Name: ");
	 		String bankBranchName = sc.nextLine();
	 		cheque.setBankBranchName(bankBranchName);
	
	 		System.out.println("Enter Cheque Date (yyyy-mm-dd): ");
	 		String date = sc.next();
	
	 		Date chequeDate = Date.valueOf(date);
	 		cheque.setChequeDate(chequeDate);
	 		
	 		cheque.setInvoiceId(invoiceId);
	 		cheque.setStudentId(studentId);
	 		
	 		registrationInterface.paymentByCheque(cheque);
	 		registrationInterface.setPaymentStatus(studentId, invoiceId, fee);
	 		
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	private static void paymentByNetBanking(int studentId) {
		// TODO Auto-generated method stub
		
		try {
			NetBanking netBanking = new NetBanking();
			
			sc.nextLine();
			
	 		System.out.println("Enter Bank Account Holder Name: ");
	 		String bankAccountHolderName = sc.nextLine();
	 		netBanking.setBankAccountHolderName(bankAccountHolderName);
	 		
	 		System.out.println("Enter Bank Name: ");
	 		String bankName = sc.nextLine();
	 		netBanking.setBankName(bankName);
	 		
	 		netBanking.setInvoiceId(invoiceId);
	 		netBanking.setStudentId(studentId);
	 		
	 		registrationInterface.paymentByNetBanking(netBanking);
	 		registrationInterface.setPaymentStatus(studentId, invoiceId, fee);
	 		
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}
