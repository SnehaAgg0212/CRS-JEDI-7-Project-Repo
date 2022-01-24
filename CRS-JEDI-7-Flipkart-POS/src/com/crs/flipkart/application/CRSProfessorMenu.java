/**
 * 
 */
package com.crs.flipkart.application;

import java.util.Scanner;

/**
 * @author devanshugarg,
 *
 */
public class CRSProfessorMenu {

	/**
	 * @param args
	 */
	public static void menu(int professorID) {

		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("Professor Menu:");
			System.out.println();
			System.out.println("1. View Courses");
			System.out.println("2. Add Grades");
			System.out.println("3. View Enrolled Students");
			System.out.println("4. Choose Courses");
			System.out.println("5. Exit");
			System.out.println();
			
			System.out.println("Enter the choice: ");
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				getCourses(professorID);
				break;
			case 2:
				addGrade(professorID);
				break;
				
			case 3:
				viewEnrolledStudents(professorID);
				break;
			case 4:
				chooseCourses(professorID);
				break;
			case 5:
				return;
			default:
				System.out.println("Invalid Choice");
			}
			if(choice > 5) {
				break;
			}
		}
		
		
	}
	
	public static void getCourses(int professorID) {
		
	}
	
	public static void addGrade(int professorID) {
			
		}
	
	public static void viewEnrolledStudents(int professorID) {
		
	}
	
	public static void chooseCourses(int professorID) {
		
	}
	
}
