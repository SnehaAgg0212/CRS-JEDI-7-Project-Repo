/**
 * 
 */
package com.crs.flipkart.application;

import java.util.Scanner;

/**
 * @author devanshugarg
 *
 */
public class CRSProfessorMenu {

	static Scanner sc = new Scanner(System.in);
	/**
	 * @param args
	 */
	public static void main(int professorId) {
		// TODO Auto-generated method stub
		
		while(true) {
			
			createProfessorMenu();
			
			int choice = sc.nextInt();
			
			switch(choice) {
			
			case 1:
				getCourses(professorId);
				break;
			case 2:
				addGrade(professorId);
				break;
			case 3:
				viewEnrolledStudents(professorId);
				break;
			case 4:
				chooseCourses(professorId);
				break;
			case 5:
				return;
			default:
				System.out.println("Invalid Input !");
			}
		}
	}
	
	/**
	 * Method to Create Main Menu
	 */
	public static void createProfessorMenu()
	{
        System.out.println("#------------------------Welcome to Course Registration System------------------------#");
        
        System.out.println("*************************************************************************************");
        System.out.println("********************************* Professor Menu ************************************");
        System.out.println("*************************************************************************************");
        
        System.out.println("1. View Courses");
		System.out.println("2. Add Grades");
		System.out.println("3. View Enrolled Students");
		System.out.println("4. Choose Courses");
		System.out.println("5. Exit");
        
        System.out.println("*********************************************************************************");
        
        System.out.print("Enter User Input: ");
	}
	
	private static void chooseCourses(int professorId) {
		// TODO Auto-generated method stub
		
	}

	private static void viewEnrolledStudents(int professorId) {
		// TODO Auto-generated method stub
		
	}

	private static void addGrade(int professorId) {
		// TODO Auto-generated method stub
		
	}

	private static void getCourses(int professorId) {
		// TODO Auto-generated method stub
		
	}

}
