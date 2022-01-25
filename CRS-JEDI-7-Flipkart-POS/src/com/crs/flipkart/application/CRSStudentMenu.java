/**
 * 
 */
package com.crs.flipkart.application;

import java.util.Scanner;
import java.util.Vector;

import com.crs.flipkart.bean.Course;
import com.crs.flipkart.business.RegistrationInterface;
import com.crs.flipkart.business.RegistrationService;

/**
 * @author devanshugarg
 *
 */
public class CRSStudentMenu {

	static Scanner sc = new Scanner(System.in);
	static RegistrationInterface registrationInterface = new RegistrationService();
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
	        
	        System.out.println("1. Course Registration");
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
				viewGradeCard(studentId);
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
		int totalCourses = 1;
		while(totalCourses < 7) {
			Vector<Course> courseList = viewAvailableCourse(studentId);
			if(courseList == null) {
				return;
			}
			
			System.out.println("Enter CourseID: " + totalCourses);
			int courseId = sc.nextInt();
			
			boolean checkstatus = registrationInterface.addCourse(courseId, studentId, courseList);
			if(checkstatus) {
				System.out.println("Course registration of " + courseId + " done successfully.");
				totalCourses++;
			}else {
				System.out.println("Course registration of " + courseId + " is already done.");
			}
		}
		
		System.out.println();
		System.out.println("Registration Successful");
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
		}else {
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
		}else {
			System.out.println("Course of " + courseId + " is already deleted.");
		}
	}

	/**
	 * View Course
	 * @param studentId
	 * @return 
	 */
	private static Vector<Course> viewAvailableCourse(int studentId) {
		// TODO Auto-generated method stub
		Vector<Course> availableCourses = null;
		
		availableCourses = registrationInterface.viewCourses(studentId);
		
		if(availableCourses.isEmpty()) {
			System.out.println("No Courses are available!");
			return null;
		}
		
		for(Course course: availableCourses) {
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
		
		for(Course course: registeredCourses) {
			System.out.println(course.getCourseId() + " " + course.getCourseName() + " " + course.getCourseDescription() + " " + course.getCourseFee() + " " + course.getCourseSeats());
		}
		
		return registeredCourses;
	}

	/**
	 * View Grade Card
	 * @param studentId
	 */
	private static void viewGradeCard(int studentId) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Make Payment
	 * @param studentId
	 */
	private static void makePayment(int studentId) {
		// TODO Auto-generated method stub
		
	}

}
