/**
 * 
 */
package com.crs.flipkart.application;

import java.sql.Date;
import java.util.Vector;
import java.util.Scanner;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.bean.GradeCard;
import com.crs.flipkart.business.RegistrationInterface;
import com.crs.flipkart.business.RegistrationService;
import com.crs.flipkart.business.StudentInterface;
import com.crs.flipkart.business.StudentService;

/**
 * @author devanshugarg
 *
 */
public class CRSStudentMenu {

	static Scanner sc = new Scanner(System.in);
	static RegistrationInterface registrationInterface = new RegistrationService();
	static StudentInterface studentInterface = new StudentService();
	static int invoiceId;
 	static double fee;
	
	/**
	 * Method to Create Main Menu
	 */
	public static void createStudentMenu(int studentId)
	{
		
		while(true) {
			
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
	        
	        System.out.println("*********************************************************************************");
	        
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
				return;
			default:
				System.out.println("Invalid Input !");
			}
		}
	}

	/**
	 * Course Registration
	 * @param studentId
	 */
	private static void registerCourses(int studentId) {
		// TODO Auto-generated method stub
	
		System.out.println("Enter the Semester: ");
 		int semester = sc.nextInt();

 		boolean check = studentInterface.semesterRegistration(semester, studentId);
 		if(check) {
 			int totalCourses = 1;
 			while(totalCourses < 7) {
 				
 				Vector<Course> courseList = viewAvailableCourse(studentId);
 				if(courseList == null) {
 					return;
 				}

 				System.out.println("Enter Course Id " + totalCourses + ": ");
 				int courseId = sc.nextInt();

 				boolean checkstatus = registrationInterface.addCourse(courseId, studentId, courseList);
 				if(checkstatus) {
 					System.out.println("Course registration of " + courseId + " done successfully.");
 					totalCourses++;
 				} else {
 					System.out.println("Course registration of " + courseId + " is already done.");
 				}
 			}

 			System.out.println();
 			System.out.println("Registration Successful");
 		}
	}

	/**
	 * Add Course
	 * @param studentId
	 */
	private static void addCourse(int studentId) {
		// TODO Auto-generated method stub
		
		Vector<Course> availableCourse = viewAvailableCourse(studentId);
 		if(availableCourse == null) {
 			return;
 		}

 		System.out.println("Enter the CourseID to ADD: ");
 		int courseId = sc.nextInt();

 		boolean checkstatus = registrationInterface.addCourse(courseId, studentId, availableCourse);
 		if(checkstatus) {
 			System.out.println("Course registration of " + courseId + " done successfully.");
 		} else {
 			System.out.println("Course registration of " + courseId + " is already done.");
 		}
	}

	/**
	 * Drop Course
	 * @param studentId
	 */
	private static void dropCourse(int studentId) {
		// TODO Auto-generated method stub
		
		Vector<Course> availableCourse = viewRegisteredCourse(studentId);
 		if(availableCourse == null) {
 			return;
 		}

 		System.out.println("Enter the CourseID to DROP: ");
 		int courseId = sc.nextInt();

 		boolean checkstatus = registrationInterface.dropCourse(courseId, studentId, availableCourse);
 		if(checkstatus) {
 			System.out.println("Course Deletion of " + courseId + " done successfully.");
 		} else {
 			System.out.println("Course of " + courseId + " is already deleted.");
 		}
	}

	/**
	 * View Course
	 * @param studentId
	 */
	private static Vector<Course> viewAvailableCourse(int studentId) {
		// TODO Auto-generated method stub
		
		Vector<Course> availableCourses = null;

 		availableCourses = registrationInterface.viewCourses(studentId);

 		if(availableCourses.isEmpty()) {
 			System.out.println("No Courses are available right now!");
 			return null;
 		}

 		for(Course course : availableCourses) {
 			System.out.println(course.getCourseId() + " " + course.getCourseName() + " " + course.getCourseDescription() + " " + course.getCourseFee() + " " + course.getCourseSeats());
 		}

 		return availableCourses;
	}

	/**
	 * View Registered Courses
	 * @param studentId
	 */
	private static Vector<Course> viewRegisteredCourse(int studentId) {
		// TODO Auto-generated method stub
		
		Vector<Course> registeredCourses = null;

 		registeredCourses = registrationInterface.viewRegisteredCourses(studentId);

 		if(registeredCourses.isEmpty()) {
 			System.out.println("No Courses are Registered!");
 			return null;
 		}

 		for(Course course : registeredCourses) {
 			System.out.println(course.getCourseId() + " " + course.getCourseName() + " " + course.getCourseDescription() + " " + course.getCourseFee() + " " + course.getCourseSeats());
 		}

 		return registeredCourses;
	}

	/**
	 * View Grade Card
	 * @param studentId
	 * @param semesterId
	 */
	private static void viewGradeCard(int studentId, int semesterId) {
		// TODO Auto-generated method stub
		 
		boolean isGenerated = registrationInterface.isGenerated(studentId);

		if(!isGenerated) {

			System.out.println("GradeCard is not generated yet.");
		}
		else {

			Vector<GradeCard> grades = registrationInterface.viewGradeCard(studentId, semesterId);

			double overallgpa=0.0;

			for(GradeCard course_grade : grades) {

				System.out.println("CourseId: " + course_grade.getCourseId() + " GPA: " + course_grade.getGpa());

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
		
		fee = registrationInterface.calculateFee(studentId);

 		boolean isapprove = true;
 		boolean ispaid = false;

 		isapprove = registrationInterface.getRegistrationStatus(studentId);
 		ispaid = registrationInterface.getPaymentStatus(studentId);

 		if(!isapprove) {
 			System.out.println("You have not registered yet.");
 		}
 		else if(ispaid) {
 			System.out.println("You have already paid.");
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

 				System.out.println("Enter Invoice Id: ");
 				invoiceId = sc.nextInt();

 				int done = 0;

 				switch(selected_mode) {

 				case 1:
 					paymentByCard(studentId);
 					done = 1;
 					break;
 				case 2:
 					paymentByCheque(studentId);					
 					done = 1;
 					break;
 				case 3:
 					paymentByNetBanking(studentId);
 					done = 1;
 					break;
 				default:
 					System.out.println("Invalid Input!");
 					break;
 				}
	 			if (done == 1) {
	 				System.out.println("Payment Succesfully.");
	 			}
	 			else {
	 				System.out.println("Payment Failed.");
	 			}

 			}
	 		else {
	 			System.out.println("You have already paid the fees.");
	 		}
 		}
	}

	private static void paymentByNetBanking(int studentId) {
		// TODO Auto-generated method stub
		
		registrationInterface.setPaymentStatus(studentId, invoiceId, fee);

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

 		registrationInterface.paymentByCard(studentId, invoiceId, cardType, cardNumber, cardHolderName, cvv, bankName, expiryDate);	
	}

	private static void paymentByCheque(int studentId) {
		// TODO Auto-generated method stub
		
		registrationInterface.setPaymentStatus(studentId, invoiceId, fee);

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

 		registrationInterface.paymentByCheque(studentId, invoiceId, chequeNo, bankAccountHolderName, bankAccountNumber, ifsc, bankName, bankBranchName, chequeDate);
	}

	private static void paymentByCard(int studentId) {
		// TODO Auto-generated method stub
		
		registrationInterface.setPaymentStatus(studentId,invoiceId,fee);

 		System.out.println("Enter Bank Account Holder Name: ");
 		String bankAccountHolderName = sc.next();

 		System.out.println("Enter Bank Name: ");
 		String bankName = sc.next();

 		registrationInterface.paymentByNetBanking(studentId, invoiceId, bankAccountHolderName, bankName);
	}

}
