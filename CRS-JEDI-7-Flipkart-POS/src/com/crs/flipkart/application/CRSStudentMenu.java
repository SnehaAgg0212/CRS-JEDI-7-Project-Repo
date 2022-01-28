/**
 * 
 */
package com.crs.flipkart.application;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Vector;
import java.util.Scanner;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.GradeCard;
import com.crs.flipkart.business.NotificationInterface;
import com.crs.flipkart.business.NotificationService;
import com.crs.flipkart.business.RegistrationInterface;
import com.crs.flipkart.business.RegistrationService;
import com.crs.flipkart.business.StudentInterface;
import com.crs.flipkart.business.StudentService;
import com.crs.flipkart.constants.NotificationTypeConstant;
<<<<<<< HEAD
import com.flipkart.exceptions.CourseLimitExceededException;
import com.flipkart.exceptions.CourseNotFoundException;
import com.flipkart.exceptions.SeatsNotAvailableException;
=======
import com.crs.flipkart.utils.Utils;
>>>>>>> origin/Aniket-Payment-ViewGradeCard-with-Exceptions

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
 	static boolean is_registered = false;
	
	/**
	 * Method to Create Main Menu
	 * @throws SQLException 
	 * @throws SeatsNotAvailableException 
	 * @throws CourseLimitExceededException 
	 * @throws CourseNotFoundException 
	 */
	public static void createStudentMenu(int studentId) throws CourseLimitExceededException, SeatsNotAvailableException, SQLException, CourseNotFoundException
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
				System.out.println("Enter Semester Id: ");
				int semesterId = sc.nextInt();
				viewGradeCard(studentId, semesterId);
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
	 */
	private static void registerCourses(int studentId) throws CourseLimitExceededException, SeatsNotAvailableException, SQLException {
		// TODO Auto-generated method stub
	
		int semester = 5;
 		
 		boolean check = studentInterface.semesterRegistration(semester, studentId);
 		if(check) {
 			int totalCourses = registrationInterface.totalRegisteredCourses(studentId);
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
 		 		}catch(SeatsNotAvailableException se) {
 		 			System.out.println("Error : " + se);
 		 			return;
 		 		}
 				
 			}

 			System.out.println();
 			System.out.println("Registration Successful");
 		}else {
 			System.out.println("You have already registered for this Semester");
 		}
}

	/**
	 * Add Course
	 * @param studentId
	 * @throws SQLException 
	 * @throws SeatsNotAvailableException 
	 * @throws CourseLimitExceededException 
	 */
	private static void addCourse(int studentId) throws CourseLimitExceededException, SeatsNotAvailableException, SQLException {
		// TODO Auto-generated method stub
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
	 		}catch(SeatsNotAvailableException se) {
	 			System.out.println("Error : " + se);
	 			return;
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
		
	}

	/**
	 * View Course
	 * @param studentId
	 * @throws SQLException 
	 */
	private static Vector<Course> viewAvailableCourse(int studentId) throws SQLException {
		// TODO Auto-generated method stub
		Vector<Course> availableCourses = null;
		
		try {
			availableCourses = registrationInterface.viewCourses(studentId);
		}catch(SQLException se) {
			System.out.println("Error : " + se);
		}
		 
		if(availableCourses.isEmpty()) {
 			System.out.println("No Courses are available right now!");
 			return null;
 		}

 		System.out.println(String.format("%-20s %-20s %-20s %-20s %-20s", "COURSE ID", "COURSE NAME", "COURSE DESCRIPTION", "COURSE FEES", "SEATS"));
 		System.out.println();
 		
 		availableCourses.forEach((course) -> {
 			System.out.println(String.format("%-20s %-20s %-20s %-20s %-20s", course.getCourseId(), course.getCourseName(), course.getCourseDescription(), course.getCourseFee(), course.getCourseSeats()));
 		});
 		
 		System.out.println();
	
		return availableCourses;
	}

	/**
	 * View Registered Courses
	 * @param studentId
	 */
	private static Vector<Course> viewRegisteredCourse(int studentId) {
		// TODO Auto-generated method stub
		
		Vector<Course> registeredCourses = null;
		try {
			registeredCourses = registrationInterface.viewRegisteredCourses(studentId);
		}catch(SQLException se){
			System.out.println("Error: " + se);
		}
		
		if(registeredCourses.isEmpty()) {
 			System.out.println("No Courses are Registered!");
 			return null;
 		}

 		System.out.println(String.format("%-20s %-20s %-20s %-20s %-20s", "COURSE ID", "COURSE NAME", "COURSE DESCRIPTION", "COURSE FEES", "SEATS"));
 		System.out.println();
 		
 		registeredCourses.forEach((course) -> {
 			System.out.println(String.format("%-20s %-20s %-20s %-20s %-20s", course.getCourseId(), course.getCourseName(), course.getCourseDescription(), course.getCourseFee(), course.getCourseSeats()));
 		});
 		
 		
 		System.out.println();	
		
 		return registeredCourses;
	}

	/**
	 * View Grade Card
	 * @param studentId
	 * @param semesterId
	 */
	private static void viewGradeCard(int studentId, int semesterId) {
		// TODO Auto-generated method stub
		 
		boolean isGenerated=false;
		
		try {
			isGenerated = registrationInterface.isGenerated(studentId);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if(!isGenerated) {

			System.out.println("GradeCard is not generated yet.");
		}
		else {

			Vector<GradeCard> grades=new Vector<GradeCard>();
			try {
				grades = registrationInterface.viewGradeCard(studentId, semesterId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if(grades.isEmpty()) {
				System.out.println("\"You haven't registered for any course.");
				return;
			}
			
			double overallgpa = 0.0;

			for(GradeCard course_grade : grades) {

				System.out.println("Course Code: " + course_grade.getCourseId() + " GPA: " + course_grade.getGpa());

				overallgpa += course_grade.getGpa();
			}

			overallgpa /= (double)grades.size();

			System.out.println("Overall GPA: " + overallgpa);
		}
	}

	/**
	 * Make Payment
	 * @param studentId
	 */
	private static void makePayment(int studentId) {
		// TODO Auto-generated method stub
		

 		boolean isapprove = true;
 		boolean ispaid = false;

 		try {
			isapprove = registrationInterface.getRegistrationStatus(studentId);
			ispaid = registrationInterface.getPaymentStatus(studentId);
			fee = registrationInterface.calculateFee(studentId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

 		if(!isapprove) {
 			System.out.println("You have not registered yet.");
 		}
 		else if(ispaid) {
 			System.out.println("You have already paid the fees.");
 		}
 		else if(isapprove && !ispaid) {
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

 				// TODO: invoiceId Generation
 				invoiceId=Utils.generateId();

 				switch(selected_mode) {

 				case 1:
 					paymentByCard(studentId);
 					notificationInterface.sendPaymentNotification(NotificationTypeConstant.PAYMENT, studentId, selected_mode, fee);
 					break;
 				case 2:
 					paymentByCheque(studentId);					
 					notificationInterface.sendPaymentNotification(NotificationTypeConstant.PAYMENT, studentId, selected_mode, fee);
 					break;
 				case 3:
 					paymentByNetBanking(studentId);
 					notificationInterface.sendPaymentNotification(NotificationTypeConstant.PAYMENT, studentId, selected_mode, fee);
 					break;
 				default:
 					System.out.println("Invalid Input!");
 					break;
 				}
 			}
 		}
	}

	private static void paymentByCard(int studentId) {
		// TODO Auto-generated method stub
		
		try {
			registrationInterface.setPaymentStatus(studentId, invoiceId, fee);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

 		System.out.println("Enter Card Type: ");
 		String cardType = sc.next();

 		System.out.println("Enter Card Number: ");
 		String cardNumber = sc.next();

 		System.out.println("Enter Card Holder Name: ");
 		String cardHolderName = sc.next();

 		System.out.println("Enter CVV: ");
 		int cvv = sc.nextInt();

 		System.out.println("Enter Bank Name: ");
 		String bankName = sc.next();
 
 		System.out.println("Enter Expiry Date (yyyy-mm-dd): ");
 		String date = sc.next();

 		Date expiryDate = Date.valueOf(date);

 		try {
			registrationInterface.paymentByCard(studentId, invoiceId, cardType, cardNumber, cardHolderName, cvv, bankName, expiryDate);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	private static void paymentByCheque(int studentId) {
		// TODO Auto-generated method stub
		
		try {
			registrationInterface.setPaymentStatus(studentId, invoiceId, fee);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

 		System.out.println("Enter Cheque Number: ");
 		int chequeNo = sc.nextInt();

 		System.out.println("Enter Bank Account Holder Name: ");
 		String bankAccountHolderName = sc.next();

 		System.out.println("Enter Bank Account Number: ");
 		String bankAccountNumber = sc.next();

 		System.out.println("Enter IFSC: ");
 		String ifsc = sc.next();

 		System.out.println("Enter Bank Name: ");
 		String bankName = sc.next();

 		System.out.println("Enter Bank Branch Name: ");
 		String bankBranchName = sc.next();

 		System.out.println("Enter Cheque Date (yyyy-mm-dd): ");
 		String date = sc.next();

 		Date chequeDate = Date.valueOf(date);

 		try {
			registrationInterface.paymentByCheque(studentId, invoiceId, chequeNo, bankAccountHolderName, bankAccountNumber, ifsc, bankName, bankBranchName, chequeDate);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void paymentByNetBanking(int studentId) {
		// TODO Auto-generated method stub
		
		try {
			registrationInterface.setPaymentStatus(studentId, invoiceId, fee);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

 		System.out.println("Enter Bank Account Holder Name: ");
 		String bankAccountHolderName = sc.next();

 		System.out.println("Enter Bank Name: ");
 		String bankName = sc.next();

 		try {
			registrationInterface.paymentByNetBanking(studentId, invoiceId, bankAccountHolderName, bankName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
