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
 	static boolean is_registered = false;
	
	/**
	 * Method to Create Main Menu
	 */
	public static void createStudentMenu(int studentId)
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
	 */
	private static void registerCourses(int studentId) {
		// TODO Auto-generated method stub
	
		System.out.println("Enter the Semester: ");
 		int semester = sc.nextInt();
 		
 		boolean isApproved = studentInterface.isApproved(studentId);
 		
 		if(isApproved) {
 			try {
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
		 				
		 				try {
			 				boolean checkstatus = registrationInterface.addCourse(courseId, studentId, courseList);
			 				if(checkstatus) {
			 					System.out.println("Course registration of " + courseId + " done successfully.");
			 					totalCourses++;
			 				} else {
			 					System.out.println("Course registration of " + courseId + " is already done.");
			 				}
		 				} catch (CourseNotFoundException e) {
		 					System.out.println("Error: " + e.getMessage());
		 				} catch (CourseLimitExceededException e) {
		 					System.out.println("Error: " + e.getMessage());
		 				} catch (SeatNotAvailableException e) {
		 					System.out.println("Error: " + e.getMessage());
		 				} catch (SQLException e) {
		 					System.out.println("Error: " + e.getMessage());
		 				}
		 			}
		
		 			System.out.println();
		 			System.out.println("Registration Successful");
		 			is_registered = true;
		 		}
 			} catch (SQLException e) {
 				System.out.println("Error: " + e.getMessage());
 			}
 		} else {
 			System.out.println("You have not been approved yet.");
 		}
	}

	/**
	 * Add Course
	 * @param studentId
	 */
	private static void addCourse(int studentId) {
		// TODO Auto-generated method stub
		if (is_registered) {
			
			boolean isApproved = studentInterface.isApproved(studentId);
			if (isApproved) {
				
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
		 		} catch (CourseNotFoundException e) {
		 			System.out.println("Error: " +e.getMessage());
		 		} catch (CourseLimitExceededException e) {
 					System.out.println("Error: " + e.getMessage());
 				} catch (SeatNotAvailableException e) {
 					System.out.println("Error: " + e.getMessage());
		 		} catch (SQLException e) {
		 			System.out.println("Error: " + e.getMessage());
		 		}
			} else {
				System.out.println("You have not been approved yet.");
			}
		} else {
			System.out.println("Registration is still pending!");
		}
	}

	/**
	 * Drop Course
	 * @param studentId
	 */
	private static void dropCourse(int studentId) {
		// TODO Auto-generated method stub
		
		if (is_registered) {
			
			boolean isApproved = studentInterface.isApproved(studentId);
			if (isApproved) {
				
				Vector<Course> availableCourse = viewRegisteredCourse(studentId);
		 		if(availableCourse == null) {
		 			return;
		 		}

		 		System.out.println("Enter the CourseID to DROP: ");
		 		int courseId = sc.nextInt();
		 		
		 		try {
			 		boolean checkstatus = registrationInterface.dropCourse(courseId, studentId, availableCourse);
			 		if(checkstatus) {
			 			System.out.println("Course Deletion of " + courseId + " done successfully.");
			 		} else {
			 			System.out.println("Course of " + courseId + " is already deleted.");
			 		}
		 		} catch (CourseNotFoundException e) {
		 			System.out.println("Error: " + e.getMessage());
		 		} catch (SQLException e) {
		 			System.out.println("Error: " + e.getMessage());
		 		}
			} else {
				System.out.println("You have not been approved yet.");
			}
		} else {
			System.out.println("Registration is still pending!");
		}
	}

	/**
	 * View Course
	 * @param studentId
	 */
	private static Vector<Course> viewAvailableCourse(int studentId) {
		// TODO Auto-generated method stub
		Vector<Course> availableCourses = null;
		boolean isApproved = studentInterface.isApproved(studentId);
		
		if (isApproved) {
		
			try {
		 		availableCourses = registrationInterface.viewCourses(studentId);
	
		 		if(availableCourses.isEmpty()) {
		 			System.out.println("No Courses are available right now!");
		 			return null;
		 		}
	
		 		System.out.println(String.format("%-20s %-20s %-20s %-20s %-20s", "COURSE ID", "COURSE NAME", "COURSE DESCRIPTION", "COURSE FEES", "SEATS"));
	 	 		System.out.println();
	 	 		
	 	 		for(Course course : availableCourses) {
	 	 			System.out.println(String.format("%-20s %-20s %-20s %-20s %-20s", course.getCourseId(), course.getCourseName(), course.getCourseDescription(), course.getCourseFee(), course.getCourseSeats()));
	 	 		}
	 	 		
	 	 		System.out.println();
			} catch (SQLException e) {
				System.out.println("Error: " + e.getMessage());
			}
		} else {
			System.out.println("You have not been approved yet.");
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
		boolean isApproved = studentInterface.isApproved(studentId);
		
		if (isApproved) {
					
			try {
				registeredCourses = registrationInterface.viewRegisteredCourses(studentId);
	
		 		if(registeredCourses.isEmpty()) {
		 			System.out.println("No Courses are Registered!");
		 			return null;
		 		}
	
		 		System.out.println(String.format("%-20s %-20s %-20s %-20s %-20s", "COURSE ID", "COURSE NAME", "COURSE DESCRIPTION", "COURSE FEES", "SEATS"));
	 	 		System.out.println();
	 	 		
	 	 		for(Course course : registeredCourses) {
	 	 			System.out.println(String.format("%-20s %-20s %-20s %-20s %-20s", course.getCourseId(), course.getCourseName(), course.getCourseDescription(), course.getCourseFee(), course.getCourseSeats()));
	 	 		}
	 	 		
	 	 		System.out.println();	
			} catch (SQLException e) {
				System.out.println("Error: " + e.getMessage());
			}
		} else {
			System.out.println("You have not been approved yet.");
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
		
		try {
			boolean isGenerated = registrationInterface.isGenerated(studentId);
	
			if(!isGenerated) {
	
				System.out.println("GradeCard is not generated yet.");
			}
			else {
	
				try {
					Vector<GradeCard> grades = registrationInterface.viewGradeCard(studentId, semesterId);
		
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
	
	 		boolean isapprove = true;
	 		boolean ispaid = false;
	 		int notificationId = 0;
	
	 		isapprove = registrationInterface.getRegistrationStatus(studentId);
	 		ispaid = registrationInterface.getPaymentStatus(studentId);
	
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
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	private static void paymentByCheque(int studentId) {
		// TODO Auto-generated method stub
		
		try {
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
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	private static void paymentByNetBanking(int studentId) {
		// TODO Auto-generated method stub
		
		try {
			registrationInterface.setPaymentStatus(studentId, invoiceId, fee);
	
	 		System.out.println("Enter Bank Account Holder Name: ");
	 		String bankAccountHolderName = sc.next();
	
	 		System.out.println("Enter Bank Name: ");
	 		String bankName = sc.next();
	
	 		registrationInterface.paymentByNetBanking(studentId, invoiceId, bankAccountHolderName, bankName);
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}
