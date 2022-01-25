/**
 * 
 */
package com.crs.flipkart.application;

import java.util.Scanner;

/**
 * @author devanshugarg
 *
 */
public class CRSStudentMenu {

	static Scanner sc = new Scanner(System.in);
	
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
				viewCourse(studentId);
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
		
	}

	/**
	 * Add Course
	 * @param studentId
	 */
	private static void addCourse(int studentId) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Drop Course
	 * @param studentId
	 */
	private static void dropCourse(int studentId) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * View Course
	 * @param studentId
	 */
	private static void viewCourse(int studentId) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * View Registered Courses
	 * @param studentId
	 */
	private static void viewRegisteredCourse(int studentId) {
		// TODO Auto-generated method stub
		
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
