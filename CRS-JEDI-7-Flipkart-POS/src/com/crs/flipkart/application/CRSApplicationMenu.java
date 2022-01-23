/**
 * 
 */
package com.crs.flipkart.application;

import java.util.Scanner;

import com.crs.flipkart.business.AdminService;
import com.crs.flipkart.business.UserService;
import com.crs.flipkart.utils.Utils.UserType;

/**
 * @author devanshugarg
 *
 */
public class CRSApplicationMenu {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		CRSApplicationMenu crsApplicationMenu = new CRSApplicationMenu();
		
		createMainMenu();
		
		int userInput;
		userInput = sc.nextInt();
		
		switch(userInput) {
		
		case 1:
			crsApplicationMenu.userLogin();
			break;
		case 2:
			crsApplicationMenu.registerStudent();
			break;
		case 3:	
			crsApplicationMenu.updatePassword();
			break;
		case 4:
			crsApplicationMenu.exit();
			break;
		default:
			System.out.println("Invalid Input !");
		}
		
	}
	
	/**
	 * Method to Create Main Menu
	 */
	public static void createMainMenu()
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
	public void userLogin() {
		
		Scanner sc = new Scanner(System.in);
		UserService userService = new UserService();
		
		System.out.println("-----------------Login------------------");
		
		int userType; 
		String userEmailId, userPassword;
		
		System.out.println("Enter UserType as 0->ADMIN, 1->PROFESSOR, 2->STUDENT: ");
		userType = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Email ID: ");
		userEmailId = sc.next();
		
		System.out.println("Enter Password: ");
		userPassword = sc.next();
		
		userService.userLogin(UserType.ADMIN, userEmailId, userPassword);

		sc.close();
	}
	
	/**
	 * Student Registration
	 */
	public void registerStudent() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("---------------Student Registration-------------");
		
		String studentName, studentEmailId, studentPassword, studentGender, studentPhoneNo, studentBranch, studentBatch, studentAddress;
		
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
		
		System.out.println("Enter Student Batch: ");
		studentBatch = sc.nextLine();
		
		System.out.println("Enter Student Address: ");
		studentAddress = sc.nextLine();
		
		System.out.println("Enter Student Phone Number: ");
		studentPhoneNo = sc.nextLine();
		
	}
	
	/**
	 * Password Updation
	 */
	public void updatePassword() {
		
		Scanner sc = new Scanner(System.in);
		
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
	
	public void exit() {
		
		System.out.println("Thanks for your visit !");
	}
}
