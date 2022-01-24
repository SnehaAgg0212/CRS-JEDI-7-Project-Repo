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

	/**
	 * @param args
	 */
	
		public static void menu(int studentID) {
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				
				System.out.println("Student Menu");
				System.out.println();
				System.out.println("1. Course Registration");
				System.out.println("2. Add Course");
				System.out.println("3. Drop Course");
				System.out.println("4. View Course");
				System.out.println("5. View Registered Courses");
				System.out.println("6. View grade card");
				System.out.println("7. Make Payment");
				System.out.println("8. Exit");
				System.out.println();
				
				System.out.println("Enter the choice: ");
				int choice = sc.nextInt();
				
				switch(choice) {
				case 1: 
					registerCourses(studentID);
					break;
					
				case 2:
					addCourse(studentID);
					break;
					
				case 3:
					dropCourse(studentID);
					break;
					
				case 4:
					viewCourse(studentID);
					break;
					
				case 5:
					viewRegisteredCourse(studentID);
					break;
					
				case 6:
					viewGradeCard(studentID);
					break;
					
				case 7:
					makePayment(studentID);
					break;
					
				case 8:
					return;
					
				default:
					System.out.println("Invalid Choice!");
				}
				if(choice > 8) {
					break;
				}
			}
		}
	
	public static void registerCourses(int studentID) {
		
	}
	
	public static void addCourse(int studentID) {
			
		}
	
	public static void dropCourse(int studentID) {
		
	}
	
	public static void viewCourse(int studentID) {
		
	}
	
	public static void viewRegisteredCourse(int studentID) {
		
	}
	
	public static void viewGradeCard(int studentID) {
		
	}
	
	public static void makePayment(int studentID) {
		
	}


}
