/**
 * 
 */
package com.crs.flipkart.application;

import java.util.Scanner;

import com.crs.flipkart.business.UserInterface;
import com.crs.flipkart.business.UserService;

/**
 * @author devanshugarg
 *
 */
public class CRSApplicationMenu {

	CRSApplicationMenu crsApplicationMenu = new CRSApplicationMenu();
	static Scanner sc = new Scanner(System.in);
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		createMainMenu();
		
		int userInput;
		
		while(true) {
			
			userInput = sc.nextInt();
			
			switch(userInput) {
			
			case 1:
				userLogin();
				break;
			case 2:
				registerStudent();
				break;
			case 3:	
				updatePassword();
				break;
			case 4:
				exit();
				break;
			default:
				System.out.println("Invalid Input !");
				createMainMenu();
			}
		}
		
	}
	
	/**
	 * Method to Create Main Menu
	 */
	private static void createMainMenu()
	{
        System.out.println("#------------------------Welcome to Course Registration System------------------------#");
        
        System.out.println("1. Login");
        System.out.println("2. Student Registration");
        System.out.println("3. Update Password");
        System.out.println("4. Exit");
        
        System.out.print("Enter User Input: ");
	}
	
	/**
	 * User Login
	 */
	private static void userLogin() {
		
		Scanner sc = new Scanner(System.in);
		UserInterface userService = new UserService();
		
		System.out.println("-----------------Login------------------");
		
		String role = "ADMIN"; 
		// String role = "STUDENT"; 
		// String role = "PROFESSOR"; 
		String userEmailId, userPassword;
		
		System.out.println("Enter Email ID: ");
		userEmailId = sc.next();
		
		System.out.println("Enter Password: ");
		userPassword = sc.next();
		
		boolean login = userService.userLogin(userEmailId, userPassword);
		
		if(login) {
			
			switch (role) {
			
			case "ADMIN": 
				CRSAdminMenu.createAdminMenu();
				break;
			case "STUDENT": 
				CRSStudentMenu.createStudentMenu(501); //studentID need to be passed
				break;
			case "PROFESSOR": 
				CRSProfessorMenu.createProfessorMenu(101); //professorID need to be passed
				break;
			}
		}
		else {
			
			System.out.println("Invalid Credentials !");
		}
	}
	
	/**
	 * Student Registration
	 */
	private static void registerStudent() {
		
		System.out.println("---------------Student Registration-------------");
		
		String studentName, studentEmailId, studentPassword, studentGender, studentPhoneNo, studentBranch, studentAddress;
		int studentBatch;
		
		System.out.println("Enter Student Name: ");
		studentName = sc.nextLine();
		
		System.out.println("Enter Student Email ID: ");
		studentEmailId = sc.nextLine();
		
		System.out.println("Enter Student Password: ");
		studentPassword = sc.nextLine();
		
		System.out.println("Enter Student Gender: ");
		studentGender = sc.nextLine();
		
		System.out.println("Enter Student Branch: ");
		studentBranch = sc.nextLine();
		
		System.out.println("Enter Student Batch (Graduation Year): ");
		studentBatch = sc.nextInt();
		
		System.out.println("Enter Student Address: ");
		studentAddress = sc.nextLine();
		
		System.out.println("Enter Student Phone Number: ");
		studentPhoneNo = sc.nextLine();
		
	}
	
	/**
	 * Password Updation
	 */
	private static void updatePassword() {
		
		System.out.println("------------------Update Password--------------------");
		
		String userEmailId, oldPassword, newPassword, confirmNewPassword;
		
		System.out.println("Enter Email Id: ");
		userEmailId = sc.nextLine();
		
		System.out.println("Enter Current Password: ");
		oldPassword = sc.nextLine();
		
		System.out.println("Enter New Password: ");
		newPassword = sc.nextLine();
		
		System.out.println("Confirm New Password: ");
		confirmNewPassword = sc.nextLine();
		
	}
	
	/**
	 * Exiting from the System
	 */
	private static void exit() {
		
		System.out.println("Thanks for your visit !");
	}
}
