/**
 * 
 */
package com.crs.flipkart.application;

import java.util.Scanner;

import com.crs.flipkart.business.AdminService;

/**
 * @author LENOVO
 *
 */
public class CRSAdminMenu {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdminService adminServices = new AdminService();
		Scanner sc = new Scanner(System.in);

		while(true) {
			
			createAdminMenu();
			
			int userInput = sc.nextInt();  
			
			switch(userInput) {
			
			case 1: 
				adminServices.addProfessor();
				break;
			case 2: 
				adminServices.viewProfessor();
				break;
			case 3: 
				adminServices.deleteProfessor();
				break;
			default:
				System.out.println("Invalid Input !");
			}
		}
	}
	
	/**
	 * Method to Create Main Menu
	 */
	public static void createAdminMenu()
	{
        System.out.println("#------------------------Welcome to Course Registration System------------------------#");
        
        System.out.println("*********************************************************************************");
        System.out.println("********************************* Admin Menu ************************************");
        System.out.println("*********************************************************************************");
        
        System.out.println("1. Add Professor");
        System.out.println("2. View Professor");
        System.out.println("3. Remove Professor");
        System.out.println("4. Exit");
        
        System.out.print("Enter User Input: ");
	}
}